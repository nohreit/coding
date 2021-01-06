
//1

var factorial = function (n) {
  if (n < 0) {
    return null;
  } else if (n === 0 || n === 1) {
    return 1;
  }
  return n * factorial(n - 1);
};

// 2. 
var sum = function (array) {
  let i = array.length - 1;
  if (i < 0) {
    return 0;
  }
  return array[i] + sum(array.slice(0, i));
};

// 3. 

var arraySum = function (array) {
  let sum = 0;
  for (let i = 0; i < array.length; i++) {
    let val = array[i];
    if (Array.isArray(val)) {
      sum += arraySum(val);
    } else {
      sum += val;
    }
  }
  return sum;
};

// 4. Check if a number is even.
var Even = function (n) {
  // if (n < 0) {
  //   n = Math.abs(n);
  // }
  if (n == 0) {
    return true;
  }
  if (n === 1) {
    return false;
  }
  // return isEven(n - 2);
  return Even(Math.abs(n) - 2);
};

// 5. Sum all integers below a given integer.
// sumBelow(10); // 45
// sumBelow(7); // 21
var sumBelow = function (n) {
  if (n === 0 || n === 1) {
    return 0;
  } else if (n < 0) {
    return n + 1 + sumBelow(n + 1);
  } else {
    return n - 1 + sumBelow(n - 1);
  }
};

// 6. Get the integers within a range (x, y).
// range(2,9); // [3,4,5,6,7,8]
var range = function (x, y) {
  let inter = true;
  if (x > y) {
    let temp = x;
    x = y;
    y = temp;
    inter = false;
  }

  if (x === y || x + 1 === y) {
    return [];
  }
  let array = range(x, y - 1);
  array.push(y - 1);
  return inter ? array : array.reverse();
};

// 7. Compute the exponent of a number.
// The exponent of a number says how many times the base number is used as a factor.
// 8^2 = 8 x 8 = 64. Here, 8 is the base and 2 is the exponent.
// exponent(4,3); // 64
// https://www.khanacademy.org/computing/computer-science/algorithms/recursive-algorithms/a/computing-powers-of-a-number

var exponent = function (base, exp) {
  if (exp === 0) {
    return 1;
  } else if (exp === 1) {
    return base;
  }
  if (exp > 0) {
    return base * exponent(base, exp - 1);
    // return exponent(base, exp / 2) * 2;
  } else if (exp < 0) {
    return exponent(base, exp + 1) / base;
    // return exponent(base, exp / 2) * 2;
  }
};

// 8. Determine if a number is a power of two.
// powerOfTwo(1); // true
// powerOfTwo(16); // true
// powerOfTwo(10); // false

var powerOfTwo = function (n) {
  power = n / 2;
  if (n < 1) {
    return false;
  } else if (n === 1) {
    return true;
  }
  return powerOfTwo(power);
};

// 9. Write a function that reverses a string.

var reverse = function (string) {
  if (string === "") {
    return "";
  } else {
    return reverse(string.substr(1)) + string.charAt(0);
  }
};

// 10. Write a function that determines if a string is a palindrome.

var palindrome = function (string) {
  const cleanString = string.replace(/\W/g, "").toLowerCase();

  if (cleanString.length === 1) {
    return true;
  } else if (cleanString.length === 2) {
    return cleanString[0] === cleanString[1];
  } else if (cleanString[0] === cleanString.slice(-1)) {
    return palindrome(cleanString.slice(1, -1));
  }
  return false;
};

// 11. Write a function that returns the remainder of x divided by y without using the
// modulo (%) operator.
// modulo(5,2) // 1
// modulo(17,5) // 2
// modulo(22,6) // 4

var modulo = function (x, y) {
  if (y === 0) {
    return NaN;
  }

  if (x < 0) {
    return -modulo(-x, y);
  } else if (y < 0) {
    return modulo(x, -y);
  } else if (x < y) {
    return x;
  }
  return modulo(x - y, y);
};

// 12. Write a function that multiplies two numbers without using the * operator or
// Math methods.

var multiply = function (x, y) {
  if (x === 0 || y === 0) {
    return 0;
  } else if (y < 0) {
    return -x + multiply(x, y + 1);
  } else {
    return x + multiply(x, y - 1);
  }
};

// 13. Write a function that divides two numbers without using the / operator or
// Math methods to arrive at an approximate quotient (ignore decimal endings).

var divide = function (x, y) {
  debugger;
  if (x === 0 && y === 0) {
    return NaN;
  } else if (x < 0) {
    return -divide(-x, y);
  } else if (y < 0) {
    return -divide(x, -y);
  } else if (x < y) {
    return 0;
  } else {
    return 1 + divide(x - y, y);
  }
};

// 14. Find the greatest common divisor (gcd) of two positive numbers. The GCD of two
// integers is the greatest integer that divides both x and y with no remainder.
// gcd(4,36); // 4
// http://www.cse.wustl.edu/~kjg/cse131/Notes/Recursion/recursion.html
// https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/the-euclidean-algorithm

var gcd = function (x, y) {
  if (x < 0 || y < 0) {
    return null;
  } else if (!y) {
    // this base case stops the recursion once y equals zero
    return x;
  } else {
    return gcd(y, x % y); // recursively call the gcd function with params y & the remainder of x minus y
  }
};

// 15. Write a function that compares each character of two strings and returns true if
// both are identical.
// compareStr('house', 'houses') // false
// compareStr('tomato', 'tomato') // true

var compareStr = function (str1, str2) {
  if (
    (str1.length !== 0 && str2.length === 0) ||
    (str1.length === 0 && str2.length !== 0)
  ) {
    if (str1[0] !== str2[0]) {
      return false;
    }
  } else if (str1.length === 0 && str2.length === 0) {
    if (str1[0] === str2[0]) {
      return true;
    }
  }
  return compareStr(str1.slice(1), str2.slice(1));
};

// 16. Write a function that accepts a string and creates an array where each letter
// occupies an index of the array.

var createArray = function (str) {
  let strArr = [];
  if (str.length === 0) {
    return strArr;
  } else {
    strArr.push(str.charAt(0));
    return strArr.concat(createArray(str.slice(1, str.length)));
  }
};

// 17. Reverse the order of an array

var reverseArr = function (array) {
  yarra = [];
  if (array.length === 0) {
    return yarra;
  } else {
    return yarra.concat(reverseArr(array.slice(1)), array[0]);
  }
};

// 18. Create a new array with a given value and length.
// buildList(0,5) // [0,0,0,0,0]
// buildList(7,3) // [7,7,7]

var buildList = function (value, length) {
  let built = [value];
  if (length === 0 || length === 1) {
    return built;
  } else {
    return built.concat(buildList(value, length - 1));
  }
};

// 19. Implement FizzBuzz. Given integer n, return an array of the string representations of 1 to n.
// For multiples of three, output 'Fizz' instead of the number.
// For multiples of five, output 'Buzz' instead of the number.
// For numbers which are multiples of both three and five, output “FizzBuzz” instead of the number.
// fizzBuzz(5) // ['1','2','Fizz','4','Buzz']

var fizzBuzz = function (n) {
  let fzzbzz = [];

  if (n === 1) {
    return fzzbzz.concat("1");
  } else if (n % 3 === 0 && n % 5 === 0) {
    fzzbzz.push("FizzBuzz");
  } else if (n % 3 === 0) {
    fzzbzz.push("Fizz");
  } else if (n % 5 === 0) {
    fzzbzz.push("Buzz");
  } else {
    fzzbzz.push(n + "");
  }

  return fizzBuzz(n - 1).concat(fzzbzz);
};
