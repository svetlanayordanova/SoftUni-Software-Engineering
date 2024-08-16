function songs(inputArray) {
    class Song {
        constructor(typeList, name, time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }
    }

    const songType = inputArray.pop();
    const [numberOfSongs, ...songsData] = inputArray;
    let songs = [];

    for (let i = 0; i < numberOfSongs; i++) {
        let currentSongData = songsData[i];
        let [type, name, time] = currentSongData.split('_');
        let song = new Song(type, name, time);
        songs.push(song);
    }

    if (songType === 'all') {
        songs.forEach(song => console.log(song.name));
    } else {
        songs
            .filter(song => song.typeList === songType)
            .forEach(song => console.log(song.name));
    }
}

songs([3, 'favourite_DownTown_3:14', 'favourite_Kiss_4:16', 'favourite_Smooth Criminal_4:01', 'favourite']);
songs([4, 'favourite_DownTown_3:14', 'listenLater_Andalouse_3:24', 'favourite_In To The Night_3:58', 'favourite_Live It Up_3:48', 'listenLater']);
songs([2, 'like_Replay_3:15', 'ban_Photoshop_3:48', 'all']);