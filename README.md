Sample Food Order Delivery application with below endpoints :


1. Place and Manage Orders
PUT
/order/OrderUpdate

POST
/order/OrderAdd

GET
/order/Orders

GET
/order/Orders/{id}

DELETE
/order/OrderDelete/{id}
customer-controller

2. Register Users
PUT
/cus/CustomerUpdate

POST
/cus/CustomerAdd

GET
/cus/Customers

GET
/cus/Customer/{id}

DELETE
/cus/CustomerDelete/{id}
rider-controller

3. Add Delivery Rider

PUT
/RiderUpdate

POST
/RiderAdd

GET
/Riders

GET
/Rider/{id}

DELETE
/RiderDelete/{id}

4. Add Restaurent Select restaurent based on type of foods

PUT
/RestaurantUpdate

POST
/RestaurantAdd

GET
/Restaurants/{foodType}

GET
/Restaurants/{field}/{direction}

GET
/Restaurant/{id}

DELETE
/RestaurantDelete/{id}

  
