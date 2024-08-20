class Storage {
    capacity;
    storage = [];
    totalCost = 0;

    constructor(capacity) {
        this.capacity = capacity;
    }

    addProduct(product) {
        const productToAdd = {
            name: product.name,
            price: product.price,
            quantity: product.quantity,
        }

        this.storage.push(productToAdd);
        this.capacity -= product.quantity;
        this.totalCost += product.price * product.quantity;
    }

    getProducts() {
        return this.storage.map(product => JSON.stringify(product)).join('\n');
    }
}

let productOne = {name: 'Cucamber', price: 1.50, quantity: 15};
let productTwo = {name: 'Tomato', price: 0.90, quantity: 25};
let productThree = {name: 'Bread', price: 1.10, quantity: 8};
let storage = new Storage(50);
storage.addProduct(productOne);
storage.addProduct(productTwo);
storage.addProduct(productThree);
console.log(storage.getProducts());
console.log(storage.capacity);
console.log(storage.totalCost);