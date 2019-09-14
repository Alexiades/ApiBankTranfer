# ApiBankTranfer
Api for make transfers between differents accounts.

### How to run

```sh
mvn exec:java
```

### Available Services

| HTTP METHOD | PATH | USAGE |
| -----------| ------ | ------ |
| GET | /account/{accountId} | get account by accountId | 
| POST | /transaction | perform transaction between 2 user accounts | 


### Http Status
- 200 OK: The request has succeeded
- 400 Bad Request: The request could not be understood by the server 
- 404 Not Found: The requested resource cannot be found
- 500 Internal Server Error: The server encountered an unexpected condition 


## Usage

Main Functionality:

![alt text](https://github.com/Alexiades/ApiBankTranfer/blob/master/Readme_schemes/GeneralTransfer.png)

Send Transfer:

![alt text](https://github.com/Alexiades/ApiBankTranfer/blob/master/Readme_schemes/sendApi.png)

 JSON Structure
 
 
### Sample JSON for User and Account
 
 ##### User : 
 ```sh
 {  
   "userName":"test1",
   "emailAddress":"test1@gmail.com"
 } 
 ```
 
##### User Account: : 

```sh
{  
   "userName":"test1",
   "balance":10.0000,
   "currencyCode":"GBP"
} 
```

 
#### User Transaction:

 ```
	{
	   "firstName":"Alex",
	   "lastName":"Alexiades",
	   "currencyCode":"EUR",
	   "Country":"Spain",
	   "fromAccountId":"ES..",
	   "toAccountId":"ES..",
	   "transdate":"Sysdate"
       "amount":"9999"
       "comment":"You own it"
	}

```



## Built With

* [Java](https://maven.apache.org/) - Dependency Management
* [RESTEasy](https://resteasy.github.io/) - Api RESTful Library
* [JSON](https://www.json.org) - Data interchange format
* [JUnit](https://junit.org/junit5/) - Unit testing framework 
* [Log4j](https://logging.apache.org/log4j/2.x/) -  Java-based logging utility 


## Contributing

Please read [CONTRIBUTING.md](https://github.com/Alexiades/ApiBankTranfer/blob/master/CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors

* **Alejandro Alexiades**

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
