function horseRacing(inputArray) {
    let [horsesPositions, ...commands] = inputArray;
    const horses = horsesPositions.split('|');

    const finishCommand = commands.indexOf('Finish');
    commands = commands.slice(0, finishCommand);
    
    commands.forEach(command => {
        if (command.startsWith('Retake')) {
            const [_, overtakingHorse, overtakenHorse] = command.split(' ');
            const overtakingHorseIdx = horses.indexOf(overtakingHorse);
            const overtakenHorseIdx = horses.indexOf(overtakenHorse);
            
            if (overtakingHorseIdx < overtakenHorseIdx) {
                horses.splice(overtakenHorseIdx, 1, overtakingHorse);
                horses.splice(overtakingHorseIdx, 1, overtakenHorse);
                
                console.log(`${overtakingHorse} retakes ${overtakenHorse}.`);
            }
        } else if (command.startsWith('Trouble')) {
            const [_, horseName] = command.split(' ');
            
            const horseIdx = horses.indexOf(horseName);
            
            if (horseIdx >= 1) {
                const nextHorseIdx = horseIdx - 1;
                const nextHorse = horses[nextHorseIdx];

                horses.splice(nextHorseIdx, 1, horseName);
                horses.splice(horseIdx, 1, nextHorse);

                console.log(`Trouble for ${horseName} - drops one position.`);
            }          
        } else if (command.startsWith('Rage')) {
            const [_, horseName] = command.split(' ');
            
            const horseIdx = horses.indexOf(horseName);
            
            if (horseIdx <= horses.length - 1 - 1) {
                horses.splice(horseIdx, 1);
                horses.splice(horseIdx + 2, 0, horseName);
            } else if (horseIdx === horses.length - 1 - 1) {
                horses.splice(horseIdx, 1);
                horses.push(horseName);
            }

            console.log(`${horseName} rages 2 positions ahead.`);
        } else if (command.startsWith('Miracle')) {
            const lastHorse = horses.shift();
            horses.push(lastHorse);
            
            console.log(`What a miracle - ${lastHorse} becomes first.`);
        }
    });
    
    console.log(horses.join('->'));
    console.log(`The winner is: ${horses[horses.length - 1]}`);
}

horseRacing((['Bella|Alexia|Sugar',
    'Retake Alexia Sugar',
    'Rage Bella',
    'Trouble Bella',
    'Finish']));
horseRacing((['Onyx|Domino|Sugar|Fiona',
    'Trouble Onyx',
    'Retake Onyx Sugar',
    'Rage Domino',
    'Miracle',
    'Finish']));
horseRacing((['Fancy|Lilly',
    'Retake Lilly Fancy',
    'Trouble Lilly',
    'Trouble Lilly',
    'Finish',
    'Rage Lilly']));