import json
import requests

response_API = requests.get('https://fakestoreapi.com/products')
data = response_API.text
parsedJSON = json.loads(data)


def displayProducts(products):
    for product in products:
        print(product["id"], "|",  product["title"], "|", product["price"])

# Session Cart
cart = []

def displayCart(cart):
    for i in range(len(cart)):
        print(i+1, "|", cart[i])

while(True):
    print("WELCOME TO 15minsofwork.")
    print("What do you want to do? ")
    print("1. Add an item")
    print("2. Remove an item")
    print("3. Get me out of here.")
    choice = int(input())
    if choice == 1:
        displayProducts(parsedJSON)
        itemid = int(input())
        cart.append(parsedJSON[itemid-1])
    elif choice == 2:
        displayCart(cart)
        itemid = int(input())
        del cart[parsedJSON[itemid-1]]
    elif choice == 3:
        break
    else:
        print("BRO THERE ARE LIKE THREE NUMBERS AND YOU STILL COULDN'T DO IT RIGHT.")
    
print("YOUR ORDER WAS PLACED. YOU ORDERED: ")
print(cart)