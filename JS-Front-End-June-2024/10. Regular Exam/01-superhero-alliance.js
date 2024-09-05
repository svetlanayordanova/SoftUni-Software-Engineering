function superheroAlliance(inputArray) {
    const n = Number(inputArray[0]);

    const superheroesData = inputArray.slice(1, n + 1);
    const commands = inputArray.slice(n + 1);

    const superheroes = [];

    superheroesData.forEach(superheroData => {
        const [superheroName, superpower, energy] = superheroData.split('-');
        const superhero = {
            superheroName,
            superpowers: [],
            energy: Number(energy),
        };
        const currentSuperpowers = superpower.split(',');
        currentSuperpowers.forEach(superpower => superhero.superpowers.push(superpower));
        
        superheroes.push(superhero);
    });
    
    commands.forEach(command => {
        const [commandName, superheroName, ...rest] = command.split(' * ');
        const currentSuperhero = findSuperhero(superheroName);

        switch(commandName) {
            case 'Use Power':
                const superpower = rest[0];
                const energyRequired = Number(rest[1]);

                if (currentSuperhero.energy > 0) {
                    if (currentSuperhero.superpowers.includes(superpower) && currentSuperhero.energy >= energyRequired) {
                        currentSuperhero.energy -= energyRequired;
                        const currentEnergy = currentSuperhero.energy;
    
                        console.log(`${superheroName} has used ${superpower} and now has ${currentEnergy} energy!`);
                    } else {
                        console.log(`${superheroName} is unable to use ${superpower} or lacks energy!`);
                    }
                }
            break;
            case 'Train':
                const trainingEnergy = Number(rest[0]);

                const initialEnergy = currentSuperhero.energy;

                if (initialEnergy < 100) {
                    if (initialEnergy + trainingEnergy <= 100) {
                        currentSuperhero.energy += trainingEnergy;
                        console.log(`${superheroName} has trained and gained ${trainingEnergy} energy!`);
                    } else {
                        currentSuperhero.energy = 100;
                        console.log(`${superheroName} has trained and gained ${100 - initialEnergy} energy!`);
                    }
                } else {
                    console.log(`${superheroName} is already at full energy!`);
                }
            break;
            case 'Learn':
                const newSuperpower = rest[0];

                if (currentSuperhero.superpowers.includes(newSuperpower)) {
                    console.log(`${superheroName} already knows ${newSuperpower}.`);
                } else {
                    currentSuperhero.superpowers.push(newSuperpower);

                    console.log(`${superheroName} has learned ${newSuperpower}!`);
                }
            break;
            case 'Evil Defeated!':
                return;
        }
    });

    superheroes.forEach(superhero => {
        console.log(`Superhero: ${superhero.superheroName}`);
        console.log(`- Superpowers: ${superhero.superpowers.join(', ')}`);
        console.log(`- Energy: ${superhero.energy}`);
    });

    function findSuperhero(superheroName) {
        return superheroes.find(superhero => superhero.superheroName === superheroName);
    }    
}

superheroAlliance(([
    "3",
    "Iron Man-Repulsor Beams,Flight-80",
    "Thor-Lightning Strike,Hammer Throw-10",
    "Hulk-Super Strength-60",
    "Use Power * Iron Man * Flight * 30",
    "Train * Thor * 20",
    "Train * Hulk * 50",
    "Learn * Hulk * Thunderclap",
    "Use Power * Hulk * Thunderclap * 70",
    "Evil Defeated!"
]));
superheroAlliance(([
    "2",
    "Iron Man-Repulsor Beams,Flight-20",
    "Thor-Lightning Strike,Hammer Throw-100",
    "Train * Thor * 20",
    "Use Power * Iron Man * Repulsor Beams * 30",
    "Evil Defeated!"
]));
superheroAlliance(([
    "2",
    "Iron Man-Repulsor Beams,Flight-100",
    "Thor-Lightning Strike,Hammer Throw-50",
    "Train * Thor * 20",
    "Learn * Thor * Hammer Throw",
    "Use Power * Iron Man * Repulsor Beams * 30",
    "Evil Defeated!"
]));