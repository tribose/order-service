A > Exposed REST URI:

1. Create an Order  : POST Service

	http://localhost:8081/orders
	
	Sample Request Body: 
	
	{
		"customer_name": "Alice",
		"order_date": "02/03/2019",
		"shipping_address": "Bangalore",
		"order_item": [
			{
				"productName": "Jacket",
				"count": 2
			},
			{
				"productName": "Shirt",
				"count": 1
			}
		],
		"total": 700
	}
	
2. Get All Order: GET Service

	http://localhost:8081/orders
	
3. Get Order by Order Number : GET Service

	http://localhost:8081/orders/{orderNumber}
	
	
B > To Open H2 DB UI console

	http://localhost:8081/h2-console/

	Driver class : org.h2.Driver

	JDBC URL : jdbc:h2:mem:orderdb
	
	User name : admin
	
	Password: password