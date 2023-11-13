<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%out.print(request.getAttribute("name"));%></title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,500;0,600;1,400;1,500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <link rel="stylesheet" type="text/css" href="css/styleProduto.css">
    <link rel="icon" href="img/OrganicBagLogo.png">
</head>
<body>
    <!--Barra de menu-->
    <header class="menu">

        <nav class="navBar">
            <img class="logo" src="img/OrganicBagLogo.png">

            <div class="nav-list">
                <ul class="item">
                    <li class="nav-item"><a href="index.html" class="nav-link">página inicial</a></li>
                    <li class="nav-item"><a href="index.html#produtos" class="nav-link">produtos</a></li>
                    <li class="nav-item"><a href="index.html#sobre" class="nav-link">sobre</a></li>
                    <li class="nav-item">
                        <a href="login.html"><button class="nav-link" id="login"><u>entrar</u></button></a>
                    </li>
                    <li>
                        <a href="cadastro.html"><button class="nav-link" id="conta">criar conta</button></a>
                    </li>
                    <!--CARRINHO-->
                    <li class="cart-toggle">
                        <i class="bi bi-cart3" id="cart"></i>

                        <div class="cart-box" id="cart-box">
                            <i class="bi bi-x-lg" id="close"></i>

                            <h1 class="cartTitle">seu carrinho</h1>

                            <div class="productAdd" id="p1">
                                <img src="img/veganSoap2.png" class="img-cart">
                                <p class="product-name">Sabonete vegano <br><br>
                                R$ 4,50
                                </p>

                                <div class="input-qtd">
                                    <h3 class="update-qtd" id="sub">-</h3>
                                    <input type="number" class="cart-qtd">
                                    <h3 class="update-qtd" id="add">+</h3>
                                </div>
                            </div>
                    </li>

                </ul>
            </div>

        </nav>

    </header>

    <h4 class="path"><a href="index.html">página inicial</a> / 
        <a href="index.html#produtos">produtos</a> / 
        <a href="index.html"><%out.print(request.getAttribute("category"));%></a> / 
        <a href="#"><%out.print(request.getAttribute("name"));%></a>
    </h4>

    <!-- PRODUTO -->
    <main>

        <div class="produto">
            <h4 class="back">
                <a href="index.html#produtos">< voltar para página de produtos</a>
            </h4>

            <div class="images">
                <div class="lateral" id="images">
                    <img id="img1" src="getImage1" class="imgProduct" onclick="trocar('getImage1')">
                    <img id="img2" src="getImage2" class="imgProduct" onclick="trocar('getImage2')">
                    <img id="img3" src="getImage3" class="imgProduct" onclick="trocar('getImage3')">
                    <img id="img2" src="getImage4" class="imgProduct" onclick="trocar('getImage4')">
                </div>

                <div class="productPrice">
                    <img id="img0" src="getImage1" class="productImage">

                    <h1 class="price">R$<%out.print(String.format("%.2f", request.getAttribute("price")));%></h1>
                </div>

            </div>

            <div class="info">
                <h1 class="nameProduct"><%out.print(request.getAttribute("name"));%></h1> 

                <div class="desc" id="desc">
                    <p><%out.print(request.getAttribute("description"));%></p> 

                    <!--<p class="moreText">peso: <br>
                        fabricação: <br>
                        validade:
                    </p>-->
                </div>

                <p class="more" onclick="moreInfo()" id="more">mais informações</p>

                <div class="qtd">
                    <input type="number" min="1" class="inputQtd" value="1">
                    <p>quantidade</p>
                </div>

              <button class="buy">comprar</button> 
            </div>
        </div>
    </main>

    <script src="js/scriptProduct.js"></script>
</body>
</html>