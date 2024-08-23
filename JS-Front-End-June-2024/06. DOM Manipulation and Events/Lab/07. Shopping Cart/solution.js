function solve() {
   const allProductsElements = document.querySelectorAll('.product');
   const textareaElement = document.querySelector('textarea');
   const checkoutButtonElement = document.querySelector('.checkout');
   const allButtonsElements = document.querySelectorAll('button');

   const products = [];
   let totalPrice = 0;

   for (const currentProduct of allProductsElements) {
      const addButton = currentProduct.querySelector('.add-product');
      const name = currentProduct.querySelector('.product-title').textContent;
      const price = Number(currentProduct.querySelector('.product-line-price').textContent);

      addButton.addEventListener('click', (e) => {
         textareaElement.value += `Added ${name} for ${price.toFixed(2)} to the cart.\n`;
         products.push(name);
         totalPrice += price;
      });
   }

   checkoutButtonElement.addEventListener('click', (e) => {
      const productList = Array.from(new Set(products));
      textareaElement.value += `You bought ${productList.join(', ')} for ${totalPrice.toFixed(2)}.`

      allButtonsElements.forEach(button => button.setAttribute('disabled', 'disabled'));
   });
}