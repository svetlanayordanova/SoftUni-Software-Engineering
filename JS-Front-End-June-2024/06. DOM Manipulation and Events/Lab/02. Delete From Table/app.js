function deleteByEmail() {
    const customersEmailsElements = document.querySelectorAll('#customers tbody tr td:nth-child(2)');
    const inputTextElement = document.querySelector('input[type=text][name=email]');
    const resultElement = document.getElementById('result');

    for (const currentEmail of customersEmailsElements) {
        if (inputTextElement.value === currentEmail.textContent) {
            currentEmail.parentElement.remove();
            resultElement.textContent = 'Deleted.';
            return;
        }

        resultElement.textContent = 'Not found.';
    }
}