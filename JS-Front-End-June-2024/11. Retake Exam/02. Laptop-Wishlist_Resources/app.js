window.addEventListener("load", solve);

function solve() {
  const modelInputElement = document.getElementById('laptop-model');
  const storageInputElement = document.getElementById('storage');
  const priceInputElement = document.getElementById('price');

  const ulCheckList = document.getElementById('check-list');
  const ulLaptopsList = document.getElementById('laptops-list');

  const addButton = document.getElementById('add-btn');
  const clearButton = document.querySelector('.btn.clear');

  addButton.addEventListener('click', () => {
    if (modelInputElement.value === '' || storageInputElement.value === '' || priceInputElement.value === '') {
      return;
    }

    const liElement = document.createElement('li');
    liElement.classList.add('laptop-item');

    const articleElement = document.createElement('article');

    const pModelElement = document.createElement('p');
    pModelElement.textContent = modelInputElement.value;
    const model = modelInputElement.value;

    const pStorageElement = document.createElement('p');
    pStorageElement.textContent = `Memory: ${storageInputElement.value} TB`;
    const storage = storageInputElement.value;

    const pPriceElement = document.createElement('p');
    pPriceElement.textContent = `Price: ${priceInputElement.value}$`;
    const price = priceInputElement.value;

    const editButton = document.createElement('button');
    editButton.classList.add('btn');
    editButton.classList.add('edit');
    editButton.textContent = 'edit';
    editButton.addEventListener('click', () => {
        modelInputElement.value = model;
        storageInputElement.value = storage;
        priceInputElement.value = price;
        liElement.remove();
        addButton.removeAttribute('disabled');
    });

    const okButton = document.createElement('button');
    okButton.classList.add('btn');
    okButton.classList.add('ok');
    okButton.textContent = 'ok';
    okButton.addEventListener('click', () => {
        ulLaptopsList.appendChild(liElement);
        editButton.remove();
        okButton.remove();
        addButton.removeAttribute('disabled');
    });

    articleElement.appendChild(pModelElement);
    articleElement.appendChild(pStorageElement);
    articleElement.appendChild(pPriceElement);

    liElement.appendChild(articleElement);
    liElement.appendChild(editButton);
    liElement.appendChild(okButton);

    ulCheckList.appendChild(liElement);

    clearInputFields();

    addButton.setAttribute('disabled', 'disabled');
  });

  clearButton.addEventListener('click', () => {
    location.reload();
  });

  function clearInputFields() {
    modelInputElement.value = '';
    storageInputElement.value = '';
    priceInputElement.value = '';
  }
}