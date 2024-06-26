const welcomeMsg = document.querySelector(".welcome");
function changeText() {
  if (welcomeMsg.innerText === "Welcome Message") {
    welcomeMsg.innerHTML = `<h1>Have a Good Time!</h1>`;
  } else {
    welcomeMsg.innerHTML = `<h1>Welcome Message</h1>`;
  }
}
