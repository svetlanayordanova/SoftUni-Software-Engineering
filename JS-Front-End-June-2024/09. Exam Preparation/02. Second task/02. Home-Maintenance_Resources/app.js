window.addEventListener("load", solve);

function solve() {
    const addButton = document.getElementById('add-btn');
    const ulTaskListElement = document.getElementById('task-list');
    const ulDoneListElement = document.getElementById('done-list');

    addButton.addEventListener('click', onAdd);

    function onAdd() {
        const placeElement = document.getElementById('place');
        const actionElement = document.getElementById('action');
        const personElement = document.getElementById('person');

        if (placeElement.value === '' || actionElement.value === '' || personElement.value === '') {
            return;
        }

        const liCleanTaskElement = document.createElement('li');
        liCleanTaskElement.classList.add('clean-task');
        
        const articleElement = document.createElement('article');

        const placeElementP = document.createElement('p');
        placeElementP.textContent = `Place:${placeElement.value}`;
        const place = placeElement.value;

        const actionElementP = document.createElement('p');
        actionElementP.textContent = `Action:${actionElement.value}`;
        const action = actionElement.value;

        const personElementP = document.createElement('p');
        personElementP.textContent = `Person:${personElement.value}`;
        const person = personElement.value;

        const divElement = document.createElement('div');
        divElement.classList.add('buttons');

        const editButton = document.createElement('button');
        editButton.classList.add('edit');
        editButton.textContent = 'Edit';

        const doneButton = document.createElement('button');
        doneButton.classList.add('done');
        doneButton.textContent = 'Done';

        articleElement.appendChild(placeElementP);
        articleElement.appendChild(actionElementP);
        articleElement.appendChild(personElementP);

        divElement.appendChild(editButton);
        divElement.appendChild(doneButton);

        liCleanTaskElement.appendChild(articleElement);
        liCleanTaskElement.appendChild(divElement);

        ulTaskListElement.appendChild(liCleanTaskElement);

        placeElement.value = '';
        actionElement.value = '';
        personElement.value = '';

        editButton.addEventListener('click', edit);

        function edit() {
            placeElement.value = place;
            actionElement.value = action;
            personElement.value = person;

            ulTaskListElement.removeChild(liCleanTaskElement);
        }

        doneButton.addEventListener('click', onDone);

        function onDone() {
            const liDoneListElement = document.createElement('li');
            const deleteButton = document.createElement('button');
            deleteButton.classList.add('delete');
            deleteButton.textContent = 'Delete';

            liDoneListElement.appendChild(articleElement);
            liDoneListElement.appendChild(deleteButton);

            ulDoneListElement.appendChild(liDoneListElement);

            ulTaskListElement.removeChild(liCleanTaskElement);

            deleteButton.addEventListener('click', onDelete);

            function onDelete() {
                ulDoneListElement.removeChild(liDoneListElement);
            }
        }
    }
}