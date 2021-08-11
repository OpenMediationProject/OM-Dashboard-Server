# OpenMediation Dashboard Server

## Add a new ad network step:

```
1 Add new type in enum AdNetworkType;
    Chartboost(12),// adnetwork id
    ----------------
    AdNetworkType.getAdNetworkType
    case 12:
                return Chartboost;

2 Add checking for duplication of account in 'AccountService.getDuplicatedAccount';
    case Chartboost:
                if (StringUtils.isBlank(account.getUserId())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Chartboost's [User ID] must be not null");
                }
                if (StringUtils.isBlank(account.getUserSignature())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Chartboost's [ User Signature] must be not null");
                }
                break;

3 Add checking for validation of account key in 'AccountService.isAdKeyValid';
    case Chartboost:
                if (StringUtils.isBlank(account.getUserId())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Chartboost's [User ID] must be not null");
                }
                if (StringUtils.isBlank(account.getUserSignature())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Chartboost's [ User Signature] must be not null");
                }
                break;
```
