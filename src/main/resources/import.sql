CREATE TABLE IF NOT EXISTS products (id serial, name VARCHAR(255), cost float, PRIMARY KEY (id));
INSERT INTO products (name, cost) VALUES ('Pen', 25),('Pineapple', 8), ('Apple', 20), ('Pen', 16);

CREATE TABLE IF NOT EXISTS customers (id serial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO customers (name) VALUES ('Kazuhito Kosaka'),('Daimaou'), ('Pikotaro');

CREATE TABLE IF NOT EXISTS orders (customer_id INT, product_id INT, FOREIGN KEY (product_id) REFERENCES products (id), FOREIGN KEY (customer_id) REFERENCES customers (id));
INSERT INTO orders (customer_id, product_id) VALUES (1, 1), (1, 2), (1, 3), (1, 4), (2, 2), (2, 4), (3, 1), (3, 3), (3, 4);