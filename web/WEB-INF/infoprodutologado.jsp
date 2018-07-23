<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Vitrine Informática</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="css/padrao.css">
        <link rel="stylesheet" href="css/index.css">
    </head>
    <body>
       <header>

            <!-- inicio da nav bar-->
            <nav class="navbar navbar-default" >
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="Indexlogado"><img src="img/logo.png" alt="Vitrine Informática" id="logo"></a>
                    </div>

                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span> ${usuario.nome}

                                    <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Conta</a></li>
                                    <li><a href="#">Compras</a></li>
                                    <li><a href="Mensagem">Mensagens</a></li>
                                </ul>
                            </li>
                            <li><a href="Carrinhologado" id="linkcarrinho"><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho <span class="badge">${carrinho.totalDeItens}</span></a></li>
                            <li><a href="Logout" id="linksair"><span class="glyphicon glyphicon-log-in"></span> Sair </a></li>
                        </ul>
                    </div>
                </div>

                <img class="img-responsive" src="img/placamae.png" id="img" alt="Placa Mãe">
            </nav>
            <!-- fim da nav bar-->
        </header>

        <section class="container-fluid vitrine">

            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <p class="lead">Produto</p>
                        <div class="list-group">
                            <a href="#" class="list-group-item active">Processador</a>
                        </div>
                    </div>

                    <div class="col-md-9" >
                        <div class="thumbnail">
                            <img class="img-responsive" src="${produto.imagem}" alt="produto">
                            <div>
                                <h4><strong>R$ ${produto.valorunit}</strong></h4>
                                <h4><a href="#">${produto.nome}</a>
                                </h4>
                                <p>${produto.descricao}</p>
                               
                                <a href="CarrinhoPage?codigo=${produto.codigo}" class="btn btn-primary">
                                    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
                                    Adicionar
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <footer class="container-fluid ">
            <a class="navbar-brand" href="#"><img src="img/logo.png" alt="logo"></a>
            <p>Endereço:<br/>
                Rua Dez, 560 -  Prazeres <br/>
                Jaboatão dos Guararapes - PE <br/>
            </p>
        </footer>


    </body>
</html>
