function sortCatalogue(inputArray) {
    const catalogue = {};

    for (const element of inputArray) {
        const firstLetter = element[0];

        if (!catalogue.hasOwnProperty(firstLetter)) {
            catalogue[firstLetter] = [];
        }

        catalogue[firstLetter].push(element);
    }

    Object.keys(catalogue).sort((a, b) => a.localeCompare(b)).forEach(key => {
        console.log(key)
        const values = catalogue[key];
        values.sort((a, b) => a.localeCompare(b));
        values.forEach((value) => {
            const output = value.split(' : ')
            console.log(`  ${output[0]}: ${output[1]}`);
        });
    });
}
         
sortCatalogue([
    'Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10'
    ]);
sortCatalogue([
    'Omlet : 5.4',
    'Shirt : 15',
    'Cake : 59'
    ]);