function extractText() {
    const ulElement = document.getElementById('items');
    const resultElement = document.getElementById('result');

    const textResult = ulElement.innerText;

    resultElement.textContent = textResult;
}