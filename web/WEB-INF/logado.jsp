
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Vitrine Informática</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="css/index.css">
        <link rel="stylesheet" href="css/padrao.css">
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
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span> ${usuario.nome}</a>
                                 
                                    <li><a href="ContaUsuario?idusuario=${usuario.idusuario}">Conta</a></li>
                                    <li><a href="ComprasUsuario">Compras</a></li>
                                    <li><a href="Mensagem">Mensagens</a></li>
                                
                            </li>
                            <li><a href="CarrinhoLogado" id="linkcarrinho"><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho <span class="badge">${carrinho.totalDeItens}</span></a></li>
                            <li><a href="Logout" id="linksair"><span class="glyphicon glyphicon-log-in"></span> Sair </a></li>
                        </ul>
                    </div>
                </div>

                <img class="img-responsive" src="img/placamae.png" id="img" alt="Placa Mãe">
            </nav>
            <!-- fim da nav bar-->
        </header>

       <section class="container-fluid vitrine">

            <div class="form-group" id="categorias">
                <label for="sel">Pesquisar por categoria:</label>
                <select class="form-control" id="sel">
                    <option value="" disabled selected hidden></option>
                    <option value="processador">Processadores</option>
                    <option value="placa">Placas</option>
            
                    <option value="memo">Memorias</option>
                </select>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <h3>Produtos</h3>
                </div>
            </div>
            <!-- /.row -->
            <!-- Page Features -->
            
            <jsp:useBean id="daoproduto" class="DAO.ProdutoDAO"/>
            
            <div class="row text-center">
            
                <c:forEach var="produto" items="${daoproduto.produtos}">
                    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                        <div class="thumbnail">
                            <img src="${produto.imagem}" alt="produto">
                            <div class="caption">
                                <h4>${produto.nome}</h4>
                               <c:if test = "${produto.quantidade > 0}">  
                                    
                                    <p class="precoProduto">R$ ${produto.valorunit}</p>
                                    <p>${produto.descricaoCurta}</p>
                                    <div>
                                        <a href="CarrinhoPage?codigo=${produto.codigo}" class="btn btn-primary">
                                            <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
                                        Adicionar
                                        </a> 
                                        <a href="Info?codigo=${produto.codigo}" class="btn btn-default">Mais Informações</a>
                                    </div>
                                    
                                </c:if>
                                    
                                <c:if test = "${produto.quantidade < 1}">  
                                    
                                    <p class="precoProduto">Produto não disponível</p>
                                    <p>${produto.descricaoCurta}</p>
                                    <div>
                                        
                                        <a href="Info?codigo=${produto.codigo}" class="btn btn-default">Mais Informações</a>
                                    </div>
                                    
                                </c:if>
                            </div>
                        </div>
                    </div>

                </c:forEach>
            
                <ul class="pagination">
                    <li class="active"><a href="#"> 1 </a></li>
                    <li><a href="#"> 2 </a></li>
                    <li><a href="#"> 3 </a></li>
                    <li><a href="#"> > </a></li>
                </ul>
            </div>

            

        </section>

        <footer class="container-fluid ">
            <a class="navbar-brand" href="#"><img src="img/logo.png" alt="logo"></a>
            <p>Endereço:<br/>
                Rua Dez, 560 -  Prazeres <br/>
                Jaboatão dos Guararapes - PE <br/>
            </p>
        </footer>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </body>
</html>
