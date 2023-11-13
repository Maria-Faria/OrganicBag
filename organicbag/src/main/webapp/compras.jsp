<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meus pedidos</title>
    <link rel="stylesheet" type="text/css" href="css/styleCompras.css">
    <link rel="icon" href="img/shop.png">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,500;0,600;1,400;1,500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
    <!--Barra de menu-->
    <header>
        <nav class="navBar">
            <img class="logo" src="img/OrganicBagLogo.png">

            <div class="nav-list">
                <ul>
                    <li class="nav-item"><a href="#" class="nav-link">página inicial</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">produtos</a></li>
                    <li class="nav-item" id="username"></li>
                    <li>
                        <div class="user">
                            <!--Ícone de usuário-->
                            <img class="userIcon" src="img/user.png">
        
                            <!--Opções do usuário-->
                            <div class="userOptions">
                                <button>Perfil</button>
                                <button>Sair</button>
                            </div>
                        </div>
        
                    </li>
                </ul>

            </div>
        </nav>
    </header>

    <!--Pedidos do cliente-->
    <main>
        <div class="order">
            <h3>Pedido: 000000</h3>
            <img class="productImg" src="img/image.png">
    
            <div class="product">
                <h4>nome do produto</h4>
                <h4>quantidade</h4>
                <h4>valor unitário</h4>
            </div>

            <h3 class="price">Total: R$0,00</h3>
           
            <button class="note">nota fiscal</button>
        </div>
    </main>

    <script src="js/scriptCompras.js"></script>
</body>
</html>