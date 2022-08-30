# 1st Naver Homework for 2nd Week

## Application Properties

```
Endpoint: http://www.hoangthinh.me/api
Server: Ubuntu
NGINX: nginx/1.18.0 (Ubuntu)
Database: H2 DB
```

## How to run the server at your local

```
docker pull venetus/naver-btvn13

docker run --name naver-btvn13-container -p8080:8080 -d venetus/naver-btvn13
```

## Application endpoints

> All body should be JSON formatted. Server already have Validation.

### Products

Get all products based on the given price and property

```
GET /products?price=0.0&condition=LESS_THAN
Params: 
condition: LESS_THAN | EQUAL | GREATER_THAN
price: doubl
```

### Get Cart Item detail

Get a cart item based on product name and customer id.

```
 GET /cart-item?customerId={customerId}&productName={productName}&offset={offset}&limit={limit}
 Params: 
 customerId: Long
 productName: String
 offset: Long
 limit: Long
```

Example URL:

```
GET /cart-item?customerId=1&productName=Product 1&offset=0&limit=1
```

### Add item to cart

```
POST /cart/add-item
-d
{
    "customerId": 1,
    "items": [
        {
            "productId": 16,
            "quantity": 1
        }
    ]
}
```

