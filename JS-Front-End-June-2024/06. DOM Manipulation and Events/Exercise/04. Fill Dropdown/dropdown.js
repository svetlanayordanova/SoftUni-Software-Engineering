function addItem() {
    const newItemText = document.getElementById('newItemText');
    const newItemValue = document.getElementById('newItemValue');
    const selectElement = document.querySelector('select#menu');

    const optionElement = document.createElement('option');

    optionElement.textContent = newItemText.value;
    optionElement.value = newItemValue.value;

    selectElement.appendChild(optionElement);

    newItemText.value = '';
    newItemValue.value = '';
}