function wordTracker(inputArray) {
    const [specialWords, ...restOfTheWords] = inputArray;
    const specialWordsSplitted = specialWords.split(' ');

    const wordsCounter = [];

    for (const specialWord of specialWordsSplitted) {
        const wordFound = {
            specialWord,
            count: 0,
        }

        for (const word of restOfTheWords) {
            if (specialWord === word) {
                wordFound.count += 1;
            }
        }

        wordsCounter.push(wordFound);
    }

    wordsCounter.sort((a, b) => b.count - a.count)
            .forEach(word => console.log(`${word.specialWord} - ${word.count}`));
}

wordTracker([
    'this sentence', 
    'In', 'this', 'sentence', 'you', 'have', 'to', 'count', 'the', 'occurrences', 'of', 'the', 'words', 'this', 'and', 'sentence', 'because', 'this', 'is', 'your', 'task'
    ]);
wordTracker([
    'is the', 
    'first', 'sentence', 'Here', 'is', 'another', 'the', 'And', 'finally', 'the', 'the', 'sentence']);