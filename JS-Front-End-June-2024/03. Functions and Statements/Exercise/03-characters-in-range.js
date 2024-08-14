function printCharactersInRange(firstChar, secondChar) {
    const smallerCharCode = Math.min(firstChar.charCodeAt(0), secondChar.charCodeAt(0));
    const biggerCharCode = Math.max(firstChar.charCodeAt(0), secondChar.charCodeAt(0));

    let arr = [];

    const fillArray = (array, charCode) => array.push(String.fromCharCode(charCode));
    const printArray = array => console.log(array.join(' '));

    for (let i = smallerCharCode + 1; i < biggerCharCode; i++) {
        fillArray(arr, i);
    }

    printArray(arr);
}

printCharactersInRange('a', 'd');
printCharactersInRange('#', ':');
printCharactersInRange('C', '#');