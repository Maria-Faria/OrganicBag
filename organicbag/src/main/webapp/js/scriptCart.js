var cart = document.querySelector('#cart')
var menu = document.querySelector(".menu")

cart.addEventListener('click', function() {
    menu.classList.toggle('cart-box')
})