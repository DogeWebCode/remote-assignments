function ajax(src, callback) {
  // your code here
  const xhr = new XMLHttpRequest();
  xhr.open("get", src, true);
  xhr.send();
  xhr.onload = function () {
    const data = JSON.parse(this.responseText);
    callback(data);
  };
}
function render(data) {
  // your code here
  data.forEach((json, index) => {
    const newCard = document.createElement("div");
    newCard.className = "info";
    document.querySelector(".contain").appendChild(newCard);
    const newCardInfo = `
        <span class="order">ID：${index + 1}</span>
        <h3 class="name">Product_Name：${json.name}</h3>
        <p class="price">Price：${json.price}</p>
        <p class="description">description：${json.description}</p>
        <hr style="border-color:#f00">
    `;
    newCard.innerHTML = newCardInfo;
  });

  console.log(data);
  // document.createElement() and appendChild() methods are preferred.
}

ajax(
  "https://remote-assignment.s3.ap-northeast-1.amazonaws.com/products",
  function (response) {
    render(response);
  }
); // you should get product information in JSON format and render data in the page
