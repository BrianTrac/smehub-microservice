--liquibase formatted sql

--changeset brian-dang:insert-sample-products
INSERT INTO product (id, type, name, total_price, data) VALUE
    ('f9d24df4-0a59-4e41-bd90-d98b2851e111', 'VietTelOffice', 'Package of VO_19', 1200.00,
    JSON_OBJECT('number_of_months_used', 6, 'number_of_users', 160)),
    ('b4a5d3ce-d5e1-47a3-bf3a-27953cfb70d2', 'SInvoiceEI', 'Package of 50 personal income tax deduction certificates', 150.50,
    JSON_OBJECT('number_of_months_used', 12, 'number_of_invoices', 50, 'invoice_fee', 140.35)),
    ('a3e7291d-6ef9-4989-8a66-4ec0c11939a8', 'EasyBooks', 'Easybooks 2 year package 5000 documents circular 133', 89.99,
    JSON_OBJECT('number_of_months_used', 24, 'number_of_documents', 5000, 'circular', '300w', 'has_device', true));
