function storeSequences(inputArray) {
    const arrays = {}
    
    for (const jsonElement of inputArray) {
        const currentArray = JSON.parse(jsonElement).sort((a, b) => b - a);
        const key = currentArray.toString();
        arrays[key] = currentArray;
    }

    const sortedArrays = Object.values(arrays).sort((a, b) => a.length - b.length);

    for (const arraysKey in sortedArrays) {
        console.log(`[${sortedArrays[arraysKey].join(', ')}]`);
    }
}

storeSequences(["[-3, -2, -1, 0, 1, 2, 3, 4]",
    "[10, 1, -17, 0, 2, 13]",
    "[4, -3, 3, -2, 2, -1, 1, 0]"]);
storeSequences(["[7.14, 7.180, 7.339, 80.099]",
    "[7.339, 80.0990, 7.140000, 7.18]",
    "[7.339, 7.180, 7.14, 80.099]"]);