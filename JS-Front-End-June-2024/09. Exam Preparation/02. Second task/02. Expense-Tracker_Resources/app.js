window.addEventListener("load", solve);

function solve() {
    const addButton = document.getElementById('add-btn');
    const ulPreviewListElement = document.getElementById('preview-list');
    const divExpensesElement = document.getElementById('expenses');
    const ulExpensesListElement = document.getElementById('expenses-list');

    addButton.addEventListener('click', onAdd);

    function onAdd() {
        const expenseTypeInputElement = document.getElementById('expense');
        const amountInputElement = document.getElementById('amount');
        const dateInputElement = document.getElementById('date');

        if (expenseTypeInputElement.value === '' || amountInputElement.value === '' || dateInputElement.value === '') {
            return;
        }

        const liExpenseItemElement = document.createElement('li');
        liExpenseItemElement.classList.add('expense-item');

        const articleElement = document.createElement('article');
        
        const pExpenseTypeElement = document.createElement('p');
        pExpenseTypeElement.textContent = `Type: ${expenseTypeInputElement.value}`;
        const expenseType = expenseTypeInputElement.value;

        const pAmountElement = document.createElement('p');
        pAmountElement.textContent = `Amount: ${amountInputElement.value}$`;
        const amount = amountInputElement.value;
        
        const pDateElement = document.createElement('p');
        pDateElement.textContent = `Date: ${dateInputElement.value}`;
        const date = dateInputElement.value;

        const divElement = document.createElement('div');
        divElement.classList.add('buttons');

        const editButton = document.createElement('button');
        editButton.classList.add('btn');
        editButton.classList.add('edit');
        editButton.textContent = 'edit';

        const okButton = document.createElement('button');
        okButton.classList.add('btn');
        okButton.classList.add('ok');
        okButton.textContent = 'ok';

        articleElement.appendChild(pExpenseTypeElement);
        articleElement.appendChild(pAmountElement);
        articleElement.appendChild(pDateElement);

        divElement.appendChild(editButton);
        divElement.appendChild(okButton);

        liExpenseItemElement.appendChild(articleElement);
        liExpenseItemElement.appendChild(divElement);

        ulPreviewListElement.appendChild(liExpenseItemElement);

        const formElement = document.querySelector('form');
        formElement.reset();
        addButton.setAttribute('disabled', 'disabled');

        editButton.addEventListener('click', edit);

        function edit() {
            expenseTypeInputElement.value = expenseType;
            amountInputElement.value = amount;
            dateInputElement.value = date;

            ulPreviewListElement.removeChild(liExpenseItemElement);
            addButton.disabled = false;
        }

        okButton.addEventListener('click', onOk);

        function onOk() {
            const clonedLiElement = liExpenseItemElement.cloneNode(true);
            ulPreviewListElement.removeChild(liExpenseItemElement);
            clonedLiElement.removeChild(clonedLiElement.children[1]);

            const deleteButton = document.createElement('button');
            deleteButton.classList.add('btn');
            deleteButton.classList.add('delete');
            deleteButton.textContent = 'Delete';

            ulExpensesListElement.appendChild(clonedLiElement);

            divExpensesElement.appendChild(ulExpensesListElement);
            divExpensesElement.appendChild(deleteButton);

            deleteButton.addEventListener('click', onDelete);

            function onDelete() {
                // презарежда страницата
                location.reload();
            }
        }
    }
}