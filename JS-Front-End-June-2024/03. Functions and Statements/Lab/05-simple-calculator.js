function simpleCalculator(firstNumber, secondNumber, operator) {
    let operate = null;

    switch(operator) {
        case 'multiply':
            operate = (a, b) => a * b;
        break;
        case 'divide':
            operate = (a, b) => a / b;
        break;
        case 'add':
            operate = (a, b) => a + b;
        break;
        case 'subtract':
            operate = (a, b) => a - b;
    }

    const result = operate(firstNumber, secondNumber);

    console.log(result);
}

simpleCalculator(5, 5, 'multiply');
simpleCalculator(40, 8, 'divide');
simpleCalculator(12, 19, 'add');
simpleCalculator(50, 13, 'subtract');