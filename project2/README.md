# Naver Spring Project 2

> An currency exchange application with load balancing with Eureka, gateway, config server, etc...
Get currency exchange of given amount
```
GET http://localhost:8100/exchange?from=USD&to=VND&amount=10

Params: 
  from: USD or EUR
  to: VND
  amount: amount of money to convert
```
