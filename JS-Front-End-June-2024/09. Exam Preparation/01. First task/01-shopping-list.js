function shoppingList(inputArray) {
    let [groceries, ...commands] = inputArray;

    groceries = groceries.split('!');

    commands.forEach(command => {
        const [commandName, item, ...rest] = command.split(' ');

        switch(commandName) {
            case 'Urgent':
                if (!groceries.includes(item)) {
                    groceries.unshift(item);
                }
            break;
            case 'Unnecessary':
                if (groceries.includes(item)) {
                    const index = groceries.indexOf(item);

                    groceries.splice(index, 1);
                }
            break;
            case 'Correct':
                const newItem = rest[0];

                if (groceries.includes(item)) {
                    const index = groceries.indexOf(item);

                    groceries.splice(index, 1, newItem);
                }
            break;
            case 'Rearrange':
                if (groceries.includes(item)) {
                    const index = groceries.indexOf(item);

                    groceries.splice(index, 1);
                    groceries.push(item);
                }
            break;
            case 'Go Shopping':
                return;
        }
    });

    console.log(groceries.join(', '));
}

shoppingList((["Tomatoes!Potatoes!Bread",
    "Unnecessary Milk",
    "Urgent Tomatoes",
    "Go Shopping!"]));
shoppingList((["Milk!Pepper!Salt!Water!Banana",
    "Urgent Salt",
    "Unnecessary Grapes",
    "Correct Pepper Onion",
    "Rearrange Grapes",
    "Correct Tomatoes Potatoes",
    "Go Shopping!"]));