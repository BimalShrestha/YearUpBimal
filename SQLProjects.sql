

CREATE TABLE Dealerships(
	dealership_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    address VARCHAR(50),
    phone VARCHAR(12));
    
    
CREATE TABLE Vehicles(
	vin INT PRIMARY KEY,
    year INT,
    make VARCHAR(30),
    model VARCHAR(30),
    vehicleType VARCHAR(30),
    color VARCHAR(12),
    odometer INT,
    price float(15,2));
    
    
CREATE TABLE Inventory(
	dealership_id INT,
    vin INT,
    FOREIGN KEY (dealership_id) REFERENCES Dealerships (dealership_id),
    FOREIGN KEY (vin) REFERENCES Vehicles (vin));
    
    
CREATE TABLE Sales_contracts(
	sales_id INT PRIMARY KEY AUTO_INCREMENT,
    dateOfContract DATETIME,
    customerName VARCHAR(50),
    customerEmail VARCHAR(100),
    isFinanced bit,
    vin INT,
    dealership_id INT,
    FOREIGN KEY (dealership_id) REFERENCES Dealerships(dealership_id),
    FOREIGN KEY (vin) REFERENCES Vehicles(vin));
	
    
CREATE TABLE Lease_contracts(
	lease_id INT PRIMARY KEY AUTO_INCREMENT,
    dateOfContract DATETIME,
    customerName VARCHAR(50),
    customerEmail VARCHAR(100),
    vin INT,
    dealership_id INT,
    FOREIGN KEY (dealership_id) REFERENCES Dealerships(dealership_id),
    FOREIGN KEY (vin) REFERENCES Vehicles(vin));
    
    
INSERT INTO Dealerships (name, address, phone) VALUES
('ABC Motors', '123 Main Street', '123-456-7890'),
('XYZ Auto', '456 Oak Avenue', '987-654-3210'),
('Quick Cars', '789 Pine Lane', '555-123-4567'),
('Speedy Autos', '234 Elm Street', '111-222-3333'),
('City Cars', '567 Maple Road', '444-555-6666'),
('Sunset Motors', '890 Birch Drive', '777-888-9999'),
('Golden Wheels', '321 Cedar Lane', '888-777-6666'),
('Express Cars', '654 Pine Street', '333-222-1111'),
('Elite Motors', '987 Oak Road', '999-888-7777'),
('Dynamic Autos', '432 Birch Avenue', '666-555-4444');

INSERT INTO Vehicles (vin, year, make, model, vehicleType, color, odometer, price) VALUES
(123456, 2022, 'Toyota', 'Camry', 'Sedan', 'Blue', 15000, 25000.00),
(789012, 2020, 'Honda', 'Civic', 'Sedan', 'Red', 18000, 22000.50),
(345678, 2021, 'Ford', 'Escape', 'SUV', 'Silver', 20000, 28000.75),
(901234, 2019, 'Chevrolet', 'Malibu', 'Sedan', 'White', 22000, 20000.00),
(567890, 2020, 'Nissan', 'Altima', 'Sedan', 'Black', 17000, 23000.25),
(234567, 2018, 'Hyundai', 'Tucson', 'SUV', 'Gray', 25000, 26000.50),
(890123, 2019, 'Kia', 'Sportage', 'SUV', 'Green', 23000, 24000.75),
(456789, 2021, 'Mazda', 'CX-5', 'SUV', 'Blue', 18000, 27000.00),
(112233, 2022, 'Subaru', 'Outback', 'Wagon', 'Brown', 15000, 29000.25),
(445566, 2020, 'Volkswagen', 'Jetta', 'Sedan', 'Black', 19000, 21000.50),
(778819, 2019, 'Ford', 'F-150', 'Truck', 'Red', 30000, 35000.75),
(223344, 2021, 'Toyota', 'RAV4', 'SUV', 'Silver', 21000, 26000.00),
(667788, 2018, 'Honda', 'Pilot', 'SUV', 'White', 26000, 32000.25),
(990011, 2017, 'Chevrolet', 'Equinox', 'SUV', 'Blue', 28000, 31000.50),
(112235, 2022, 'Jeep', 'Cherokee', 'SUV', 'Gray', 20000, 29000.75),
(445567, 2020, 'Ford', 'Mustang', 'Coupe', 'Red', 15000, 38000.00),
(778899, 2019, 'Nissan', 'Rogue', 'SUV', 'Silver', 24000, 27000.25),
(223544, 2021, 'Hyundai', 'Santa Fe', 'SUV', 'Black', 23000, 30000.50),
(667588, 2018, 'Tesla', 'Model 3', 'Sedan', 'Blue', 12000, 50000.75),
(990051, 2017, 'BMW', 'X5', 'SUV', 'Black', 18000, 45000.00);

