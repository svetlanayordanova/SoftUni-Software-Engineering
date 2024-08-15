function numberModification(number) {
    const convertNumberToArray = num => String(num).split('').map(num => Number(num));

    const numberAsArray = convertNumberToArray(number);

    const averageValue = arr => {
        let sumDigits = arr.reduce((a, b) => a + b, 0);

        return sumDigits / arr.length;
    }

    let averVal = averageValue(numberAsArray);

    while (averVal <= 5) {
        numberAsArray.push(9);

        averVal = averageValue(numberAsArray);
    }

    console.log(numberAsArray.join(''));
}

numberModification(101);
numberModification(5835);