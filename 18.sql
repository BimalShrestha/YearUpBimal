SELECT * FROM northwind.Suppliers;
-- 1 add a new supplier
INSERT INTO suppliers(SupplierID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax, HomePage)
VALUES(30, 'hop industry', 'Bimal', 'ceo','1212 Bucklane', 'irving','tx','43564','usa','54545454',null,null);

-- 2 add a new product provided by that supplier
INSERT INTO products(ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued)
VALUES('dorian', 30, 7, '1 pice of fruit', 30, 50, 10, 0, 0);

SELECT * FROM northwind.Products;

-- 3 