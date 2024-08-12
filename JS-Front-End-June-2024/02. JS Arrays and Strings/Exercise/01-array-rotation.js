function arrayRotation(array, countRotations) {    
    for (let i = 0; i < countRotations; i++) {
        array.push(array.shift());
    }

    const result = array.join(' ');

    console.log(result);
}

arrayRotation([51, 47, 32, 61, 21], 2);
arrayRotation([32, 21, 61, 1], 4);
arrayRotation([2, 4, 15, 31], 5);