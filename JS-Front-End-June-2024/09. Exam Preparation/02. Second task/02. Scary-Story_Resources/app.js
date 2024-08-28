window.addEventListener("load", solve);

function solve() {
  const publishButton = document.getElementById('form-btn');
  const ulPreviewListElement = document.getElementById('preview-list');
  const formElement = document.querySelector('form');
  const divMainElement = document.getElementById('main');

  publishButton.addEventListener('click', publish);

  function publish() {
    const firstNameInputElement = document.getElementById('first-name');
    const lastNameInputElement = document.getElementById('last-name');
    const ageInputElement = document.getElementById('age');
    const storyTitleInputElement = document.getElementById('story-title');
    const genreSelectElement = document.getElementById('genre');
    const storyTextareaElement = document.getElementById('story');

    if (firstNameInputElement.value === '' || lastNameInputElement.value === '' ||
      ageInputElement.value === '' || storyTitleInputElement.value === '' || 
      genreSelectElement.value === '' || storyTextareaElement.value === '') {
      return;
    }

    const liStoryInfoElement = document.createElement('li');
    liStoryInfoElement.classList.add('story-info');

    const articleElement = document.createElement('article');

    const h4NameElement = document.createElement('h4');
    h4NameElement.textContent = `Name: ${firstNameInputElement.value + ' ' + lastNameInputElement.value}`;
    const firstName = firstNameInputElement.value;
    const lastName = lastNameInputElement.value;

    const pAgeElement = document.createElement('p');
    pAgeElement.textContent = `Age: ${ageInputElement.value}`;
    const age = ageInputElement.value;

    const pTitleElement = document.createElement('p');
    pTitleElement.textContent = `Title: ${storyTitleInputElement.value}`;
    const title = storyTitleInputElement.value;

    const pGenreElement = document.createElement('p');
    pGenreElement.textContent = `Genre: ${genreSelectElement.value}`;
    const genre = genreSelectElement.value;

    const pStoryElement = document.createElement('p');
    pStoryElement.textContent = storyTextareaElement.value;
    const story = storyTextareaElement.value;

    const saveButton = document.createElement('button');
    saveButton.classList.add('save-btn');
    saveButton.textContent = 'Save Story';

    const editButton = document.createElement('button');
    editButton.classList.add('edit-btn');
    editButton.textContent = 'Edit Story';

    const deleteButton = document.createElement('button');
    deleteButton.classList.add('delete-btn');
    deleteButton.textContent = 'Delete Story';

    articleElement.appendChild(h4NameElement);
    articleElement.appendChild(pAgeElement);
    articleElement.appendChild(pTitleElement);
    articleElement.appendChild(pGenreElement);
    articleElement.appendChild(pStoryElement);

    liStoryInfoElement.appendChild(articleElement);
    liStoryInfoElement.appendChild(saveButton);
    liStoryInfoElement.appendChild(editButton);
    liStoryInfoElement.appendChild(deleteButton);

    ulPreviewListElement.appendChild(liStoryInfoElement);

    formElement.reset();

    publishButton.setAttribute('disabled', 'disabled');

    editButton.addEventListener('click', editStory);

    function editStory() {
      firstNameInputElement.value = firstName;
      lastNameInputElement.value = lastName;
      ageInputElement.value = age;
      storyTitleInputElement.value = title;
      genreSelectElement.value = genre;
      storyTextareaElement.value = story;

      saveButton.setAttribute('disabled', 'disabled');
      editButton.setAttribute('disabled', 'disabled');
      deleteButton.setAttribute('disabled', 'disabled');
      publishButton.disabled = false;

      ulPreviewListElement.removeChild(liStoryInfoElement);
    }

    saveButton.addEventListener('click', saveStory);

    function saveStory() {
      divMainElement.removeChild(divMainElement.children[1]);
      divMainElement.removeChild(divMainElement.children[0]);

      const h1Element = document.createElement('h1');
      h1Element.textContent = 'Your scary story is saved!';

      divMainElement.appendChild(h1Element);
    }

    deleteButton.addEventListener('click', deleteStory);

    function deleteStory() {
      ulPreviewListElement.removeChild(liStoryInfoElement);
      publishButton.disabled = false;
    }
  }
}
