# Java Exceptional Sample Employee Initial Version

## Introduction

This project is used to introduce Java Spring REST API CRUD applications. As such it is a small application showing just the code that is needed to explain the topic.

## Database layout

The table layouts are as follows:

- Employee is the driving table
- Email has a Many-To-One relationship with Employee. Each employee has many emails. Each email has only one employee.
- Jobtitles has a Many-To-Many relationship with Employee
- EmployeeTitles the join table between Jobtitles and Employee

![Image of Database Layout](sampleemps-audit-db.png)

Using the provided seed data, the given endpoint will produce the stated output. Expand each endpoint to see it's correct output. Note I am only generated 3 random Java Faker Employees

<details>
<summary>http://localhost:2019/employees/employees</summary>

```JSON
[
    {
        "employeeid": 3,
        "name": "CINNAMON",
        "salary": 80000.0,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            },
            {
                "jobname": {
                    "jobtitleid": 2,
                    "title": "Wizard"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 4,
                "email": "hops@local.com"
            },
            {
                "emailid": 5,
                "email": "bunny@hoppin.local"
            }
        ]
    },
    {
        "employeeid": 6,
        "name": "BARNBARN",
        "salary": 80000.0,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 7,
                "email": "barnbarn@local.com"
            }
        ]
    },
    {
        "employeeid": 8,
        "name": "JOHN",
        "salary": 75000.0,
        "jobnames": [],
        "emails": []
    },
    {
        "employeeid": 9,
        "name": "Noel Huels III",
        "salary": 113698.15297821208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 10,
                "email": "mariam.okeefe@gmail.com"
            },
            {
                "emailid": 11,
                "email": "porter.howe@yahoo.com"
            },
            {
                "emailid": 12,
                "email": "georgianne.kemmer@gmail.com"
            }
        ]
    },
    {
        "employeeid": 13,
        "name": "Cristen Jaskolski",
        "salary": 147121.55766714324,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 14,
                "email": "stefanie.harris@gmail.com"
            },
            {
                "emailid": 15,
                "email": "jenae.lockman@yahoo.com"
            },
            {
                "emailid": 16,
                "email": "janise.howe@gmail.com"
            },
            {
                "emailid": 17,
                "email": "dallas.pouros@hotmail.com"
            },
            {
                "emailid": 18,
                "email": "hal.muller@gmail.com"
            },
            {
                "emailid": 19,
                "email": "loris.frami@gmail.com"
            },
            {
                "emailid": 20,
                "email": "garnett.rogahn@yahoo.com"
            },
            {
                "emailid": 21,
                "email": "anisa.hodkiewicz@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 22,
        "name": "Mrs. Rebekah Corkery",
        "salary": 134733.43775082208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 23,
                "email": "harold.jacobi@yahoo.com"
            },
            {
                "emailid": 24,
                "email": "horace.gerhold@gmail.com"
            },
            {
                "emailid": 25,
                "email": "jerica.shanahan@hotmail.com"
            },
            {
                "emailid": 26,
                "email": "owen.swaniawski@hotmail.com"
            },
            {
                "emailid": 27,
                "email": "birdie.mckenzie@yahoo.com"
            }
        ]
    }
]
```

</details>

<details>
<summary>http://localhost:2019/employees/employee/3</summary>

```JSON{
    "employeeid": 3,
    "name": "CINNAMON",
    "salary": 80000.0,
    "jobnames": [
        {
            "jobname": {
                "jobtitleid": 1,
                "title": "Big Boss"
            },
            "manager": "Stumps"
        },
        {
            "jobname": {
                "jobtitleid": 2,
                "title": "Wizard"
            },
            "manager": "Stumps"
        }
    ],
    "emails": [
        {
            "emailid": 4,
            "email": "hops@local.com"
        },
        {
            "emailid": 5,
            "email": "bunny@hoppin.local"
        }
    ]
}
```

</details>

<details>
<summary>http://localhost:2019/employees/employee/777</summary>

```JSON
{
    "title": "Resource Not Found",
    "status": 404,
    "detail": "Error from a BloomTech Application Employee 777 Not Found",
    "timestamp": "2020-07-21 15:49:05",
    "developerMessage": "com.lambdaschool.sampleemps.exceptions.ResourceNotFoundException",
    "errors": []
}
```

</details>

<details>
<summary>http://localhost:2019/employees/employeename/mon</summary>

