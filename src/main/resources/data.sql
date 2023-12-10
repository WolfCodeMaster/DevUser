--DROP TABLE APP_USER;
--DROP TABLE PHONES;
-- Crear la tabla APP_USER
CREATE TABLE IF NOT EXISTS APP_USER (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active  BOOLEAN DEFAULT true,
    session_token VARCHAR(255) 
);

-- Crear la tabla PHONES
CREATE TABLE IF NOT EXISTS PHONES (
    phone_id INT PRIMARY KEY AUTO_INCREMENT,
    number BIGINT NOT NULL,
    city_code INT NOT NULL,
    country_code VARCHAR(255) NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES APP_USER(user_id)
);

-- Insertar datos en la tabla APP_USER
INSERT INTO APP_USER (name, email, password) VALUES ('Usuario de Prueba', 'pruebas@dominio.com', 'contrasena');


-- Obtener el ID del usuario recién insertado
SET @userId = SELECT USER_ID FROM APP_USER WHERE email = 'pruebas@dominio.com';

-- Insertar teléfonos asociados al usuario
INSERT INTO PHONES (number, city_code, country_code, user_id) VALUES (123456789, 1, '+1', @userId);
INSERT INTO PHONES (number, city_code, country_code, user_id) VALUES (987654321, 1, '+1', @userId);