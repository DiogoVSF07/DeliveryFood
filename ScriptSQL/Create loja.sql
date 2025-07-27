CREATE TABLE store (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    tax_id VARCHAR(14) NOT NULL UNIQUE,                -- CGC
    trade_name VARCHAR(150) NOT NULL,                  -- Fantasia
    corporate_name VARCHAR(150) NOT NULL,              -- Razão Social
    street VARCHAR(150) NOT NULL,
    number VARCHAR(10) NOT NULL,
    district VARCHAR(100) NOT NULL,                    -- Bairro
    city VARCHAR(100) NOT NULL,
    state CHAR(2) NOT NULL,                            -- UF
    zip_code VARCHAR(8) NOT NULL,                      -- CEP
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    status ENUM('active', 'inactive') NOT NULL DEFAULT 'active'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
