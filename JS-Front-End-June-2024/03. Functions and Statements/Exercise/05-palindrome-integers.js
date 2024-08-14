function getPalindromeIntegers(numbers) {
    function isNumberPalindrome(number) {
        const reversedNumber = Number(number.toString().split('').reverse().join(''));

        return number === reversedNumber;
    }

    numbers.forEach(num => {
        console.log(isNumberPalindrome(num));
    });
}

getPalindromeIntegers([123,323,421,121]);
getPalindromeIntegers([32,2,232,1010]);