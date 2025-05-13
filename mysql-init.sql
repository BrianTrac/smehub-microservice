-- Create databases for each service
CREATE DATABASE IF NOT EXISTS identity_db;
CREATE DATABASE IF NOT EXISTS keycloak_db;
CREATE DATABASE IF NOT EXISTS product_db;
CREATE DATABASE IF NOT EXISTS order_db;
CREATE DATABASE IF NOT EXISTS payment_db;
CREATE DATABASE IF NOT EXISTS notification_db;


-- Create a user for the identity service
CREATE USER IF NOT EXISTS 'identity_user'@'%' IDENTIFIED BY 'identity_pass';
GRANT ALL PRIVILEGES ON identity_db.* TO 'identity_user'@'%';
FLUSH PRIVILEGES;

-- Create a user for the keycloak service
DROP USER IF EXISTS 'keycloak_user'@'%';
CREATE USER 'keycloak_user'@'%' IDENTIFIED WITH mysql_native_password BY 'keycloak_pass';
GRANT ALL PRIVILEGES ON keycloak_db.* TO 'keycloak_user'@'%';
FLUSH PRIVILEGES;

-- Create a user for the product service
CREATE USER IF NOT EXISTS 'product_user'@'%' IDENTIFIED BY 'product_pass';
GRANT ALL PRIVILEGES ON product_db.* TO 'product_user'@'%';
FLUSH PRIVILEGES;

-- Create a user for the order service
CREATE USER IF NOT EXISTS 'order_user'@'%' IDENTIFIED BY 'order_pass';
GRANT ALL PRIVILEGES ON order_db.* TO 'order_user'@'%';
FLUSH PRIVILEGES;

-- Create a user for the payment service
CREATE USER IF NOT EXISTS 'payment_user'@'%' IDENTIFIED BY 'payment_pass';
GRANT ALL PRIVILEGES ON payment_db.* TO 'payment_user'@'%';
FLUSH PRIVILEGES;

-- Create a user for the notification service
CREATE USER IF NOT EXISTS 'notification_user'@'%' IDENTIFIED BY 'notification_pass';
GRANT ALL PRIVILEGES ON notification_db.* TO 'notification_user'@'%';
FLUSH PRIVILEGES;

