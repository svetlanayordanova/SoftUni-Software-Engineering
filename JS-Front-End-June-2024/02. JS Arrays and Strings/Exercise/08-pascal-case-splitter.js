function pascalCaseSplitter(input) {
    const regExp = /[A-Z][a-z]*/g;

    const matches = input.match(regExp);

    console.log(matches.join(', '));
}

pascalCaseSplitter('SplitMeIfYouCanHaHaYouCantOrYouCan');
pascalCaseSplitter('HoldTheDoor');
pascalCaseSplitter('ThisIsSoAnnoyingToDo');