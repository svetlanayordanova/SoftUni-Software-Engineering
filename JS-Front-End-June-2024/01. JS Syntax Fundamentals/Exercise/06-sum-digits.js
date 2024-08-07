function sumDigits(number) {
    const numberAsString = number.toString();

    let sum = 0;

    for (let i = 0; i < numberAsString.length; i++) {
        sum += Number(numberAsString[i]);
    }

    console.log(sum);
}

sumDigits(245678);

//function sumDigits(number) {
//    let sum = 0;
//
//    let currentNumber = number;
//
//    while (currentNumber > 0) {
//        sum += currentNumber % 10;
//
//        currentNumber = parseInt(currentNumber / 10);
//    }
//
//    console.log(sum);
//}

//function sumDigits(number) {
//    console.log(
//        number
//        .toString()
//        .split("")
//        .map(Number)
//        .reduce((a, b) => a + b, 0)
//    );
//}