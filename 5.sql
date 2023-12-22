SELECT *
FROM Customers;

#2
SELECT CompanyName, ContactName
FROM Customers;

#3
SELECT DISTINCT(Country)
FROM Customers
ORDER BY Country;

#4 Write a SQL query to find all customers from the Customers table who are from the UK.
SELECT *
FROM Customers
WHERE Country = 'UK';

#5 Write a SQL query to list all orders from the Orders table where the Freight is between 50 and 100.
SELECT *
FROM Orders
WHERE Freight >= 50 AND Freight <= 100;

#6 Write a SQL query to find all orders from the Orders table where the OrderDate is after '1997-01-01' AND the ShipCountry is either 'USA' or 'Canada'.
SELECT *
FROM Orders
WHERE OrderDate > '1997-01-01' AND (ShipCountry = 'USA' OR ShipCountry = 'Canada');

#7 Write a SQL query to display orders from the Orders table where the ShipCountry is in ('France', 'Belgium', 'Germany').
SELECT *
FROM Orders
WHERE ShipCountry IN ('France', 'Belgium', 'Germany');

#8 Write a SQL query to select all products from the Products table with a UnitPrice between 10 and 20.
SELECT *
FROM Products
WHERE UnitPrice >= 10 AND UnitPrice <= 20;

#9
SELECT *
FROM Suppliers
ORDER BY Country;

#10
SELECT *
FROM Customers
ORDER BY ContactName DESC;

#11
/*
EmployeeID int AI PK
LastName varchar(20)
FirstName varchar(10)
Title varchar(30)
TitleOfCourtesy varchar(25)
BirthDate datetime
HireDate datetime
Address varchar(60)
City varchar(15)
Region varchar(15)
PostalCode varchar(10)
Country varchar(15)
HomePhone varchar(24)
Extension varchar(4)
Photo longblob
Notes mediumtext
ReportsTo int
PhotoPath varchar(255)
Salary float

*/
#12
SELECT * 
FROM Orders
WHERE OrderDate = '1996-07-04';

#13
SELECT CompanyName
FROM Customers
WHERE CustomerId = (
	SELECT CustomerID
    FROM Orders
    WHERE OrderID = '10248');
    
    
#14
SELECT ProductID
FROM `Order Details`;