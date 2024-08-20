function storeArmies(inputArray) {
    const army = {};
    let leader = '';

    for (const currentElement of inputArray) {
        if (currentElement.includes('arrives')) {
            leader = currentElement.split(' arrives')[0];
            army[leader] = [];
        } else if (currentElement.includes(':')) {
            leader = currentElement.split(': ')[0];
            let currentArmy = [];
            const [armyName, armyCount] = currentElement.split(': ')[1].split(', ');
            currentArmy.push(armyName);
            currentArmy.push(armyCount);

            if (army.hasOwnProperty(leader)) {
                army[leader].push(currentArmy);
            }
        } else if (currentElement.includes('+')) {
            const [armyName, armyCount] = currentElement.split('+');

            for (const armyKey in army) {
                for (let i = 0; i < army[armyKey].length; i++) {
                    for (let j = 0; j < army[armyKey][i].length; j += 2) {
                        if (army[armyKey][i][j] === armyName) {
                            army[armyKey][i][j + 1] += Number(armyCount);
                        }
                    }
                }
            }
        } else if (currentElement.includes('defeated')) {
            leader = currentElement.split(' defeated')[0];

            delete army[leader];
        }
    }

    let finalArmies = {};
    for (let armyKey in army) {
        let counter = 0;
        for (let i = 0; i < army[armyKey].length; i++) {
            for (let j = 1; j < army[armyKey][i].length; j += 2) {
                counter += Number(army[armyKey][i][j]);
            }
        }
        finalArmies[armyKey] = counter;
    }
    let sortedArmies = Object.entries(finalArmies).sort((a, b) => b[1] - a[1]);
    for (let armyKey in army) {
        army[armyKey].sort((a, b) => b[1] - a[1]);
    }
    for (let sortedArmy of sortedArmies) {
        console.log(`${sortedArmy[0]}: ${sortedArmy[1]}`);
        for (let i = 0; i < army[sortedArmy[0]].length; i++) {
            for (let j = 1; j < army[sortedArmy[0]][i].length; j += 2) {
                console.log(`>>> ${army[sortedArmy[0]][i][0]} - ${army[sortedArmy[0]][i][1]}`)
            }
        }
    }
}


storeArmies(['Rick Burr arrives', 'Fergus: Wexamp, 30245', 'Rick Burr: Juard, 50000', 'Findlay arrives', 'Findlay: Britox, 34540', 'Wexamp + 6000', 'Juard + 1350', 'Britox + 4500', 'Porter arrives', 'Porter: Legion, 55000', 'Legion + 302', 'Rick Burr defeated', 'Porter: Retix, 3205']);