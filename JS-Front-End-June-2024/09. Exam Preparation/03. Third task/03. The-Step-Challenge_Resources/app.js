const baseUrl = 'http://localhost:3030/jsonstore/records';

const loadButton = document.getElementById('load-records');
const addButton = document.getElementById('add-record');
const editButton = document.getElementById('edit-record');
const ulListElement = document.getElementById('list');
const formElement = document.querySelector('form')

const nameInputElement = document.getElementById('p-name');
const stepsInputElement = document.getElementById('steps');
const caloriesInputElement = document.getElementById('calories');

loadButton.addEventListener('click', loadRecords);
addButton.addEventListener('click', addRecord);
editButton.addEventListener('click', editRecord);

async function addRecord() {
    const name = nameInputElement.value;
    const steps = stepsInputElement.value;
    const calories = caloriesInputElement.value;

    clearInputData();

    const response = await fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, steps, calories }),
    });

    if (!response.ok) {
        return;
    }

    await loadRecords();
}

async function editRecord() {
    const recordId = formElement.getAttribute('data-id');

    const name = nameInputElement.value;
    const steps = stepsInputElement.value;
    const calories = caloriesInputElement.value;

    clearInputData();

    const response = await fetch(`${baseUrl}/${recordId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, steps, calories, _id: recordId }),
    });

    if (!response.ok) {
        return;
    }

    await loadRecords();

    editButton.setAttribute('disabled', 'disabled');
    addButton.removeAttribute('disabled');
    formElement.removeAttribute('data-id');
}

async function loadRecords() {
    ulListElement.innerHTML = '';

    const response = await fetch(baseUrl);
    const result = await response.json();
    const records = Object.values(result);

    const recordElements = records.map(record => createRecordElement(record.name, record.steps, record.calories, record._id));

    ulListElement.append(...recordElements);
}

function createRecordElement(name, steps, calories, recordId) {
    const liElement = document.createElement('li');
    liElement.classList.add('record');

    const divInfoElement = document.createElement('div');
    divInfoElement.classList.add('info');

    const pNameElement = document.createElement('p');
    pNameElement.textContent = name;

    const pStepsElement = document.createElement('p');
    pStepsElement.textContent = steps;

    const pCaloriesElement = document.createElement('p');
    pCaloriesElement.textContent = calories;

    const divButtonsElement = document.createElement('div');
    divButtonsElement.classList.add('btn-wrapper');

    const changeButton = document.createElement('button');
    changeButton.classList.add('change-btn');
    changeButton.textContent = 'Change';
    changeButton.addEventListener('click', () => {
        formElement.setAttribute('data-id', recordId);

        nameInputElement.value = name;
        stepsInputElement.value = steps;
        caloriesInputElement.value = calories;

        editButton.removeAttribute('disabled');
        addButton.setAttribute('disabled', 'disabled');
    });

    const deleteButton = document.createElement('button');
    deleteButton.classList.add('delete-btn');
    deleteButton.textContent = 'Delete';
    deleteButton.addEventListener('click', async () => {
        await fetch(`${baseUrl}/${recordId}`, {
            method: 'DELETE',
        });

        await loadRecords();
    });

    divInfoElement.appendChild(pNameElement);
    divInfoElement.appendChild(pStepsElement);
    divInfoElement.appendChild(pCaloriesElement);

    divButtonsElement.appendChild(changeButton);
    divButtonsElement.appendChild(deleteButton);

    liElement.appendChild(divInfoElement);
    liElement.appendChild(divButtonsElement);

    return liElement;
}

function clearInputData() {
    nameInputElement.value = '';
    stepsInputElement.value = '';
    caloriesInputElement.value = '';
}