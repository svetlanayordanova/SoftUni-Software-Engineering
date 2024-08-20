function flightSchedule(inputArray) {
    let flightsStatus = {};

    let [allFlightsArray, changedStatusesArray, statusToCheck] = inputArray;
    statusToCheck = statusToCheck.join('');

    for (const currentElement of allFlightsArray) {
        let [flightNumber, ...destination] = currentElement.split(' ');
        destination = destination.join(' ');

        for (const currElement of changedStatusesArray) {
            const [numberFlight, status] = currElement.split(' ');

            if (flightNumber === numberFlight) {
                flightsStatus[destination] = status;
                break;
            } else {
                flightsStatus[destination] = 'Ready to fly';
            }
        }
    }

    Object.entries(flightsStatus)
        .filter(([key, _]) => flightsStatus[key] === statusToCheck)
        .forEach(([key, value]) => console.log(`{ Destination: '${key}', Status: '${value}' }`));
}

flightSchedule([['WN269 Delaware',
    'FL2269 Oregon',
    'WN498 Las Vegas',
    'WN3145 Ohio',
    'WN612 Alabama',
    'WN4010 New York',
    'WN1173 California',
    'DL2120 Texas',
    'KL5744 Illinois',
    'WN678 Pennsylvania'],
    ['DL2120 Cancelled',
        'WN612 Cancelled',
        'WN1173 Cancelled',
        'SK430 Cancelled'],
        ['Cancelled']
    ]);
flightSchedule([['WN269 Delaware',
    'FL2269 Oregon',
    'WN498 Las Vegas',
    'WN3145 Ohio',
    'WN612 Alabama',
    'WN4010 New York',
    'WN1173 California',
    'DL2120 Texas',
    'KL5744 Illinois',
    'WN678 Pennsylvania'],
    ['DL2120 Cancelled',
    'WN612 Cancelled',
    'WN1173 Cancelled',
    'SK330 Cancelled'],
    ['Ready to fly']
    ]);