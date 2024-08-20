function storeComments(inputArray) {
    const comments = {};
    const users = [];
    const articles = [];
    
    for (const currentElement of inputArray) {
        if (currentElement.startsWith('user')) {
            const user = currentElement.split(' ')[1];
            users.push(user);
        } else if (currentElement.startsWith('article')) {
            const article = currentElement.split(' ')[1];
            articles.push(article);
        } else if (currentElement.includes('posts')) {
            const currentElementParts = currentElement.split(': ');
            const user = currentElementParts[0].split(' ')[0];
            const article = currentElementParts[0].split(' ')[3];
            const title = currentElementParts[1].split(', ')[0];
            const content = currentElementParts[1].split(', ')[1];
            
            if (users.includes(user) && articles.includes(article)) {
                comments[article] = [];
                comments[article].push({
                    user,
                    title,
                    content,
                });
            }
        }
    }

    const sortedEntries = Object.entries(comments).sort((a, b) => b[1].length - a[1].length);

    Object.values(sortedEntries).forEach(value => {
        value.sort((a, b) => a.localeCompare(b));
    })

    for (const keyComment in sortedEntries) {
        console.log(`Comments on ${keyComment}`);

        value = sortedEntries[keyComment];

        value.forEach(val => {
            console.log(`--- From user ${val[0]}: ${val[1]} - ${val[2]}`);
        })
    }
}

storeComments(['user aUser123', 'someUser posts on someArticle: NoTitle, stupidComment', 'article Books', 'article Movies', 'article Shopping', 'user someUser', 'user uSeR4', 'user lastUser', 'uSeR4 posts on Books: I like books, I do really like them', 'uSeR4 posts on Movies: I also like movies, I really do', 'someUser posts on Shopping: title, I go shopping every day', 'someUser posts on Movies: Like, I also like movies very much']);