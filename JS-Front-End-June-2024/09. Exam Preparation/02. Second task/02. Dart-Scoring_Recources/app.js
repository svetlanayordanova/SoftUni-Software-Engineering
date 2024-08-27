window.addEventListener("load", solve);

function solve() {
  const addButton = document.getElementById('add-btn');
  const clearButton = document.querySelector('.btn.clear');
  const ulSureListElement = document.getElementById('sure-list');
  const ulScoreboardListElement = document.getElementById('scoreboard-list');

  addButton.addEventListener('click', onAdd);

  function onAdd() {
    const playerNameInputElement = document.getElementById('player');
    const scoreInputElement = document.getElementById('score');
    const roundInputElement = document.getElementById('round');

    if (playerNameInputElement.value === '' || scoreInputElement.value === '' || roundInputElement.value === '') {
      return;
    }

    const liDartItemElement = document.createElement('li');
    liDartItemElement.classList.add('dart-item');

    const articleElement = document.createElement('article');

    const pPlayerNameElement = document.createElement('p');
    pPlayerNameElement.textContent = `${playerNameInputElement.value}`;
    const playerName = playerNameInputElement.value;

    const pScoreElement = document.createElement('p');
    pScoreElement.textContent = `Score: ${scoreInputElement.value}`;
    const score = scoreInputElement.value;

    const pRoundElement = document.createElement('p');
    pRoundElement.textContent = `Round: ${roundInputElement.value}`;
    const round = roundInputElement.value;

    const editButton = document.createElement('button');
    editButton.classList.add('btn');
    editButton.classList.add('edit');
    editButton.textContent = 'edit';

    const okButton = document.createElement('button');
    okButton.classList.add('btn');
    okButton.classList.add('ok');
    okButton.textContent = 'ok';

    articleElement.appendChild(pPlayerNameElement);
    articleElement.appendChild(pScoreElement);
    articleElement.appendChild(pRoundElement);

    liDartItemElement.appendChild(articleElement);
    liDartItemElement.appendChild(editButton);
    liDartItemElement.appendChild(okButton);

    ulSureListElement.appendChild(liDartItemElement);

    const formElement = document.querySelector('form');
    formElement.reset();
    addButton.setAttribute('disabled', 'disabled');

    editButton.addEventListener('click', edit);

    function edit() {
      playerNameInputElement.value = playerName;
      scoreInputElement.value = score;
      roundInputElement.value = round;

      ulSureListElement.removeChild(liDartItemElement);
      addButton.disabled = false;
    }

    okButton.addEventListener('click', onOk);

    function onOk() {
      const clonedLiElement = liDartItemElement.cloneNode(true);
      ulSureListElement.removeChild(liDartItemElement);

      clonedLiElement.removeChild(clonedLiElement.children[2]);
      clonedLiElement.removeChild(clonedLiElement.children[1]);

      ulScoreboardListElement.appendChild(clonedLiElement);
    }
  }

  clearButton.addEventListener('click', clear);

  function clear() {
    location.reload();
  }
}
  