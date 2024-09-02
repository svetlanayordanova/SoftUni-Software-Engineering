const baseUrl = 'http://localhost:3030/jsonstore/tasks';

const loadButton = document.getElementById('load-course');
const addButton = document.getElementById('add-course');
const editFormButton = document.getElementById('edit-course');
const divListElement = document.getElementById('list');
const formElement = document.querySelector('form');

const courseTitleInputElement = document.getElementById('course-name');
const typeInputElement = document.getElementById('course-type');
const descriptionTextareaElement = document.getElementById('description');
const teacherNameInputElement = document.getElementById('teacher-name');

loadButton.addEventListener('click', loadCourses);
addButton.addEventListener('click', addCourse);
editFormButton.addEventListener('click', editCourse);

async function addCourse() {
    const title = courseTitleInputElement.value;
    const type = typeInputElement.value;
    const description = descriptionTextareaElement.value;
    const teacher = teacherNameInputElement.value;

    formElement.reset();

    const response = await fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ title, type, description, teacher }),
    });

    if (!response.ok) {
        return;
    }

    await loadCourses();
}

async function editCourse() {
    const courseId = formElement.getAttribute('data-course-id');

    const title = courseTitleInputElement.value;
    const type = typeInputElement.value;
    const description = descriptionTextareaElement.value;
    const teacher = teacherNameInputElement.value;

    formElement.reset();

    const response = await fetch(`${baseUrl}/${courseId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ title, type, description, teacher, _id: courseId }),
    });

    if (!response.ok) {
        return;
    }

    await loadCourses();

    editFormButton.setAttribute('disabled', 'disabled');
    addButton.removeAttribute('disabled');
    formElement.removeAttribute('data-course-id');
}

async function loadCourses() {
    divListElement.innerHTML = '';

    const response = await fetch(baseUrl);
    const result = await response.json();
    const courses = Object.values(result);

    const courseElements = courses.map(course => createCourseElement(course.title, course.type, course.description, course.teacher, course._id));

    divListElement.append(...courseElements);
}

function createCourseElement(title, type, description, teacher, courseId) {
    const divContainerElement = document.createElement('container');
    divContainerElement.classList.add('container');

    const h2TitleElement = document.createElement('h2');
    h2TitleElement.textContent = title;

    const h3TeacherElement = document.createElement('h3');
    h3TeacherElement.textContent = teacher;

    const h3TypeElement = document.createElement('h3');
    h3TypeElement.textContent = type;

    const h4DescriptionElement = document.createElement('h4');
    h4DescriptionElement.textContent = description;

    const editRecordButton = document.createElement('button');
    editRecordButton.classList.add('edit-btn');
    editRecordButton.textContent = 'Edit Course';
    editRecordButton.addEventListener('click', () => {
        formElement.setAttribute('data-course-id', courseId);

        courseTitleInputElement.value = title;
        typeInputElement.value = type;
        descriptionTextareaElement.value = description;
        teacherNameInputElement.value = teacher;

        divContainerElement.remove();

        editFormButton.removeAttribute('disabled');
        addButton.setAttribute('disabled', 'disabled');
    });

    const finishButton = document.createElement('button');
    finishButton.classList.add('finish-btn');
    finishButton.textContent = 'Finish Course';
    finishButton.addEventListener('click', async () => {
        await fetch(`${baseUrl}/${courseId}`, {
            method: 'DELETE',
        });

        await loadCourses();
    });

    divContainerElement.appendChild(h2TitleElement);
    divContainerElement.appendChild(h3TeacherElement);
    divContainerElement.appendChild(h3TypeElement);
    divContainerElement.appendChild(h4DescriptionElement);
    divContainerElement.appendChild(editRecordButton);
    divContainerElement.appendChild(finishButton);

    return divContainerElement;
}
