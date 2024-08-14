function getOddAndEvenSum(number) {
    const isOddDigit = digit => digit % 2 !== 0;
    const isEvenDigit = digit => digit % 2 === 0;

    let oddSum = 0;
    let evenSum = 0;

    while (number > 0) {
        let lastDigit = number % 10;

        if (isOddDigit(lastDigit)) {
            oddSum += lastDigit;
        } else if (isEvenDigit(lastDigit)) {
            evenSum += lastDigit;
        }
        
        number = parseInt(number / 10);
    }
    
    const printResult = ((firstSum, secondSum) => console.log(`Odd sum = ${firstSum}, Even sum = ${secondSum}`));

    printResult(oddSum, evenSum);
}

getOddAndEvenSum(1000435);
getOddAndEvenSum(3495892137259234);