function create(words) {
   const contentDivElement = document.getElementById('content');

   words.forEach(word => {
      const divElement = document.createElement('div');
      const pElement = document.createElement('p');

      pElement.textContent = word;
      pElement.style.display = 'none';

      contentDivElement.appendChild(divElement);
      divElement.appendChild(pElement);
   });

   const allDivElements = document.querySelectorAll('#content div');

   allDivElements.forEach(divElement => {
      divElement.addEventListener('click', (e) => {
         divElement.children[0].style.display = 'block';
      });
   });
}