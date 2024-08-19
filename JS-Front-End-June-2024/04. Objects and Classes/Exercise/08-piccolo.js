function storeCars(inputArray) {
    let parkingLot = {};

    for (const element of inputArray) {
        const [direction, carNumber] = element.split(', ');

        if (direction === 'IN') {
            parkingLot[carNumber] = direction;
        } else if (direction === 'OUT') {
            delete parkingLot[carNumber];
        }
    }

    if (Object.keys(parkingLot).length > 0) {
        Object.keys(parkingLot).sort((a, b) => a.localeCompare(b))
                               .forEach(key => console.log(key));  
    } else {
        console.log('Parking Lot is Empty');
    }
}

storeCars(['IN, CA2844AA',
    'IN, CA1234TA',
    'OUT, CA2844AA',
    'IN, CA9999TT',
    'IN, CA2866HI',
    'OUT, CA1234TA',
    'IN, CA2844AA',
    'OUT, CA2866HI',
    'IN, CA9876HH',
    'IN, CA2822UU']);
storeCars(['IN, CA2844AA',
    'IN, CA1234TA',
    'OUT, CA2844AA',
    'OUT, CA1234TA']);
