--liquibase formatted sql

--changeset brian-dang:create-product-table
CREATE TABLE product (
                         id VARCHAR(36) NOT NULL PRIMARY KEY,
                         type VARCHAR(100),
                         name VARCHAR(255),
                         total_price DOUBLE,
                         data JSON,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         created_by VARCHAR(255) default 'system',
                         updated_by VARCHAR(255) default 'system',
                         deleted BOOLEAN DEFAULT FALSE
);
