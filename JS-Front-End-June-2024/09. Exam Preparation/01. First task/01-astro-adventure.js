function astroAdventure(inputArray) {
    const n = Number(inputArray[0]);

    const astronautsData = inputArray.slice(1, n + 1);
    const commands = inputArray.slice(n + 1);

    const astronauts = [];

    astronautsData.forEach(astronautData => {
        const [astronautName, oxygenLevel, energyReserves] = astronautData.split(' ');
        const astronaut = {
            astronautName,
            oxygenLevel: Number(oxygenLevel),
            energyReserves: Number(energyReserves),
        }
        astronauts.push(astronaut);
    });

    commands.forEach(command => {
        const [commandName, astronautName, value] = command.split(' - ');
        const currentAstronaut = findAstronaut(astronautName);

        switch(commandName) {
            case 'Explore':
                const energyNeeded = Number(value);

                if (currentAstronaut.energyReserves >= energyNeeded) {
                    currentAstronaut.energyReserves -= energyNeeded;

                    console.log(`${astronautName} has successfully explored a new area and now has ${currentAstronaut.energyReserves} energy!`);
                } else {
                    console.log(`${astronautName} does not have enough energy to explore!`);
                }
            break;
            case 'Refuel':
                const amountEnergy = Number(value);

                const currentEnergyReserves = currentAstronaut.energyReserves;

                if (currentEnergyReserves + amountEnergy <= 200) {
                    currentAstronaut.energyReserves += amountEnergy;
                    console.log(`${astronautName} refueled their energy by ${amountEnergy}!`);
                } else {
                    currentAstronaut.energyReserves = 200;
                    console.log(`${astronautName} refueled their energy by ${200 - currentEnergyReserves}!`);
                }
            break;
            case 'Breathe':
                const amountOxygen = Number(value);

                const currentOxygenLevel = currentAstronaut.oxygenLevel;
                
                if (currentOxygenLevel + amountOxygen <= 100) {
                    currentAstronaut.oxygenLevel += amountOxygen;
                    console.log(`${astronautName} took a breath and recovered ${amountOxygen} oxygen!`);
                } else {
                    currentAstronaut.oxygenLevel = 100;
                    console.log(`${astronautName} took a breath and recovered ${100 - currentOxygenLevel} oxygen!`);
                }
            break;
            case 'End':
                return;
        }
    });

    astronauts.forEach(astronaut => {
        console.log(`Astronaut: ${astronaut.astronautName}, Oxygen: ${astronaut.oxygenLevel}, Energy: ${astronaut.energyReserves}`);
    });

    function findAstronaut(astronautName) {
        return astronauts.find(astronaut => astronaut.astronautName === astronautName);
    }
}

astroAdventure(['3',
    'John 50 120',
    'Kate 80 180',
    'Rob 70 150',
    'Explore - John - 50',
    'Refuel - Kate - 30',
    'Breathe - Rob - 20',
    'End']);
astroAdventure(['4',
    'Alice 60 100',
    'Bob 40 80',
    'Charlie 70 150',
    'Dave 80 180',
    'Explore - Bob - 60',
    'Refuel - Alice - 30',
    'Breathe - Charlie - 50',
    'Refuel - Dave - 40',
    'Explore - Bob - 40',
    'Breathe - Charlie - 30',
    'Explore - Alice - 40',
    'End']);