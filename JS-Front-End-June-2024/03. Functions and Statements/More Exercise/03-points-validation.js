function pointsValidation(points) {
    const x1 = points[0];
    const y1 = points[1];
    const x2 = points[2];
    const y2 = points[3];

    const isValidDistanceBetweenPointAndStart = (a, b) => Number.isInteger(Math.sqrt(a ** 2 + b ** 2));
    const isValidDistanceBetweenPoints = (a, b, c, d) => Number.isInteger(Math.sqrt((c - a) ** 2 + (d - b) ** 2));
    
    const printMessageWhenComparedToStart = (a, b) => isValidDistanceBetweenPointAndStart(a, b) 
                                                    ? console.log(`{${a}, ${b}} to {0, 0} is valid`)
                                                    : console.log(`{${a}, ${b}} to {0, 0} is invalid`);
    const printMessageWhenComparedTwoPoints = (a, b, c, d) => isValidDistanceBetweenPoints(a, b, c, d)
                                                            ? console.log(`{${a}, ${b}} to {${c}, ${d}} is valid`)
                                                            : console.log(`{${a}, ${b}} to {${c}, ${d}} is invalid`);

    printMessageWhenComparedToStart(x1, y1);
    printMessageWhenComparedToStart(x2, y2);
    printMessageWhenComparedTwoPoints(x1, y1, x2, y2);
}

pointsValidation([3, 0, 0, 4]);
pointsValidation([2, 1, 1, 1]);