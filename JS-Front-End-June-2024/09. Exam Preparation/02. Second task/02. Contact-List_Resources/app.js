window.addEventListener("load", solve);

function solve() {
  const addButton = document.getElementById('add-btn');
  const ulCheckList = document.getElementById('check-list');
  const ulContactList = document.getElementById('contact-list');
  
  addButton.addEventListener('click', onAdd);
  
  function onAdd() {
    const nameInputElement = document.getElementById('name');
    const phoneInputElement = document.getElementById('phone');
    const categoryInputElement = document.getElementById('category');
    
    if (nameInputElement.value === '' || phoneInputElement.value === '' || categoryInputElement.value === '') {
      return;
    }
    
    const liCheckListElement = document.createElement('li');
    
    const articleElement = document.createElement('article');
    
    const pNameElement = document.createElement('p');
    pNameElement.textContent = `name:${nameInputElement.value}`;
    const name = nameInputElement.value;
    
    const pPhoneElement = document.createElement('p');
    pPhoneElement.textContent = `phone:${phoneInputElement.value}`;
    const phone = phoneInputElement.value;
    
    const pCategoryElement = document.createElement('p');
    pCategoryElement.textContent = `category:${categoryInputElement.value}`;
    const category = categoryInputElement.value;
    
    const divElement = document.createElement('div');
    divElement.classList.add('buttons');
    
    const editButton = document.createElement('button');
    editButton.classList.add('edit-btn');
    
    const saveButton = document.createElement('button');
    saveButton.classList.add('save-btn');
    
    articleElement.appendChild(pNameElement);
    articleElement.appendChild(pPhoneElement);
    articleElement.appendChild(pCategoryElement);
    
    divElement.appendChild(editButton);
    divElement.appendChild(saveButton);
    
    liCheckListElement.appendChild(articleElement);
    liCheckListElement.appendChild(divElement);
    
    ulCheckList.appendChild(liCheckListElement);
    
    const formElement = document.querySelector('form');
    formElement.reset();
    
    editButton.addEventListener('click', edit);
    
    function edit() {
      nameInputElement.value = name;
      phoneInputElement.value = phone;
      categoryInputElement.value = category;
      
      ulCheckList.removeChild(liCheckListElement);
    }
    
    saveButton.addEventListener('click', save);
    
    function save() {
      const liContactList = document.createElement('li');
      const deleteButton = document.createElement('button');
      deleteButton.classList.add('del-btn');
      
      liContactList.appendChild(articleElement);
      liContactList.appendChild(deleteButton);
      
      ulContactList.appendChild(liContactList);
      
      ulCheckList.removeChild(liCheckListElement);
      
      deleteButton.addEventListener('click', onDelete);
      
      function onDelete() {
        ulContactList.removeChild(liContactList);
      }
    }
  }
}