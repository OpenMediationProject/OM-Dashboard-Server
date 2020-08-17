// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web.shiro;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "app.redis")
public class OmShiroConfig {

    private static final Logger log = LogManager.getLogger();
    private final long sessionTimeout = 3600000 * 12;
    private String server;
    private int database;
    private String password;
    private int timeout;

    @Value("${shiro.cipher-key}")
    private String cipherKey;

    public void setServer(String server) {
        this.server = server;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Filter factory
     *
     * @return ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("authc", new OmFormAuthenticationFilter());
        filterMap.put("perms", new OmShiroPermissionFilter());
        filterMap.put("logout", new OmLogoutFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

        /*
         * anon:all urls can be accessed anonymously，
         * authc:all urls must be authenticated to be accessible
         * perms:user must have this permission
         * */
        filterChainDefinitionMap.put("/check", "anon");
        filterChainDefinitionMap.put("/auth/login", "anon");
        filterChainDefinitionMap.put("/auth/login.admin", "anon");
        filterChainDefinitionMap.put("/auth/un_auth", "anon");
        filterChainDefinitionMap.put("/auth/unauthorized", "anon");
        filterChainDefinitionMap.put("/report/callback/admob/**", "anon");
        filterChainDefinitionMap.put("/report/callback/google/**", "anon");
        filterChainDefinitionMap.put("/finance/pingpong/link/succeed", "anon");
        filterChainDefinitionMap.put("/auth/logout", "logout");
        filterChainDefinitionMap.put("/un_auth", "anon");
        filterChainDefinitionMap.put("/msg/dict", "anon");

        filterChainDefinitionMap.put("/user/info", "authc");
        filterChainDefinitionMap.put("/publisher/app/sort_list", "authc");
        filterChainDefinitionMap.put("/placement/select/list", "authc");
        filterChainDefinitionMap.put("/publisher/select/list", "authc");
        filterChainDefinitionMap.put("/util/**", "authc");
        filterChainDefinitionMap.put("/adnetwork/list", "authc");
        filterChainDefinitionMap.put("/auth/login/switch/publisher", "authc");
        //authc,perms
        filterChainDefinitionMap.put("/**", "authc,perms");
        shiroFilterFactoryBean.setLoginUrl("/un_auth");
        shiroFilterFactoryBean.setUnauthorizedUrl("/un_auth");

        //authc,perms
        filterChainDefinitionMap.put("/**", "authc,perms");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * RedisSessionDAO shiro sessionDao
     * The shiro-redis open source plugin is used here
     *
     * @return RedisSessionDAO
     */
    @Bean
    public RedisSessionDAO redisSessionDAO(RedisManager redisManager) {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager);
        redisSessionDAO.setSessionInMemoryEnabled(true);
        redisSessionDAO.setSessionInMemoryTimeout(sessionTimeout);
        return redisSessionDAO;
    }

    @Bean
    public OmSessionListener sessionListener() {
        return new OmSessionListener();
    }

    /**
     * Custom sessionManager
     *
     * @return SessionManager
     */
    @Bean
    public SessionManager sessionManager(RedisSessionDAO redisSessionDAO, OmSessionListener sessionListener) {
        Collection<SessionListener> listeners = new ArrayList<>();
        listeners.add(sessionListener);

        OmSessionManager mySessionManager = new OmSessionManager();
        mySessionManager.setSessionDAO(redisSessionDAO);
        mySessionManager.setSessionListeners(listeners);
        mySessionManager.setSessionIdCookieEnabled(false);
        mySessionManager.setDeleteInvalidSessions(true);
        mySessionManager.setSessionValidationSchedulerEnabled(true);
        // 单位为毫秒，600000毫秒为1个小时
        mySessionManager.setSessionValidationInterval(sessionTimeout);
        // 3600000 milliseconds = 1 hour
        mySessionManager.setGlobalSessionTimeout(sessionTimeout);
        return mySessionManager;
    }

    /**
     * Configure shiro redisManager, Using shiro-redis open source plugin
     *
     * @return RedisManager
     */
    @Bean
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(server);
        if (database > 0) {
            redisManager.setDatabase(database);
        }
        if (StringUtils.isNotBlank(password)) {
            redisManager.setPassword(password);
        }
        redisManager.setTimeout(timeout);
        return redisManager;
    }

    /**
     * cacheManager
     *
     * @return RedisCacheManager
     */
    @Bean
    public RedisCacheManager cacheManager(RedisManager redisManager) {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager);
        redisCacheManager.setPrincipalIdFieldName("id");
        return redisCacheManager;
    }

    /**
     * Authority management, configuration is mainly management authentication of Realm
     *
     * @return SecurityManager
     */
    @Bean
    public SecurityManager securityManager(OmShiroRealm shiroRealm, SessionManager sessionManager, CacheManager cacheManager/*, SimpleCookie rememberMeCookie*/) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);
        // custom session manager, use redis
        securityManager.setSessionManager(sessionManager);
        // custom cache manager, use redis
        securityManager.setCacheManager(cacheManager);
        return securityManager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
