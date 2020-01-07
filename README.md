# MicroserviceExample


# urls:

Db-Service
Delete: localhost:8300/rest/db/userstockquotes/delete/Sam 

Post: localhost:8300/rest/db/userstockquotes/add 

Get: localhost:8300/rest/db/userstockquotes/sam 

Stock-service
Get: localhost:8301/rest/stock/Rocky

# APi Gateway using zuul:
Get DB-service: http://localhost:8761/api/db-service/rest/db/userstockquotes/Sam

Post DB-Service: http://localhost:8761/api/db-service/rest/db/userstockquotes/add

Get Stock-service: http://localhost:8761/api/stock-service/rest/stock/Rocky

UI:
http://localhost:8080/html/add-stocks.html

Eureka Url:
http://localhost:8761/


Note: Try on IE , as there might be issue with Cross Browser Request in other browsers as we are calling one url from another.
