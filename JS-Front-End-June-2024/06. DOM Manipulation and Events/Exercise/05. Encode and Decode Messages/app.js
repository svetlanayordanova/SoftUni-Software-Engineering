function encodeAndDecodeMessages() {
    const firstTextareaElement = document.querySelector('#container #main div:nth-child(1) textarea');
    const secondTextareaElement = document.querySelector('#container #main div:nth-child(2) textarea');
    const encodeButton = document.querySelector('#container #main div:nth-child(1) button');
    const decodeButton = document.querySelector('#container #main div:nth-child(2) button');

    encodeButton.addEventListener('click', (e) => {
        const message = firstTextareaElement.value;
        let encodedMessage = '';

        for (let i = 0; i < message.length; i++) {
            const symbolAsciiCode = message.charCodeAt(i);
            encodedMessage += String.fromCharCode(symbolAsciiCode + 1);
        }

        secondTextareaElement.textContent = encodedMessage;
        firstTextareaElement.value = '';
    });

    decodeButton.addEventListener('click', (e) => {
        let decodedMessage = '';

        for (let i = 0; i < secondTextareaElement.textContent.length; i++) {
            const symbolAsciiCode = secondTextareaElement.textContent.charCodeAt(i);
            decodedMessage += String.fromCharCode(symbolAsciiCode - 1);
        }

        secondTextareaElement.textContent = decodedMessage;
    });
}