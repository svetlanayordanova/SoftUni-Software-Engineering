function stringSubstring(word, text) {
    const textToLowerCase = text.toLowerCase();
    const regExp = new RegExp(`\\b${word}\\b`, 'g');

    const containsWord = regExp.test(textToLowerCase);

    if (containsWord) {
        console.log(word);
    } else {
        console.log(`${word} not found!`);
    }
}

stringSubstring('javascript', 'JavaScript is the best programming language');
stringSubstring('python', 'JavaScript is the best programming language');