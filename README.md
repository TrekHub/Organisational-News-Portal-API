<link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
      integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />

<div style="text-align: center; ">
        <div>
            <h1>Hi There, I'm <span style="color: green; ">Teddy Omondi</span> <span style='font-size:50px;'> &#128075</span></h1>
            <h3>Upcoming Junior Software Developer &#128187; &#127911;</h3>
        </div>
        
</div>
<br>

# Organisational Spark Api <span style='font-size:30px;'> <img height="20" class="mx-1" id="logo-img" src="./images/icons/shop-solid.svg" alt=""></span> 
A REST API for querying and retrieving scoped news and information. There should be news/articles/posts that are available to all employees without navigating into any department, and others that are housed/classified within departments




>## Api EndPoints &#128273;

### Departments EndPoints

 <br>

   >-  Create new Department

   ```
POST /departments/new
```



#### Parameters - `Request Body Parameters`

| Name     | Type       | Description                           |
|----------|------------|---------------------------------------|
| id | `Int` | <p>The new value.</p> |
| departName | `String` | <p>Department Name</p> |
| departDesc | `String` | <p>Department Description</p> |
| employeeNo | `Int` | <p>The number of employees  in the department</p> |

<br>

  >- Get all Departments

```
GET /departments/
```

<br>

  >- Get Departments by Id


```
GET departments/id
```

<br>

### Users Endpoints

<br>

   >-  Create new User

   ```
POST /departments/new
```



#### Parameters - `Request Body Parameters`

| Name     | Type       | 
|----------|------------|
| id | `Int` | 
| name | `String` | 
| position | `String` | 
| location | `String` |
| department | `String` | 
| departId | `String` | 



<br>

  >- Get all Users

```
GET /users
```

<br>

  >- Get USer by Id


```
GET users/id
```

<br>

  >- Get USer by Department he/she belongs


```
GET users/departments/departId
```

<br>

### News Endpoints

<br>

   >-  Create new News

   ```
POST /news/new
```



#### Parameters - `Request Body Parameters`

| Name     | Type       | 
|----------|------------|
| id | `Int` | 
| title | `String` | 
| content | `String` | 
| departId | `String` | 



<br>

  >- Get all News

```
GET /news
```

<br>

  >- Get News by Id


```
GET news/id
```

<br>

  >- Get News by Department related to it


```
GET news/departments/departId
```

<br>


# Technology Used <span style='font-size:30px;'>&#128187;</span> 

1. Java

2. Spark

3. Postgres

3. HandleBars



# Author <span style='font-size:30px;'>&#128524;</span> 

Teddy Omondi 

# License  <span style='font-size:30px;'>🔐</span> 
[MIT](https://choosealicense.com/licenses/mit/)