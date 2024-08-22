function search() {
   const liElements = document.querySelectorAll('#towns li');
   const searchedElement = document.getElementById('searchText');
   const resultElement = document.getElementById('result');
   
   const searchedElementValue = searchedElement.value;
   
   const towns = Array.from(liElements);
   
   function clearPreviousState() {
      for (let currentTown of towns) {
         currentTown.style.fontWeight = 'normal';
         currentTown.style.textDecoration = 'none';
      }
   }

   clearPreviousState();
   
   let matches = 0;
   
   for (let currentTown of towns) {
      if (currentTown.textContent.includes(searchedElementValue)) {
         currentTown.style.fontWeight = 'bold';
         currentTown.style.textDecoration = 'underline';
         matches++;
      }
   }
   
   resultElement.textContent = `${matches} matches found`;
}