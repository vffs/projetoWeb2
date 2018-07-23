<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Vitrine Informática</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="css/padrao.css">
        <link rel="stylesheet" href="css/index.css">
        <link rel="stylesheet" href="css/checkout.css">
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
                        <a class="navbar-brand" href="index.jsp"><img src="img/logo.png" alt="Vitrine Informática" id="logo"></a>
                    </div>

                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav navbar-left">
                            <li><a href="contato.jsp" id="linkcontato">Contato</a></li>
                            <li><a href="quem-somos.jsp" id="linkquemsomos">Quem Somos</a></li>
                            <li><a href="politica.jsp" id="linkpoliticas">Política do Site</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li class="active"><a href="CarrinhoPage" id="linkcarrinho"><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho <span class="badge">${carrinho.totalDeItens}</span></a></li>
                            <li><a href="cadastro.jsp" id="linkcadastrese"><span class="glyphicon glyphicon-user"></span> Cadastre-se</a></li>
                            <li><a href="login.jsp" id="linklogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                        </ul>
                    </div>
                </div>

                <img class="img-responsive" src="img/placamae.png" id="img" alt="Placa Mãe">
            </nav>
            <!-- fim da nav bar-->

        </header>

        <section>

            <h2>Carrinho</h2>
            <div class="table">          
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Cód.</th>
                            <th>Produto</th>
                            <th>Qtd</th>
                            <th>Valor</th>
                            <th>${carrinho.valorTotal}</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <td>Total:</td>
                            <td></td>
                            <td></td>
                            <td>${carrinho.valorTotal}</td>
                            <td></td>
                        </tr>
                    </tfoot>
                    <tbody>
                        
                        <c:forEach var="item" items="${carrinho.itens}">
                        
                            <tr>
                                <td style="width: 10%;">${item.produto.codigo}</td>
                                <td style="width: 20%;"><a href="infoproduto.jsp">${item.produto.nome}</a></td>
                                <td style="width: 30%;"><a href="IncrementarQuantidade?codigoProdutoIncrementado=${item.produto.codigo}"><button>+</button></a><input type="text" value="${item.quantidade}" style="width: 20%;" pattern="[0-9]+" ><a href="DecrementarQuantidade?codigoProdutoDecrementado=${item.produto.codigo}"><button>-</button></a></td>
                                <td style="width: 20%;">${item.subtotal}</td>
                                <td style="width: 10%;"><a href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                            </tr>
                        
                        </c:forEach>
                        
                    </tbody>
                </table>
                <small>É preciso estar logado para realizar a compra. Se não possui cadastro,
                    <a href="cadastro.jsp">cadastre-se</a>, ou <a href="login.jsp">logue-se</a>.
                </small>
                <br/>
                <a href="FinalizarCompra"><input type="submit" class="btn btn-primary" value="Finalizar"></a>
                <a href="CancelarCompra"><input type="submit" class="btn btn-danger" value="Cancelar"></a>
            </div>          
            
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        </section>

        <footer class="container-fluid ">
            <a class="navbar-brand" href="#"><img src="img/logo.png" alt="logo"></a>
            <p>Endereço:<br/>
                Rua Dez, 560 -  Prazeres <br/>
                Jaboatão dos Guararapes - PE <br/>
            </p>
        </footer>

    </body>
</html>
