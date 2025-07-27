CREATE TABLE product (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    sale_price DECIMAL(10,2) NOT NULL,                  -- preco_venda
    note TEXT,                                          -- observacao
    image VARCHAR(255),
    store_id INT UNSIGNED NOT NULL,                     -- id_loja
    category_id INT UNSIGNED NOT NULL,                  -- id_categoria
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    status ENUM('active', 'inactive') NOT NULL DEFAULT 'active',
    CONSTRAINT fk_product_store FOREIGN KEY (store_id) REFERENCES store(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES category(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