```JSON
[
    {
        "employeeid": 3,
        "name": "CINNAMON",
        "salary": 80000.0,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            },
            {
                "jobname": {
                    "jobtitleid": 2,
                    "title": "Wizard"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 4,
                "email": "hops@local.com"
            },
            {
                "emailid": 5,
                "email": "bunny@hoppin.local"
            }
        ]
    }
]
```

</details>

<details>
<summary>http://localhost:2019/employees/employeeemail/com</summary>

```JSON
[
    {
        "employeeid": 3,
        "name": "CINNAMON",
        "salary": 80000.0,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            },
            {
                "jobname": {
                    "jobtitleid": 2,
                    "title": "Wizard"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 4,
                "email": "hops@local.com"
            },
            {
                "emailid": 5,
                "email": "bunny@hoppin.local"
            }
        ]
    },
    {
        "employeeid": 6,
        "name": "BARNBARN",
        "salary": 80000.0,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 7,
                "email": "barnbarn@local.com"
            }
        ]
    },
    {
        "employeeid": 9,
        "name": "Noel Huels III",
        "salary": 113698.15297821208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 10,
                "email": "mariam.okeefe@gmail.com"
            },
            {
                "emailid": 11,
                "email": "porter.howe@yahoo.com"
            },
            {
                "emailid": 12,
                "email": "georgianne.kemmer@gmail.com"
            }
        ]
    },
    {
        "employeeid": 9,
        "name": "Noel Huels III",
        "salary": 113698.15297821208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 10,
                "email": "mariam.okeefe@gmail.com"
            },
            {
                "emailid": 11,
                "email": "porter.howe@yahoo.com"
            },
            {
                "emailid": 12,
                "email": "georgianne.kemmer@gmail.com"
            }
        ]
    },
    {
        "employeeid": 9,
        "name": "Noel Huels III",
        "salary": 113698.15297821208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 10,
                "email": "mariam.okeefe@gmail.com"
            },
            {
                "emailid": 11,
                "email": "porter.howe@yahoo.com"
            },
            {
                "emailid": 12,
                "email": "georgianne.kemmer@gmail.com"
            }
        ]
    },
    {
        "employeeid": 13,
        "name": "Cristen Jaskolski",
        "salary": 147121.55766714324,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 14,
                "email": "stefanie.harris@gmail.com"
            },
            {
                "emailid": 15,
                "email": "jenae.lockman@yahoo.com"
            },
            {
                "emailid": 16,
                "email": "janise.howe@gmail.com"
            },
            {
                "emailid": 17,
                "email": "dallas.pouros@hotmail.com"
            },
            {
                "emailid": 18,
                "email": "hal.muller@gmail.com"
            },
            {
                "emailid": 19,
                "email": "loris.frami@gmail.com"
            },
            {
                "emailid": 20,
                "email": "garnett.rogahn@yahoo.com"
            },
            {
                "emailid": 21,
                "email": "anisa.hodkiewicz@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 13,
        "name": "Cristen Jaskolski",
        "salary": 147121.55766714324,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 14,
                "email": "stefanie.harris@gmail.com"
            },
            {
                "emailid": 15,
                "email": "jenae.lockman@yahoo.com"
            },
            {
                "emailid": 16,
                "email": "janise.howe@gmail.com"
            },
            {
                "emailid": 17,
                "email": "dallas.pouros@hotmail.com"
            },
            {
                "emailid": 18,
                "email": "hal.muller@gmail.com"
            },
            {
                "emailid": 19,
                "email": "loris.frami@gmail.com"
            },
            {
                "emailid": 20,
                "email": "garnett.rogahn@yahoo.com"
            },
            {
                "emailid": 21,
                "email": "anisa.hodkiewicz@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 13,
        "name": "Cristen Jaskolski",
        "salary": 147121.55766714324,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 14,
                "email": "stefanie.harris@gmail.com"
            },
            {
                "emailid": 15,
                "email": "jenae.lockman@yahoo.com"
            },
            {
                "emailid": 16,
                "email": "janise.howe@gmail.com"
            },
            {
                "emailid": 17,
                "email": "dallas.pouros@hotmail.com"
            },
            {
                "emailid": 18,
                "email": "hal.muller@gmail.com"
            },
            {
                "emailid": 19,
                "email": "loris.frami@gmail.com"
            },
            {
                "emailid": 20,
                "email": "garnett.rogahn@yahoo.com"
            },
            {
                "emailid": 21,
                "email": "anisa.hodkiewicz@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 13,
        "name": "Cristen Jaskolski",
        "salary": 147121.55766714324,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 14,
                "email": "stefanie.harris@gmail.com"
            },
            {
                "emailid": 15,
                "email": "jenae.lockman@yahoo.com"
            },
            {
                "emailid": 16,
                "email": "janise.howe@gmail.com"
            },
            {
                "emailid": 17,
                "email": "dallas.pouros@hotmail.com"
            },
            {
                "emailid": 18,
                "email": "hal.muller@gmail.com"
            },
            {
                "emailid": 19,
                "email": "loris.frami@gmail.com"
            },
            {
                "emailid": 20,
                "email": "garnett.rogahn@yahoo.com"
            },
            {
                "emailid": 21,
                "email": "anisa.hodkiewicz@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 13,
        "name": "Cristen Jaskolski",
        "salary": 147121.55766714324,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 14,
                "email": "stefanie.harris@gmail.com"
            },
            {
                "emailid": 15,
                "email": "jenae.lockman@yahoo.com"
            },
            {
                "emailid": 16,
                "email": "janise.howe@gmail.com"
            },
            {
                "emailid": 17,
                "email": "dallas.pouros@hotmail.com"
            },
            {
                "emailid": 18,
                "email": "hal.muller@gmail.com"
            },
            {
                "emailid": 19,
                "email": "loris.frami@gmail.com"
            },
            {
                "emailid": 20,
                "email": "garnett.rogahn@yahoo.com"
            },
            {
                "emailid": 21,
                "email": "anisa.hodkiewicz@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 13,
        "name": "Cristen Jaskolski",
        "salary": 147121.55766714324,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 14,
                "email": "stefanie.harris@gmail.com"
            },
            {
                "emailid": 15,
                "email": "jenae.lockman@yahoo.com"
            },
            {
                "emailid": 16,
                "email": "janise.howe@gmail.com"
            },
            {
                "emailid": 17,
                "email": "dallas.pouros@hotmail.com"
            },
            {
                "emailid": 18,
                "email": "hal.muller@gmail.com"
            },
            {
                "emailid": 19,
                "email": "loris.frami@gmail.com"
            },
            {
                "emailid": 20,
                "email": "garnett.rogahn@yahoo.com"
            },
            {
                "emailid": 21,
                "email": "anisa.hodkiewicz@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 13,
        "name": "Cristen Jaskolski",
        "salary": 147121.55766714324,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 14,
                "email": "stefanie.harris@gmail.com"
            },
            {
                "emailid": 15,
                "email": "jenae.lockman@yahoo.com"
            },
            {
                "emailid": 16,
                "email": "janise.howe@gmail.com"
            },
            {
                "emailid": 17,
                "email": "dallas.pouros@hotmail.com"
            },
            {
                "emailid": 18,
                "email": "hal.muller@gmail.com"
            },
            {
                "emailid": 19,
                "email": "loris.frami@gmail.com"
            },
            {
                "emailid": 20,
                "email": "garnett.rogahn@yahoo.com"
            },
            {
                "emailid": 21,
                "email": "anisa.hodkiewicz@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 13,
        "name": "Cristen Jaskolski",
        "salary": 147121.55766714324,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 14,
                "email": "stefanie.harris@gmail.com"
            },
            {
                "emailid": 15,
                "email": "jenae.lockman@yahoo.com"
            },
            {
                "emailid": 16,
                "email": "janise.howe@gmail.com"
            },
            {
                "emailid": 17,
                "email": "dallas.pouros@hotmail.com"
            },
            {
                "emailid": 18,
                "email": "hal.muller@gmail.com"
            },
            {
                "emailid": 19,
                "email": "loris.frami@gmail.com"
            },
            {
                "emailid": 20,
                "email": "garnett.rogahn@yahoo.com"
            },
            {
                "emailid": 21,
                "email": "anisa.hodkiewicz@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 22,
        "name": "Mrs. Rebekah Corkery",
        "salary": 134733.43775082208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 23,
                "email": "harold.jacobi@yahoo.com"
            },
            {
                "emailid": 24,
                "email": "horace.gerhold@gmail.com"
            },
            {
                "emailid": 25,
                "email": "jerica.shanahan@hotmail.com"
            },
            {
                "emailid": 26,
                "email": "owen.swaniawski@hotmail.com"
            },
            {
                "emailid": 27,
                "email": "birdie.mckenzie@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 22,
        "name": "Mrs. Rebekah Corkery",
        "salary": 134733.43775082208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 23,
                "email": "harold.jacobi@yahoo.com"
            },
            {
                "emailid": 24,
                "email": "horace.gerhold@gmail.com"
            },
            {
                "emailid": 25,
                "email": "jerica.shanahan@hotmail.com"
            },
            {
                "emailid": 26,
                "email": "owen.swaniawski@hotmail.com"
            },
            {
                "emailid": 27,
                "email": "birdie.mckenzie@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 22,
        "name": "Mrs. Rebekah Corkery",
        "salary": 134733.43775082208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 23,
                "email": "harold.jacobi@yahoo.com"
            },
            {
                "emailid": 24,
                "email": "horace.gerhold@gmail.com"
            },
            {
                "emailid": 25,
                "email": "jerica.shanahan@hotmail.com"
            },
            {
                "emailid": 26,
                "email": "owen.swaniawski@hotmail.com"
            },
            {
                "emailid": 27,
                "email": "birdie.mckenzie@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 22,
        "name": "Mrs. Rebekah Corkery",
        "salary": 134733.43775082208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 23,
                "email": "harold.jacobi@yahoo.com"
            },
            {
                "emailid": 24,
                "email": "horace.gerhold@gmail.com"
            },
            {
                "emailid": 25,
                "email": "jerica.shanahan@hotmail.com"
            },
            {
                "emailid": 26,
                "email": "owen.swaniawski@hotmail.com"
            },
            {
                "emailid": 27,
                "email": "birdie.mckenzie@yahoo.com"
            }
        ]
    },
    {
        "employeeid": 22,
        "name": "Mrs. Rebekah Corkery",
        "salary": 134733.43775082208,
        "jobnames": [
            {
                "jobname": {
                    "jobtitleid": 1,
                    "title": "Big Boss"
                },
                "manager": "Stumps"
            }
        ],
        "emails": [
            {
                "emailid": 23,
                "email": "harold.jacobi@yahoo.com"
            },
            {
                "emailid": 24,
                "email": "horace.gerhold@gmail.com"
            },
            {
                "emailid": 25,
                "email": "jerica.shanahan@hotmail.com"
            },
            {
                "emailid": 26,
                "email": "owen.swaniawski@hotmail.com"
            },
            {
                "emailid": 27,
                "email": "birdie.mckenzie@yahoo.com"
            }
        ]
    }
]
```

