function attachEventsListeners() {
    const allDivElements = document.querySelectorAll('div');
    const daysInputElement = document.getElementById('days');
    const hoursInputElement = document.getElementById('hours');
    const minutesInputElement = document.getElementById('minutes');
    const secondsInputElement = document.getElementById('seconds');

    allDivElements.forEach(divElement => {
        const currentButton = divElement.querySelector('input[type=button]');
        currentButton.addEventListener('click', (e) => {
            const currentInputElement = divElement.querySelector('input[type=text]');

            switch(currentInputElement) {
                case daysInputElement:
                    hoursInputElement.value = daysInputElement.value * 24;
                    minutesInputElement.value = hoursInputElement.value * 60;
                    secondsInputElement.value = minutesInputElement.value * 60;
                    break;
                case hoursInputElement:
                    daysInputElement.value = hoursInputElement.value / 24;
                    minutesInputElement.value = hoursInputElement.value * 60;
                    secondsInputElement.value = minutesInputElement.value * 60;
                    break;
                case minutesInputElement:
                    daysInputElement.value = (minutesInputElement.value / 60) / 24;
                    hoursInputElement.value = daysInputElement.value * 24;
                    secondsInputElement.value = minutesInputElement.value * 60;
                    break;
                case secondsInputElement:
                    daysInputElement.value = (secondsInputElement.value / 60 / 60) / 24;
                    hoursInputElement.value = daysInputElement.value * 24;
                    minutesInputElement.value = hoursInputElement.value * 60;
                    break;
            }
        });
    });
}