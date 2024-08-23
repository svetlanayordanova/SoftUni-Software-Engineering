function addItem() {
    const ulElement = document.getElementById('items');
    const inputTextElement = document.getElementById('newItemText');

    const liElement = document.createElement('li');
    const deleteLinkElement = document.createElement('a');

    liElement.textContent = inputTextElement.value;

    deleteLinkElement.textContent = '[Delete]';
    deleteLinkElement.href = '#';

    liElement.appendChild(deleteLinkElement);
    ulElement.appendChild(liElement);

    deleteLinkElement.addEventListener('click', (e) => {
        e.currentTarget.parentElement.remove();
    });

    inputTextElement.value = '';
}