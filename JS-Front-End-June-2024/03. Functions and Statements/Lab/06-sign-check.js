function signCheck(firstNumber, secondNumber, thirdNumber) {
    const isNegative = num => num < 0;

    countNegativeNumbers = 0;

    if (isNegative(firstNumber)) {
        countNegativeNumbers++;
    }
    
    if (isNegative(secondNumber)) {
        countNegativeNumbers++; 
    } 
    
    if (isNegative(thirdNumber)) {
        countNegativeNumbers++;
    }

    const printResult = count => count % 2 !== 0 ? console.log('Negative') : console.log('Positive');
    
    printResult(countNegativeNumbers);
}

signCheck(5, 12, -15);
signCheck(-6, -12, 14);
signCheck(-1, -2, -3);
signCheck(-5, 1, 1);