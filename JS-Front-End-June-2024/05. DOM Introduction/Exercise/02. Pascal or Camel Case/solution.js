function solve() {
  const textElement = document.getElementById('text');
  const namingConventionElement = document.getElementById('naming-convention');
  const resultElement = document.getElementById('result');
  
  const textElementValue = textElement.value.toLowerCase();
  const namingConventionElementValue = namingConventionElement.value;
  
  const textElementValueArray = textElementValue.split(' ');
  
  let pascalCaseText = '';
  
  for (let currentElement of textElementValueArray) {
    currentElement = currentElement.charAt(0).toUpperCase().concat(currentElement.substring(1));
    pascalCaseText = pascalCaseText.concat(currentElement);
  }
  
  if (namingConventionElementValue === 'Pascal Case') {
    resultElement.textContent = pascalCaseText;
  } else if (namingConventionElementValue === 'Camel Case') {
    resultElement.textContent = pascalCaseText.charAt(0).toLowerCase().concat(pascalCaseText.substring(1));
  } else {
    resultElement.textContent = 'Error!';
  }
}