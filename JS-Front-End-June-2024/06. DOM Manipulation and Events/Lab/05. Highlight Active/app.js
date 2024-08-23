function focused() {
    const inputTextElements = document.querySelectorAll('input[type=text]');

    for (const inputElement of inputTextElements) {
        inputElement.addEventListener('focus', (e) => {
            e.currentTarget.parentElement.classList.add('focused');
        });
    }

    for (const inputElement of inputTextElements) {
        inputElement.addEventListener('blur', (e) => {
            e.currentTarget.parentElement.classList.remove('focused');
        });
    }
}