</details>

<details>
<summary>POST http://localhost:2019/employees/employee</summary>

DATA

```JSON
{
    "name": "Mojo",
    "salary": 100000.00,
    "jobnames": [
        {
            "jobname":{
                "jobtitleid": 2,
                "title": "Wizard"
            },
            "manager":"stumps"
        }
    ],
    "emails": [
        {
            "email": "mojo@local.com"
        },
        {
            "email": "corgi@home.local"
        }
    ]
}
```

OUTPUT

```TEXT
Location Header: http://localhost:2019/employees/employee/22
STATUS 201 Created
```

</details>

<details>
<summary>PUT http://localhost:2019/employees/employee/13</summary>

DATA

```JSON
{
    "name": "Corgie",
    "salary": 80000.00,
    "jobnames": [
        {
            "jobname":{
                "jobtitleid": 2,
                "title": "Wizard"
            },
            "manager":"stumps"
        },
        {
            "jobname":{
                "jobtitleid": 1,
                "title": "Big Boss"
            },
            "manager":"stumps"
        }
    ],
    "emails": [
        {
            "email": "hops@local.com"
        },
        {
            "email": "bunny@hoppin.local"
        }
    ]
}

```

OUTPUT

```TEXT
STATUS 200 OK
```

</details>

<details>
<summary>PATCH http://localhost:2019/employees/employee/16</summary>

DATA

```JSON
{
    "salary": 100000.00
}
```

OUTPUT

```TEXT
STATUS 200 OK
```

</details>

<details>
<summary>DELETE http://localhost:2019/employees/employee/16</summary>

OUTPUT

```TEXT
STATUS 200 OK
```

</details>

[Sample Swagger Documentation](https://drive.google.com/file/d/1EijscrIhpv6lbnSbLXcaH7NeLFCEpI2l/view)
