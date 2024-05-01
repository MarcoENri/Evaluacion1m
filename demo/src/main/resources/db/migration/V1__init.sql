CREATE TABLE IF NOT EXISTS sensor (
                                      sensor_id SERIAL PRIMARY KEY,
                                      sensor_name VARCHAR(100) NOT NULL,
    description TEXT,
    brand VARCHAR(100),
    price DECIMAL(10, 2) NOT NULL
    );
