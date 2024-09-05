function sprintReview(inputArray) {
    const n = Number(inputArray[0]);
    
    const assigneesData = inputArray.slice(1, n + 1);
    const commands = inputArray.slice(n + 1);
    
    const assignees = [];
    
    assigneesData.forEach(assigneeData => {
        const [assigneeName, taskId, title, status, estimatedPoints] = assigneeData.split(':');
        
        const currentAssignee = findAssignee(assigneeName);
        
        if (!currentAssignee) {
            const assignee = {
                assigneeName,
                tasks: [{
                    taskId,
                    title,
                    status,
                    estimatedPoints: Number(estimatedPoints),
                }],         
            }
            assignees.push(assignee);
        } else {
            const task = {
                taskId,
                title,
                status,
                estimatedPoints: Number(estimatedPoints),
            }
            currentAssignee.tasks.push(task);
        }
    });
    
    commands.forEach(command => {
        const [commandName, assigneeName, ...rest] = command.split(':');
        const currentAssignee = findAssignee(assigneeName);
        
        switch(commandName) {
            case 'Add New':
            const taskId = rest[0];
            const title = rest[1];
            const status = rest[2];
            const estimatedPoints = rest[3];
            
            if (currentAssignee) {
                const task = {
                    taskId,
                    title,
                    status,
                    estimatedPoints: Number(estimatedPoints),
                }
                currentAssignee.tasks.push(task);
            } else {
                console.log(`Assignee ${assigneeName} does not exist on the board!`);
            }
            break;
            case 'Change Status':
            const idTask = rest[0];
            const newStatus = rest[1];
            
            if (currentAssignee) {
                const taskWithCurrentId = currentAssignee.tasks.find(task => task.taskId === idTask);
                
                if (taskWithCurrentId) {
                    taskWithCurrentId.status = newStatus;
                } else {
                    console.log(`Task with ID ${idTask} does not exist for ${assigneeName}!`);
                }
            } else {
                console.log(`Assignee ${assigneeName} does not exist on the board!`);
            }
            break;
            case 'Remove Task':
            const index = Number(rest[0]);
            
            if (currentAssignee) {
                const currentAssigneeTasks = currentAssignee.tasks;
                
                if (index >= 0 && index < currentAssigneeTasks.length) {
                    currentAssigneeTasks.splice(index, 1);
                } else {
                    console.log(`Index is out of range!`);
                }
            } else {
                console.log(`Assignee ${assigneeName} does not exist on the board!`);
            }
            break;
        }
    });
    
    let toDoTasksTotalPoints = 0;
    let inProgressTasksTotalPoints = 0;
    let codeReviewTasksTotalPoints = 0;
    let doneTasksTotalPoints = 0;
    
    assignees.forEach(assignee => {
        assignee.tasks.forEach(task => {
            if (task.status === 'ToDo') {
                toDoTasksTotalPoints += task.estimatedPoints;
            } else if (task.status === 'In Progress') {
                inProgressTasksTotalPoints += task.estimatedPoints;
            } else if (task.status === 'Code Review') {
                codeReviewTasksTotalPoints += task.estimatedPoints;
            } else if (task.status === 'Done') {
                doneTasksTotalPoints += task.estimatedPoints;
            }
        });
    });
    
    console.log(`ToDo: ${toDoTasksTotalPoints}pts`);
    console.log(`In Progress: ${inProgressTasksTotalPoints}pts`);
    console.log(`Code Review: ${codeReviewTasksTotalPoints}pts`);
    console.log(`Done Points: ${doneTasksTotalPoints}pts`);
    
    if (doneTasksTotalPoints >= toDoTasksTotalPoints + inProgressTasksTotalPoints + codeReviewTasksTotalPoints) {
        console.log('Sprint was successful!');
    } else {
        console.log('Sprint was unsuccessful...')
    }
    
    function findAssignee(assigneeName) {
        return assignees.find(assignee => assignee.assigneeName === assigneeName);
    }
}

sprintReview([
    '5',
    'Kiril:BOP-1209:Fix Minor Bug:ToDo:3',
    'Mariya:BOP-1210:Fix Major Bug:In Progress:3',
    'Peter:BOP-1211:POC:Code Review:5',
    'Georgi:BOP-1212:Investigation Task:Done:2',
    'Mariya:BOP-1213:New Account Page:In Progress:13',
    'Add New:Kiril:BOP-1217:Add Info Page:In Progress:5',
    'Change Status:Peter:BOP-1290:ToDo',
    'Remove Task:Mariya:1',
    'Remove Task:Joro:1',
]);
sprintReview([
    '4',
    'Kiril:BOP-1213:Fix Typo:Done:1',
    'Peter:BOP-1214:New Products Page:In Progress:2',
    'Mariya:BOP-1215:Setup Routing:ToDo:8',
    'Georgi:BOP-1216:Add Business Card:Code Review:3',
    'Add New:Sam:BOP-1237:Testing Home Page:Done:3',
    'Change Status:Georgi:BOP-1216:Done',
    'Change Status:Will:BOP-1212:In Progress',
    'Remove Task:Georgi:3',
    'Change Status:Mariya:BOP-1215:Done',
]);