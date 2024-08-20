function schoolRegister(inputArray) {
    let schoolRegister = [];

    for (const element of inputArray) {
        const currentElement = element.split(', ');
        const name = currentElement[0].split('Student name: ').join('');
        const grade = Number(currentElement[1].split('Grade: ').join(''));
        const averageScore = Number(currentElement[2].split('Graduated with an average score: ').join(''));

        if (averageScore >= 3) {
            const student = {
                grade: grade + 1,
                name,
                averageScore,
            }

            schoolRegister.push(student);
        }
    }

    schoolRegister.sort((a, b) => a.grade - b.grade);

    for (let i = 1; i <= 12; i++) {
        const currentGrade = schoolRegister.filter(student => student.grade === i);
        const currentNames = [];
        let totalScore = 0;

        for (const currentStudent of currentGrade) {
            currentNames.push(currentStudent.name);
            totalScore += currentStudent.averageScore;
        }

        const currentAverageScore = totalScore / currentNames.length;

        if (currentGrade.length > 0) {
            console.log(`${i} Grade`);
            console.log(`List of students: ${currentNames.join(', ')}`);
            console.log(`Average annual score from last year: ${currentAverageScore.toFixed(2)}`);
            console.log();
        }
    }
}

schoolRegister([
    "Student name: Mark, Grade: 8, Graduated with an average score: 4.75",
        "Student name: Ethan, Grade: 9, Graduated with an average score: 5.66",
        "Student name: George, Grade: 8, Graduated with an average score: 2.83",
        "Student name: Steven, Grade: 10, Graduated with an average score: 4.20",
        "Student name: Joey, Grade: 9, Graduated with an average score: 4.90",
        "Student name: Angus, Grade: 11, Graduated with an average score: 2.90",
        "Student name: Bob, Grade: 11, Graduated with an average score: 5.15",
        "Student name: Daryl, Grade: 8, Graduated with an average score: 5.95",
        "Student name: Bill, Grade: 9, Graduated with an average score: 6.00",
        "Student name: Philip, Grade: 10, Graduated with an average score: 5.05",
        "Student name: Peter, Grade: 11, Graduated with an average score: 4.88",
        "Student name: Gavin, Grade: 10, Graduated with an average score: 4.00"
    ]);
schoolRegister([
    'Student name: George, Grade: 5, Graduated with an average score: 2.75',
    'Student name: Alex, Grade: 9, Graduated with an average score: 3.66',
    'Student name: Peter, Grade: 8, Graduated with an average score: 2.83',
    'Student name: Boby, Grade: 5, Graduated with an average score: 4.20',
    'Student name: John, Grade: 9, Graduated with an average score: 2.90',
    'Student name: Steven, Grade: 2, Graduated with an average score: 4.90',
    'Student name: Darsy, Grade: 1, Graduated with an average score: 5.15'
    ]);