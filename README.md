Sample Food Order Delivery application with below endpoints :

  ![Screenshot from 2024-05-19 18-17-26](https://github.com/giriraj07/FoodHub/assets/30201275/5a7cd8b3-1117-42f5-8b5c-3e77aa24666c)

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

   ![Screenshot from 2024-05-19 18-18-49](https://github.com/giriraj07/FoodHub/assets/30201275/d085f913-b924-49cb-ba98-5a1bce190cd0)

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

![Screenshot from 2024-05-19 18-19-40](https://github.com/giriraj07/FoodHub/assets/30201275/eaf78a46-c26c-4e3b-a087-2239b3ed2bc0)

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
   ![Screenshot from 2024-05-19 18-19-40](https://github.com/giriraj07/FoodHub/assets/30201275/7c022df1-55d4-412c-8136-4ae163fdc7de)


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

  
