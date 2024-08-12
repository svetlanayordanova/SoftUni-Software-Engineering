function modernTimesOfHashTag(input) {
    const regExp = /#\b[A-Za-z]+\b/g;

    const matches = input.match(regExp);

    for (const match of matches) {
        console.log(match.substring(1));
    }
}

modernTimesOfHashTag('Nowadays everyone uses # to tag a #special word in #socialMedia');
modernTimesOfHashTag('The symbol # is known #variously in English-speaking #regions as the #number sign');