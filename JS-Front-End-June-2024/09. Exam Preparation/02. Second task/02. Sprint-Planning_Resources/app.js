window.addEventListener('load', solve);

function solve() {
    const createTaskButton = document.getElementById('create-task-btn');
    const deleteTaskButton = document.getElementById('delete-task-btn');
    const sectionTasksSectionElement = document.getElementById('tasks-section');
    const pTotalSprintPointsElement = document.getElementById('total-sprint-points');
    const formElement = document.querySelector('form');
    const hiddenInputElement = document.getElementById('task-id');
    
    let totalPoints = 0;
    let taskId = 0;
    
    createTaskButton.addEventListener('click', createTask);
    
    function createTask() {
        const titleInputElement = document.getElementById('title');
        const descriptionTextareaElement = document.getElementById('description');
        const labelSelectElement = document.getElementById('label');
        const pointsInputElement = document.getElementById('points');
        const assigneeInputElement = document.getElementById('assignee');
        
        if (titleInputElement.value === '' || descriptionTextareaElement.value === '' ||
            labelSelectElement.value === '' || pointsInputElement.value === '' || assigneeInputElement.value === '') {
            return;
        }
            
        taskId++;
        totalPoints += Number(pointsInputElement.value);
            
        pTotalSprintPointsElement.textContent = `Total Points ${totalPoints}pts`;
            
        const articleElement = document.createElement('article');
        articleElement.setAttribute('id', `task-${taskId}`);
        articleElement.classList.add('task-card');
            
        const divLabelElement = document.createElement('div');
        divLabelElement.classList.add('task-card-label');
            
        if (labelSelectElement.value === 'Feature') {
            divLabelElement.classList.add('feature');
            const featureIcon = document.createElement('i');
            featureIcon.innerHTML = '&#8865;';
            divLabelElement.textContent = 'Feature ';
            divLabelElement.appendChild(featureIcon);
        } else if (labelSelectElement.value === 'Low Priority Bug') {
            divLabelElement.classList.add('low-priority');
            const lowPriorityIcon = document.createElement('i');
            lowPriorityIcon.innerHTML = '&#9737;';
            divLabelElement.textContent = 'Low Priority Bug ';
            divLabelElement.appendChild(lowPriorityIcon);
        } else if (labelSelectElement.value === 'High Priority Bug') {
            divLabelElement.classList.add('high-priority');
            const highPriorityIcon = document.createElement('i');
            highPriorityIcon.innerHTML = '&#9888;';
            divLabelElement.textContent = 'High Priority Bug ';
            divLabelElement.appendChild(highPriorityIcon);
        }
            
        const label = labelSelectElement.value;
            
        const h3TittleElement = document.createElement('h3');
        h3TittleElement.classList.add('task-card-title');
        h3TittleElement.textContent = `${titleInputElement.value}`;
        const title = titleInputElement.value;
            
        const pDescriptionElement = document.createElement('p');
        pDescriptionElement.classList.add('task-card-description');
        pDescriptionElement.textContent = `${descriptionTextareaElement.value}`;
        const description = descriptionTextareaElement.value;
            
        const divPointsElement = document.createElement('div');
        divPointsElement.classList.add('task-card-points');
        divPointsElement.textContent = `Estimated at ${pointsInputElement.value} pts`;
        const points = pointsInputElement.value;
            
        const divAssigneeElement = document.createElement('div');
        divAssigneeElement.classList.add('task-card-assignee');
        divAssigneeElement.textContent = `Assigned to: ${assigneeInputElement.value}`;
        const assignee = assigneeInputElement.value;
            
        const divActionsElement = document.createElement('div');
        divActionsElement.classList.add('task-card-actions');
            
        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete';
            
        divActionsElement.appendChild(deleteButton);
            
        articleElement.appendChild(divLabelElement);
        articleElement.appendChild(h3TittleElement);
        articleElement.appendChild(pDescriptionElement);
        articleElement.appendChild(divPointsElement);
        articleElement.appendChild(divAssigneeElement);
        articleElement.appendChild(divActionsElement);
            
        sectionTasksSectionElement.appendChild(articleElement);
            
        formElement.reset();
            
        deleteButton.addEventListener('click', onDelete);
            
        function onDelete(e) {
            titleInputElement.value = title;
            descriptionTextareaElement.value = description;
            labelSelectElement.value = label;
            pointsInputElement.value = points;
            assigneeInputElement.value = assignee;

            const currentId = e.currentTarget.parentNode.parentNode.id;
            hiddenInputElement.value = currentId;
                
            deleteTaskButton.disabled = false;
            createTaskButton.setAttribute('disabled', 'disabled');
                
            titleInputElement.setAttribute('disabled', 'disabled');
            descriptionTextareaElement.setAttribute('disabled', 'disabled');
            labelSelectElement.setAttribute('disabled', 'disabled');
            pointsInputElement.setAttribute('disabled', 'disabled');
            assigneeInputElement.setAttribute('disabled', 'disabled');
                            
            deleteTaskButton.addEventListener('click', deleteTask);
                
            function deleteTask() {
                const articleToDelete = document.getElementById(currentId);
                sectionTasksSectionElement.removeChild(articleToDelete);
                    
                const pointsToSubtract = pointsInputElement.value;
                totalPoints -= Number(pointsToSubtract);
                pTotalSprintPointsElement.textContent = `Total Points ${totalPoints}pts`;
                    
                formElement.reset();
                    
                titleInputElement.disabled = false;
                descriptionTextareaElement.disabled = false;
                labelSelectElement.disabled = false;
                pointsInputElement.disabled = false;
                assigneeInputElement.disabled = false;
                    
                createTaskButton.disabled = false;
                deleteTaskButton.disabled = true;
            }
        }        
    }
}