function cafeteria(inputArray) {
    const n = Number(inputArray[0]);

    const baristasData = inputArray.slice(1, n + 1);
    const commands = inputArray.slice(n + 1);

    const baristas = [];

    baristasData.forEach(baristaData => {
        const [baristaName, shift, coffeeTypesList] = baristaData.split(' ');
        const coffeeTypes = coffeeTypesList.split(',');
        const barista = {
            baristaName,
            shift,
            coffeeTypes
        }
        baristas.push(barista);
    });

    commands.forEach(command => {
        if (command.startsWith('Prepare')) {
            const [_, baristaName, shift, coffeeType] = command.split(' / ');

            const currentBarista = findBarista(baristaName);

            if (currentBarista.shift === shift && currentBarista.coffeeTypes.includes(coffeeType)) {
                console.log(`${baristaName} has prepared a ${coffeeType} for you!`);
            } else {
                console.log(`${baristaName} is not available to prepare a ${coffeeType}.`);
            }
        } else if (command.startsWith('Change Shift')) {
            const [_, baristaName, newShift] = command.split(' / ');

            const currentBarista = findBarista(baristaName);

            currentBarista.shift = newShift;

            console.log(`${baristaName} has updated his shift to: ${newShift}`);
        } else if (command.startsWith('Learn')) {
            const [_, baristaName, newCoffeeType] = command.split(' / ');

            const currentBarista = findBarista(baristaName);

            if (currentBarista.coffeeTypes.includes(newCoffeeType)) {
                console.log(`${baristaName} knows how to make ${newCoffeeType}.`);
            } else {
                currentBarista.coffeeTypes.push(newCoffeeType);
                console.log(`${baristaName} has learned a new coffee type: ${newCoffeeType}.`);
            }
        } else if (command === 'Closed') {
            return;
        }
    });


    baristas.forEach(barista => {
        console.log(`Barista: ${barista.baristaName}, Shift: ${barista.shift}, Drinks: ${barista.coffeeTypes.join(', ')}`);
    })

    function findBarista(baristaName) {
        return baristas.find(barista => barista.baristaName === baristaName);
    }
}

cafeteria([
    '3',
      'Alice day Espresso,Cappuccino',
      'Bob night Latte,Mocha',
      'Carol day Americano,Mocha',
      'Prepare / Alice / day / Espresso',
      'Change Shift / Bob / night',
      'Learn / Carol / Latte',
      'Learn / Bob / Latte',
      'Prepare / Bob / night / Latte',
      'Closed']);
cafeteria(['4',
    'Alice day Espresso,Cappuccino',
    'Bob night Latte,Mocha',
    'Carol day Americano,Mocha',
    'David night Espresso',
    'Prepare / Alice / day / Espresso',
    'Change Shift / Bob / day',
    'Learn / Carol / Latte',
    'Prepare / Bob / night / Latte',
    'Learn / David / Cappuccino',
    'Prepare / Carol / day / Cappuccino',
    'Change Shift / Alice / night',
     'Learn / Bob / Mocha',
    'Prepare / David / night / Espresso',
    'Closed']);