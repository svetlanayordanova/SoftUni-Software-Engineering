function spiceMustFlow(startingYield) {
    const consumedSpicesPerDay = 26;
    let extractedSpicesPerDay = 0;
    let totalExtractedSpices = 0;
    let days = 0;

    while (startingYield >= 100) {
        days++;
        extractedSpicesPerDay = startingYield;
        extractedSpicesPerDay = Math.max(0, extractedSpicesPerDay - consumedSpicesPerDay);
        totalExtractedSpices += extractedSpicesPerDay;
        startingYield -= 10;
    }

    totalExtractedSpices = Math.max(0, totalExtractedSpices - consumedSpicesPerDay);

    console.log(days);
    console.log(totalExtractedSpices);
}

spiceMustFlow(111);
spiceMustFlow(450);