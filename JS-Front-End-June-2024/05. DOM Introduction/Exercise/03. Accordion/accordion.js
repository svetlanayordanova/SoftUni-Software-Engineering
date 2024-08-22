function toggle() {
    const buttonElement = document.querySelector('.button');
    const extraElement = document.getElementById('extra');

    if (buttonElement.textContent === 'More') {
        buttonElement.textContent = 'Less';
        extraElement.style.display = 'block';
    } else if (buttonElement.textContent === 'Less') {
        buttonElement.textContent = 'More';
        extraElement.style.display = 'none';
    }
}