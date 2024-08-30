const baseUrl = 'http://localhost:3030/jsonstore/grocery';

const loadButton = document.getElementById('load-product');
const addProductButton = document.getElementById('add-product');
const updateProductButton = document.getElementById('update-product');
const tbodyElement = document.getElementById('tbody');
const formElement = document.querySelector('form');

const productInputElement = document.getElementById('product');
const countInputElement = document.getElementById('count');
const priceInputElement = document.getElementById('price');

loadButton.addEventListener('click', loadProducts);
addProductButton.addEventListener('click', addProduct);
updateProductButton.addEventListener('click', updateProduct);

async function addProduct(e) {
    e.preventDefault();
    const product = productInputElement.value;
    const count = countInputElement.value;
    const price = priceInputElement.value;

    clearInputData();

    await fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ product, count, price }),
    });

    await loadProducts(e)
    e.preventDefault();
}

async function updateProduct(e) {
    e.preventDefault();
    const productId = formElement.getAttribute('data-product-id');

    const product = productInputElement.value;
    const count = countInputElement.value;
    const price = priceInputElement.value;

    clearInputData();

    await fetch(`${baseUrl}/${productId}`, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ product, count, price, _id: productId }),
    });

    await loadProducts(e);
    e.preventDefault();
}

async function loadProducts(e) {
    e.preventDefault();
    tbodyElement.innerHTML = '';

    const response = await fetch(baseUrl);
    const result = await response.json();
    const products = Object.values(result);

    const productElements = products.map(product => createProductElement(product.product, product.count, product.price, product._id));

    tbodyElement.append(...productElements);
}

function createProductElement(productName, count, price, productId) {
    const trElement = document.createElement('tr');

    const tdProductElement = document.createElement('td');
    tdProductElement.classList.add('name');
    tdProductElement.textContent = productName;

    const tdCountElement = document.createElement('td');
    tdCountElement.classList.add('count-product');
    tdCountElement.textContent = count;

    const tdPriceElement = document.createElement('td');
    tdPriceElement.classList.add('product-price');
    tdPriceElement.textContent = price;

    const tdButtonsElement = document.createElement('td');
    tdButtonsElement.classList.add('btn');

    const updateButton = document.createElement('button');
    updateButton.classList.add('update');
    updateButton.textContent = 'Update';
    updateButton.addEventListener('click', () => {
        formElement.setAttribute('data-product-id', productId);

        productInputElement.value = productName;
        countInputElement.value = count;
        priceInputElement.value = price;

        trElement.remove();

        updateProductButton.removeAttribute('disabled');
    });

    const deleteButton = document.createElement('button');
    deleteButton.classList.add('delete');
    deleteButton.textContent = 'Delete';
    deleteButton.addEventListener('click', async (e) => {
        e.preventDefault();
        await fetch(`${baseUrl}/${productId}`, {
            method: 'DELETE',
        });

        await loadProducts(e);
        e.preventDefault();
    });

    tdButtonsElement.appendChild(updateButton);
    tdButtonsElement.appendChild(deleteButton);

    trElement.appendChild(tdProductElement);
    trElement.appendChild(tdCountElement);
    trElement.appendChild(tdPriceElement);
    trElement.appendChild(tdButtonsElement);

    return trElement;
}

function clearInputData() {
    productInputElement.value = '';
    countInputElement.value = '';
    priceInputElement.value = '';
}