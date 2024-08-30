window.addEventListener("load", solve);

function solve() {
  const nextButton = document.getElementById('next-btn');
  const ulPreviewListElement = document.getElementById('preview-list');
  const ulCandidatesListElement = document.getElementById('candidates-list');
  
  nextButton.addEventListener('click', onNext);

  function onNext() {
    const studentInputElement = document.getElementById('student');
    const universityInputElement = document.getElementById('university');
    const scoreInputElement = document.getElementById('score');

    if (studentInputElement.value === '' || universityInputElement.value === '' || scoreInputElement.value === '') {
      return;
    }

    const liApplicationElement = document.createElement('li');
    liApplicationElement.classList.add('application');

    const articleElement = document.createElement('article');

    const h4StudentElement = document.createElement('h4');
    h4StudentElement.textContent = `${studentInputElement.value}`;
    const student = studentInputElement.value;

    const pUniversityElement = document.createElement('p');
    pUniversityElement.textContent = `University: ${universityInputElement.value}`;
    const university = universityInputElement.value;

    const pScoreElement = document.createElement('p');
    pScoreElement.textContent = `Score: ${scoreInputElement.value}`;
    const score = scoreInputElement.value;

    const editButton = document.createElement('button');
    editButton.classList.add('action-btn');
    editButton.classList.add('edit');
    editButton.textContent = 'edit';

    const applyButton = document.createElement('button');
    applyButton.classList.add('action-btn');
    applyButton.classList.add('apply');
    applyButton.textContent = 'apply';

    articleElement.appendChild(h4StudentElement);
    articleElement.appendChild(pUniversityElement);
    articleElement.appendChild(pScoreElement);

    liApplicationElement.appendChild(articleElement);
    liApplicationElement.appendChild(editButton);
    liApplicationElement.appendChild(applyButton);

    ulPreviewListElement.appendChild(liApplicationElement);

    const formElement = document.querySelector('form');
    formElement.reset();
    nextButton.setAttribute('disabled', 'disabled');

    editButton.addEventListener('click', edit);

    function edit() {
      studentInputElement.value = student;
      universityInputElement.value = university;
      scoreInputElement.value = score;

      ulPreviewListElement.removeChild(liApplicationElement);

      nextButton.disabled = false;
    }

    applyButton.addEventListener('click', apply);

    function apply() {
      const clonedLiElement = liApplicationElement.cloneNode(true);
      ulPreviewListElement.removeChild(liApplicationElement);

      clonedLiElement.removeChild(clonedLiElement.children[2]);
      clonedLiElement.removeChild(clonedLiElement.children[1]);

      ulCandidatesListElement.appendChild(clonedLiElement);
      nextButton.disabled = false;
    }
  }
} 