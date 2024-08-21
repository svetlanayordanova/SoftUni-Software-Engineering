function colorize() {
    const evenTableRowElements = document.querySelectorAll('table tbody tr:nth-child(even)');

    for (const trElement of evenTableRowElements) {
        trElement.style.backgroundColor = 'teal'; 
    }
}