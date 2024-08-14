function getPerfectNumber(number) {
    if (number < 0 || !Number.isInteger(number)) {
        console.log("It's not so perfect.");
        return;
    }

    function getDivisors(num) {
        const half = number / 2;
        const divisors = [];

        for (let i = 1; i <= half; i++) {
            if (number % i === 0) {
                divisors.push(i);
            }
        }

        return divisors;
    }

    const sumDivisors = array => array.reduce((a, b) => a + b, 0);

    const isNumberPerfect = (num, sum) => {
        return num === sum;
    };

    if (isNumberPerfect(number, sumDivisors(getDivisors(number)))) {
        console.log("We have a perfect number!");
    } else {
        console.log("It's not so perfect.");
    }
}

getPerfectNumber(6);
getPerfectNumber(28);
getPerfectNumber(1236498);