window.addEventListener("load", solve);

function solve() {
  const adoptButton = document.getElementById('adopt-btn');
  const ulAdoptionInfoElement = document.getElementById('adoption-info');
  const ulAdoptedListElement = document.getElementById('adopted-list');
  
  adoptButton.addEventListener('click', adopt);

  function adopt(e) {
    e.preventDefault();
        
    const typeElement = document.querySelector('input[type=text]');
    const ageElement = document.querySelector('input[type=number]');
    const genderElement = document.querySelector('select#gender');

    if (typeElement.value === '' || ageElement.value === '' || genderElement.value === '') {
      return;
    }

    const liAdoptionInfoElement = document.createElement('li');

    const articleElement = document.createElement('article');

    const typeAnimalPElement = document.createElement('p');
    typeAnimalPElement.textContent = `Pet:${typeElement.value}`;
    const type = typeElement.value;
    articleElement.appendChild(typeAnimalPElement);

    const genderPElement = document.createElement('p');
    genderPElement.textContent = `Gender:${genderElement.value}`;
    const gender = genderElement.value;
    articleElement.appendChild(genderPElement);

    const agePElement = document.createElement('p');
    agePElement.textContent = `Age:${ageElement.value}`;
    const age = ageElement.value;
    articleElement.appendChild(agePElement);
    
    const divElement = document.createElement('div');
    divElement.classList.add('buttons');

    const editButtonElement = document.createElement('button');
    editButtonElement.classList.add('edit-btn');
    editButtonElement.textContent = 'Edit';

    const doneButtonElement = document.createElement('button'); 
    doneButtonElement.classList.add('done-btn');
    doneButtonElement.textContent = 'Done';

    divElement.appendChild(editButtonElement);
    divElement.appendChild(doneButtonElement);
    
    liAdoptionInfoElement.appendChild(articleElement);
    liAdoptionInfoElement.appendChild(divElement);
    
    ulAdoptionInfoElement.appendChild(liAdoptionInfoElement);

    typeElement.value = '';
    ageElement.value = '';
    genderElement.value = '';
    
    const editButton = document.querySelector('button.edit-btn');
    editButton.addEventListener('click', edit);

    function edit() {
      typeElement.value = type;
      ageElement.value = age;
      genderElement.value = gender;    
      
      ulAdoptionInfoElement.removeChild(liAdoptionInfoElement);
    }

    const doneButton = document.querySelector('button.done-btn');
    doneButton.addEventListener('click', onDone);

    function onDone() {
      const liAdoptedListElement = document.createElement('li');
      const clearButton = document.createElement('button');
      clearButton.classList.add('clear-btn');
      clearButton.textContent = 'Clear';

      liAdoptedListElement.appendChild(articleElement);
      liAdoptedListElement.appendChild(clearButton);

      ulAdoptedListElement.appendChild(liAdoptedListElement);

      ulAdoptionInfoElement.removeChild(liAdoptionInfoElement);

      clearButton.addEventListener('click', clear);

      function clear() {
        ulAdoptedListElement.removeChild(liAdoptedListElement);
      }
    }
  }
}
