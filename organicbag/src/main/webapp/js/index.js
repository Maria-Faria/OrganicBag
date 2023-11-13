let menu = document.getElementById("menu-nav");
const iconCart = document.querySelector("#icon-cart");
let cart = document.querySelector("#cart");
let qtdItem = document.querySelector(".qtd-item");
const closeCart = document.querySelector("#close-cart");
let countItem = document.getElementsByClassName("count-item");
let count = 1;
//const removeItem = document.querySelector(".remove-button");
//const addItem = document.querySelector(".add-button");

function changeMenuBackground() {
  //evento para alterar background do menu de acordo com scroll
  document.addEventListener("scroll", () => {
    var positionY = window.pageYOffset;

    menu.style.backgroundColor = positionY <= 700 ? "transparent" : "#8fa793";
  });
}

//contador do carrinho
function removeAddItem(button) {
    let divButton = button.parentElement;
    let input = divButton.children[1];
    
    
    if (button.classList.contains("remove-button")){
      count--;
    }

    else if (button.classList.contains("add-button")){
      count++;      
    }

    if (count == 0){
      divButton.parentElement.remove()
    }

    input.value = count;
    
}

//eventos e chamadas de métodos
function Main() {
  changeMenuBackground();

  for(i = 0; i < countItem.length; i++){
    countItem[i].addEventListener("click", (e) => {
      //e.preventDefault();
      removeAddItem(e.currentTarget); 
     
    })
  }

  
  //mostrar e fechar carrinho
  iconCart.addEventListener("click", () => cart.classList.remove("hide"));
  closeCart.addEventListener("click", () => cart.classList.add("hide"));

}

Main();

//redicrecionar produto para página dele
document.querySelector('.produto').addEventListener('click', () => {
  window.location('produto.jsp')
})