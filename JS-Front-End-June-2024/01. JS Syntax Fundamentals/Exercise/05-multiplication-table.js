function printTable(number) {
    for (let i = 1; i <= 10; i++) {
        let result = number * i;

        console.log(`${number} X ${i} = ${result}`);
    }
}

printTable(2);