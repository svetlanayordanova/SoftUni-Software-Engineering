function gladiatorExpenses(lostFightsCount, helmetPrice, swordPrice, shieldPrice, armorPrice) {
    let countBrokenHelmet = 0;
    let countBrokenSword = 0;
    let countBrokenShield = 0;
    let countBrokenArmor = 0;

    let totalExpenses = 0;

    for (let i = 1; i <= lostFightsCount; i++) {
        if (i % 2 === 0) {
            countBrokenHelmet++;
            if (i % 3 === 0) {
                countBrokenSword++;
                countBrokenShield++;

                if (countBrokenShield % 2 === 0) {
                    countBrokenArmor++;
                }
            }
        } else if (i % 3 === 0) {
            countBrokenSword++;
        }
    }

    totalExpenses = countBrokenHelmet * helmetPrice 
                    + countBrokenSword * swordPrice 
                    + countBrokenShield * shieldPrice 
                    + countBrokenArmor * armorPrice;

    console.log(`Gladiator expenses: ${totalExpenses.toFixed(2)} aureus`);
}

gladiatorExpenses(7, 2, 3, 4, 5);
gladiatorExpenses(23, 12.50, 21.50, 40, 200);