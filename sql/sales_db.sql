-- ============================================================
-- Sales Management System - Database SQL Script
-- University of Sri Jayewardenepura | ICT 1062 | AS20240980
-- ============================================================

CREATE DATABASE sales_db;
USE sales_db;

-- ============================================================
-- TABLE: users
-- Stores system login credentials
-- ============================================================
CREATE TABLE IF users (
    user_id    INT  PRIMARY KEY AUTO_INCREMENT,
    user_name  VARCHAR(25) UNIQUE NOT NULL,
    password   VARCHAR(255)  NOT NULL
);

-- Inserting Values to the users table
INSERT INTO users (user_name, password) 
VALUES ("User_1", "password01"),
       ("User_2", "password02"),
       ("Admin", "admin123"   );

-- Other operations on users table

SELECT * FROM users WHERE user_name =? AND password = BINARY ?;
-- Where user inputs for user_name and password will be checked verified
--     with the database records





-- ============================================================
-- TABLE: customer
-- Stores customer details
-- ============================================================
CREATE TABLE customer (
    customer_id   INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(255) NOT NULL,
    phone_no      VARCHAR(20)  NOT NULL UNIQUE,
    created_by    INT,
    created_date  NOT NULL DATETIME DEFAULT NOW(),
    FOREIGN KEY (created_by) REFERENCES users(user_id)
);

-- Inserting values manually to the Customer Relation

INSERT INTO customer (customer_name, phone_no, created_by) VALUES
	("Jane", "0711234567",3),
 	("John","0771234567",3),
    ("Michael","0761234567",3),
    ("Cydney","0781234567",3),
    ("Senu","0741234567",3),
    ("Siri","0751234567",3),
    ("Cherry","0775555555",3),
    ("Jerry","0765555555",3),
    ("Tom","0745555555",3),
    ("Niki","0715555555",3),
    ("Lili","0769876541",3);


-- ============================================================
-- TABLE: product
-- Stores product catalogue and stock levels
-- ============================================================
CREATE TABLE product (
    product_id   INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(255) NOT NULL,
    unit_price   DECIMAL(7,2) NOT NULL CHECK (unit_price > 0),
    quantity     INT           NOT NULL CHECK (quantity >= 0),
    updated_by   INT,
    created_date DATETIME DEFAULT NOW(),
    updated_date DATETIME DEFAULT NOW() ON UPDATE NOW(),
    is_active    TINYINT(1) NOT NULL DEFAULT 1,
    FOREIGN KEY (updated_by) REFERENCES users(user_id)
);

-- Sample products
INSERT INTO product (product_name, unit_price, quantity, updated_by) VALUES
    ("Rice (1 kg)",         185.00, 100, 3),
    ("Sugar (1 kg)",        220.00, 80,  3),
    ("Flour (1 kg)",        165.00, 60,  3),
    ("Coconut Oil (1 L)",   490.00, 50,  3),
    ("Milk Powder (400 g)", 720.00, 40,  3),
    ("Chocolate (100 g)",   100.00, 30,  3),
    ("Dhal (1 kg)",         260.00, 30,  3);

-- ============================================================
-- TABLE: sale
-- Stores the header record of each sales transaction
-- ============================================================
CREATE TABLE sale (
    sale_id      INT PRIMARY KEY AUTO_INCREMENT,
    customer_id  INT NOT NULL,
    user_id      INT NOT NULL,
    sub_total    DECIMAL(9,2)  NOT NULL,
    sale_date    DATETIME NOT NULL DEFAULT NOW(),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY (user_id)     REFERENCES users(user_id)
);

-- ============================================================
-- TABLE: sale_item
-- Stores details and products of the sale
-- ============================================================
CREATE TABLE sale_item (
    sale_id     INT            NOT NULL,
    product_id  INT            NOT NULL,
    quantity    INT            NOT NULL CHECK (quantity > 0),
    unit_price  DECIMAL(7,2)   NOT NULL,

    PRIMARY KEY (sale_id, product_id),

    CONSTRAINT fk_saleitem_sale
        FOREIGN KEY (sale_id) REFERENCES sale (sale_id),
    CONSTRAINT fk_saleitem_product
        FOREIGN KEY (product_id) REFERENCES product (product_id)
);

