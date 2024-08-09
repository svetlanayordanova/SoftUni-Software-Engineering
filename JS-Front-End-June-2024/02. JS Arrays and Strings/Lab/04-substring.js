function substring(text, startIndex, count) {
    const result = text.substring(startIndex, startIndex + count);
    
    console.log(result);
}

substring('ASentence', 1, 8);
substring('SkipWord', 4, 7);