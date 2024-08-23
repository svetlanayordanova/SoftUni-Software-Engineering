function validate() {
    const emailInputElement = document.getElementById('email');
    const regex = /[a-z]+@[a-z]+\.[a-z]+/g;

    emailInputElement.addEventListener('change', (e) => {
        if (!regex.test(emailInputElement.value)) {
            return e.currentTarget.classList.add('error');
        }

        e.currentTarget.classList.remove('error');
    });
}