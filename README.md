# mm-store-rest-api
REST API using Java Spring Boot + PostgreSQL database that provides CRUD capabilities.

- Add Customer endpoint with example payload:

POST localhost:8080/api/v1/customer

{
    "id": 1,
    "name": "Meluleki",
    "address": "123 Main Ave",
    "dob": "1992-03-12",
    "createdAt": "2023-04-28"
}

- Add Product endpoint with example payload:

POST localhost:8080/api/v1/product

{
    "id":1,
    "name": "Product 1",
    "description": "This is a product 1 description",
    "price": 25.0,
    "quantity": 5
}

- Make a purchase endpoint with example payload:

POST localhost:8080/api/v1/purchase

{
    "customer": {
        "id": 1,
        "name": "Meluleki",
        "dob": "1992-03-12",
        "address": "123 Main Ave",
        "createdAt": "2023-04-28"
    },
    "product": {
        "id": 1,
        "name": "Product 1",
        "description": "This is a product 1 description",
        "price": 25.0,
        "quantity": 5
    },
    "unitsBought": 2,
    "date": "2023-04-28"
}

- Get number of purchases for a customer endpoint:

GET localhost:8080/api/v1/purchase/customer/1

- Get an average expenditure per customer in a given time frame endpoint:

GET localhost:8080/api/v1/purchase/1/2023-04-28/2023-04-28