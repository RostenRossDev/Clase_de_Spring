INSERT INTO DIRECCIONES (CALLE, BARRIO, ALTURA) VALUES ('Calle siempre viva', 'Springfield', '1234');

INSERT INTO PERSONAS (NOMBRE, EDAD, DIRECCION_ID, TELEFONO, EMAIL) VALUES ('nestor', 33, 1, '123456789', 'rosten2016@gmail.com');



INSERT INTO users (username, password, enabled) VALUES ('user', '$2a$10$p7LHk/KItqUEAyK2VksvzeOMeZWi7TXbA7uta3bMOz89uzlNeSe3q', 1)
INSERT INTO users (username, password, enabled)  VALUES ('ADMIN', '$2a$10$p7LHk/KItqUEAyK2VksvzeOMeZWi7TXbA7uta3bMOz89uzlNeSe3q', 1)

INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_USER')

INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_ADMIN')
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_USER')
