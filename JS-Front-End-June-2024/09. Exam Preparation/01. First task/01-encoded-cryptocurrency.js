function encodedCryptocurrency(inputArray) {
    let [input, ...commands] = inputArray;

    commands.forEach(command => {
        if (command === 'TakeEven') {
            let inputNew = ''
            for (let i = 0; i < input.length; i++) {
                const symbol = input.charAt(i);
                if (i % 2 === 0) {
                    inputNew += symbol;
                }
            }
            input = inputNew;
            console.log(input);
        } else if (command.startsWith('ChangeAll')) {
            const [_, substring, replacement] = command.split('?');
            while (input.includes(substring)) {
                input = input.replace(substring, replacement);
            }
            console.log(input);
        } else if (command.startsWith('Reverse')) {
            const [_, substring] = command.split('?');
            if (input.includes(substring)) {
                input = input.replace(substring, '');
                const reversedSubstring = substring.split('').reverse().join('');
                input += reversedSubstring;
                console.log(input);
            } else {
                console.log('error');
            }
        } else if (command === 'Buy') {
            console.log(`The cryptocurrency is: ${input}`);
            return;
        }
    });
}

encodedCryptocurrency((["z2tdsfndoctsB6z7tjc8ojzdngzhtjsyVjek!snfzsafhscs", 
    "TakeEven",
    "Reverse?!nzahc",
    "ChangeAll?m?g",
    "Reverse?adshk",
    "ChangeAll?z?i",
    "Buy"]));
encodedCryptocurrency((["PZDfA2PkAsakhnefZ7aZ", 
    "TakeEven",
    "TakeEven",
    "TakeEven",
    "ChangeAll?Z?X",
    "ChangeAll?A?R",
    "Reverse?PRX",
    "Buy"]));