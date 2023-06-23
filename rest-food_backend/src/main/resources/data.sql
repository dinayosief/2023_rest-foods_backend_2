INSERT INTO Menu(type,menuId, img, name, price, description)
VALUES ('Appetizers','1', 'url', 'Frühlingsrollen', '7.80'),
       ('Appetizers','2', 'url', 'Knusprige Ente mit Pfannkuchen', '10.00'),
       ('Appetizers','3', 'url', 'Sichuan-Hühnchen-Satay', '13.00'),

       ('main course','1', 'url', 'Ente in Hoisinsauce', '24.00'),
       ('main course','2', 'url', 'Kung Pao Hühnchen', '26.00'),
       ('main course','3', 'url', 'Süß-saures Hühnchen', '25.00'),

       ('drinks','1', 'url', 'Grüner Tee', '5.00'),
       ('drinks','2', 'url', 'Jasmin-Tee', '5.00'),
       ('drinks','3', 'url', 'Lychee-Saft', '5.50'),

       ('Dessert','1', 'url', 'Gebackene Banane mit Honig', '7.80'),
       ('Dessert','2', 'url', 'Sesambällchen', '6.50'),
       ('Dessert','3', 'url', 'Lychee-Eis', '5.00');

INSERT INTO Reservation(date, time, persons, tel, tableNumber)
VALUES ('2023-06-23', '15:30:00', '2', '076 545 82 44','2'),
       ('2023-06-23', '17:30:00', '3', '076 753 54 56','3'),
       ('2023-06-23', '11:45:00', '1', '076 545 82 44','4'),
       ('2023-06-23', '20:30:00', '4', '076 753 54 56','5');


