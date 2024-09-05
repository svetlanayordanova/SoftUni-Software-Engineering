function thePianist(inputArray) {
    const n = Number(inputArray[0]);
    
    const piecesData = inputArray.slice(1, n + 1);
    const commands = inputArray.slice(n + 1);
    
    const pieces = [];
    
    piecesData.forEach(pieceData => {
        const [pieceName, composer, key] = pieceData.split('|');
        const piece = {
            pieceName,
            composer,
            key,
        }
        pieces.push(piece);
    });
    
    commands.forEach(command => {
        const [commandName, pieceName, ...rest] = command.split('|');
        const currentPiece = findPiece(pieceName);
        
        switch(commandName) {
            case 'Add':
                const composer = rest[0];
                const key = rest[1];
            
                if (!currentPiece) {
                    const piece = {
                        pieceName,
                        composer,
                        key
                    }
                    pieces.push(piece);

                    console.log(`${pieceName} by ${composer} in ${key} added to the collection!`);
                } else {
                    console.log(`${pieceName} is already in the collection!`);
                }
            break;
            case 'Remove':
                if (currentPiece) {
                    const index = pieces.indexOf(currentPiece);
                    pieces.splice(index, 1);
                
                    console.log(`Successfully removed ${pieceName}!`);
                } else {
                    console.log(`Invalid operation! ${pieceName} does not exist in the collection.`);
                }
            break;
            case 'ChangeKey':
                const newKey = rest[0];
            
                if (currentPiece) {
                    currentPiece.key = newKey;
                
                    console.log(`Changed the key of ${pieceName} to ${newKey}!`);
                } else {
                    console.log(`Invalid operation! ${pieceName} does not exist in the collection.`);
                }
            break;
            case 'Stop':
                return;
        }
    });
    
    pieces.forEach(piece => console.log(`${piece.pieceName} -> Composer: ${piece.composer}, Key: ${piece.key}`));
    
    function findPiece(pieceName) {
        return pieces.find(piece => piece.pieceName === pieceName);
    }
}

thePianist([
    '3',
    'Fur Elise|Beethoven|A Minor',
    'Moonlight Sonata|Beethoven|C# Minor',
    'Clair de Lune|Debussy|C# Minor',
    'Add|Sonata No.2|Chopin|B Minor',
    'Add|Hungarian Rhapsody No.2|Liszt|C# Minor',
    'Add|Fur Elise|Beethoven|C# Minor',
    'Remove|Clair de Lune',
    'ChangeKey|Moonlight Sonata|C# Major',
    'Stop'  
]);
thePianist([
    '4',
    'Eine kleine Nachtmusik|Mozart|G Major',
    'La Campanella|Liszt|G# Minor',
    'The Marriage of Figaro|Mozart|G Major',
    'Hungarian Dance No.5|Brahms|G Minor',
    'Add|Spring|Vivaldi|E Major',
    'Remove|The Marriage of Figaro',
    'Remove|Turkish March',
    'ChangeKey|Spring|C Major',
    'Add|Nocturne|Chopin|C# Minor',
    'Stop'
]);