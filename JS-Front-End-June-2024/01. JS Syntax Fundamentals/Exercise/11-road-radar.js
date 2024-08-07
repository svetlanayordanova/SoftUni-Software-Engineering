function roadRadar(speed, area) {
    const motorwayLimit = 130;
    const interstateLimit = 90;
    const cityLimit = 50;
    const residentialLimit = 20;
    const speedingStatus = 'speeding';
    const excessiveSpeedingStatus = 'excessive speeding';
    const recklessDrivingStatus = 'reckless driving';
    
    let speedLimit = 0;
    
    switch (area) {
        case 'motorway':
            speedLimit = motorwayLimit;
        break;
        case 'interstate':
            speedLimit = interstateLimit;
        break;
        case 'city':
            speedLimit = cityLimit;
        break;
        case 'residential':
            speedLimit = residentialLimit;
        break;
    }
    
    let diff = speed - speedLimit;
    let status = "";
    
    if (diff > 0) {
        if (diff <= 20) {
            status = speedingStatus;
        } else if (diff <= 40) {
            status = excessiveSpeedingStatus;
        } else if (diff > 40) {
            status = recklessDrivingStatus;
        }
        
        console.log(`The speed is ${diff} km/h faster than the allowed speed of ${speedLimit} - ${status}`);
    } else {
        console.log(`Driving ${speed} km/h in a ${speedLimit} zone`);
    }
}

roadRadar(40, 'city');
roadRadar(21, 'residential');
roadRadar(120, 'interstate');
roadRadar(200, 'motorway');