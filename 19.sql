-- 1 Retrieve all the columns from the Customers table for customers who are from the UK.

SELECT * 
FROM Customers
WHERE Country = 'UK';

-- 2 Using the Products table, list the product names and their unit prices where the unit price is greater than 30.
SELECT ProductName, UnitPrice
FROM Products
WHERE UnitPrice > 30;

-- 3 Count the number of products in the Products table that have been discontinued. 
SELECT COUNT(discontinued)
FROM Products;

-- 4 Find the average, maximum, and minimum unit prices from the Products table.
SELECT AVG(UnitPrice) AS avgUnitPrice, MAX(UnitPrice) as maxUnitPrice, MIN(UnitPrice) as minUnitPrice
FROM Products;

-- 5 Retrieve the names of categories and the count of products in each category from the Categories and Products tables.
SELECT c.CategoryName, Count(p.ProductID)
FROM products p
JOIN Categories c ON p.CategoryID = c.CategoryID
GROUP BY c.CategoryName;


-- 6 List the suppliers (SupplierID and CompanyName) from the Suppliers table who are not from USA, Germany, or UK. 
SELECT SupplierID, CompanyName, Country
FROM Suppliers
WHERE Country NOT IN ('USA', 'Germany', 'UK');

-- 7 Retrieve all the distinct countries from the Customers table.
SELECT DISTINCT(Country)
FROM Customers
ORDER BY Country;

-- 8 Find the top 5 most expensive products (Product name and Unit price) from the Products table.
SELECT ProductName, UnitPrice
FROM Products
ORDER BY UnitPrice DESC
LIMIT 5;

-- 9 Using the Orders and Order Details tables, calculate the total revenue for each order (OrderID). 
SELECT o.OrderID, SUM(od.UnitPrice * od.Quantity) AS TotalRevenue
FROM orders o 
JOIN `Order Details` od ON o.OrderID = od.OrderID
GROUP BY o.OrderID
ORDER BY o.OrderID;

-- 10 List all employees (FirstName and LastName) and the count of orders they have taken from the Employees and Orders tables.
SELECT e.FirstName, e.LastName, Count(o.OrderID)
FROM Employees e
JOIN Orders o ON e.EmployeeID = o.EmployeeID
GROUP BY e.EmployeeID
ORDER BY e.EmployeeID;

-- 11 Retrieve customers (CustomerID and CompanyName) who have placed more than 10 orders using the Customers and Orders tables. 
SELECT c.CustomerID, c.CompanyName, COUNT(o.OrderID) AS count
FROM Customers c
JOIN Orders o ON c.CustomerID = o.CustomerID
GROUP BY CustomerID
HAVING COUNT(o.OrderID) > 10
ORDER BY count; 

-- 12 From the Products table, retrieve the names of products that are out of stock (units in stock is 0).
SELECT ProductName, UnitsInStock
FROM Products
WHERE UnitsInStock = 0;

-- 13 Using the Products and Categories tables, list the names of products and their respective categories where the category is either 'Beverage' or 'Confectionery'.
SELECT p.ProductName, c.CategoryName
FROM Products p
JOIN Categories c ON p.CategoryID = c.CategoryID
WHERE c.CategoryName='Beverages'OR c.CategoryName =  'Confections';

-- 14 Identify which supplier (SupplierID and CompanyName from Suppliers table) has the highest number of products in the Products table.
SELECT s.SupplierID, s.CompanyName, Count(p.ProductID) AS ProductCount
FROM Suppliers s
JOIN Products p ON s.SupplierID = s.SupplierID
GROUP BY SupplierID, s.CompanyName
ORDER BY ProductCount DESC
LIMIT 1;

-- 15 List all the products (ProductID and ProductName) which have never been ordered. Use the Products and Order Details tables. 
SELECT p.ProductID, p.ProductName
FROM Products p 
LEFT JOIN `Order Details` od ON p.ProductID = od.ProductID
WHERE od.ProductID IS NULL;

-- 16 Retrieve all orders (OrderID from Orders table) that were placed in December 1997. 
SELECT OrderID, OrderDate
FROM Orders
WHERE OrderDate >= '1997-12-1' AND OrderDate <= '1997-12-31';

-- 17 Using the Employees and Orders tables, find out which employee has processed the most number of orders in 1998.
SELECT e.FirstName, e.LastName, COUNT(o.OrderID) AS OrderCount
FROM Employees e 
JOIN Orders o ON e.EmployeeID = e.EmployeeID
WHERE o.OrderDate >= '1998-1-1' AND o.OrderDate <= '1998-12-31'
GROUP BY e.EmployeeID
ORDER BY OrderCount DESC
LIMIT 1;

-- 18 Find the customer (CustomerID and CompanyName from Customers table) who has purchased the most by quantity in the Order Details table.
SELECT c.CustomerID, c.CompanyName, SUM(od.Quantity) AS TotalQuantity
FROM Customers c
JOIN Orders o ON c.CustomerID = o.CustomerID
JOIN `Order Details` od ON o.OrderID = od.OrderID
GROUP BY c.CustomerID, c.CompanyName
ORDER BY TotalQuantity DESC
LIMIT 1;

-- 19 From the Shippers and Orders tables, determine which shipper has delivered the most number of orders. 
SELECT s.ShipperID, s.CompanyName, COUNT(o.OrderID) AS TotalOrders
FROM Shippers s
JOIN Orders o ON s.ShipperID = o.ShipVia
GROUP BY s.ShipperID, s.CompanyName
ORDER BY TotalOrders DESC
LIMIT 1;

-- 20 Identify the top 3 categories in terms of the number of products they have using the Categories and Products tables. 
SELECT c.CategoryID, c.CategoryName, COUNT(p.ProductID) AS ProductCount
FROM Categories c
LEFT JOIN Products p ON c.CategoryID = p.CategoryID
GROUP BY c.CategoryID, c.CategoryName
ORDER BY ProductCount DESC
LIMIT 3;