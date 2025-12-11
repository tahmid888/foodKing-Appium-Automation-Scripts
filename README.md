
# FoodKing Customer App – Mobile Automation Framework

### Automated Android Testing using Appium, TestNG, and POM Architecture

##  About FoodKing Restaurant
FoodKing Restaurant Management & Food Delivery System is a complete platform offering:

- Online food ordering
- Inventory & restaurant management
- Delivery tracking
- Point of sale
- Customer relationship management
- Scheduled order times

The FoodKing system is built as a Single Page Application (SPA) and fully API-based.
The website and app provide customers with detailed information about:
- Menu items
- Offers & promotions
- Restaurant details
- Ordering process
FoodKing is known for its user-friendly UI, smooth performance, and flexible customization options making it a powerful solution for both customers and businesses.

## Mobile Automation Test Project
This project automates the FoodKing Customer Android App using:
- Appium (Android Automation)
- Java
- TestNG
- Page Object Model (POM)
- Maven
- TestNG Reports

##  Project Structure

```bash
  FoodKing-Customer-App
│── src
│   └── test
│       └── java
│            ├── base          # Appium driver setup
│            ├── pages         # Page Object Model (POM)
│            ├── tests         # Test classes
│            ├── utils         # Helper utilities
│
│── app/FoodKing.apk           # Tested application
│── pom.xml                    # Maven dependencies
│── testng.xml                 # Test execution suite
│── README.md                  # Project documentation
```
    
## Technologies Used
```bash
| Category       | Tools                   |
| -------------- | ----------------------- |
| Automation     | Appium                  |
| Language       | Java                    |
| Test Runner    | TestNG                  |
| Design Pattern | Page Object Model (POM) |
| Build Tool     | Maven                   |
| Reports        | TestNG HTML Reports     |
```

## Test Execution
### Run All Tests

```bash
 mvn test -DsuiteXmlFile=testng.xml
```
### Run from IDE
Open any test file → Right click → Run

##  Test Reports
After execution, TestNG generates HTML reports:
```bash
 test-output/index.html
```
Open in any browser for full results.

## Test Case List

####  Authentication
Covers all login, signup, logout, and credential validation flows. Ensures secure and correct authentication behavior.
- TC01_LoginTest
- TC02_LoginInvalidTest
- TC03_LoginEmptyFieldTest
-  TC04_SignUpTest
- TC05_SignUpEmptyFieldTest
- TC35_LogOutTest

#### Search & Menu
Validates food search, search results, menu visibility, and menu item listing.
- TC07_SearchFunctionalityTest
- TC08_NoSearchResultTest
- TC09_PartialSearchResultTest
- TC10_VerifyMenuIsDisplayedTest
- TC11_CountAllMenuAndDisplayedTest
- TC12_SelectMenuWithItemTest

####  Cart & Checkout
Covers adding/removing items, quantity updates, subtotal calculations, empty cart behavior, and checkout flows.
- TC13_VerifyItemToCartTest
- TC14_VerifyIncFromCartTest
- TC15_VerifyRemoveItemFromCartTest
- TC16_SubTotalAmountTest
- TC17_EmptyCartTest
- TC18_ProceedToCheckoutwithoutLoginTest
- TC19_ProceedToCheckoutTest

#### Address & Delivery
Manages delivery-related functions: adding/editing addresses, selecting delivery locations, delivery time preferences, and verifying delivery/takeaway charges.
- TC20_DeliveryAddressSelectionTest
- TC21_EditDeliveryAddressTest
- TC22_AddDeliveryAddressTest
- TC23_PreferenceTimeToDeliveryTest
- TC24_VerifyCartSummeryDetailsTest
- TC25_VerifyTotalDeliveryTest
- TC26_VerifyTotalTakewayTest

####  Order Placement
Ensures smooth order submission, order confirmation, order history verification, and online payment functionality.
- TC27_PlaceOrderTest
- TC28_VerifyPlacedOrderTest
- TC29_VerifyMyOrdersTest
- TC30_OnlinePaymentTest

#### Profile & Settings
Validates profile updates, account deletion, password changes, language preferences, and app logout.
- TC31_EditProfileTest
- TC32_DeleteAccountTest
- TC33_ChangePasswordTest
- TC34_ChangeLanguageTest

## License
Copyright © 2025, iNiLabs Ltd | Mobile Automation by Tahamidul Haque
- [@iNiLabs](https://inilabs.net)


## Demo
https://play.google.com/store/apps/details?id=com.inilabs.foodking


## Feedback

If you have any feedback, please reach out to me at tahmidulanon@gmail.com


## Links
[![my_portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://portfolio-sigma-one-98.vercel.app)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](www.linkedin.com/in/tahamidul-haque/)




![Logo](https://foodking.dev/assets/img/hero/foodking.png)
