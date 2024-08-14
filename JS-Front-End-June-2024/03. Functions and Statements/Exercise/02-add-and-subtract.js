function addAndSubtract(firstNum, secondNum, thirdNum) {
    const sum = (a, b) => a + b;
    const subtract = (a, b) => a - b;
    const printResult = res => console.log(res);

    const result = subtract(sum(firstNum, secondNum), thirdNum); 

    printResult(result);
}

addAndSubtract(23, 6, 10);
addAndSubtract(1, 17, 30);
addAndSubtract(42, 58, 100);