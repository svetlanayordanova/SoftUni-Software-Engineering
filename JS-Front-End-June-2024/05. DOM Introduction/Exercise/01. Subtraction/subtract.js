function subtract() {
    const firstNumberElement = document.getElementById('firstNumber');
    const secondNumberElement = document.getElementById('secondNumber');
    const resultElement = document.getElementById('result');

    const firstNumberValue = Number(firstNumberElement.value);
    const secondNumberValue = Number(secondNumberElement.value);

    resultElement.textContent = firstNumberValue - secondNumberValue;
}