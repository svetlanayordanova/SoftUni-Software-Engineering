function meetings(inputArray) {
    const meetings = {};

    for (const entry of inputArray) {
        const [weekday, personsName] = entry.split(' ');

        if (!meetings.hasOwnProperty(weekday)) {
            meetings[weekday] = personsName;
            console.log(`Scheduled for ${weekday}`);
        } else {
            console.log(`Conflict on ${weekday}!`);
        }
    }

    Object
        .keys(meetings)
        .forEach(key => console.log(`${key} -> ${meetings[key]}`));
}

meetings(['Monday Peter', 'Wednesday Bill', 'Monday Tim', 'Friday Tim']);
meetings(['Friday Bob', 'Saturday Ted', 'Monday Bill', 'Monday John', 'Wednesday George']);