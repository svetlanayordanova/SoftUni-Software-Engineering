window.addEventListener("load", solve);

function solve() {
  const nameInput = document.getElementById('name');
  const dateInput = document.getElementById('time');
  const descriptionTextarea = document.getElementById('description');

  const ulPreviewList = document.getElementById('preview-list');
  const ulArchiveList = document.getElementById('archive-list');
  const formElement = document.querySelector('form');

  const addButton = document.getElementById('add-btn');

  addButton.addEventListener('click', () => {
    if (nameInput.value === '' || dateInput.value === '' || descriptionTextarea.value === '') {
      return;
    }
    
    const liElement = document.createElement('li');

    const articleElement = document.createElement('article');

    const pNameElement = document.createElement('p');
    pNameElement.textContent = nameInput.value;
    const name = nameInput.value;

    const pDateElement = document.createElement('p');
    pDateElement.textContent = dateInput.value;
    const date = dateInput.value;

    const pDescriptionElement = document.createElement('p');
    pDescriptionElement.textContent = descriptionTextarea.value;
    const description = descriptionTextarea.value;

    const divButtonsElement = document.createElement('div');
    divButtonsElement.classList.add('buttons');

    const editButton = document.createElement('button');
    editButton.classList.add('edit-btn');
    editButton.textContent = 'Edit';
    editButton.addEventListener('click', () => {
      nameInput.value = name;
      dateInput.value = date;
      descriptionTextarea.value = description;
      liElement.remove();
      addButton.removeAttribute('disabled');
    });

    const nextButton = document.createElement('button');
    nextButton.classList.add('next-btn');
    nextButton.textContent = 'Next';
    nextButton.addEventListener('click', () => {
      ulArchiveList.appendChild(liElement);
      divButtonsElement.remove();
      const archiveButton = document.createElement('button');
      archiveButton.classList.add('archive-btn');
      archiveButton.textContent = 'Archive';
      liElement.appendChild(archiveButton);

      archiveButton.addEventListener('click', () => {
        liElement.remove();
        addButton.removeAttribute('disabled');
      })
    });

    articleElement.appendChild(pNameElement);
    articleElement.appendChild(pDateElement);
    articleElement.appendChild(pDescriptionElement);

    divButtonsElement.appendChild(editButton);
    divButtonsElement.appendChild(nextButton);

    liElement.appendChild(articleElement);
    liElement.appendChild(divButtonsElement);

    ulPreviewList.appendChild(liElement);

    formElement.reset();

    addButton.setAttribute('disabled', 'disabled');
  });
}