# om-ds-server 新增Ad Network流程

---
主要涉及到adnetwrok账号切换处理，需要修改com.adtiming.om.ds.service.AdNetworkService中对应方法

####1.buildAccountInfo方法中增加新adnetwork的账号配置OmAdnetworkApp对象与ReportAdnetworkAccount对象中属性的对应关系

```
case 14: //Mintegral
    fieldMap.put("apiKey", "adnApiKey");//账号配置属性对应关系
    fieldMap.put("clientSecret", "userSignature");
    primaryFiled = "apiKey";//OmAdnetworkApp对象中的账号主键属性字段
    break;
case 15: //新adnetwork的adn_id
    fieldMap.put("apiKey", "adnApiKey");
    fieldMap.put("refreshToken", "adnAppToken");
    primaryFiled = "apiKey";
    break;
```

####2.getAccountKeyField方法中增加新adnetwork账号在OmAdnetworkApp对象中的账号主键属性字段
```
case 14:
    return "apiKey";
case 15://新adnetwork的adn_id
    return "adnAppKey";//OmAdnetworkApp对象中的账号主键属性字段
```



