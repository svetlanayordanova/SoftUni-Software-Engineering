function storeEmployees(inputArray) {
    const employees = {};

    for (const name of inputArray) {
        const lengthOfName = name.length;
        
        employees[name] = lengthOfName;
    }

    Object
        .keys(employees)
        .forEach(key => console.log(`Name: ${key} -- Personal Number: ${employees[key]}`))
}

storeEmployees(['Silas Butler', 'Adnaan Buckley', 'Juan Peterson', 'Brendan Villarreal']);
storeEmployees(['Samuel Jackson', 'Will Smith', 'Bruce Willis', 'Tom Holland']);