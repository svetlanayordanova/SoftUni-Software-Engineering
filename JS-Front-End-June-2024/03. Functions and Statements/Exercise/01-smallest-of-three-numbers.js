function getSmallestOfThreeNumbers(firstNum, secondNum, thirdNum) {
    const smallestNum = Math.min(firstNum, secondNum, thirdNum);
    const printSmallestNumber = num => console.log(num);

    printSmallestNumber(smallestNum);
}

getSmallestOfThreeNumbers(2, 5, 3);
getSmallestOfThreeNumbers(600, 342, 123);
getSmallestOfThreeNumbers(25, 21, 4);
getSmallestOfThreeNumbers(2, 2, 2);