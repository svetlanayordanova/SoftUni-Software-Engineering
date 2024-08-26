function attachEventsListeners() {
    const buttonElement = document.querySelector('input[type=button]');
    const inputElement = document.querySelector('div:first-of-type input[type=text]');
    const outputElement = document.querySelector('div:last-of-type input[type=text]');

    let numberFromInputInM = 0;
    let numberToOutput = 0;

    buttonElement.addEventListener('click', (e) => {
        const inputOptionElement = document.querySelector('#inputUnits').value;

        switch(inputOptionElement) {
            case 'km':
                numberFromInputInM = inputElement.value * 1000;
                break;
            case 'm':
                numberFromInputInM = inputElement.value;
                break;
            case 'cm':
                numberFromInputInM = inputElement.value * 0.01;
                break;
            case 'mm':
                numberFromInputInM = inputElement.value * 0.001;
                break;
            case 'mi':
                numberFromInputInM = inputElement.value * 1609.34;
                break;
            case 'yrd':
                numberFromInputInM = inputElement.value * 0.9144;
                break;
            case 'ft':
                numberFromInputInM = inputElement.value * 0.3048;
                break;
            case 'in':
                numberFromInputInM = inputElement.value * 0.0254;
                break;
        }

        const outputOptionElement = document.querySelector('#outputUnits').value;

        switch(outputOptionElement) {
            case 'km':
                numberToOutput = numberFromInputInM / 1000;
                break;
            case 'm':
                numberToOutput = numberFromInputInM;
                break;
            case 'cm':
                numberToOutput = numberFromInputInM / 0.01;
                break;
            case 'mm':
                numberToOutput = numberFromInputInM / 0.001;
                break;
            case 'mi':
                numberToOutput = numberFromInputInM / 1609.34;
                break;
            case 'yrd':
                numberToOutput = numberFromInputInM / 0.9144;
                break;
            case 'ft':
                numberToOutput = numberFromInputInM / 0.3048;
                break;
            case 'in':
                numberToOutput = numberFromInputInM / 0.0254;
                break;
        }

        outputElement.disabled = false;
        outputElement.value = numberToOutput;
    });
}