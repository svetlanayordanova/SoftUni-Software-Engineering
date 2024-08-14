function printNxNMatrix(number) {
    const printColumn = num => {
        return `${num + ' '}`.repeat(num);
    };

    for (let row = 0; row < number; row++) {
        console.log(printColumn(number));
    }
}

printNxNMatrix(3);
printNxNMatrix(7);
printNxNMatrix(2);