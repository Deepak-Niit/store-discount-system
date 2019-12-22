# store-discount-system

On a retail website, the following discounts apply:
1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.



# Step for build the code
1. Get the clone of the code from the url ="https://github.com/Deepak-Niit/store-discount-system"
2. Go the project location
3. mvn clean install

# Test

AffiliateTest , CustomerTest , EmployeeTest and DiscountCalculatorServiceImplTest cover all the scenario

# Design Pattern

1. Singelton Design pattern to read the properties file only one PropertyReader.java
2. Factory Design Pattern to create the user based on input

# Code Coverage

Install eclema to your IDE.
Right clic k and choose coverage as JUnit to see the code coverage.

# Sonar Report

Install SonarQube locally
run command mvn clean install
run command mvn sonar:sonar
check code quality on http://localhost:9000 (url mention in pom.xml as below)
<properties>
	<sonar.host.url>http://localhost:9000</sonar.host.url>
	</properties>


