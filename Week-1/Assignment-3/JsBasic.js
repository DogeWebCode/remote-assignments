function countAandB(input) {
  // your code here
  // 先取陣列中a 跟 b有幾個，加總後return。
  let Acount = input.filter((Element) => Element == "a").length;
  let Bcount = input.filter((Element) => Element == "b").length;
  let TotalCount = Acount + Bcount;
  return TotalCount;
}
function toNumber(input) {
  // your code here
  // 用map遍歷帶進來的陣列，並將陣列內的字母轉ASCii Code。
  const arr = input.map((item) => item.charCodeAt() - 96);
  return arr;
}
let input1 = ["a", "b", "c", "a", "c", "a", "c"];
console.log(countAandB(input1)); // should print 4 (3 ‘a’ letters  and 1 ‘b’ letter)

console.log(toNumber(input1)); // should print [1, 2, 3, 1, 3, 1, 3]

let input2 = ["e", "d", "c", "d", "e"];
console.log(countAandB(input2)); // should print 0
console.log(toNumber(input2)); // should print [5, 4, 3, 4, 5]
