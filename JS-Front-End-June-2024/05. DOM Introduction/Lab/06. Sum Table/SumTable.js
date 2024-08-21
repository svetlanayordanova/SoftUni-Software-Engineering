function sumTable() {
    const sumElement = document.getElementById('sum');

    const trElements = document.querySelectorAll('table tbody tr');
    let sum = 0;

    for (const trElement of trElements) {
        const secondElement = trElement.children[1];

        if (secondElement.tagName === 'TD' && secondElement.id !== 'sum') {
            const price = Number(secondElement.textContent);
            sum += price;
        }
    }

    sumElement.textContent = sum;
}