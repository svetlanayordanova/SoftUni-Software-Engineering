function replace(text, word) {
    const result = text.replaceAll(word, '*'.repeat(word.length));

    console.log(result);
}

replace('A small sentence with some words', 'small');
replace('Find the hidden word', 'hidden');