INSERT INTO Menu (type, menuId, img, name, price, description)
VALUES
    ('Appetizers', '1', 'url', 'Frühlingsrollen', '4.50', 'Knusprige Frühlingsrollen gefüllt mit Gemüse und serviert mit süß-saurer Sauce.'),
    ('Appetizers', '2', 'url', 'Knusprige Ente mit Pfannkuchen', '9.50', 'Zarte Entenstreifen mit dünnen Pfannkuchen, Frühlingszwiebeln und Hoisinsauce.'),
    ('Appetizers', '3', 'url', 'Sichuan-Hühnchen-Satay', '11.50', 'Gegrillte Hühnchenstreifen mariniert in würziger Sichuan-Sauce und serviert mit Erdnusssauce.'),

    ('main course', '1', 'url', 'Ente in Hoisinsauce', '18.50', 'Knusprige Entenbruststücke in einer reichhaltigen Hoisinsauce mit Gemüse.'),
    ('main course', '2', 'url', 'Kung Pao Hühnchen', '20.50', 'Gebratenes Hühnchen mit Gemüse und gerösteten Erdnüssen in einer würzigen Kung Pao-Sauce.'),
    ('main course', '3', 'url', 'Süß-saures Hühnchen', '19.50', 'Knusprig frittiertes Hühnchen mit Paprika, Ananas und Zwiebeln in einer süß-sauren Sauce.'),

    ('drinks', '1', 'url', 'Grüner Tee', '2.50', 'Frischer grüner Tee mit einem Hauch von Jasmin-Aroma.'),
    ('drinks', '2', 'url', 'Jasmin-Tee', '2.50', 'Wohlriechender Jasmin-Tee, der eine beruhigende Wirkung hat.'),
    ('drinks', '3', 'url', 'Lychee-Saft', '3.50', 'Erfrischender Saft aus frischen Lychee-Früchten.'),

    ('Dessert', '1', 'url', 'Gebackene Banane mit Honig', '4.50', 'Karamellisierte Banane mit einer leichten Honignote, serviert mit Eiscreme.'),
    ('Dessert', '2', 'url', 'Sesambällchen', '3.50', 'Knusprige Sesambällchen gefüllt mit süßer Lotuspaste.'),
    ('Dessert', '3', 'url', 'Lychee-Eis', '3.50', 'Erfrischendes Eis mit dem exotischen Geschmack von Lychee.');

INSERT INTO reservation(date, time, persons, tel, tablenumber)
VALUES ('2023-06-23', '15:30:00', '2', '076 545 82 44','2'),
       ('2023-06-23', '17:30:00', '3', '076 753 54 56','3'),
       ('2023-06-23', '11:45:00', '1', '076 545 82 44','4'),
       ('2023-06-23', '20:30:00', '4', '076 753 54 56','5');