INSERT INTO Inventory (dealership_id, vin) VALUES
(1, 123456),
(1, 789012),
(2, 345678),
(2, 901234),
(3, 567890),
(3, 234567),
(4, 890123),
(4, 456789),
(5, 112233),
(5, 445566);

INSERT INTO Sales_contracts (dateOfContract, customerName, customerEmail, isFinanced, vin, dealership_id)
VALUES
('2023-01-15 10:30:00', 'John Doe', 'john.doe@example.com', 1, 123456, 1),
('2023-02-20 14:45:00', 'Jane Smith', 'jane.smith@example.com', 0, 789012, 2),
('2023-03-10 09:15:00', 'Bob Johnson', 'bob.johnson@example.com', 1, 345678, 1),
('2023-04-05 13:00:00', 'Alice Brown', 'alice.brown@example.com', 0, 901234, 3),
('2023-05-22 11:20:00', 'Charlie Davis', 'charlie.davis@example.com', 1, 567890, 2),
('2023-06-18 15:10:00', 'Eva Wilson', 'eva.wilson@example.com', 0, 234567, 3),
('2023-07-08 08:45:00', 'David Lee', 'david.lee@example.com', 1, 890123, 1),
('2023-08-30 12:30:00', 'Grace Taylor', 'grace.taylor@example.com', 0, 456789, 2),
('2023-09-14 09:50:00', 'Samuel Clark', 'samuel.clark@example.com', 1, 112233, 3),
('2023-10-25 14:15:00', 'Olivia Turner', 'olivia.turner@example.com', 0, 445566, 1);

INSERT INTO Lease_contracts (dateOfContract, customerName, customerEmail, vin, dealership_id)
VALUES
('2023-01-05 11:30:00', 'Emily White', 'emily.white@example.com', 123456, 1),
('2023-02-10 14:20:00', 'Michael Johnson', 'michael.johnson@example.com', 789012, 2),
('2023-03-15 09:45:00', 'Sophia Martinez', 'sophia.martinez@example.com', 345678, 1),
('2023-04-20 13:10:00', 'Aiden Davis', 'aiden.davis@example.com', 901234, 3),
('2023-05-25 11:50:00', 'Grace Wilson', 'grace.wilson@example.com', 567890, 2),
('2023-06-30 15:30:00', 'James Taylor', 'james.taylor@example.com', 234567, 3),
('2023-07-08 09:00:00', 'Emma Lee', 'emma.lee@example.com', 890123, 1),
('2023-08-12 12:45:00', 'Logan Brown', 'logan.brown@example.com', 456789, 2),
('2023-09-18 09:15:00', 'Isabella Clark', 'isabella.clark@example.com', 112233, 3),
('2023-10-22 14:40:00', 'Mason Turner', 'mason.turner@example.com', 445566, 1);

-- Get all dealerships
SELECT * 
FROM Dealerships;

-- Find all vehicles for a specific dealership
SELECT *
FROM Vehicles v
JOIN Inventory i ON v.vin = i.vin
JOIN Dealerships d ON i.dealership_id = d.dealership_id;

-- Find a car by vin 
SELECT *
FROM Vehicles
WHERE vin = '123456';

-- find the dealership where a certain car is located, by vin
SELECT *
FROM Dealerships d 
JOIN Inventory i ON d.dealership_id = i.dealership_id
WHERE VIN = '123456';

-- Find all Dealerships that have a certain car type
SELECT *
FROM Dealerships d 
JOIN Inventory i ON d.dealership_id = i.dealership_id
JOIN Vehicles v ON i.vin = v.vin
WHERE v.color = 'Blue' AND v.make = 'Toyota' AND v.model = 'Camry';


-- Get all sales information for a specific dealer for a specific date range
SELECT *
FROM Sales_contracts sc
JOIN Dealerships d ON sc.dealership_id = d.dealership_id
WHERE sc.dateOfContract >='2023-1-15' AND sc.dateOfContract <= '2023-10-25' AND d.dealership_id =1;

