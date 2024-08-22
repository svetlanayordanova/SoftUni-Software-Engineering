function solve() {
  const textareaElement = document.getElementById('input');
  const outputElement = document.getElementById('output');

  const textareaElementValue = textareaElement.value;

  const sentences = textareaElementValue.split('.').filter(Boolean);

  for (let i = 0; i < sentences.length; i += 3) {
    const paragraphElement = document.createElement('p');
    const currentText = sentences.slice(i, i + 3).join('. ').concat('.');
    paragraphElement.textContent = currentText;
    outputElement.appendChild(paragraphElement);
  }  
}