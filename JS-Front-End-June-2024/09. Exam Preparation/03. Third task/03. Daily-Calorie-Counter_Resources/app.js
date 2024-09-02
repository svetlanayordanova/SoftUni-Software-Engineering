const baseUrl = 'http://localhost:3030/jsonstore/tasks';

const loadButton = document.getElementById('load-meals');
const addButton = document.getElementById('add-meal');
const editButton = document.getElementById('edit-meal');
const ulList = document.getElementById('list');
const formElement = document.querySelector('form');

const foodInput = document.getElementById('food');
const timeInput = document.getElementById('time');
const caloriesInput = document.getElementById('calories');

loadButton.addEventListener('click', loadMeals);
addButton.addEventListener('click', addMeal);
editButton.addEventListener('click', editMeal);

async function loadMeals() {
    ulList.innerHTML = '';

    const response = await fetch(baseUrl);
    const result = await response.json();
    const meals = Object.values(result);

    const mealElements = meals.map(meal => createMealElement(meal.food, meal.calories, meal.time, meal._id));
    
    ulList.append(...mealElements);
}

async function addMeal() {
    const food = foodInput.value;
    const time = timeInput.value;
    const calories = caloriesInput.value;

    formElement.reset();

    await fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ food, time, calories }),
    });

    await loadMeals();
}

async function editMeal() {
    const mealId = formElement.getAttribute('data-meal-id');

    const food = foodInput.value;
    const time = timeInput.value;
    const calories = caloriesInput.value;

    formElement.reset();

    await fetch(`${baseUrl}/${mealId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ food, calories, time, _id: mealId }),
    });

    await loadMeals();

    editButton.setAttribute('disabled', 'disabled');
    addButton.removeAttribute('disabled');
    formElement.removeAttribute('data-meal-id');
}

function createMealElement(food, calories, time, mealId) {
    const divMealElement = document.createElement('div');
    divMealElement.classList.add('meal');

    const h2FoodElement = document.createElement('h2');
    h2FoodElement.textContent = food;

    const h3TimeElement = document.createElement('h3');
    h3TimeElement.textContent = time;

    const h3CaloriesElement = document.createElement('h3');
    h3CaloriesElement.textContent = calories;

    const divButtons = document.createElement('div');
    divButtons.setAttribute('id', 'meal-buttons');

    const changeButton = document.createElement('button');
    changeButton.classList.add('change-meal');
    changeButton.textContent = 'Change';
    changeButton.addEventListener('click', () => {
        foodInput.value = food;
        timeInput.value = time;
        caloriesInput.value = calories;

        divMealElement.remove();

        editButton.removeAttribute('disabled');
        addButton.setAttribute('disabled', 'disabled');
        formElement.setAttribute('data-meal-id', mealId);
    });

    const deleteButton = document.createElement('button');
    deleteButton.classList.add('delete-meal');
    deleteButton.textContent = 'Delete';
    deleteButton.addEventListener('click', async () => {
        await fetch(`${baseUrl}/${mealId}`, {
            method: 'DELETE',
        });

        await loadMeals();
    });

    divButtons.appendChild(changeButton);
    divButtons.appendChild(deleteButton);

    divMealElement.appendChild(h2FoodElement);
    divMealElement.appendChild(h3TimeElement);
    divMealElement.appendChild(h3CaloriesElement);
    divMealElement.appendChild(divButtons);

    return divMealElement;
}