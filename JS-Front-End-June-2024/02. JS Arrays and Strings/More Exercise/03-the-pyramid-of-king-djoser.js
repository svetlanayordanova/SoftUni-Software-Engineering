function thePyramidOfKingDjoser(base, increment) {
    let step = 0;
    let finalStep = 0;
    let totalStoneRequired = 0;
    let totalMarbleRequired = 0;
    let totalLapisLazuliRequired = 0;
    let totalGoldRequired = 0;

    for (let currentBase = base; currentBase > 0; currentBase -= 2) {
        step++;
        outerLayer = 4 * currentBase - 4;
        bulk = currentBase * currentBase - outerLayer;
        
        const fifthStep = step % 5 === 0;
        const lastStep = currentBase === 1 || currentBase === 2;

        if (!lastStep) {
            let stoneRequired = bulk * increment;
            totalStoneRequired += stoneRequired;

            if (!fifthStep) {
                let marbleRequired = outerLayer * increment;
                totalMarbleRequired += marbleRequired;
            } else {
                let lapisLazuliRequired = outerLayer * increment;
                totalLapisLazuliRequired += lapisLazuliRequired;
            }
        } else {
            let goldRequired = currentBase * currentBase * increment;
            totalGoldRequired += goldRequired;
            finalStep = step * increment;
        }
    }

    console.log(`Stone required: ${Math.ceil(totalStoneRequired)}`);
    console.log(`Marble required: ${Math.ceil(totalMarbleRequired)}`);
    console.log(`Lapis Lazuli required: ${Math.ceil(totalLapisLazuliRequired)}`);
    console.log(`Gold required: ${Math.ceil(totalGoldRequired)}`);
    console.log(`Final pyramid height: ${Math.floor(finalStep)}`);
}

thePyramidOfKingDjoser(11, 1);
thePyramidOfKingDjoser(11, 0.75);
thePyramidOfKingDjoser(12, 1);
thePyramidOfKingDjoser(23, 0.5);