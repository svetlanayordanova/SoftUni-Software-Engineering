function printLargestNumber(firstNumber, secondNumber, thirdNumber) {
    let result;

    if (firstNumber > secondNumber && firstNumber > thirdNumber) {
        result = firstNumber;
    } else if (secondNumber > firstNumber && secondNumber > thirdNumber) {
        result = secondNumber;
    } else if (thirdNumber > firstNumber && thirdNumber > secondNumber) {
        result = thirdNumber;
    }

    console.log(`The largest number is ${result}.`)
}

printLargestNumber(-3, -5, -22.5);