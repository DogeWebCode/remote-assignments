/**
 * 回傳number總平均(小數後2位)。
 * @param {number} data - 要計算平均的所有number
 * @returns {number} 返回平均數
 */
function avg(data) {
  // your code here
  const priceTotal = data.products.reduce((add, total) => add + total.price, 0);
  const priceAvg = priceTotal / data.size;
  return priceAvg.toFixed(2);
}
console.log(
  avg({
    size: 3,
    products: [
      {
        name: "Product 1",
        price: 100,
      },
      {
        name: "Product 2",
        price: 700,
      },
      {
        name: "Product 3",
        price: 250,
      },
    ],
  })
); // should print the average price of all products
