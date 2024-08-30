window.addEventListener("load", solve);

function solve() {
  const publishButton = document.getElementById('publish-btn');
  const ulReviewListElement = document.getElementById('review-list');
  const ulPublishedListElement = document.getElementById('published-list');

  publishButton.addEventListener('click', publish);

  function publish() {
    const titleInputElement = document.getElementById('task-title');
    const categoryInputElement = document.getElementById('task-category');
    const contentTextareaElement = document.getElementById('task-content');

    if (titleInputElement.value === '' || categoryInputElement.value === '' || contentTextareaElement.value === '') {
        return;
    }

    const liRpostElement = document.createElement('li');
    liRpostElement.classList.add('rpost');

    const articleElement = document.createElement('article');

    const h4TitleElement = document.createElement('h4');
    h4TitleElement.textContent = titleInputElement.value;
    const title = titleInputElement.value;

    const pCategoryElement = document.createElement('p');
    pCategoryElement.textContent = `Category: ${categoryInputElement.value}`;
    const category = categoryInputElement.value;

    const pContentElement = document.createElement('p');
    pContentElement.textContent = `Content: ${contentTextareaElement.value}`;
    const content = contentTextareaElement.value;

    const editButton = document.createElement('button');
    editButton.classList.add('action-btn');
    editButton.classList.add('edit');
    editButton.textContent = 'Edit';

    const postButton = document.createElement('button');
    postButton.classList.add('action-btn');
    postButton.classList.add('post');
    postButton.textContent = 'Post';

    articleElement.appendChild(h4TitleElement);
    articleElement.appendChild(pCategoryElement);
    articleElement.appendChild(pContentElement);

    liRpostElement.appendChild(articleElement);
    liRpostElement.appendChild(editButton);
    liRpostElement.appendChild(postButton);

    ulReviewListElement.appendChild(liRpostElement);

    const formElement = document.querySelector('form');
    formElement.reset();

    editButton.addEventListener('click', edit);

    function edit() {
        titleInputElement.value = title;
        categoryInputElement.value = category;
        contentTextareaElement.value = content;

        ulReviewListElement.removeChild(liRpostElement);
    }

    postButton.addEventListener('click', post);

    function post() {
        const liClonedElement = liRpostElement.cloneNode(true);
        ulReviewListElement.removeChild(liRpostElement);

        liClonedElement.removeChild(liClonedElement.children[2]);
        liClonedElement.removeChild(liClonedElement.children[1]);

        ulPublishedListElement.appendChild(liClonedElement);
    }
  }
}