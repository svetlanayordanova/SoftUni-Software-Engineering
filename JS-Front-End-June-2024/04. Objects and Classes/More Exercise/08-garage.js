function storeCars(inputArray) {
    const garage = {};

    for (const currentElement of inputArray) {
        const garageNumber = currentElement.split(' - ')[0];
        if (!garage.hasOwnProperty(garageNumber)) {
            garage[garageNumber] = [];
        }

        const carInfo = currentElement.split(' - ')[1].split(', ');
        const car = [];

        for (const current of carInfo) {
            const element = current.split(': ');
            const specific = element[0] + ' - ' + element[1]; 
            car.push(specific);
        }

        garage[garageNumber].push(car);
    }

    for (const garageKey in garage) {
        console.log(`Garage № ${garageKey}`);
        
        for (const garageElementKey of garage[garageKey]) {
            console.log(`--- ${garageElementKey.join(', ')}`);
        }
    }
}

storeCars(['1 - color: blue, fuel type: diesel', 
    '1 - color: red, manufacture: Audi', 
    '2 - fuel type: petrol', 
    '4 - color: dark blue, fuel type: diesel, manufacture: Fiat']);
storeCars(['1 - color: green, fuel type: petrol',
    '1 - color: dark red, manufacture: WV',
    '2 - fuel type: diesel',
    '3 - color: dark blue, fuel type: petrol']);