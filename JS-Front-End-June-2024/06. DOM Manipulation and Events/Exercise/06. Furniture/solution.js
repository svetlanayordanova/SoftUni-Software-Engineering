function solve() {
  const [inputTextarea, outputTextarea] = document.querySelectorAll('#container #exercise textarea');
  const generateButton = document.querySelector('#container #exercise button:nth-of-type(1)');
  const buyButton = document.querySelector('#container #exercise button:nth-of-type(2)');
  const tbodyElement = document.querySelector('.wrapper table tbody');
    
  generateButton.addEventListener('click', (e) => {
    const inputData = JSON.parse(inputTextarea.value);

    inputData.forEach(element => {
      const imgSource = element.img;
      const nameContent = element.name;
      const priceContent = element.price;
      const decFactorContent = element.decFactor;

      const imgElement = document.createElement('img');
      imgElement.src = imgSource;
      const imgTdElement = document.createElement('td');
      imgTdElement.appendChild(imgElement);
      const nameElement = document.createElement('p');
      nameElement.textContent = nameContent;
      const nameTdElement = document.createElement('td');
      nameTdElement.appendChild(nameElement);
      const priceElement = document.createElement('p');
      priceElement.textContent = priceContent;
      const priceTdElement = document.createElement('td');
      priceTdElement.appendChild(priceElement);
      const decFactorElement = document.createElement('p');
      decFactorElement.textContent = decFactorContent;
      const decFactorTdElement = document.createElement('td');
      decFactorTdElement.appendChild(decFactorElement);
      const checkboxElement = document.createElement('input')
      checkboxElement.setAttribute('type', 'checkbox');
      const checkboxTdElement = document.createElement('td');
      checkboxTdElement.appendChild(checkboxElement);
      const trElement = document.createElement('tr');
      trElement.appendChild(imgTdElement);
      trElement.appendChild(nameTdElement);
      trElement.appendChild(priceTdElement);
      trElement.appendChild(decFactorTdElement);
      trElement.appendChild(checkboxTdElement);
      tbodyElement.appendChild(trElement);
    });
  });

  const allCheckboxes = document.querySelectorAll('table tbody tr td input[type=checkbox]');
  allCheckboxes.forEach(checkbox => checkbox.disabled = false);
  
  buyButton.addEventListener('click', (e) => {
    let furniture = [];
    let totalPrice = 0;
    let totalDecFactor = 0;
    
    const trElements = document.querySelectorAll('.wrapper table tbody tr');

    trElements.forEach(trElement => {
      const checkbox = trElement.querySelector('input[type=checkbox]');
      if (checkbox.checked) {
        const name = trElement.querySelector('td:nth-child(2) p').textContent;
        const price = Number(trElement.querySelector('td:nth-child(3) p').textContent);
        const decFactor = Number(trElement.querySelector('td:nth-child(4) p').textContent);
        furniture.push(name);
        totalPrice += price;
        totalDecFactor += decFactor;
      }
    });

      outputTextarea.textContent += `Bought furniture: ${furniture.join(', ')}\n`;
      outputTextarea.textContent += `Total price: ${totalPrice.toFixed(2)}\n`;
      outputTextarea.textContent += `Average decoration factor: ${totalDecFactor / furniture.length}`;
    });
}