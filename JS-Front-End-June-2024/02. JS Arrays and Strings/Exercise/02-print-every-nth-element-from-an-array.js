function printEveryNthElement(array, number) {
    let newArray = [];

    for (let i = 0; i < array.length; i += number) {
        newArray.push(array[i]);
    }

    return newArray;
}

printEveryNthElement(['5', '20', '31', '4', '20'], 2);
printEveryNthElement(['dsa', 'asd', 'test', 'tset'], 2);
printEveryNthElement(['1', '2', '3', '4', '5'], 6);