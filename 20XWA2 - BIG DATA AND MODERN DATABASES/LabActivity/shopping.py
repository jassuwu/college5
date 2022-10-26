import json
import datetime
import uuid

"""
@author: 20PW14
Note: The errors are not handled in this code in every case. It assumes that the input is correct.
"""


class Product:
    # Constructor
    def __init__(self, name, price, quantity, uniqueIdentifier, brand):
        self.name = name
        self.price = price
        self.quantity = quantity
        self.uniqueIdentifier = uniqueIdentifier
        self.brand = brand

    # Class methods
    def toJSON(self):
        theDict = {"name": self.name, "price": self.price, "quantity": self.quantity,
                   "uniqueIdentifier": self.uniqueIdentifier, "brand": self.brand}
        return json.dumps(theDict)

    def __repr__(self):
        return "Product(" + self.name + "," + str(self.price) + "," + str(self.quantity) + "," + self.uniqueIdentifier + "," + self.brand + ")"


class Clothing(Product):
    # Constructor
    def __init__(self, name, price, quantity, uniqueIdentifier, brand, size, material):
        Product.__init__(self, name, price, quantity, uniqueIdentifier, brand)
        self.size = size
        self.material = material

    # Class methods
    def toJSON(self):
        theDict = {"name": self.name, "price": self.price, "quantity": self.quantity,
                   "uniqueIdentifier": self.uniqueIdentifier, "brand": self.brand, "size": self.size, "material": self.material}
        return json.dumps(theDict)

    def __repr__(self):
        return "Clothing(" + self.name + "," + str(self.price) + "," + str(self.quantity) + "," + self.uniqueIdentifier + "," + self.brand + "," + self.size + "," + self.material + ")"


class Food(Product):
    # Contructors
    def __init__(self, name, price, quantity, uniqueIdentifier, brand, expiry_date, gluten_free, suitable_for_vegans):
        Product.__init__(self, name, price, quantity, uniqueIdentifier, brand)
        self.expiry_date = expiry_date
        self.gluten_free = gluten_free
        self.suitable_for_vegans = suitable_for_vegans

    # Class Methods
    def toJSON(self):
        theDict = {"name": self.name, "price": self.price, "quantity": self.quantity, "uniqueIdentifier": self.uniqueIdentifier,
                   "brand": self.brand, "expiry_date": str(self.expiry_date), "gluten_free": self.gluten_free, "suitable_for_vegans": self.suitable_for_vegans}
        return json.dumps(theDict)

    def __repr__(self):
        return "Food(" + self.name + "," + str(self.price) + "," + str(self.quantity) + "," + self.uniqueIdentifier + "," + self.brand + "," + str(self.expiry_date) + "," + str(self.gluten_free) + "," + str(self.suitable_for_vegans) + ")"


class ShoppingCart:
    # Constructors
    def __init__(self):
        self.__cart = []

    # Class methods
    def addProduct(self, product):
        self.__cart.append(product)

    def removeProduct(self, sno):
        del self.__cart[sno-1]

    def getContents(self, jsonB=False):
        returnString = ""
        if jsonB:
            for i in range(len(self.__cart)):
                print(i+1, " | ", json.loads(self.__cart[i].toJSON()))
        else:
            for i in range(len(self.__cart)):
                print(i+1, "|", self.__cart[i])

    def changeProductQuantity(self, sno, newQuantity):
        self.__cart[sno-1].quantity = newQuantity


S = ShoppingCart()


print("WELCOME TO 45minsofwork and more due to corrections from jessi.")
print("What do you want to do? ")
print("A. Add an item.")
print("R. Remove an item.")
print("S. Summary of the cart.")
print("Q. Change quantity of the product")
print("E. Get JSONified cart")
print("H. Display available commands")
print("T. Terminate the shopping.")

while (True):
    choice = input("CLI>>> ")
    if choice == "A":
        name = input("Enter the name:")
        price = float(input("Enter the price: "))
        quantity = int(input("Enter the quantity: "))
        uniqueIdentifier = str(uuid.uuid4())
        brand = input("Enter the brand: ")
        clothing = input(
            "Is it special item? (C - Clothing | F - Food | N - No) ")
        if clothing == "C":
            size = input("Enter the size: ")
            material = input("Enter the material: ")
            S.addProduct(Clothing(name, price, quantity,
                         uniqueIdentifier, brand, size, material))
            print("CLOTHING ADDED.")
        elif clothing == "F":
            expiry_date = input(
                "Enter the expiry year, month, day in a csv format: ").split(",")
            expiry_date = datetime.datetime(
                int(expiry_date[0]), int(expiry_date[1]), int(expiry_date[2]))
            gluten_free = input("Is it gluten free? (Y/N)")
            if gluten_free == "Y":
                gluten_free = True
            else:
                gluten_free = False
            suitable_for_vegans = input("Is it suitable for vegans? (Y/N)")
            if suitable_for_vegans == "Y":
                suitable_for_vegans = True
            else:
                suitable_for_vegans = False
            S.addProduct(Food(name, price, quantity, uniqueIdentifier,
                         brand, expiry_date, gluten_free, suitable_for_vegans))
            print("FOOD ADDED.")
        else:
            S.addProduct(Product(name, price, quantity,
                         uniqueIdentifier, brand))
            print("PRODUCT ADDED.")
    elif choice == "R":
        sno = int(input("Enter the S.No. of the product you want to remove: "))
        S.removeProduct(sno)
        print("PRODUCT REMOVED.")
    elif choice == "Q":
        sno = int(input("Enter the S.No. of the product you want to change qty: "))
        newQuantity = int(input("Enter the new quantity of the product: "))
        S.changeProductQuantity(sno, newQuantity)
        print("PRODUCT UPDATED.")
    elif choice == "S":
        print("YOUR CART IN READABLE FORMAT: ")
        S.getContents()
    elif choice == "E":
        print("YOUR CART IN JSON: ")
        S.getContents(jsonB=True)
    elif choice == "H":
        print("A. Add a product.")
        print("R. Remove a product.")
        print("S. Summary of the cart.")
        print("Q. Change quantity of the product")
        print("E. Get JSONified cart")
        print("H. Display available commands")
        print("T. Terminate the shopping.")
    elif choice == "T":
        print("TERMINATING THE APPLICATION.")
        break
    else:
        print("STOP IT. GET SOME HELP. ( H command )")

print("YOUR ORDER WAS PLACED. YOU ORDERED: ")
S.getContents()
