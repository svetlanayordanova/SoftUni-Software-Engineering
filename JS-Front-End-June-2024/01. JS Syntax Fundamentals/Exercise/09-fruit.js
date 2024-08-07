function calculatePrice(fruit, weightInGrams, pricePerKg) {
    const weightInKg = weightInGrams / 1000;

    const totalPrice = weightInKg * pricePerKg;

    console.log(`I need $${totalPrice.toFixed(2)} to buy ${weightInKg.toFixed(2)} kilograms ${fruit}.`)
}

calculatePrice('apple', 1563, 2.35);