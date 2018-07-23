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
                        <a class="navbar-brand" href="Indexlogado.jsp"><img src="img/logo.png" alt="Vitrine Informática" id="logo"></a>
                    </div>

                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span>
            <!-- nome do usuario-->${usuario.nome}
                                    </a>
                                
                                    <li><a href="CadastroProduto">Cadastrar Produto</a></li>
                                    <li><a href="GerenciarUsuarios">Gerenciar Usuários</a></li>
                                    <li><a href="ExibirCompras">Histórico de Compras</a></li>
                                    <li><a href="GerenciarProdutos">Gerenciar Produtos</a></li>
                                
                            </li>
                            <li><a href="Logout" id="linksair"><span class="glyphicon glyphicon-log-in"></span> Sair </a></li>
                        </ul>
                    </div>
                </div>

                <img class="img-responsive" src="img/placamae.png" id="img" alt="Placa Mãe">
            </nav>
            <!-- fim da nav bar-->
        </header>

      <section>
        <div class="container">
        <h2>Estoque</h2>

        <table class="table">
            
          <jsp:useBean id="produtodao" class="DAO.ProdutoDAO"/>  
            
          <tr>
            <th>ID</th>
            <th>Tipo</th>
            <th>Marca</th>
            <th>Preço</th>
            <th>Qtd Disponível</th>
            <th>Qtd Mínima</th>
            <th></th>
            <th></th>
          </tr>
          
            
          
            <c:forEach var="produto" items="${produtodao.produtos}">
                <tr class="produtotr alert" >
                    <td id="tdid${produto.idproduto}">${produto.idproduto}</td>
                    <td>${produto.tipo}</td>
                    <td>${produto.marca}</td>
                    <td>${produto.valorunit}</td>
                    <td id="tdquantidade${produto.idproduto}">${produto.quantidade}</td>
                    <td id="tdquantidademinima${produto.idproduto}">${produto.quantidadeMinima}</td>
                    <td><a href="EditarProduto?idproduto=${produto.idproduto}"><button>Editar</button></a></td>
                    <td><a href="DeletarProduto?idproduto=${produto.idproduto}"><button>Excluir</button></a></td>
              </tr>
          </c:forEach>
          
          
          </table>
          
        </div>
        
</section>     
          
          <script>
              
            var produtos = document.getElementsByClassName("produtotr");
    
            var quantidade, quantidadeMinima, positivo = 0;
    
            for (var i = 0; positivo < produtos.length; i++) {
                
                    var idComposto = "tdid" + i;
 
                    if(document.getElementById(idComposto) !== null) {
        
                        quantidade = parseInt(document.getElementById("tdquantidade" + i).innerHTML);

                        quantidadeMinima = parseInt(document.getElementById("tdquantidademinima" + i).innerHTML);

                        if (quantidade < quantidadeMinima) {

                            produtos[positivo].setAttribute('class', 'produtotr alert alert-danger');

                        }

                        else if (quantidade === quantidadeMinima) {

                            produtos[positivo].setAttribute('class', 'produtotr alert alert-warning');
                            
                        }
                        
                        else {
                            
                            produtos[positivo].setAttribute('class', 'produtotr alert alert-success');
                            
                        }
                    
                        positivo++;
                        
                    }
            }
              
          </script>    
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
