function calculateTotalPrice(product, quantity) {
    function getOnePiecePrice(product) {
        let price = 0;

        switch(product) {
            case 'coffee':
                price = 1.50;
            break;
            case 'water':
                price = 1.00;
            break;
            case 'coke':
                price = 1.40;
            break;
            case 'snacks':
                price = 2.00;
            break;
        }

        return price;
    };

    const totalPrice = getOnePiecePrice(product) * quantity;

    console.log(totalPrice.toFixed(2));
}

calculateTotalPrice("water", 5);
calculateTotalPrice("coffee", 2)