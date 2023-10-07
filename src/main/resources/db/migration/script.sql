
-- Create Investor table
CREATE TABLE Investor (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255),
                          surname VARCHAR(255),
                          date_of_birth DATE,
                          address VARCHAR(255),
                          mobile_number VARCHAR(20),
                          email VARCHAR(255)
);

-- Insert Investor data
INSERT INTO Investor (name, surname, date_of_birth, address, mobile_number, email)
VALUES
    ('Jane', 'Smith', '19888-08-29', '888 high street Sandstone', '065-123-4567', 'jane@gmail.com');

-- Create Product table
CREATE TABLE Product (
                         productId SERIAL PRIMARY KEY,
                         productName VARCHAR(255),
                         balance DECIMAL(10, 2)
);

-- Insert values into product table
INSERT INTO Product (productName, balance) VALUES ('RETIREMENT', 500000.00);
INSERT INTO Product (productName, balance) VALUES ('SAVINGS', 36000.00);
