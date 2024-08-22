function solve() {
    const selectMenuToElement = document.getElementById('selectMenuTo');
    const resultElement = document.getElementById('result');

    const binaryOptionElement = document.createElement('option');
    binaryOptionElement.value = 'binary';
    binaryOptionElement.textContent = 'Binary';

    const hexadecimalOptionElement = document.createElement('option');
    hexadecimalOptionElement.value = 'hexadecimal';
    hexadecimalOptionElement.textContent = 'Hexadecimal';

    selectMenuToElement.appendChild(binaryOptionElement);
    selectMenuToElement.appendChild(hexadecimalOptionElement);

    const convertButtonElement = document.querySelector('button');
    convertButtonElement.addEventListener('click', () => {
        const decimalInput = document.getElementById('input').value;
        const convertTo = selectMenuToElement.value;
        let result;

        if (convertTo === 'binary') {
            result = decimalToBinary(decimalInput);
        } else if (convertTo === 'hexadecimal') {
            result = decimalToHexadecimal(decimalInput);
        }
        resultElement.value = result;
    });

    function decimalToBinary(decimal) {
        return parseInt(decimal).toString(2);
    }

    function decimalToHexadecimal(decimal) {
        return parseInt(decimal).toString(16).toUpperCase();
    }
}