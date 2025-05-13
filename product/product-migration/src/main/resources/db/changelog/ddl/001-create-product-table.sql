--liquibase formatted sql

--changeset brian-dang:create-product-table
CREATE TABLE product (
                         id VARCHAR(36) NOT NULL PRIMARY KEY,
                         type VARCHAR(100),
                         name VARCHAR(255),
                         total_price DOUBLE,
                         data JSON
);
