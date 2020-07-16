DROP TABLE IF EXISTS tbl_order;
	 
CREATE TABLE tbl_order (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  customer_name VARCHAR(250) NOT NULL,
  order_date VARCHAR(250) NOT NULL,
  shipping_address VARCHAR(250) NOT NULL,
  order_item VARCHAR(250) NOT NULL,
  total VARCHAR(250) NOT NULL
);

INSERT INTO tbl_order (customer_name, order_date, shipping_address, order_item, total) VALUES ('Alice', '01/01/2020', 'Washington', 'Shirt', '20');