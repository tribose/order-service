DROP TABLE IF EXISTS tbl_product;
DROP TABLE IF EXISTS tbl_order;
	 
CREATE TABLE tbl_order (
  id INT AUTO_INCREMENT PRIMARY KEY,
  order_number INT NOT NULL,
  customer_name VARCHAR(250) NOT NULL,
  order_date VARCHAR(250) NOT NULL,
  shipping_address VARCHAR(250) NOT NULL,
  total VARCHAR(250) NOT NULL
);

CREATE TABLE tbl_product (
	id INT AUTO_INCREMENT PRIMARY KEY,
	product_name VARCHAR(250) NOT NULL,
	product_count VARCHAR(250) NOT NULL,
	order_id INT,
	CONSTRAINT FK_ORDER_ID FOREIGN KEY (order_id) REFERENCES tbl_order(id)
);