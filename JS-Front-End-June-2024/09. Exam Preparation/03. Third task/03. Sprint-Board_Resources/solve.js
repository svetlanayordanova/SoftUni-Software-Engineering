function attachEvents() {
    const baseUrl = 'http://localhost:3030/jsonstore/tasks';

    const ulElements = document.querySelectorAll('ul');
    const toDoUlElement = document.querySelector('#todo-section ul');
    const inProgressUlElement = document.querySelector('#in-progress-section ul');
    const codeReviewUlElement = document.querySelector('#code-review-section ul');
    const doneUlElement = document.querySelector('#done-section ul');

    const listAndContent = {
        'ToDo': {
            ulElement: toDoUlElement,
            content: 'Move to In Progress',
        },
        'In Progress': {
            ulElement: inProgressUlElement,
            content: 'Move to Code Review',
        },
        'Code Review': {
            ulElement: codeReviewUlElement,
            content: 'Move to Done',
        },
        'Done': {
            ulElement: doneUlElement,
            content: 'Close',
        },
    };

    const loadButton = document.getElementById('load-board-btn');
    const addButton = document.getElementById('create-task-btn');

    const titleInputElement = document.getElementById('title');
    const descriptionInputElement = document.getElementById('description');

    loadButton.addEventListener('click', loadBoard);
    addButton.addEventListener('click', addTask);

    async function addTask() {
        const title = titleInputElement.value;
        const description = descriptionInputElement.value;
        const status = 'ToDo';

        clearInputData();

        await fetch(baseUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ title, description, status }),
        });

        await loadBoard();
    }

    async function loadBoard() {
        [...ulElements].forEach(ulElement => ulElement.innerHTML = '');

        const response = await fetch(baseUrl);
        const result = await response.json();
        const tasks = Object.values(result);

        tasks.map(task => createTaskElement(task.title, task.description, task.status, task._id));
    }

    function createTaskElement(title, description, status, taskId) {
        const currentUlElement = listAndContent[status].ulElement;

        const liTaskElement = document.createElement('li');
        liTaskElement.classList.add('task');

        const h3TitleElement = document.createElement('h3');
        h3TitleElement.textContent = title;

        const pDescriptionElement = document.createElement('p');
        pDescriptionElement.textContent = description;

        const buttonElement = document.createElement('button');
        buttonElement.textContent = listAndContent[status].content;
        buttonElement.addEventListener('click', async () => {
            let newStatus = '';
            
            if (status !== 'Done') {
                if (status === 'ToDo') {
                    newStatus = 'In Progress';
                } else if (status === 'In Progress') {
                    newStatus = 'Code Review';
                } else if (status === 'Code Review') {
                    newStatus = 'Done';
                }

                await fetch(`${baseUrl}/${taskId}`, {
                    method: 'PATCH',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({ title, description, status: newStatus })
                });
            
                await loadBoard();
            } else {
                await fetch(`${baseUrl}/${taskId}`, {
                    method: 'DELETE',
                });

                await loadBoard();
            }
        });

        liTaskElement.appendChild(h3TitleElement);
        liTaskElement.appendChild(pDescriptionElement);
        liTaskElement.appendChild(buttonElement);

        currentUlElement.appendChild(liTaskElement);
    }

    function clearInputData() {
        titleInputElement.value = '';
        descriptionInputElement.value = '';
    }
}

attachEvents();