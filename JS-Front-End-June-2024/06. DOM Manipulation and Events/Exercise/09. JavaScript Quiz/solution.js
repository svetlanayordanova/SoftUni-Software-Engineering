function solve() {
  const sectionElements = document.querySelectorAll('section');
  const correctAnswers = ['onclick', 'JSON.stringify()', 'A programming API for HTML and XML documents'];
  let countCorrectAnswers = 0;
  
  for (let i = 0; i < sectionElements.length; i++) {
    const sectionElement = sectionElements[i];
    const answerTextElements = sectionElement.querySelectorAll('.answer-text');
    
    answerTextElements.forEach(answerTextElement => {
      answerTextElement.addEventListener('click', (e) => {
        const ulResultElement = document.getElementById('results');
        const h1Element = ulResultElement.querySelector('h1');
        
        if (correctAnswers.includes(answerTextElement.textContent)) {
          countCorrectAnswers++;
        }
        
        sectionElement.style.display = 'none';
        
        if (i < sectionElements.length - 1) {
          sectionElements[i + 1].style.display = 'block';
        } else {
          if (countCorrectAnswers === correctAnswers.length) {
            h1Element.textContent = 'You are recognized as top JavaScript fan!';
          } else {
            h1Element.textContent = `You have ${countCorrectAnswers} right answers`;
          }

          ulResultElement.style.display = 'block';
        }
      });
    });
  }
}