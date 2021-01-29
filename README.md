Coverage: 49.5%
# Project Title

Java project that allows user to manage customers,items and orders which are stored in an SQL Database.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Java 11
Git
MySQL 8.0 (at least)
Maven

```
Give examples
```

### Installing

After making sure you have the prerequisites installed clone https://github.com/DDuncan-qa/20DecSDET2-IMS-Starter.git to your system

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests
To run the JUnit test in the package make sure you are in the src/test/java folder. Then right click and select run Coverage as - JUnit Test

### Unit Tests 
Unit tests check how functional your code is
 Testing Create method in Item
 @Test
public void testCreate() {
    final Item created = new Item(3L,"pear", 2.00);
    assertEquals(created, DAO.create(created));

## Deployment
Start application by deploying in the command line ava -jar ims-0.0.1-jar-with-dependencies.jar
Regularly push things up to your GitHub


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
