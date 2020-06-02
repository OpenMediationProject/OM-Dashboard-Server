package com.adtiming.om.ds.web.filter;

import com.adtiming.om.ds.dto.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by ruandianbo on 20-3-12.
 */
public class ResponseFilter implements Filter {

    protected static final Logger log = LogManager.getLogger();
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        ResponseWrapper wrapperResponse = new ResponseWrapper((HttpServletResponse) response);
        filterChain.doFilter(request, wrapperResponse);
        if (wrapperResponse.getStatus() != HttpServletResponse.SC_OK) {
            return;
        }

        byte[] content = wrapperResponse.getContent();
        String contentType = wrapperResponse.getContentType();
        if (StringUtils.isNotBlank(contentType) && contentType.contains("json") && content.length > 0) {
            String responseContent = new String(content, StandardCharsets.UTF_8);
            try {
                Response responseObject = objectMapper.readValue(responseContent, Response.class);
                if (responseObject.getCode() == Response.CODE_PARAMETER_ERROR) {
                    ((HttpServletResponse) response).setStatus(HttpStatus.SC_BAD_REQUEST);
                } else if (responseObject.getCode() == Response.CODE_RES_FAILED) {
                    ((HttpServletResponse) response).setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
                }
            } catch (Exception e) {
                log.error("Filter response content {} error:", responseContent, e);
            }
        }
        ServletOutputStream out = response.getOutputStream();
        out.write(content);
        out.flush();
    }
}
