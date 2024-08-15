function carWash(commands) {
    const soap = val => val += 10;
    const water = val => val += 0.2 * val;
    const vacuumCleaner = val => val += 0.25 * val;
    const mud = val => val -= 0.1 * val;

    let value = 0;

    for (let i = 0; i < commands.length; i++) {
        let currentCommand = commands[i];
        
        switch(currentCommand) {
            case 'soap':
                value = soap(value);
            break;
            case 'water':
                value = water(value);
            break;
            case 'vacuum cleaner':
                value = vacuumCleaner(value);
            break;
            case 'mud':
                value = mud(value);
            break;
        }
    }

    console.log(`The car is ${value.toFixed(2)}% clean.`)
}

carWash(['soap', 'soap', 'vacuum cleaner', 'mud', 'soap', 'water']);
carWash(["soap", "water", "mud", "mud", "water", "mud", "vacuum cleaner"]);