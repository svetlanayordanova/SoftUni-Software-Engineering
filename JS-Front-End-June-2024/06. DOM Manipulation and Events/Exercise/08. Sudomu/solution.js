function solve() {
    const quickCheckButton = document.querySelector('table tfoot button:first-of-type');
    const clearButton = document.querySelector('table tfoot button:last-of-type');
    const tableElement = document.querySelector('table');
    const checkParagraph = document.querySelector('div#check p');
    
    let isSolved = true;
    
    quickCheckButton.addEventListener('click', (e) => {
        const trElements = document.querySelectorAll('table tbody tr');
        
        for (let row = 0; row < trElements.length; row++) {
            const trElement = trElements[row];
            
            const firstInputRow = trElement.children[0].children[0].value;
            const secondInputRow = trElement.children[1].children[0].value;
            const thirdInputRow = trElement.children[2].children[0].value;

            if (!validateInput(firstInputRow, secondInputRow, thirdInputRow)) {
                isSolved = false;
                break;
            }
        }

        for (let col = 0; col < trElements.length; col++) {
            const firstInputCol = trElements[0].children[col].children[0].value;
            const secondInputCol = trElements[1].children[col].children[0].value;
            const thirdInputCol = trElements[2].children[col].children[0].value;
            
            if (!validateInput(firstInputCol, secondInputCol, thirdInputCol)) {
                isSolved = false;
                break;
            }
        }

        if (isSolved) {
            tableElement.style.border = '2px solid green';
            checkParagraph.textContent = 'You solve it! Congratulations!';
            checkParagraph.style.color = 'green';
        } else {
            tableElement.style.border = '2px solid red';
            checkParagraph.textContent = 'NOP! You are not done yet...';
            checkParagraph.style.color = 'red';
        }
    });

    clearButton.addEventListener('click', (e) => {
        const allInputElements = document.querySelectorAll('input');

        [...allInputElements].map(input => input.value = '');
        checkParagraph.textContent = '';
        tableElement.style.border = 'none';
    });

    function validateInput(firstInput, secondInput, thirdInput) {
        return firstInput !== secondInput &&
        firstInput !== thirdInput && 
        secondInput !== thirdInput &&
        firstInput >= 1 && firstInput <= 3 && 
        secondInput >= 1 && secondInput <= 3 && 
        thirdInput >= 1 && thirdInput <= 3;
    }
}