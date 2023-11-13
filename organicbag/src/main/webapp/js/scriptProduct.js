//var image = document.getElementById("img1")
/*var imageMain = document.getElementById("img0");
var aux = imageMain.src;

var images = document.querySelectorAll("#images img");



    /*imageMain.setAttribute('src', image.src);

    image.setAttribute('src', aux);*/
    /*alert('a')
    for(var i = 0; i < images.length; i++) {
        images[i].addEventListener("click", function(e) {
            images[i].setAttribute('src', aux)
        })
    }*/

/*var img1 = document.getElementById("img1")
var img2 = document.getElementById("img2")
var img3 = document.getElementById("img3")
var img4 = document.getElementById("img4")

var imageMain = document.getElementById("img0")
var aux = imageMain.src

img1.addEventListener("click", function(e) {
    alert(img1.src)

    imageMain.setAttribute('src', img1.src)
})*/

/*var images = document.querySelectorAll("#images img").src

images[0].addEventListener("click", function(e) {
    alert(images[0])
})*/

var imageMain = document.getElementById("img0");
let desc = document.getElementById("desc");
let more = document.getElementById("more");

let click = false

function trocar(imgTroca) {
    imageMain.setAttribute('src', imgTroca)
}

function moreInfo() {

    if(!click) {
        desc.style.height = '500px';
        more.innerHTML = 'menos informações'
        click = true

    }else {
        desc.style.height = '100px';
        more.innerHTML = 'mais informações'
        click = false
    }
}

var cart = document.querySelector("#cart")
//var menu = document.querySelector(".cart-toggle")

let cartOpen = document.getElementById("cart")
let cartBox = document.getElementById('cart-box')

var close = document.querySelector("#close")

cart.addEventListener('click', function() {
    /*cart.classList.remove('bi bi-cart3')
    cart.classList.add('bi bi-x-lg')*/
    //menu.classList.toggle('cart-box')
    cartBox.style.display = 'flex'

    if(cartOpen.classList.contains('bi-cart3')) {
        cartOpen.style.position = 'absolute'
        /*cartOpen.classList.remove('bi-cart3')
        cartOpen.classList.add('bi-x-lg')

        cartOpen.style.marginTop = '20px'*/
    
    }/*else {
        cart.classList.remove('bi-x-lg')
        cart.classList.add('bi-cart3')
        cartOpen.style.marginTop = '0'
    }*/
})

close.addEventListener('click', function() {
    cartBox.style.display = 'none'
})

/*function openCart() {
    alert('clicou')
    const cart = document.getElementById('#cart')

    //cart.classList.remove('bi-cart3')
    cart.classList.toggle('bi-x-lg')
}*/

var products = document.querySelectorAll(".img-cart");

function addQtd() {
    
}