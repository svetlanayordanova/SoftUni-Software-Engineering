function sortingNumbers(array) {
    const sortedArray = [];
    array.sort((a, b) => a - b);

    while (array.length > 0) {
        sortedArray.push(array.shift());
        sortedArray.push(array.pop());
    }

    return sortedArray;
}

sortingNumbers([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]);