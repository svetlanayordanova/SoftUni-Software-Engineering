const baseUrl = 'http://localhost:3030/jsonstore/tasks';

const loadButton = document.getElementById('load-history');
const addButton = document.getElementById('add-weather');
const editButton = document.getElementById('edit-weather');
const divList = document.getElementById('list');
const formElement = document.querySelector('form');

const locationInputElement = document.getElementById('location');
const temperatureInputElement = document.getElementById('temperature');
const dateInputElement = document.getElementById('date');

loadButton.addEventListener('click', loadHistory);
addButton.addEventListener('click', addWeather);
editButton.addEventListener('click', editWeather);

async function addWeather() {
    const location = locationInputElement.value;
    const temperature = temperatureInputElement.value;
    const date = dateInputElement.value;
    
    formElement.reset();

    const response = await fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ location, temperature, date }),
    });

    if (!response.ok) {
        return;
    }

    await loadHistory();
}

async function editWeather() {
    const weatherId = formElement.getAttribute('data-weather-id');

    const location = locationInputElement.value;
    const temperature = temperatureInputElement.value;
    const date = dateInputElement.value;

    formElement.reset();

    const response = await fetch(`${baseUrl}/${weatherId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ location, temperature, date, _id: weatherId }),
    });

    if (!response.ok) {
        return;
    }

    await loadHistory();

    editButton.setAttribute('disabled', 'disabled');
    addButton.removeAttribute('disabled');
    formElement.removeAttribute('data-weather-id');
}

async function loadHistory() {
    divList.innerHTML = '';

    const response = await fetch(baseUrl);
    const result = await response.json();
    const weathers = Object.values(result);

    const weatherElements = weathers.map(weather => createWeatherElement(weather.location, Number(weather.temperature), weather.date, weather._id));

    divList.append(...weatherElements);
}

function createWeatherElement(location, temperature, date, weatherId) {
    const divContainer = document.createElement('div');
    divContainer.classList.add('container');

    const h2LocationElement = document.createElement('h2');
    h2LocationElement.textContent = location;

    const h3DateElement = document.createElement('h3');
    h3DateElement.textContent = date;

    const h3TemperatureElement = document.createElement('h3');
    h3TemperatureElement.setAttribute('id', 'celsius');
    h3TemperatureElement.textContent = temperature;

    const divButtonsContainer = document.createElement('div');
    divButtonsContainer.classList.add('buttons-container');

    const changeButton = document.createElement('button');
    changeButton.classList.add('change-btn');
    changeButton.textContent = 'Change';
    changeButton.addEventListener('click', () => {
        formElement.setAttribute('data-weather-id', weatherId);

        locationInputElement.value = location;
        temperatureInputElement.value = temperature;
        dateInputElement.value = date;

        divContainer.remove();

        editButton.removeAttribute('disabled');
        addButton.setAttribute('disabled', 'disabled');
    })

    const deleteButton = document.createElement('button');
    deleteButton.classList.add('delete-btn');
    deleteButton.textContent = 'Delete';
    deleteButton.addEventListener('click', async () => {
        await fetch(`${baseUrl}/${weatherId}`, {
            method: 'DELETE',
        });

        await loadHistory();
    });

    divButtonsContainer.appendChild(changeButton);
    divButtonsContainer.appendChild(deleteButton);

    divContainer.appendChild(h2LocationElement);
    divContainer.appendChild(h3DateElement);
    divContainer.appendChild(h3TemperatureElement);
    divContainer.appendChild(divButtonsContainer);

    return divContainer;
}