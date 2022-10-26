import json
import requests

response_API = requests.get('https://fakestoreapi.com/products')
data = response_API.text
parse_json = json.loads(data)


def displayProducts(products):
    for product in products:
        print(product["id"], "|",  product["title"], "|", product["price"])

displayProducts(parse_json)