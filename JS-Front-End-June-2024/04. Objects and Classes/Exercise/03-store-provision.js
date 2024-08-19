function storeProvision(currentProducts, orderedProducts) {
    const store = {};

    for (let index = 0; index < currentProducts.length; index += 2) {
        const currentProduct = currentProducts[index];
        const currentQuantity = Number(currentProducts[index + 1]);

        store[currentProduct] = currentQuantity;
    }

    for (let index = 0; index < orderedProducts.length; index += 2) {
        const orderedProduct = orderedProducts[index];
        const orderedQuantity = Number(orderedProducts[index + 1]);

        if (store.hasOwnProperty(orderedProduct)) {
            store[orderedProduct] = store[orderedProduct] + orderedQuantity;
        } else {
            store[orderedProduct] = orderedQuantity;
        }
    }

    Object
        .keys(store)
        .forEach(key => console.log(`${key} -> ${store[key]}`));
}

storeProvision(['Chips', '5', 'CocaCola', '9', 'Bananas', '14', 'Pasta', '4', 'Beer', '2'],
    ['Flour', '44', 'Oil', '12', 'Pasta', '7', 'Tomatoes', '70', 'Bananas', '30']);
storeProvision(['Salt', '2', 'Fanta', '4', 'Apple', '14', 'Water', '4', 'Juice', '5'],
    ['Sugar', '44', 'Oil', '12', 'Apple', '7', 'Tomatoes', '7', 'Bananas', '30']);