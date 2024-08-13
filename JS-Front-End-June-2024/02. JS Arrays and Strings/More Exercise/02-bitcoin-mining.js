function bitcoinMining(input) {
    const oneBitcoinPrice = 11949.16;
    const oneGramGoldPrice = 67.51;
    const percentStolenGold = 0.3;

    let dailyPurchasedBitcoins = 0;
    let allPurchasedBitcoins = 0;
    let dayFirstPurchasedBitcoin = 0;
    let totalMoney = 0;

    for (let i = 0; i < input.length; i++) {
        let dailyGoldGrams = input[i];
        let dailyIncome = dailyGoldGrams * oneGramGoldPrice;
        let day = i + 1;

        if (day % 3 === 0) {
            dailyIncome -= percentStolenGold * dailyIncome;
        }

        totalMoney += dailyIncome;

        if (totalMoney >= oneBitcoinPrice) {
            dailyPurchasedBitcoins = Math.trunc(totalMoney / oneBitcoinPrice);
            allPurchasedBitcoins += dailyPurchasedBitcoins;

            totalMoney -= dailyPurchasedBitcoins * oneBitcoinPrice;

            if (dayFirstPurchasedBitcoin === 0) {
                dayFirstPurchasedBitcoin = day;
            }
        }
    }

    console.log(`Bought bitcoins: ${allPurchasedBitcoins}`);

    if (allPurchasedBitcoins > 0) {
        console.log(`Day of the first purchased bitcoin: ${dayFirstPurchasedBitcoin}`);
    }

    console.log(`Left money: ${totalMoney.toFixed(2)} lv.`);
}

bitcoinMining([100, 200, 300]);
bitcoinMining([50, 100]);
bitcoinMining([3124.15, 504.212, 2511.124]);