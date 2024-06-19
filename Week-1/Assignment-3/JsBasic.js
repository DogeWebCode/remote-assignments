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
  //先將Array to String，再用迴圈把Array裡的字母都轉成數字，主要是charCodeAt沒辦法直接針對Array使用。
  let str = input.toString();
  //此為將逗點改空格，因為轉換的時候也會將String中的","變Acsii Code。
  let replaced_str = str.split(",").join("");
  let result = [];
  // 用charCodeAt來將英文轉成ASCii Code，減96是因為"a"在ASCii Code的Decimal為97，相減後得1。
  for (let i = 0; i < input.length; i++) {
    result[i] = replaced_str.charCodeAt(i) - 96;
  }
  return result;
}
let input1 = ["a", "b", "c", "a", "c", "a", "c"];
console.log(countAandB(input1)); // should print 4 (3 ‘a’ letters  and 1 ‘b’ letter)

console.log(toNumber(input1)); // should print [1, 2, 3, 1, 3, 1, 3]

let input2 = ["e", "d", "c", "d", "e"];
console.log(countAandB(input2)); // should print 0
console.log(toNumber(input2)); // should print [5, 4, 3, 4, 5]
