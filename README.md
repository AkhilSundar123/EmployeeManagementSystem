# Employee Management System
It is RESTFUL APIs for managing a database of Employees and Department.


Created two entities Employee and Department.
Created APIs for supporting POST, PUT, DELETE and GET operations on the employee and related objects. 
Used Servlet 3.0 Container.
Language - Java 7
Server - Apache Tomcat 7

## Show Users
Returns json data about all employees.

- #### URL<br />
/EmployeeManagementSystem/webapi/employees 

- Method<br />
`GET`

- URL Params<br />
None

- Response
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
  
## Show Employee by id
Returns json data about Employee.

- URL<br />
/EmployeeManagementSystem/webapi/employees/1

- Method<br />
`GET`

- URL Params<br />
None

- Data Params<br />
None

- Response
  - Content: `{
    "dept": {
      "deptid": 1,
      "deptname": "Science"
    },
    "empid": 1,
    "firstname": "Michael",
    "lastname": "Warner"
  }`
 
## Add Employee 
Adds an Employee to the database.

- URL<br />
/EmployeeManagementSystem/webapi/employees/2

- Method<br />
`POST`

- URL Params<br />
  - Required:<br />
  `deptid=[integer]`

- Data Params<br />
`{
  "dept": {
    "deptname": "Technology"
  },
  "firstname": "Mat",
  "lastname": "Hayden"
}`

- Response<br />
 `{
  "dept": {
    "deptid": 2,
    "deptname": "Business"
  },
  "empid": 3,
  "firstname": "Mat",
  "lastname": "Hayden"
}`
  
## Update Employee data
Updates the data of an Employee.

- URL<br />
/EmployeeManagementSystem/webapi/employees/3

- Method<br />
`PUT`

- URL Params<br />
  - Required:<br />
  `empid=[integer]`

- Data Params<br />
`{
  "dept": {
     "deptid": 2
  },
  "firstname": "Adam",
  "lastname": "Hayden"
}`

- Response<br />
 `{
  "dept": {
    "deptid": 2
  },
  "empid": 3,
  "firstname": "Adam",
  "lastname": "Hayden"
}`

## Delete Employee record
Deletes record of an Employee.

- URL<br />
/EmployeeManagementSystem/webapi/employees/3

- Method<br />
`DELETE`

- URL Params<br />
  - Required:<br />
  `empid=[integer]`

- Data Params<br />
None

- Response<br />
 None

