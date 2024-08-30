const baseUrl = 'http://localhost:3030/jsonstore/gifts';

const loadButton = document.getElementById('load-presents');
const addButton = document.getElementById('add-present');
const editButton = document.getElementById('edit-present');
const ulGiftList = document.getElementById('gift-list');
const formElement = document.querySelector('form');

const giftInput = document.getElementById('gift');
const forInput = document.getElementById('for');
const priceInput = document.getElementById('price');

loadButton.addEventListener('click', loadPresents);
addButton.addEventListener('click', addGift);
editButton.addEventListener('click', editGift);

async function addGift() {
    const gift = giftInput.value;
    const forGift = forInput.value;
    const price = priceInput.value;

    formElement.reset();
    
    const response = await fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ gift, for: forGift, price }),
    });

    if (!response.ok) {
        return;
    }

    await loadPresents();
}

async function editGift() {
    const giftId = formElement.getAttribute('data-gift-id');

    const gift = giftInput.value;
    const forGift = forInput.value;
    const price = priceInput.value;
    
    formElement.reset();
    
    const response = await fetch(`${baseUrl}/${giftId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ gift, for: forGift, price, _id: giftId }),
    });

    if (!response.ok) {
        return;
    }
    
    await loadPresents();
    
    editButton.setAttribute('disabled', 'disabled');
    addButton.removeAttribute('disabled');
    formElement.removeAttribute('data-gift-id');
}

async function loadPresents() {
    ulGiftList.innerHTML = '';
    
    const response = await fetch(baseUrl);
    const result = await response.json();
    const gifts = Object.values(result);
    
    const giftElements = gifts.map(gift => createGiftElement(gift.gift, gift.for, gift.price, gift._id));
    
    ulGiftList.append(...giftElements);
}

function createGiftElement(gift, forGift, price, giftId) {
    const divGiftSock = document.createElement('div');
    divGiftSock.classList.add('gift-sock');
    
    const divContent = document.createElement('div');
    divContent.classList.add('content');
    
    const pGiftElement = document.createElement('p');
    pGiftElement.textContent = gift;
    
    const pForElement = document.createElement('p');
    pForElement.textContent = forGift;
    
    const pPriceElement = document.createElement('p');
    pPriceElement.textContent = price;
    
    const divButtonsContainer = document.createElement('div');
    divButtonsContainer.classList.add('buttons-container');
    
    const changeButton = document.createElement('button');
    changeButton.classList.add('change-btn');
    changeButton.textContent = 'Change';
    changeButton.addEventListener('click', () => {
        giftInput.value = gift;
        forInput.value = forGift;
        priceInput.value = price;
        
        divGiftSock.remove();
        
        editButton.removeAttribute('disabled');
        addButton.setAttribute('disabled', 'disabled');
        formElement.setAttribute('data-gift-id', giftId);
    });
    
    const deleteButton = document.createElement('button');
    deleteButton.classList.add('delete-btn');
    deleteButton.textContent = 'Delete';
    deleteButton.addEventListener('click', async () => {
        await fetch(`${baseUrl}/${giftId}`, {
            method: 'DELETE',
        });
        
        await loadPresents();
    });
    
    divContent.appendChild(pGiftElement);
    divContent.appendChild(pForElement);
    divContent.appendChild(pPriceElement);
    
    divButtonsContainer.appendChild(changeButton);
    divButtonsContainer.appendChild(deleteButton);
    
    divGiftSock.appendChild(divContent);
    divGiftSock.appendChild(divButtonsContainer);
    
    return divGiftSock;
}