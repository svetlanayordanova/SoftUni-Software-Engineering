function spellBookUnraveling(inputArray) {
    let [input, ...commands] = inputArray;

    commands.forEach(command => {
        if (command === 'RemoveEven') {
            let inputNew = ''
            for (let i = 0; i < input.length; i++) {
                const symbol = input.charAt(i);
                if (i % 2 === 0) {
                    inputNew += symbol;
                }
            }
            input = inputNew;
            console.log(input);
        } else if (command.startsWith('TakePart')) {
            const [_, startIdx, endIdx] = command.split('!');
            input = input.substring(startIdx, endIdx);
            console.log(input);
        } else if (command.startsWith('Reverse')) {
            const [_, substring] = command.split('!');
            if (input.includes(substring)) {
                input = input.replace(substring, '');
                const reversedSubstring = substring.split('').reverse().join('');
                input += reversedSubstring;
                console.log(input);
            } else {
                console.log('Error');
            }
        } else if (command === 'End') {
            console.log(`The concealed spell is: ${input}`);
            return;
        }
    });    
}

spellBookUnraveling((["asAsl2adkda2mdaczsa", 
    "RemoveEven",
    "TakePart!1!9",
    "Reverse!maz",
    "End"]));
spellBookUnraveling((["hZwemtroiui5tfone1haGnanbvcaploL2u2a2n2i2m", 
    "TakePart!31!42",
    "RemoveEven",
    "Reverse!anim",
    "Reverse!sad",
    "End"]));