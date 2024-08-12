function revealWords(words, template) {
    const searchedWords = words.split(', ');

    for (const word of searchedWords) {
        if (template.includes('*'.repeat(word.length))) {
            template = template.replace('*'.repeat(word.length), word);
        }
    }

    console.log(template);
}

revealWords('great', 'softuni is ***** place for learning new programming languages');
revealWords('great, learning', 'softuni is ***** place for ******** new programming languages');