const baseUrl = 'http://localhost:3030/jsonstore/games';

const loadButton = document.getElementById('load-games');
const addButton = document.getElementById('add-game');
const editButton = document.getElementById('edit-game');
const divGamesList = document.getElementById('games-list');
const formElement = document.querySelector('form');

const nameInputElement = document.getElementById('g-name');
const typeInputElement = document.getElementById('type');
const playersInputElement = document.getElementById('players');

loadButton.addEventListener('click', loadGames);
addButton.addEventListener('click', addGame);
editButton.addEventListener('click', editGame);

async function addGame() {
    const name = nameInputElement.value;
    const type = typeInputElement.value;
    const players = playersInputElement.value;

    clearInputData();

    const response = await fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, type, players }),
    });

    if (!response.ok) {
        return;
    }

    await loadGames();
}

async function editGame() {
    const gameId = formElement.getAttribute('data-game-id');

    const name = nameInputElement.value;
    const type = typeInputElement.value;
    const players = playersInputElement.value;

    clearInputData();

    const response = await fetch(`${baseUrl}/${gameId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, type, players, _id: gameId }),
    });

    if (!response.ok) {
        return;
    }

    await loadGames();

    editButton.setAttribute('disabled', 'disabled');
    addButton.removeAttribute('disabled');
    formElement.removeAttribute('data-game-id');
}

async function loadGames() {
    divGamesList.innerHTML = '';

    const response = await fetch(baseUrl);
    const result = await response.json();
    const games = Object.values(result);

    const gameElements = games.map(game => createGameElement(game.name, game.type, game.players, game._id));

    divGamesList.append(...gameElements);
}

function createGameElement(name, type, players, gameId) {
    const divBoardGameElement = document.createElement('div');
    divBoardGameElement.classList.add('board-game');

    const divContentElement = document.createElement('div');
    divContentElement.classList.add('content');

    const pNameElement = document.createElement('p');
    pNameElement.textContent = name;

    const pTypeElement = document.createElement('p');
    pTypeElement.textContent = type;

    const pPlayersElement = document.createElement('p');
    pPlayersElement.textContent = players;

    const divButtonsContainer = document.createElement('div');
    divBoardGameElement.classList.add('buttons-container');

    const changeButton = document.createElement('button');
    changeButton.classList.add('change-btn');
    changeButton.textContent = 'Change';
    changeButton.addEventListener('click', () => {
        formElement.setAttribute('data-game-id', gameId);

        nameInputElement.value = name;
        typeInputElement.value = type;
        playersInputElement.value = players;

        editButton.removeAttribute('disabled');
        addButton.setAttribute('disabled', 'disabled');
    });

    const deleteButton = document.createElement('button');
    deleteButton.classList.add('delete-btn');
    deleteButton.textContent = 'Delete';
    deleteButton.addEventListener('click', async () => {
        await fetch(`${baseUrl}/${gameId}`, {
            method: 'DELETE',
        });

        await loadGames();
    });

    divContentElement.appendChild(pNameElement);
    divContentElement.appendChild(pTypeElement);
    divContentElement.appendChild(pPlayersElement);

    divButtonsContainer.appendChild(changeButton);
    divButtonsContainer.appendChild(deleteButton);

    divBoardGameElement.appendChild(divContentElement);
    divBoardGameElement.appendChild(divButtonsContainer);

    return divBoardGameElement;
}

function clearInputData() {
    nameInputElement.value = '';
    typeInputElement.value = '';
    playersInputElement.value = '';
}