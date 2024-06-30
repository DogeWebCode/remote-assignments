function binarySearchPosition(numbers, target) {
  // your code here
  //array從0開始，array長度-1 = 陣列最後一個元素
  let start = 0;
  let end = numbers.length - 1;
  while (start <= end) {
    const midIndex = Math.floor((start + end) / 2);
    if (numbers[midIndex] === target) {
      return midIndex;
    } else if (numbers[midIndex] > target) {
      end = midIndex - 1;
    } else {
      start = midIndex + 1;
    }
  }
}
console.log(binarySearchPosition([1, 2, 5, 6, 7], 1)); // should print 0

console.log(binarySearchPosition([1, 2, 5, 6, 7], 6)); // should print 3
