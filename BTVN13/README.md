# 1st Naver Homework for 2nd Week 

## Application Properties

```
host: http://www.hoangthinh.me/api
server: Ubuntu
NGINX: nginx/1.18.0 (Ubuntu)
database: H2 DB
```

## Application endpoints

### Get departments
Get departments
```
GET /departments
```

### Get department by ID **(EMPLOYEES LIST INCLUDED)**
Get a department by id.
```
 GET /department/{id}
```

### Create Department
Create a department
```
 POST /department/create
 -d 
{
    "departmentName" : "Department 1",
    "description" : "Department 1"
}
```

### Update Department (Partial Update)
Update department. Nullable fields will be skipped 
```
PUT /department/update/{id}
-d 
{
    "departmentName":"New Name 1",
    "description":"Description 1"
}
```

### Delete Department
Delete department. **PERMANENT DELETE ALERT**
 ```
 DELETE /department/delete/{id}
 ```
 
## Employees
### Get employees
Get employees
```
GET /employees
```

### Get employee by their ID (department included)
Get employee by their ID

```
GET /employee/{id}
```

### Create an employee
Create an employee in specified department. **(Department must be exists)**
```
POST /employee/create
-d 
{
    "name": "Le Hoang Thinh",
    "birthday": "08-12-2001",
    "gender": "MALE",
    "departmentId": 1
}
```

### Update an employee
Update department. Nullable fields will be skipped. `Null` departmentID will throw error.

```
PUT /employee/update/{id}
-d 
{
    "name":"Employee new name",
    "birthday":"07-09-2001",
    "gender":"MALE",
    "departmentId":1
}
```

### Delete an employee
Delete an employee. **PERMANENT DELETE ALERT**

```
DELETE /employee/delete/{id}
```