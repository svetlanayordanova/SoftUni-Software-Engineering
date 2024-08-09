function reverse(n, numbers) {
    const arr = [];

    for (let i = 0; i < n; i++) {
        arr.push(numbers[i]);
    }

    arr.reverse();

    console.log(arr.join(' '));
}

reverse(3, [10, 20, 30, 40, 50]);
reverse(4, [-1, 20, 99, 5]);
reverse(2, [66, 43, 75, 89, 47]);