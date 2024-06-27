const welcomeMsg = document.querySelector(".welcome h1");
const contenbox = document.querySelector(".contenbox_hidden");
function changeText() {
  if (welcomeMsg.textContent === "Welcome Message") {
    welcomeMsg.textContent = "Have a Good Time!";
  } else {
    welcomeMsg.textContent = "Welcome Message";
  }
}

function btn_Toggle() {
  if (contenbox.classList.contains("contenbox_hidden")) {
    contenbox.classList.remove("contenbox_hidden");
    contenbox.classList.add("contenbox_show");
  } else {
    contenbox.classList.remove("contenbox_show");
    contenbox.classList.add("contenbox_hidden");
  }
}
