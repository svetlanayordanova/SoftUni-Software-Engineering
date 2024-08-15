function radioCrystals(numbers) {
    const [targetThickness, ...thicknessOfDifferentCrystals] = numbers;
    
    const cut = num => num / 4;
    const lap = num => num -= 0.2 * num;
    const grind = num => num -= 20;
    const etch = num => num -= 2;
    const xRay = num => num += 1; 
    const transportAndWash = num => Math.floor(num);

    const cutOperation = 'Cut';
    const lapOperation = 'Lap';
    const grindOperation = 'Grind';
    const etchOperation = 'Etch';
    const xRayOperation = 'X-ray';

    function printResult(count, operation) {
        if (count > 0 && operation !== 'X-ray') {
            console.log(`${operation} x${count}`);
            console.log('Transporting and washing');
        } else if (count > 0 && operation === 'X-ray') {
            console.log(`${operation} x${count}`);
        }
    }
    
    for (let currentThickness of thicknessOfDifferentCrystals) {
        console.log(`Processing chunk ${currentThickness} microns`);
        
        let cutCount = 0;
        let lapCount = 0;
        let grindCount = 0;
        let etchCount = 0;
        let xRayCount = 0;
        
        while (currentThickness !== targetThickness) { 
            while (cut(currentThickness) >= targetThickness) {
                currentThickness = cut(currentThickness);
                currentThickness = transportAndWash(currentThickness);
                cutCount++;
            }
            
            while (lap(currentThickness) >= targetThickness) {
                currentThickness = lap(currentThickness);
                currentThickness = transportAndWash(currentThickness);
                lapCount++;
            }
            
            while (grind(currentThickness) >= targetThickness) {  
                currentThickness = grind(currentThickness);
                currentThickness = transportAndWash(currentThickness);
                grindCount++;
            } 

            while (etch(currentThickness) >= targetThickness - 1) {
                currentThickness = etch(currentThickness);
                currentThickness = transportAndWash(currentThickness);
                etchCount++;
            }

            if (currentThickness === targetThickness - 1) {
                currentThickness = xRay(currentThickness);
                xRayCount++;
            }
        }

       printResult(cutCount, cutOperation);
       printResult(lapCount, lapOperation);
       printResult(grindCount, grindOperation);
       printResult(etchCount, etchOperation);
       printResult(xRayCount, xRayOperation);
       
       console.log(`Finished crystal ${targetThickness} microns`);
    }
}

radioCrystals([1375, 50000]);
radioCrystals([1000, 4000, 8100]);
