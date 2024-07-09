// callback
function delayedResult(n1, n2, delayTime, callback) {
  const total = n1 + n2;
  setTimeout(function () {
    callback(
      `${total} (${n1}+${n2}) will be shown in the console after ${
        delayTime / 1000
      } seconds`
    );
  }, delayTime);
}
delayedResult(4, 5, 3000, function (result) {
  console.log(result);
});

delayedResult(-5, 10, 2000, function (result) {
  console.log(result);
});

// promise
function delayedResultPromise(n1, n2, delayTime) {
  // your code here
  return new Promise(function (resolve, reject) {
    const total = n1 + n2;
    setTimeout(function () {
      resolve(
        `${total} (${n1}+${n2}) will be shown in the console after 3 seconds`
      );
    }, delayTime);
  });
}
delayedResultPromise(4, 5, 3000).then(console.log);

// async/await
async function main() {
  // your code here, you should call delayedResultPromise here and get the result using async/await.
  console.log(await delayedResultPromise(4, 5, 3000));
}
main(); // result will be shown in the console after <delayTime> seconds
