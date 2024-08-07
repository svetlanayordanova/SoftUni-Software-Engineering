function calculatePrice(people, type, day) {
    let price;

    switch (type) {
        case 'Students':
            if (day === 'Friday') {
                price = people * 8.45;
            } else if (day === 'Saturday') {
                price = people * 9.80;
            } else if (day === 'Sunday') {
                price = people * 10.46;
            }

            if (people >= 30) {
                price = price - 0.15 * price;
            }
        break;
        case 'Business':
            if (day === 'Friday') {
                if (people >= 100) {
                    price = (people - 10) * 10.90;
                } else {
                    price = people * 10.90;
                }
            } else if (day === 'Saturday') {
                if (people >= 100) {
                    price = (people - 10) * 15.60;
                } else {
                    price = people * 15.60;
                }
            } else if (day === 'Sunday') {
                if (people >= 100) {
                    price = (people - 10) * 16;
                } else {
                    price = people * 16;
                }
            }
        break;
        case 'Regular':
            if (day === 'Friday') {
                price = people * 15;
            } else if (day === 'Saturday') {
                price = people * 20;
            } else if (day === 'Sunday') {
                price = people * 22.50;
            }

            if (people >= 10 && people <= 20) {
                price = price - 0.05 * price;
            }
        break;
    }

    console.log(`Total price: ${price.toFixed(2)}`);
}

calculatePrice(40, "Regular", "Saturday");