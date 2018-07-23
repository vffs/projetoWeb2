<%-- 
    Document   : editarproduto
    Created on : 04/07/2017, 00:02:56
    Author     : proto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Vitrine Informática</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="css/padrao.css">
        <link rel="stylesheet" href="css/forms.css">
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
            <!-- nome do usuario--> ${usuario.nome}
                                    <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="CadastroProduto">Cadastrar Produto</a></li>
                                    <li><a href="GerenciarUsuarios">Gerenciar Usuários</a></li>
                                    <li><a href="ExibirCompras">Histórico de Compras</a></li>
                                    <li><a href="GerenciarProdutos">Gerenciar Produtos</a></li>
                                </ul>
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
          <div class="container-fluid">   
                  
          <form action="EditarProduto" method="POST">
              <h2>Editar Produto</h2>
              <div class="form-group">
               <label for="nome" id="labelnome">Nome do Produto:</label>
               <input type="text" class="form-control" name="nome" id="nome" maxlength="50" placeholder pattern="[a-zA-Z\s]+" value="${produtosendoeditado.nome}" required>
              </div>
              <div class="form-group">
               <label for="preco" id="labelnome">Preço:</label>
               <input type="text" class="form-control" name="preco" id="preco" value="${produtosendoeditado.valorunit}" required>
              </div>  
              <div class="form-group">
               <label for="desconto" id="labelnome">Desconto:</label>
               <input type="text" class="form-control" name="desconto" id="desconto" value="${produtosendoeditado.desconto}" required>
              </div>
              <div class="form-group">
               <label for="codigo" id="labelnome">Código do Produto:</label>
               <input type="text" class="form-control" name="codigo" id="codigo"  value="${produtosendoeditado.codigo}" required>
              </div>
              <div class="form-group">
               <label for="tipo" id="labelnome">Tipo:</label>
               <input type="text" class="form-control" name="tipo" id="tipo" maxlength="50" placeholder pattern="[a-zA-Z\s]+" value="${produtosendoeditado.tipo}" required>
              </div>
              <div class="form-group">
               <label for="marca" id="labelnome">Marca:</label>
               <input type="text" class="form-control" name="marca" id="marca" maxlength="50" placeholder pattern="[a-zA-Z\s]+" value="${produtosendoeditado.marca}" required>
              </div> 
              <div class="form-group">
               <label for="descricao" id="labelnome">Descrição:</label>
               <input type="text" class="form-control" name="descricao" id="descricao" maxlength="200"  value="${produtosendoeditado.descricao}" required>
              </div> 
              <div class="form-group">
               <label for="descricaoCurta" id="labelnome">Descrição Curta:</label>
               <input type="text" class="form-control" name="descricaocurta" id="descricaocurta" value="${produtosendoeditado.descricaoCurta}" maxlength="50" placeholder pattern="[a-zA-Z\s]+" required>
              </div> 
              <div class="form-group">
               <label for="quantidade" id="labelnome">Quantidade:</label>
               <input type="text" class="form-control" name="quantidade" id="quantidade" value="${produtosendoeditado.quantidade}" required>
              </div> 
              <div class="form-group">
               <label for="quantidadeMinima" id="labelnome">Quantidade Mínima:</label>
               <input type="text" class="form-control" name="quantidadeMinima" id="quantidade" value="${produtosendoeditado.quantidadeMinima}" required>
              </div> 
              <div class="form-group">
               <label for="imagem" id="labelnome">Imagem:</label>
               <input type="file" class="form-control" name="imagem" id="imagem" required>
              </div>
              <button type="submit" class="btn btn-primary">Editar Produto</button> 
          
          </form>
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
