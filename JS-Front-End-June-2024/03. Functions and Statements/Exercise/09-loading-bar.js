function printLoadingBar(percents) {
    const maxPercents = 100;

    function printLoadingBarCompleteMessage() {
        console.log('100% Complete!');
        console.log('[%%%%%%%%%%]');
    }

    function printLoadingBarNotCompleteMessage(number) {
        const percentageCount = number / 10;
        const dotsMaxCount = 10;
        const percentageStr = '%'.repeat(percentageCount);
        const dotsStr = '.'.repeat(dotsMaxCount - percentageCount);

        console.log(`${number}% [${percentageStr}${dotsStr}]`);
        console.log('Still loading...');
    }

    if (percents === maxPercents) {
        printLoadingBarCompleteMessage();
    } else {
        printLoadingBarNotCompleteMessage(percents);
    }
}

printLoadingBar(30);
printLoadingBar(50);
printLoadingBar(100);
printLoadingBar(0);