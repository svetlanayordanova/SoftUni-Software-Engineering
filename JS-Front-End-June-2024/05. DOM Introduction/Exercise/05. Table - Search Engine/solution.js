function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      const tableElements = document.querySelectorAll('tbody tr td');
      const searchedElementValue = document.getElementById('searchField').value;

      const tableElementsArray = Array.from(tableElements);

      function clearPreviousState() {
         for (const currentElement of tableElementsArray) {
            currentElement.parentElement.classList.remove('select');
         }
      }

      clearPreviousState();

      for (const currentElement of tableElementsArray) {
         if (currentElement.textContent.includes(searchedElementValue)) {
            currentElement.parentElement.classList.add('select');
         }
      }
   }
}