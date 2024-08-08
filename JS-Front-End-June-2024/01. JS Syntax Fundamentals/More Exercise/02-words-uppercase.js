function wordsUppercase(text) {
    const regExp = /\w+/g;
    const words = text.match(regExp);

    console.log(words.join(', ').toUpperCase());
}

wordsUppercase('Hi, how are you?');
wordsUppercase('hello');