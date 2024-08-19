function storeOddOccurrences(input) {
    let oddOccurrencesCounter = {};

    const words = input.toLowerCase().split(' ');

    for (const word of words) {
        if (!oddOccurrencesCounter.hasOwnProperty(word)) {
            oddOccurrencesCounter[word] = 1;
        } else {
            oddOccurrencesCounter[word] += 1;
        }
    }

    let output = '';

    Object.entries(oddOccurrencesCounter).sort((a, b) => b[1] - a[1])
                                        .filter(word => word[1] % 2 !== 0)
                                        .forEach(word => output += word[0] + ' ');

    console.log(output);
}

storeOddOccurrences('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');
storeOddOccurrences('Cake IS SWEET is Soft CAKE sweet Food');