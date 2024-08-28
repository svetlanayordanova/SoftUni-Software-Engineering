function motogpRace(inputArray) {
    const n = Number(inputArray[0]);

    const ridersData = inputArray.slice(1, n + 1);
    const commands = inputArray.slice(n + 1);

    const riders = [];

    ridersData.forEach(riderData => {
        const [riderName, fuelCapacity, position] = riderData.split('|');
        const rider = {
            riderName,
            fuelCapacity: Number(fuelCapacity),
            position,
        }
        riders.push(rider);
    });

    commands.forEach(command => {
        const [commandName, riderName, ...rest] = command.split(' - ');
        const currentRider = findRider(riderName);

        switch(commandName) {
            case 'StopForFuel':
                const minimumFuel = Number(rest[0]);
                const changedPosition = rest[1];

                if (currentRider.fuelCapacity < minimumFuel) {
                    currentRider.position = changedPosition;

                    console.log(`${currentRider.riderName} stopped to refuel but lost his position, now he is ${currentRider.position}.`);
                } else {
                    console.log(`${currentRider.riderName} does not need to stop for fuel!`);
                }
            break;
            case 'Overtaking':
                const secondRiderName = rest[0];

                const secondRider = findRider(secondRiderName);

                const firstRiderPosition = currentRider.position;
                const secondRiderPosition = secondRider.position;

                if (firstRiderPosition < secondRiderPosition) {
                    currentRider.position = secondRiderPosition;
                    secondRider.position = firstRiderPosition;

                    console.log(`${currentRider.riderName} overtook ${secondRider.riderName}!`);
                }
            break;
            case 'EngineFail':
                const lapsLeft = rest[0];

                const index = riders.indexOf(currentRider);
                riders.splice(index, 1);

                console.log(`${currentRider.riderName} is out of the race because of a technical issue, ${lapsLeft} laps before the finish.`);
            break;
            case 'Finish':
                return;
        }
    });
    
    riders.forEach(rider => {
        console.log(`${rider.riderName}`);
        console.log(` Final position: ${rider.position}`);
    })

    function findRider(riderName) {
        return riders.find(rider => rider.riderName === riderName);
    }
}

motogpRace((["3",
    "Valentino Rossi|100|1",
    "Marc Marquez|90|2",
    "Jorge Lorenzo|80|3",
    "StopForFuel - Valentino Rossi - 50 - 1",
    "Overtaking - Marc Marquez - Jorge Lorenzo",
    "EngineFail - Marc Marquez - 10",
    "Finish"]));
motogpRace((["4",
    "Valentino Rossi|100|1",
    "Marc Marquez|90|3",
    "Jorge Lorenzo|80|4",
    "Johann Zarco|80|2",
    "StopForFuel - Johann Zarco - 90 - 5",
    "Overtaking - Marc Marquez - Jorge Lorenzo",
    "EngineFail - Marc Marquez - 10",
    "Finish"]));