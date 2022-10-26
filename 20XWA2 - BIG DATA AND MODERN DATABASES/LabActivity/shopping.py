import json, datetime, uuid

class Product:
    
    # Class members
    name=""
    price=0
    quantity=0
    uniqueIdentifier=""
    brand=""
    
    # Constructor
    def __init__(self, name, price, quantity, uniqueIdentifier, brand):
        self.name = name
        self.price = price
        self.quantity = quantity
        self.uniqueIdentifier = uniqueIdentifier
        self.brand = brand
        
    # Class methods
    def toJSON(self):
        theDict={"name":self.name, "price": self.price, "quantity": self.quantity, "uniqueIdentifier": self.uniqueIdentifier, "brand": self.brand}
        return json.dumps(theDict)
    
    def __repr__(self):
        return "Product(" + self.name + "," + str(self.price) + "," + str(self.quantity) + "," + self.uniqueIdentifier + "," + self.brand + ")"
class Clothing(Product):
    
    # Class members
    size=""
    material=""
    
    # Constructor
    def __init__(self, name, price, quantity, uniqueIdentifier, brand, size, material):
        super().__init__(self, name, price, quantity, uniqueIdentifier, brand)
        self.size = size
        self.brand = brand
    
    # Class methods
    def toJSON(self):
        theDict={"name":self.name, "price": self.price, "quantity": self.quantity, "uniqueIdentifier": self.uniqueIdentifier, "brand": self.brand, "size": self.size, "material": self.material}
        return json.dumps(theDict)
 
class Food(Product):
    
    # Class members
    expiry_date=datetime.datetime(1, 1, 1)
    gluten_free=False
    suitable_for_vegans=False
    
    # Contructors
    def __init__(self, name, price, quantity, uniqueIdentifier, brand, expiry_date, gluten_free, suitable_for_vegans):
        super().__init__(self, name, price, quantity, uniqueIdentifier, brand)
        self.expiry_date = expiry_date
        self.gluten_free = gluten_free
        self.suitable_for_vegans = suitable_for_vegans
        
    # Class Methods
    def toJSON(self):
        theDict={"name":self.name, "price": self.price, "quantity": self.quantity, "uniqueIdentifier": self.uniqueIdentifier, "brand": self.brand, "expiry_date": self.expiry_date, "gluten_free": self.gluten_free, "suitable_for_vegans": self.suitable_for_vegans}
        return json.dumps(theDict)
    
class ShoppingCart:
    # Class members
    cart = []
    
    # Constructors
    def __init__(self):
        self.cart = []
    
    # Class methods
    def addProduct(self, product):
        self.cart.append(product)
        
    def removeProduct(self, sno):
        del self.cart[sno-1]
        
    def getContents(self, jsonB=False):
        if jsonB:
            for i in range(len(self.cart)):
                print(i+1, "|", json.loads(self.cart[i].toJSON()))
        else:
            for i in range(len(self.cart)):
                print(i+1, "|", self.cart[i])
        
    def changeProductQuantity(self, sno, newQuantity):
        self.cart[sno-1].quantity = newQuantity

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

while(True):
    choice = input()
    if choice == "A":
        name=input("Enter the name:")
        price=float(input("Enter the price: "))
        quantity=int(input("Enter the quantity: "))
        uniqueIdentifier=str(uuid.uuid4())
        brand=input("Enter the brand: ")
        S.addProduct(Product(name, price, quantity, uniqueIdentifier, brand))
        print("ITEM ADDED.")
    elif choice == "R":
        sno = int(input("Enter the S.No. of the product you want to remove: "))
        S.removeProduct(sno)
        print("ITEM REMOVED.")        
    elif choice == "Q":
        sno = int(input("Enter the S.No. of the product you want to change qty: "))
        newQuantity = int(input("Enter the new quantity of the product: "))
        S.changeProductQuantity(sno, newQuantity)
    elif choice == "S":
        print("YOUR CART IN JSON: ")
        S.getContents()
    elif choice == "E":
        S.getContents(json=True)
    elif choice == "H":
        print("A. Add an item.")
        print("R. Remove an item.")
        print("S. Summary of the cart.")
        print("Q. Change quantity of the product")
        print("E. Get JSONified cart")
        print("H. Display available commands")
        print("T. Terminate the shopping.")
    elif choice == "T":
        break
    else:
        print("Use H. for HELP.")
    
print("YOUR ORDER WAS PLACED. YOU ORDERED: ")
print(S.getContents())

        