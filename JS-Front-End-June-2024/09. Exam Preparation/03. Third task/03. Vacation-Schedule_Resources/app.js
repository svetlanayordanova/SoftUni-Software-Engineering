const baseUrl = 'http://localhost:3030/jsonstore/tasks';

const loadButton = document.getElementById('load-vacations');
const addButton = document.getElementById('add-vacation');
const editButton = document.getElementById('edit-vacation');
const divListElement = document.getElementById('list');
const formElement = document.querySelector('form');

const nameInputElement = document.getElementById('name');
const daysInputElement = document.getElementById('num-days');
const dateInputElement = document.getElementById('from-date');

loadButton.addEventListener('click', loadVacations);
addButton.addEventListener('click', addVacation);
editButton.addEventListener('click', editVacation);

async function addVacation() {
    const name = nameInputElement.value;
    const date = dateInputElement.value;
    const days = daysInputElement.value;
    
    formElement.reset();

    const response = await fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, date, days }),
    });

    if (!response.ok) {
        return;
    }

    await loadVacations();
}

async function editVacation() {
    const vacationId = formElement.getAttribute('data-vacation-id');

    const name = nameInputElement.value;
    const date = dateInputElement.value;
    const days = daysInputElement.value;

    const response = await fetch(`${baseUrl}/${vacationId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, date, days, _id: vacationId}),
    });

    if (!response.ok) {
        return;
    }

    await loadVacations();

    editButton.setAttribute('disabled', 'disabled');
    addButton.removeAttribute('disabled');
    formElement.removeAttribute('data-vacation-id');
}

async function loadVacations() {
    divListElement.innerHTML = '';

    const response = await fetch(baseUrl);
    const result = await response.json();
    const vacations = Object.values(result);

    const vacationElements = vacations.map(vacation => createVacationElement(vacation.name, vacation.days, vacation.date, vacation._id));

    divListElement.append(...vacationElements);
}

function createVacationElement(name, days, date, vacationId) {
    const divContainerElement = document.createElement('div');
    divContainerElement.classList.add('container');

    const h2NameElement = document.createElement('h2');
    h2NameElement.textContent = name;

    const h3DateElement = document.createElement('h3');
    h3DateElement.textContent = date;

    const h3DaysElement = document.createElement('h3');
    h3DaysElement.textContent = days;

    const changeButton = document.createElement('button');
    changeButton.classList.add('change-btn');
    changeButton.textContent = 'Change';
    changeButton.addEventListener('click', () => {
        formElement.setAttribute('data-vacation-id', vacationId);

        nameInputElement.value = name;
        dateInputElement.value = date;
        daysInputElement.value = days;

        divContainerElement.remove();

        editButton.removeAttribute('disabled');
        addButton.setAttribute('disabled', 'disabled');
    });

    const doneButton = document.createElement('button');
    doneButton.classList.add('done-btn');
    doneButton.textContent = 'Done';
    doneButton.addEventListener('click', async () => {
        await fetch(`${baseUrl}/${vacationId}`, {
            method: 'DELETE',
        });

        await loadVacations();
    });

    divContainerElement.appendChild(h2NameElement);
    divContainerElement.appendChild(h3DateElement);
    divContainerElement.appendChild(h3DaysElement);
    divContainerElement.appendChild(changeButton);
    divContainerElement.appendChild(doneButton);

    return divContainerElement;
}

