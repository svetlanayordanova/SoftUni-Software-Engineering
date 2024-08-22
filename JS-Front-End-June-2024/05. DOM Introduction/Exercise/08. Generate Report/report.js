function generateReport() {
    const tableHeadElements = document.querySelectorAll('table thead th');
    const tableRowElements = document.querySelectorAll('table tbody tr');
    const textareaElement = document.getElementById('output');

    const columns = [];

    for (let tableHeadElement of tableHeadElements) {
        const checkBox = tableHeadElement.querySelector('input[type=checkbox]');
        columns.push({
            name: tableHeadElement.textContent.toLowerCase().trim(),
            active: checkBox.checked,
        });
    }

    const rows = [];

    for (const tableRowElement of tableRowElements) {
        const tableData = tableRowElement.querySelectorAll('td');
        const row = {};
        for (let i = 0; i < tableData.length; i++) {
            if (columns[i].active) {
                row[columns[i].name] = tableData[i].textContent;
            }
        }

        rows.push(row);
    }

    textareaElement.value = JSON.stringify(rows, null, 2);
}