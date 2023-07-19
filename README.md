# ts-ncg-2023

## PROBLEM STATEMENT:
The World Bank provides interesting Socio-economic indicator data for countries across the world. Create an application which visualizes the country’s indicators on Charts, with the ability to Create, Delete and List such charts.

## DESCRIPTION:
The application includes the backend scope of the problem statement. The application performs the create, delete, update and read operations on the views 

## Prerequisites:
1. Gradle
2. Java
3. Springboot
4. Postman
5. Any preferred IDE.

## INSTALLATION:
1. Install Gradle from the following link: https://gradle.org/
2. Install Java through any trusted Java Provider (Eg Oracle JDK)
3. Install Postman from the following link: https://www.postman.com/
4. Pull all the folders from the master branch into your local.
5. Run the command `gradle build clean` and then `gradle build`
6. Run the application. By default it will run on http://localhost:8080

## ENDPOINTS:

### 1. createView 
Description: Create a new View 


Method: POST


URL: http://localhost:8080/view


Request Body:


```
{   
    "name": "Shubhi",
    "chartType": "column",
    "country": "IN",
    "indicator": "1.0.HCount.1.90usd",
    "startDate": "2023-07-19",
    "endDate": "2023-07-20"
}
```


Response: 


```
{
    "viewId": 1,
    "name": "Shubhi",
    "chartType": "column",
    "country": "IN",
    "indicator": "1.0.HCount.1.90usd",
    "startDate": "2023-07-19",
    "endDate": "2023-07-20"
}
```


Error Handling:

-Returns HTTP Status Code 500 for Internal Server Error

-Returns HTTP Status Code 400 for bad request



### 2. listAllViews
Description: Get all the views created. 

Method: GET

URL: http://localhost:8080/view

Response: 

```
[
    {
        "viewId": 1,
        "name": "Shubhi",
        "chartType": "column",
        "country": "IN",
        "indicator": "1.0.HCount.1.90usd",
        "startDate": "2023-07-19",
        "endDate": "2023-07-20"
    },
    {
        "viewId": 2,
        "name": "tsncd2023",
        "chartType": "column",
        "country": "EU",
        "indicator": "1.0.HCount.1.2usd",
        "startDate": "2023-07-19",
        "endDate": "2023-07-20"
    }
]
```

Error Handling:

-Returns HTTP Status Code 500 for Internal Server Error

### 3. getViewById

Description: Get the view by viewId

Method: GET

URL: http://localhost:8080/view/viewId

Response: 

```
{
    "viewId": 1,
    "name": "Shubhi",
    "chartType": "column",
    "country": "IN",
    "indicator": "1.0.HCount.1.90usd",
    "startDate": "2023-07-19",
    "endDate": "2023-07-20"
}
```

Error Handling:

-Returns HTTP Status Code 404 for not found

-Returns HTTP Status Code 500 for Internal Server Error


### 4. deleteView

Description: Delete a view by viewId

Method: DELETE

URL: http://localhost:8080/view/viewId

Response: HTTP STATUS OK

Error Handling:

-Returns HTTP Status Code 404 for not found

-Returns HTTP Status Code 500 for Internal Server Error


### 5. updateView

Description: Update a view by viewId

Method: PUT

URL: http://localhost:8080/view/viewId

Request Body:

```
{   
    "name": "ShubhiUpdate123",
    "chartType": "column",
    "country": "IN",
    "indicator": "1.0.HCount.1.90usd",
    "startDate": "2023-07-19",
    "endDate": "2023-07-20"
}
```

Response: 

```
{
    "viewId": 1,
    "name": "ShubhiUpdate123",
    "chartType": "column",
    "country": "IN",
    "indicator": "1.0.HCount.1.90usd",
    "startDate": "2023-07-19",
    "endDate": "2023-07-20"
}
```

Error Handling:

-Returns HTTP Status Code 404 for not found

-Returns HTTP Status Code 500 for Internal Server Error

-Returns HTTP Status Code 400 for bad request


## PREVIEW: 

Please click on the following link for a the demo of the project: https://youtu.be/Q81KoLJpqZY
