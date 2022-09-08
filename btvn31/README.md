# 1st Naver Homework for 3rd Week

1. [Application Properties](#application-properties)
2. [How to run server at local](#how-to-run-the-server-at-your-local)
3. [How to generate error](#how-to-result-an-error-response)
4. [Application endpoints](#application-endpoints)
   1. [Employee](#employee)
   2. [Department](#department)

## Application Properties

```
Endpoint: http://www.hoangthinh.me/likelion
```

## How to run the server at your local

```
docker pull venetus/naver-btvn13

docker run --name naver-btvn13-container -p8080:8080 -d venetus/naver-btvn13
```

## How to generate an error response
### Validation Error
> Such field results error when validated
1. employeeId, departmentId: *Must be larger than 0 and not null*
2. name, deptName: *Has length >=10 and <=50, not null*
3. birthdate: *should be formatted to dd-MM-yyyy* 
4. gender: *Must be either MALE or FEMALE*
5. email: *Must be a valid gmail*
6. description: *Must not be empty*

### Service Error
> These errors will throw the error response. However, only employee service will be caught.

```
Error occurs when
name or deptName is Hoang Thinh 
```
## Application endpoints

> All body should be JSON formatted. Server already have Validation.

### Employee

Get Employee DTO from request

**`POST /employees/test`**
```
{
    "employeeId": 1,
    "name": "Le Hoang Thinh",
    "birthDate" : "08-12-2001",
    "gender":"MALE",
    "email":"thinhlh@gmail.com"
}
```

### Department

Get Employee DTO from request

**`POST /department/test`**
```

{
    "departmentId": 1,
    "deptName": "IT Department",
    "description": "description",
    "employees": [
        {
            "employeeId": 1,
            "name": "Le Hoang Thinh",
            "birthDate": "08-12-2001",
            "gender": "MALE",
            "email": "thinhlh@gmail.com"
        }
    ]
}
```

