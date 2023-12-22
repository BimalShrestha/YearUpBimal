SELECT * FROM Vehicles WHERE price BETWEEN 20000 AND 30000;

SELECT * FROM Vehicles WHERE make = 'honda' AND model = 'civic';

SELECT * FROM Vehicles WHERE year BETWEEN 2020 AND 2022;

SELECT * FROM Vehicles WHERE color = 'red';

SELECT * FROM Vehicles WHERE odometer BETWEEN 30000 AND 150000;

SELECT * FROM Vehicles WHERE vehicleType = 'sedan';

INSERT INTO Vehicles (vin, year, make, model, vehicleType, color, odometer, price) 
VALUES ('vin', year, 'make', 'model', 'vehicleType', 'color', odometer, price);

DELETE FROM Vehicles WHERE vin = 'vin';