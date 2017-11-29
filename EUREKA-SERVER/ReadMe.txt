urls for application:

Db-Service
Delete: localhost:8300/rest/db/userstockquotes/delete/tack
Post: localhost:8300/rest/db/userstockquotes/add
Get: localhost:8300/rest/db/userstockquotes/sam

Stock-service
Get: localhost:8301/rest/stock/Rocky

APi Gateway using zuul:
Get DB-service: http://localhost:8761/api/db-service/rest/db/userstockquotes/sam
Get Stock-service: http://localhost:8761/api/stock-service/rest/stock/Rocky

