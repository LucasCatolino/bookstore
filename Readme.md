## Prerequisites
* Java 17
* Maven
* PostgreSQL (port 5434)

## Run
1. mvn clean install -U
2. ./mvnw spring-boot:run

## Use
* POST
1. http://localhost:8080/api/books: {"title": "The-Great-Gatsby", "author": "F. Scott Fitzgerald", "year": 1925, "type": "novel"}
2. http://localhost:8080/api/books: {"title": "C-Programming-Language", "author": "Brian Kernighan", "year": 1978, "type": "technical"}
3. http://localhost:8080/api/customers: {"name": "Lance Armstrong", "address": "False street 123", "type": "minor"}
4. http://localhost:8080/api/customers: {"name": "Kell", "address": "Real street 321", "type": "major"}
5. http://localhost:8080/api/orders: {"name": "Kell", "address": "False street 456", "quantity": 5, "type": "bulk"}
6. http://localhost:8080/api/orders: {"name": "Lance Armstrong", "address": "False street 456", "quantity": 5, "type": "regular"}

* PUT
1. http://localhost:8080/api/books/1: {"title": "C-Programming-Language", "author": "Brian Kernighan", "year": 1978, "type": "technical"}
2. http://localhost:8080/api/customers/1: {"name": "Kell", "address": "Real Street 987", "type": "major"}
3. http://localhost:8080/api/orders/1: {"name": "Kell", "address": "False street 456", "quantity": 10, "type": "bulk"}

* GET
1. http://localhost:8080/api/books/1
2. http://localhost:8080/api/customers/1
3. http://localhost:8080/api/orders/1

* DELETE
1. http://localhost:8080/api/books/1
2. http://localhost:8080/api/customers/1
3. http://localhost:8080/api/orders/1