function wildWestAdventure(inputArray) {
    const n = Number(inputArray[0]);
    
    const charactersData = inputArray.slice(1, n + 1);
    const commands = inputArray.slice(n + 1);
    
    const heroes = [];
    
    charactersData.forEach(character => {
        const [heroName, hitPoints, bullets] = character.split(' ');
        const hero = {
            heroName,
            hitPoints: Number(hitPoints),
            bullets: Number(bullets),
        }

        heroes.push(hero);
    });

    commands.forEach(command => {
        if (command.startsWith('FireShot')) {
            const [_, characterName, target] = command.split(' - ');
            
            const currentHero = findHero(characterName);

            if (currentHero.bullets > 0) {
                currentHero.bullets -= 1;

                console.log(`${characterName} has successfully hit ${target} and now has ${currentHero.bullets} bullets!`);
            } else {
                console.log(`${characterName} doesn't have enough bullets to shoot at ${target}!`);
            }
        } else if (command.startsWith('TakeHit')) {
            const [_, characterName, damage, attacker] = command.split(' - ');

            const currentHero = findHero(characterName);

            currentHero.hitPoints -= Number(damage);

            if (currentHero.hitPoints > 0) {
                console.log(`${characterName} took a hit for ${damage} HP from ${attacker} and now has ${currentHero.hitPoints} HP!`);
            } else {
                // премахва по индекс и посочва колко елемента след индекса да бъдат премахнати
                const index = heroes.indexOf(currentHero);
                heroes.splice(index, 1);

                console.log(`${characterName} was gunned down by ${attacker}!`);
            }
        } else if (command.startsWith('Reload')) {
            const [_, characterName] = command.split(' - ');

            const currentHero = findHero(characterName);
            const currentBulletsCount = currentHero.bullets;

            if (currentBulletsCount < 6) {
                currentHero.bullets = 6;
                
                console.log(`${characterName} reloaded ${6 - currentBulletsCount} bullets!`);
            } else {
                console.log(`${characterName}'s pistol is fully loaded!`);
            }
        } else if (command.startsWith('PatchUp')) {
            const [_, characterName, amount] = command.split(' - ');

            const currentHero = findHero(characterName);
            const amountHitPoints = Number(amount);
            const currentHitPointsCount = currentHero.hitPoints;

            if (currentHitPointsCount < 100) {
                if (currentHero.hitPoints + amountHitPoints <= 100) {
                    currentHero.hitPoints += amountHitPoints;
                    console.log(`${characterName} patched up and recovered ${amount} HP!`);
                } else {
                    console.log(`${characterName} patched up and recovered ${100 - currentHitPointsCount} HP!`);
                }

            } else {
                console.log(`${characterName} is in full health!`);
            }
        } else if (command === 'Ride Off Into Sunset') {
            return;
        }
    });

    heroes.forEach(hero => {
        console.log(`${hero.heroName}`);
        console.log(` HP: ${hero.hitPoints}`);
        console.log(` Bullets: ${hero.bullets}`);
    });

    function findHero(characterName) {
        return heroes.find(hero => hero.heroName === characterName);
    }
}

wildWestAdventure((["2",
    "Gus 100 0",
    "Walt 100 6",
    "FireShot - Gus - Bandit",
    "TakeHit - Gus - 100 - Bandit",
    "Reload - Walt",
    "Ride Off Into Sunset"]));
wildWestAdventure((["2",
    "Jesse 100 4",
    "Walt 100 5",
    "FireShot - Jesse - Bandit",
     "TakeHit - Walt - 30 - Bandit",
     "PatchUp - Walt - 20" ,
     "Reload - Jesse",
     "Ride Off Into Sunset"]));
wildWestAdventure((["2",
    "Gus 100 4",
    "Walt 100 5",
    "FireShot - Gus - Bandit",
    "TakeHit - Walt - 100 - Bandit",
    "Reload - Gus",
    "Ride Off Into Sunset"]));