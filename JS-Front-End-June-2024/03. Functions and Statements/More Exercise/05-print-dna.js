function printDNA(number) {
    const str = 'ATCGTTAGGG';
    let counter = 0;

    for (let i = 0; i < number; i++) {
        if (i % 4 === 0) {
            console.log(`**${str[counter % 10]}${str[counter % 10 + 1]}**`);
        } else if (i % 4 === 1 || i % 4 === 3) {
            console.log(`*${str[counter % 10]}--${str[counter % 10 + 1]}*`);
        } else if (i % 4 === 2) {
            console.log(`${str[counter % 10]}----${str[counter % 10 + 1]}`);
        }

        counter += 2;
    }
}

printDNA(4);
printDNA(10);
