const baseUrl = 'http://localhost:3030/jsonstore/matches';

const loadButton = document.getElementById('load-matches');
const addButton = document.getElementById('add-match');
const editButton = document.getElementById('edit-match');

const hostInput = document.getElementById('host');
const scoreInput = document.getElementById('score');
const guestInput = document.getElementById('guest');

const ulListElement = document.getElementById('list');
const formElement = document.querySelector('form');

loadButton.addEventListener('click', loadMatches);
addButton.addEventListener('click', addMatch);
editButton.addEventListener('click', editMatch);

async function addMatch() {
    const host = hostInput.value;
    const score = scoreInput.value;
    const guest = guestInput.value;

    formElement.reset();

    const response = await fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ host, score, guest }),
    });

    if (!response.ok) {
        return;
    }

    await loadMatches();
}

async function editMatch() {
    const matchId = formElement.getAttribute('data-match-id');

    const host = hostInput.value;
    const score = scoreInput.value;
    const guest = guestInput.value;

    formElement.reset();

    const response = await fetch(`${baseUrl}/${matchId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ host, score, guest, _id: matchId }),
    });

    if (!response.ok) {
        return;
    }

    await loadMatches();

    editButton.setAttribute('disabled', 'disabled');
    addButton.removeAttribute('disabled');
    formElement.removeAttribute('data-match-id');
}

async function loadMatches() {
    ulListElement.innerHTML = '';

    const response = await fetch(baseUrl);
    const result = await response.json();
    const matches = Object.values(result);

    if (!response.ok) {
        return;
    }

    const matchElements = matches.map(match => createMatchElement(match.host, match.score, match.guest, match._id));

    ulListElement.append(...matchElements);
    editButton.setAttribute('disabled', 'disabled');
}

function createMatchElement(host, score, guest, matchId) {
    const liMatchElement = document.createElement('li');
    liMatchElement.classList.add('match');

    const divInfoElement = document.createElement('div');
    divInfoElement.classList.add('info');

    const pHostElement = document.createElement('p');
    pHostElement.textContent = host;

    const pScoreElement = document.createElement('p');
    pScoreElement.textContent = score;

    const pGuestElement = document.createElement('p');
    pGuestElement.textContent = guest;

    const divButtonWrapperElement = document.createElement('div');
    divButtonWrapperElement.classList.add('btn-wrapper');

    const changeButton = document.createElement('button');
    changeButton.classList.add('change-btn');
    changeButton.textContent = 'Change';
    changeButton.addEventListener('click', () => {
        formElement.setAttribute('data-match-id', matchId);

        hostInput.value = host;
        scoreInput.value = score;
        guestInput.value = guest;

        editButton.removeAttribute('disabled');
        addButton.setAttribute('disabled', 'disabled');
    });

    const deleteButton = document.createElement('button');
    deleteButton.classList.add('delete-btn');
    deleteButton.textContent = 'Delete';
    deleteButton.addEventListener('click', async () => {
        await fetch(`${baseUrl}/${matchId}`, {
            method: 'DELETE',
        });

        await loadMatches();
    });

    divInfoElement.appendChild(pHostElement);
    divInfoElement.appendChild(pScoreElement);
    divInfoElement.appendChild(pGuestElement);

    divButtonWrapperElement.appendChild(changeButton);
    divButtonWrapperElement.appendChild(deleteButton);

    liMatchElement.appendChild(divInfoElement);
    liMatchElement.appendChild(divButtonWrapperElement);

    return liMatchElement;
}