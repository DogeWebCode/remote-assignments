function count(input) {
  const array_CharacterCount = input.reduce((obj, num) => {
    if (obj[num] !== undefined) {
      obj[num]++;
    } else {
      obj[num] = 1;
    }
    return obj;
  }, {});
  return array_CharacterCount;
}
let input1 = ["a", "b", "c", "a", "c", "a", "x"];
console.log(count(input1));
// should print {a:3, b:1, c:2, x:1}
function groupByKey(input) {
  // your code here
  const object_CharacterCount = input.reduce((obj, num) => {
    const key = obj[num.key];
    if (obj[num.key] !== undefined) {
      key += num.value;
    } else {
      key = num.value;
    }
    return obj;
  }, {});

  return object_CharacterCount;
}
let input2 = [
  { key: "a", value: 3 },
  { key: "b", value: 1 },
  { key: "c", value: 2 },
  { key: "a", value: 3 },
  { key: "c", value: 5 },
];
console.log(groupByKey(input2));
// should print {a:6, b:1, c:7}
