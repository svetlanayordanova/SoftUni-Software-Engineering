function phoneBook(inputArray) {
    const phoneBook = {};

    for (const entry of inputArray) {
        const [personsName, phoneNumber] = entry.split(' ');

        phoneBook[personsName] = phoneNumber;
    }

    Object
        .keys(phoneBook)    
        .forEach(key => console.log(`${key} -> ${phoneBook[key]}`));
}

phoneBook(['Tim 0834212554', 'Peter 0877547887', 'Bill 0896543112', 'Tim 0876566344']);
phoneBook(['George 0552554', 'Peter 087587', 'George 0453112', 'Bill 0845344']);