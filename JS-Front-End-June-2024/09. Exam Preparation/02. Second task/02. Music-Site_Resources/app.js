window.addEventListener('load', solve);

function solve() {
    const addButton = document.getElementById('add-btn');
    const divAllHits = document.querySelector('.all-hits-container');
    const divSavedContainer = document.querySelector('.saved-container');
    const formElement = document.querySelector('form');
    const pLikesElement = document.querySelector('#total-likes .likes p');

    let totalLikes = 0;

    addButton.addEventListener('click', add);

    function add(e) {
        e.preventDefault();

        const genreInputElement = document.getElementById('genre');
        const nameInputElement = document.getElementById('name');
        const authorInputElement = document.getElementById('author');
        const dateInputElement = document.getElementById('date');

        if (genreInputElement.value === '' || nameInputElement.value === '' ||
            authorInputElement.value === '' || dateInputElement.value === '') {
            return;
        }

        const divHitsInfoElement = document.createElement('div');
        divHitsInfoElement.classList.add('hits-info');

        const imgElement = document.createElement('img');
        imgElement.src = './static/img/img.png';

        h2GenreElement = document.createElement('h2');
        h2GenreElement.textContent = `Genre: ${genreInputElement.value}`;

        h2NameElement = document.createElement('h2');
        h2NameElement.textContent = `Name: ${nameInputElement.value}`;

        h2AuthorElement = document.createElement('h2');
        h2AuthorElement.textContent = `Author: ${authorInputElement.value}`;

        h3DateElement = document.createElement('h3');
        h3DateElement.textContent = `Date: ${dateInputElement.value}`;

        const saveButton = document.createElement('button');
        saveButton.classList.add('save-btn');
        saveButton.textContent = 'Save song';

        const likeButton = document.createElement('button');
        likeButton.classList.add('like-btn');
        likeButton.textContent = 'Like song';

        const deleteButton = document.createElement('button');
        deleteButton.classList.add('delete-btn');
        deleteButton.textContent = 'Delete';

        divHitsInfoElement.appendChild(imgElement);
        divHitsInfoElement.appendChild(h2GenreElement);
        divHitsInfoElement.appendChild(h2NameElement);
        divHitsInfoElement.appendChild(h2AuthorElement);
        divHitsInfoElement.appendChild(h3DateElement);
        divHitsInfoElement.appendChild(saveButton);
        divHitsInfoElement.appendChild(likeButton);
        divHitsInfoElement.appendChild(deleteButton);

        divAllHits.appendChild(divHitsInfoElement);

        formElement.reset();

        likeButton.addEventListener('click', likeSong);

        function likeSong() {
            totalLikes++;

            pLikesElement.textContent = `Total Likes: ${totalLikes}`;

            likeButton.setAttribute('disabled', 'disabled');
        }

        saveButton.addEventListener('click', saveSong);

        function saveSong() {
            divSavedContainer.appendChild(divHitsInfoElement);

            divHitsInfoElement.removeChild(divHitsInfoElement.children[6]);
            divHitsInfoElement.removeChild(divHitsInfoElement.children[5]);
        }

        deleteButton.addEventListener('click', deleteSong);

        function deleteSong(e) {
            if (e.currentTarget.parentNode.parentNode === divAllHits) {
                divAllHits.removeChild(divHitsInfoElement);
            } else if (e.currentTarget.parentNode.parentNode === divSavedContainer) {
                divSavedContainer.removeChild(divHitsInfoElement);

                console.log(divAllHits);
                console.log(divSavedContainer);
            }
        }
    }
}