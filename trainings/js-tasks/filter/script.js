let numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

const filteredNumbers = numbers.myFilter(function (value, index, myArray) {
  return value > 5;
});

console.log(filteredNumbers);
