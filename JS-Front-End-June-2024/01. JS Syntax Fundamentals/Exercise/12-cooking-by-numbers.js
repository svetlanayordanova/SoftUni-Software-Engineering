function solve(number, op1, op2, op3, op4, op5) {
    let num = Number(number);

    const operations = [op1, op2, op3, op4, op5];
    
    for (let i = 0; i < operations.length; i++) {
        let currentOperation = operations[i];

        switch (currentOperation) {
            case 'chop':
                num /= 2;
            break;
            case 'dice':
                num = Math.sqrt(num);
            break;
            case 'spice':
                num++;
            break;
            case 'bake':
                num *= 3;
            break;
            case 'fillet':
                num -= num * 0.2;
            break;
        }

        console.log(num);
    }
}

solve('32', 'chop', 'chop', 'chop', 'chop', 'chop');
solve('9', 'dice', 'spice', 'chop', 'bake', 'fillet');