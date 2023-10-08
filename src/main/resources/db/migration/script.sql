
-- Create Investor table
CREATE TABLE Investor (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(20),
                          surname VARCHAR(20),
                          date_of_birth DATE,
                          address VARCHAR(255),
                          mobile_number VARCHAR(15),
                          email VARCHAR(255)
);

-- Insert Investor data
INSERT INTO Investor (name, surname, date_of_birth, address, mobile_number, email)
VALUES
    ('Jane', 'Smith', '1988-08-29', '888 high street Sandstone', '065-123-4567', 'jane@gmail.com');

-- Create Product table
CREATE TABLE Product (
                         productId SERIAL PRIMARY KEY,
                         productName VARCHAR(10),
                         balance DECIMAL(10, 2)
);

-- Insert values into product table
INSERT INTO Product (productName, balance) VALUES ('RETIREMENT', 500000.00);
INSERT INTO Product (productName, balance) VALUES ('SAVINGS', 36000.00);
