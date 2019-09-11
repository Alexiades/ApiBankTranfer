# ApiBankTranfer
Api for make transfers between differents accounts.

## Installation



```bash
Not define Jet
```

## Usage

Main Functionality:

![alt text](https://github.com/Alexiades/ApiBankTranfer/blob/master/Readme_schemes/General%20Transfer.png)

Send Transfer:

![alt text](https://github.com/Alexiades/ApiBankTranfer/blob/master/Readme_schemes/sendApi.png)

 JSON Structure

 ```
	{
	   "FirstName":"Alex",
	   "LastName":"Alexiades",
	   "Currency":"Eur",
	   "Country":"Spain",
	   "TransfereAccountNumberTo":"ES..",
	   "TransfereAccountNumberFrom":"ES..",
	   "TransferDate":"Sysdate"
       "Amount":"9999"
       "Comment":"You own it"
	}

```

```Java

```

## Built With

* [Java](https://maven.apache.org/) - Dependency Management
* [RESTEasy](https://resteasy.github.io/) - Api RESTful Library
* [JSON](https://www.json.org) - Data interchange format
* [JUnit](https://junit.org/junit5/) - Unit testing framework 

## Contributing

Please read [CONTRIBUTING.md](https://github.com/Alexiades/ApiBankTranfer/blob/master/CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors

* **Alejandro Alexiades**

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
