function calc() {
    // Първо вземаме референциите
    const num1Element = document.getElementById('num1');
    const num2Element = document.getElementById('num2');
    const sumElement = document.getElementById('sum');

    // Запазваме в променливи числовите стойности, които въвеждаме в инпут полетата
    const firstNum = Number(num1Element.value);
    const secondNum = Number(num2Element.value);

    sumElement.value = firstNum + secondNum;
}
