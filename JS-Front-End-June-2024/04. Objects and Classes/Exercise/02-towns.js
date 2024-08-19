function storeTowns(inputArray) {
    const town = {};

    for (const element of inputArray) {
        const [townName, townLatitude, townLongitude] = element.split(' | ');

        town.town = townName;
        town.latitude = Number(townLatitude).toFixed(2);
        town.longitude = Number(townLongitude).toFixed(2);

        console.log(town);
    }
}

storeTowns(['Sofia | 42.696552 | 23.32601', 'Beijing | 39.913818 | 116.363625']);
storeTowns(['Plovdiv | 136.45 | 812.575']);