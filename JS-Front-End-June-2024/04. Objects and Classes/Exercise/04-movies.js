function storeMovies(inputArray) {
    const movies = [];
    
    for (const command of inputArray) {
        if (command.startsWith('addMovie')) {
            const [, movieName] = command.split('addMovie ');
            const movie = {
                name: movieName,
            }
            movies.push(movie);
        } else if (command.includes('directedBy')) {
            const [movieName, director] = command.split(' directedBy ');
            const movie = movies.find(movie => movie.name === movieName);
            
            if (movie) {
                movie.director = director;
            }
        } else if (command.includes('onDate')) {
            const [movieName, date] = command.split(' onDate ');
            const movie = movies.find(movie => movie.name === movieName);
            
            if (movie) {
                movie.date = date;
            }
        }
    }
    
    movies
        .filter(movie => movie.director && movie.date)
        .forEach(movie => console.log(JSON.stringify(movie)));
}

storeMovies([
    'addMovie Fast and Furious',
    'addMovie Godfather',
    'Inception directedBy Christopher Nolan',
    'Godfather directedBy Francis Ford Coppola',
    'Godfather onDate 29.07.2018',
    'Fast and Furious onDate 30.07.2018',
    'Batman onDate 01.08.2018',
    'Fast and Furious directedBy Rob Cohen'
]);
storeMovies([
    'addMovie The Avengers',
    'addMovie Superman',
    'The Avengers directedBy Anthony Russo',
    'The Avengers onDate 30.07.2010',
    'Captain America onDate 30.07.2010',
    'Captain America directedBy Joe Russo'
]);