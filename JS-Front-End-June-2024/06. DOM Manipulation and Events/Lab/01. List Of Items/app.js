function addItem() {
    const ulElement = document.getElementById('items');
    const inputTextElement = document.getElementById('newItemText');
    
    const liElement = document.createElement('li');

    liElement.textContent = inputTextElement.value;
    ulElement.appendChild(liElement);

    inputTextElement.value = '';
}