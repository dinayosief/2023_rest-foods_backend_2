INSERT INTO Menu (type, img, name, price, description)
VALUES
    ('Appetizer', 'img/', 'Frühlingsrollen', '4.50', 'Knusprige Frühlingsrollen gefüllt mit Gemüse und serviert mit süß-saurer Sauce.'),
    ('Appetizer', 'img/', 'Knusprige Ente mit Pfannkuchen', '9.50', 'Zarte Entenstreifen mit dünnen Pfannkuchen, Frühlingszwiebeln und Hoisinsauce.'),
    ('Appetizer', 'img/', 'Sichuan-Hühnchen-Satay', '11.50', 'Gegrillte Hühnchenstreifen mariniert in würziger Sichuan-Sauce und serviert mit Erdnusssauce.'),

    ('Main course', 'img/', 'Ente in Hoisinsauce', '18.50', 'Knusprige Entenbruststücke in einer reichhaltigen Hoisinsauce mit Gemüse.'),
    ('Main course',  'img/', 'Kung Pao Hühnchen', '20.50', 'Gebratenes Hühnchen mit Gemüse und gerösteten Erdnüssen in einer würzigen Kung Pao-Sauce.'),
    ('Main course',  'img/', 'Süß-saures Hühnchen', '19.50', 'Knusprig frittiertes Hühnchen mit Paprika, Ananas und Zwiebeln in einer süß-sauren Sauce.'),

    ('Drink',  'img/', 'Grüner Tee', '2.50', 'Frischer grüner Tee mit einem Hauch von Jasmin-Aroma.'),
    ('Drink', 'img/', 'Jasmin-Tee', '2.50', 'Wohlriechender Jasmin-Tee, der eine beruhigende Wirkung hat.'),
    ('Drink',  'img/', 'Lychee-Saft', '3.50', 'Erfrischender Saft aus frischen Lychee-Früchten.'),

    ('Dessert',  'img/', 'Gebackene Banane mit Honig', '4.50', 'Karamellisierte Banane mit einer leichten Honignote, serviert mit Eiscreme.'),
    ('Dessert',  'img/', 'Sesambällchen', '3.50', 'Knusprige Sesambällchen gefüllt mit süßer Lotuspaste.'),
    ('Dessert', 'img/', 'Lychee-Eis', '3.50', 'Erfrischendes Eis mit dem exotischen Geschmack von Lychee.');

INSERT INTO reservation(time, lastname, date, persons, tel, tablenumber)
VALUES ('12:00:am', 'Heule', '2023-10-15', '2', '076 545 82 44','2'),
       ('09:30:am', 'Yosief', '2023-07-04', '3', '076 753 54 56','3'),
       ('05:25:pm', 'Nguyen', '2023-06-12','1', '076 545 82 44','4'),
       ('01:30:am', 'Fürst', '2023-08-04', '4', '076 753 54 56','5');


