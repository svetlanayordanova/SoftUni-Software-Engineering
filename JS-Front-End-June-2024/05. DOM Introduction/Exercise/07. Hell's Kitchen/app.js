function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function onClick () {
      const textareaElement = document.querySelector('#inputs textarea');
      const bestRestaurantElement = document.querySelector('#outputs #bestRestaurant p');
      const bestRestaurantWorkersElement = document.querySelector('#outputs #workers p');

      const textareaElementArray = JSON.parse(textareaElement.value);

      const restaurants = {};

      for (const restaurantData of textareaElementArray) {
         const [restaurantName, workersData] = restaurantData.split(' - ');

         if (!restaurants[restaurantName]) {
            restaurants[restaurantName] = [];
         }

         const workersNamesAndSalaries = workersData.split(', ');

         for (const currentElement of workersNamesAndSalaries) {
            const [workerName, workerSalary] = currentElement.split(' ');
            restaurants[restaurantName].push({
               workerName,
               workerSalary: Number(workerSalary),
            });
         }
      }

      let bestRestaurantName = '';
      let bestAverageSalary = 0;

      for (const restaurantName in restaurants) {
         const workers = restaurants[restaurantName];
         let totalSalary = 0;
         for (let i = 0; i < workers.length; i++) {
            totalSalary += workers[i].workerSalary;
         }

         const currentAverageSalary = totalSalary / workers.length;

         if (currentAverageSalary > bestAverageSalary) {
            bestAverageSalary = currentAverageSalary;
            bestRestaurantName = restaurantName;
         }
     }

      const bestRestaurantWorkers = restaurants[bestRestaurantName].sort((a, b) => b.workerSalary - a.workerSalary);
      let bestRestaurantTotalSalary = 0;
      for (let i = 0; i < bestRestaurantWorkers.length; i++) {
          bestRestaurantTotalSalary += bestRestaurantWorkers[i].workerSalary;
      }
      const bestRestaurantAverageSalary = (bestRestaurantTotalSalary / bestRestaurantWorkers.length).toFixed(2);
      const bestSalary = (bestRestaurantWorkers[0].workerSalary).toFixed(2);
      const bestWorkers = bestRestaurantWorkers.map(worker => `Name: ${worker.workerName} With Salary: ${worker.workerSalary}`).join(' ');

      bestRestaurantElement.textContent = `Name: ${bestRestaurantName} Average Salary: ${bestRestaurantAverageSalary} Best Salary: ${bestSalary}`;
      bestRestaurantWorkersElement.textContent = bestWorkers;
   }
}