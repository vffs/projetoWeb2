<%-- 
    Document   : editarusuarioconta
    Created on : 22/07/2018
    Author     : valeria
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
                        <a class="navbar-brand" href="Indexlogado"><img src="img/logo.png" alt="Vitrine Informática" id="logo"></a>
                    </div>

                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span>
            <!-- nome do usuario--> ${usuario.nome}
                                    </a>
                                 <li><a href="ContaUsuario?idusuario=${usuario.idusuario}">Conta</a></li>
                                    <li><a href="ComprasUsuario">Compras</a></li>
                                    <li class="active"><a href="Mensagem">Mensagens</a></li>
                                
                            </li>
                            <li><a href="Carrinhologado" id="linkcarrinho"><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho <span class="badge">${carrinho.itens.size()}</span></a></li>
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
                  
          <form action="ContaUsuario" method="POST">
              <h2>Editar Dados</h2>

              <select name="tipousuario">
                  <option value="PF">Pessoa Fisica</option>
                  <option value="PJ">Pessoa Juridica</option>
              </select>
                    
              
                   <div class="form-group">
                        <label for="nome" id="labelnome">Nome:</label>
                        <input type="text" class="form-control" name="nome" id="nome" maxlength="50" placeholder pattern="[a-zA-Z\s]+" value="${usuariosendoeditado.nome}" required>
                    </div>
                    <div class="form-group">
                        <label for="mail">E-mail:</label>
                        <input type="email" class="form-control" name="email" id="mail" maxlength="30" value="${usuariosendoeditado.email}" required>
                    </div>
                    <div class="form-group">
                        <label for="user">Usuário:</label>
                        <input type="text" class="form-control" name="user" id="user" maxlength="15" value="${usuariosendoeditado.login}" pattern="[a-zA-Z0-9]+" required>
                    </div>
                    <div class="form-group">
                        <label for="psw">Senha:</label>
                        <input type="password" class="form-control" name="senha" id="psw" maxlength="15" pattern="[A-Za-z0-9]*" value="${usuariosendoeditado.senha}" required>
                        <small>Letras maiúsculas, minúsculas e números. Máximo de 15 caracteres!</small>
                    </div> 
                    
                    <div class="form-group">
                        <label for="rua">Rua:</label>
                        <input type="text" class="form-control" name="rua" id="rua" maxlength="50" pattern="[A-Za-z\s]+" required value="Rua da Luz" value="${usuariosendoeditado.endereco.rua}">
                    </div>
                    <div class="form-group">
                        <label for="num">Nº:</label>
                        <input type="number" class="form-control" name="num" id="num" required value="${usuariosendoeditado.endereco.numero}">
                    </div>
			         
                    <div class="form-group">
                        <label for="comp">Complemento:</label>
                        <input type="text" class="form-control" name="comp" id="comp" maxlength="30" required value="perto da padaria" value="${usuariosendoeditado.endereco.complemento}">
                        <small>Ex.: Blobo B Apartamento 200</small>
                    </div>
			<div class="form-group">
                        <label for="cep">CEP:</label>
                        <input type="text" class="form-control" id="cep" name="cep" maxlength="10" pattern="[0-9]{5}-?[0-9]{3}" required value="${usuariosendoeditado.endereco.cep}">
                        <small>Ex.: 00000-000</small>
                    </div>     
                    <div class="form-group">
                        <label for="rua">Bairro:</label>
                        <input type="text" class="form-control" name="bairro" id="rua" maxlength="50" pattern="[A-Za-z\s]+" required value="${usuariosendoeditado.endereco.bairro}">
                    </div>           
                    <div class="form-group">
                        <label for="cidade">Cidade:</label>
                        <input type="text" class="form-control" name="cidade" id="cidade" maxlength="50" pattern="[A-Za-z\s]+" required value="${usuariosendoeditado.endereco.cidade}">
                    </div>
                    <div class="form-group">
                        <label for="estado">Estado:</label>
                        <input type="text" class="form-control" name="estado" id="estado" maxlength="50" pattern="[A-Za-z\s]+" required value="${usuariosendoeditado.endereco.estado}">
                    </div>      
                    <div class="form-group">
                        <label for="fone">Telefone Fixo:</label>
                        <input type="text" class="form-control" name="fone" id="fone" maxlength="13" pattern="[(?[0-9]{2})?[0-9]{4}-?[0-9]{4}]" value="${usuariosendoeditado.telefone.telefone}">
                        <small>Ex.: (00)0000-0000 </small>
                    </div>               
                    <div class="form-group">
                        <label for="cel">Celular:</label>
                        <input type="text" class="form-control" name="cel" id="cel" maxlength="14" value="${usuariosendoeditado.telefone.celular}">
                        <small>Ex.: (00)00000-0000 </small>
                    </div>
                    <button type="submit" class="btn btn-primary">Enviar</button>        
                    <button type="reset" class="btn btn-primary">Limpar</button> 
          
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
