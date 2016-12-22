# Employee Management System
It is RESTFUL APIs for managing a database of Employees and Department.


- Created two entities Employee and Department.<br />
- Created APIs for supporting POST, PUT, DELETE and GET operations on the employee and related objects. <br />
- Used Servlet 3.0 Container.<br />
- Language: Java 7
- Server: Apache Tomcat 7
- Database: MySQL

## Show all Employees.
Returns json data about all employees.

- #### URL<br />
/EmployeeManagementSystem/webapi/employees 

- #### Method<br />
`GET`

- #### URL Params<br />
None

- #### Data Params<br />
None

- #### Response
  - Content: `[{
    "dept": {
      "deptid": 1,
      "deptname": "Science"
    },
    "empid": 1,
    "firstname": "Michael",
    "lastname": "Warner"
  },{
    "dept": {
      "deptid": 2,
      "deptname": "Technology"
    },
    "empid": 2,
    "firstname": "James",
    "lastname": "Smith"
  }]`
  
## Show Employee by id.
Returns json data about Employee.

- #### URL<br />
/EmployeeManagementSystem/webapi/employees/1

- #### Method<br />
`GET`

- #### URL Params<br />
None

- #### Data Params<br />
None

- #### Response
  - Content: `{
    "dept": {
      "deptid": 1,
      "deptname": "Science"
    },
    "empid": 1,
    "firstname": "Michael",
    "lastname": "Warner"
  }`
 
## Add an Employee. 
Adds an Employee to the database.

- #### URL<br />
/EmployeeManagementSystem/webapi/employees/2

- #### Method<br />
`POST`

- #### URL Params<br />
  - Required:<br />
  `deptid=[integer]`

- #### Data Params<br />
`{
  "dept": {
    "deptname": "Technology"
  },
  "firstname": "Mat",
  "lastname": "Hayden"
}`

- #### Response<br />
 `{
  "dept": {
    "deptid": 2,
    "deptname": "Technology"
  },
  "empid": 3,
  "firstname": "Mat",
  "lastname": "Hayden"
}`
  
## Update an Employee data.
Updates the data of an Employee.

- #### URL<br />
/EmployeeManagementSystem/webapi/employees/3

- #### Method<br />
`PUT`

- #### URL Params<br />
  - Required:<br />
  `empid=[integer]`

- #### Data Params<br />
`{
  "dept": {
     "deptid": 2
  },
  "firstname": "Adam",
  "lastname": "Hayden"
}`

- #### Response<br />
 `{
  "dept": {
    "deptid": 2
  },
  "empid": 3,
  "firstname": "Adam",
  "lastname": "Hayden"
}`

## Delete an Employee record.
Deletes record of an Employee.

- #### URL<br />
/EmployeeManagementSystem/webapi/employees/3

- #### Method<br />
`DELETE`

- #### URL Params<br />
  - Required:<br />
  `empid=[integer]`

- #### Data Params<br />
None

- #### Response<br />
 None

## Show all Departments.
Returns json data about all employees.

- #### URL<br />
/EmployeeManagementSystem/webapi/departments 

- #### Method<br />
`GET`

- #### URL Params<br />
None

- #### Data Params<br />
None

- #### Response
  - Content: 
`[
  {
    "deptid": 1,
    "deptname": "Science"
  },
  {
    "deptid": 2,
    "deptname": "Technology"
  }
]`  

## Add a Department. 
Adds a Department to the database.

- #### URL<br />
/EmployeeManagementSystem/webapi/departments

- #### Method<br />
`POST`

- #### URL Params<br />
  - Required:<br />
  None

- #### Data Params<br />
 `{
    "deptid": 3,
    "deptname": "Business"
  }`
  
- #### Response
  - Content: 
  `{
    "deptid": 3,
    "deptname": "Business"
  }`
  
## Update a Department. 
Adds a Department to the database.

- #### URL<br />
/EmployeeManagementSystem/webapi/departments/3

- #### Method<br />
`PUT`

- #### URL Params<br />
  - Required:<br />
 `deptid=[integer]`

- #### Data Params<br />
 `{
    "deptname": "Finance"
  }`
  
- #### Response
  - Content: 
  `{
  "deptid": 3,
  "deptname": "Finance"
}`

## Delete a Department. 
Delete a Department from the database.

- #### URL<br />
/EmployeeManagementSystem/webapi/departments/3

- #### Method<br />
`DELETE`

- #### URL Params<br />
  - Required:<br />
 `deptid=[integer]`

- #### Data Params<br />
 - None
  
- #### Response
  - None
