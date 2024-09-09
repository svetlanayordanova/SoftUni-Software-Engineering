function scienceExperimentation(inputArray) {
    const n = Number(inputArray[0]);
    
    const chemicalsData = inputArray.slice(1, n + 1);
    const commands = inputArray.slice(n + 1);
    
    const chemicals = [];
    
    chemicalsData.forEach(chemicalData => {
        const [chemicalName, quantity] = chemicalData.split(' # ');
        const chemical = {
            chemicalName,
            quantity: Number(quantity)
        };
        chemicals.push(chemical);
    });
    
    commands.forEach(command => {
        const [commandName, chemicalName, ...rest] = command.split(' # ');
        const currentChemical = findChemical(chemicalName);
        
        switch(commandName) {
            case 'Mix':
                const secondChemicalName = rest[0];
                const amount = Number(rest[1]);
            
                const secondChemical = findChemical(secondChemicalName);
            
                if (currentChemical.quantity >= amount && secondChemical.quantity >= amount) {
                    currentChemical.quantity -= amount;
                    secondChemical.quantity -= amount;
                
                    console.log(`${chemicalName} and ${secondChemicalName} have been mixed. ${amount} units of each were used.`);
                } else {
                    console.log(`Insufficient quantity of ${chemicalName}/${secondChemicalName} to mix.`);
                }
            break;
            case 'Replenish':
                const amountChemical = Number(rest[0]);
            
                if (!currentChemical) {
                    console.log(`The Chemical ${chemicalName} is not available in the lab.`);
                } else {
                    if (currentChemical.quantity + amountChemical > 500) {
                        const initialQuantity = currentChemical.quantity;
                        currentChemical.quantity = 500;
                    
                        console.log(`${chemicalName} quantity increased by ${500 - initialQuantity} units, reaching maximum capacity of 500 units!`);
                    } else {
                        currentChemical.quantity += amountChemical;
                    
                        console.log(`${chemicalName} quantity increased by ${amountChemical} units!`);
                    }
                }
            break;
            case 'Add Formula':
                const formula = rest[0];
            
                if (!currentChemical) {
                    console.log(`The Chemical ${chemicalName} is not available in the lab.`);
                } else {
                    currentChemical.formula = formula;
                
                    console.log(`${chemicalName} has been assigned the formula ${formula}.`);
                }
            break;
            case 'End':
            return;
        }
    });

    chemicals.forEach(chemical => {
        if (!chemical.formula) {
            console.log(`Chemical: ${chemical.chemicalName}, Quantity: ${chemical.quantity}`);
        } else {
            console.log(`Chemical: ${chemical.chemicalName}, Quantity: ${chemical.quantity}, Formula: ${chemical.formula}`);
        }
    })
            
    function findChemical(chemicalName) {
        return chemicals.find(chemical => chemical.chemicalName === chemicalName);
    }
}

scienceExperimentation([ '4',
    'Water # 200',
    'Salt # 100',
    'Acid # 50',
    'Base # 80',
    'Mix # Water # Salt # 50',
    'Replenish # Salt # 150',
    'Add Formula # Acid # H2SO4',
    'End']);
scienceExperimentation([ '3',
    'Sodium # 300',
    'Chlorine # 100',
    'Hydrogen # 200',
    'Mix # Sodium # Chlorine # 200',
    'Replenish # Sodium # 250',
    'Add Formula # Sulfuric Acid # H2SO4',
    'Add Formula # Sodium # Na',
    'Mix # Hydrogen # Chlorine # 50',
    'End']);