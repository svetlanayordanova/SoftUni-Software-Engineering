function convertToJson(firstName, lastName, hairColor) {
    let person = {
        name: firstName, 
        lastName,
        hairColor,
    }

    let jsonStr = JSON.stringify(person);

    console.log(jsonStr);
}

convertToJson('George', 'Jones', 'Brown');
convertToJson('Peter', 'Smith', 'Blond');