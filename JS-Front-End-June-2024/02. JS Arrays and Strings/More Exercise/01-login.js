function login(input) {
    const [username, ...elements] = input;
    const splitUsername = username.split('');
    const password = splitUsername.reverse().join('');

    let usernameBlocked = false;
    let countTries = 0;

    while(!usernameBlocked) {
        for (const el of elements) {
            if (el !== password) {
                countTries++;
            } else {
                console.log(`User ${username} logged in.`);
                return;
            }

            if (countTries === 4) {
                console.log(`User ${username} blocked!`);
                usernameBlocked = true;
            } else {
                console.log('Incorrect password. Try again.');
            }
        }
    }
}

login(['Acer','login','go','let me in','recA']);
login(['momo','omom']);
login(['sunny','rainy','cloudy','sunny','not sunny']);