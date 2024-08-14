function passwordValidator(password) {
    function hasCorrectLength(pass) {
        const minLength = 6;
        const maxLength = 10;

        return pass.length >= minLength && pass.length <= maxLength;
    }

    function hasValidCharacters(pass) {
        const regex = /^[A-Za-z0-9]+$/g;

        return regex.test(pass);
    }

    function hasAtLeastTwoDigits(pass) {
        const regex = /[0-9]{2,}/g;

        return regex.test(pass);
    }

    let isValid = true;

    if (!hasCorrectLength(password)) {
        isValid = false;
        console.log('Password must be between 6 and 10 characters');
    }

    if (!hasValidCharacters(password)) {
        isValid = false;
        console.log('Password must consist only of letters and digits');
    }

    if (!hasAtLeastTwoDigits(password)) {
        isValid = false;
        console.log('Password must have at least 2 digits');
    }

    if (isValid) {
        console.log('Password is valid');
    }
}

passwordValidator('logIn');
passwordValidator('MyPass123');
passwordValidator('Pa$s$s');