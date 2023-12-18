INSERT INTO categories(CategoryName, Description)
VALUES('Foreign Foods', 'Foreign foods and drinks');

-- insert more than one thing at a time

INSERT INTO categories(CategoryName, Description)
VALUES('HisSection', 'Comidas y bebidas'),
      ('Bougie', 'Overpriced and kinda mid');
/*      
INSERT INTO categories(Description)
VALUES ('will this even work');-- it will not work
*/

SELECT * FROM categories;
