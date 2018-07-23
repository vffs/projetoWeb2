<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                        <a class="navbar-brand" href="../index.jsp"><img src="img/logo.png" alt="Vitrine Informática" id="logo"></a>
                    </div>

                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav navbar-left">
                            <li><a href="contato.jsp" id="linkcontato">Contato</a></li>
                            <li><a href="quem-somos.jsp" id="linkquemsomos">Quem Somos</a></li>
                            <li><a href="politica.jsp" id="linkpoliticas">Política do Site</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="carrinho.jsp" id="linkcarrinho"><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho <span class="badge">${carrinho.totalDeItens}</span></a></li>
                            <li class="active"><a href="cadastro.jsp" id="linkcadastrese"><span class="glyphicon glyphicon-user"></span> Cadastre-se</a></li>
                            <li><a href="login.jsp" id="linklogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                        </ul>
                    </div>
                </div>

                <img class="img-responsive" src="img/placamae.png" id="img" alt="Placa Mãe">
            </nav>
            <!-- fim da nav bar-->

        </header>

        <section>

            <div class="container-fluid">

                <form action="#" method="post" >
                    <h2>Confira os seus dados</h2>
                    
                    <label class="radio-inline">
                        <input type="radio" name="opt" id="pf" onchange="document.getElementById('inputcpf').style.display = 'block';
                                document.getElementById('inputcnpj').style.display = 'none';
                                document.getElementById('labelnome').innerHTML='Nome'" checked="checked">Pessoa Física
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="opt" id="pj" onchange="document.getElementById('inputcpf').style.display = 'none';
                                document.getElementById('inputcnpj').style.display = 'block';
                                document.getElementById('labelnome').innerHTML='Razão Social'">Pessoa Jurídica
                    </label> 
             
                    <div class="form-group" id="inputcpf">
                        <label for="cpf">CPF:</label>
                        <input type="text" class="form-control" name="cpf" id="cpf"  maxlength="14" pattern="[0-9]{3}.?[0-9]{3}.?[0-9]{3}-?[0-9]{2}">
                        <small>Ex.: 000.000.000-00</small>
                    </div>                                   
                   <div class="form-group" id="inputcnpj" style="display: none">
                        <label for="cnpj">CNPJ:</label>
                        <input type="text" class="form-control" name="cnpj" id="cnpj"   maxlength="18" pattern="[0-9]{2}.?[0-9]{3}.?[0-9]{3}/?[0-9]{4}-?[0-9]{2}">
                        <small>Ex.: 00.000.000/0000-00</small>
                    </div>
                    <div class="form-group">
                        <label for="nome" id="labelnome">Nome:</label>
                        <input type="text" class="form-control" name="nome" id="nome" value="${usuario.nome}" maxlength="50" pattern="[a-zA-Z\s]+" required>
                    </div>
                   <div class="form-group">
                        <label for="mail">E-mail:</label>
                        <input type="email" class="form-control" name="email" id="mail" maxlength="30" value="${usuario.email}" required>
                    </div>
                    <div class="form-group">
                        <label for="user">Usuário:</label>
                        <input type="text" class="form-control" name="user" id="user" maxlength="15" value="${usuario.login}" pattern="[a-zA-Z0-9]+" required>
                    </div>
                    <div class="form-group">
                        <label for="psw">Senha:</label>
                        <input type="password" class="form-control" name="senha" value="${usuario.senha}" id="psw" maxlength="15" pattern="[A-Za-z0-9]*" required>
                        <small>Letras maiúsculas, minúsculas e números. Máximo de 15 caracteres!</small>
                    </div>                 
                    <div class="form-group">
                        <label for="rua">Rua:</label>
                        <input type="text" class="form-control" name="rua" id="rua" maxlength="50" value="${endereco.rua}" pattern="[A-Za-z\s]+" required>
                    </div>
                    <div class="form-group">
                        <label for="num">Nº:</label>
                        <input type="number" class="form-control" name="num" id="num" required value="${endereco.numero}">
                    </div>
			         
                    <div class="form-group">
                        <label for="comp">Complemento:</label>
                        <input type="text" class="form-control" name="comp" id="comp" maxlength="30"  value="${endereco.complemento}" required>
                        <small>Ex.: Blobo B Apartamento 200</small>
                    </div>
			<div class="form-group">
                        <label for="cep">CEP:</label>
                        <input type="text" class="form-control" id="cep" name="cep" maxlength="10" value="${endereco.cep}" pattern="[0-9]{5}-?[0-9]{3}" required>
                        <small>Ex.: 00000-000</small>
                    </div>     
                    <div class="form-group">
                        <label for="rua">Bairro:</label>
                        <input type="text" class="form-control" name="bairro" id="rua" maxlength="50" value="${endereco.bairro}" pattern="[A-Za-z\s]+" required>
                    </div>           
                    <div class="form-group">
                        <label for="cidade">Cidade:</label>
                        <input type="text" class="form-control" name="cidade" id="cidade" maxlength="50" value="${endereco.cidade}" pattern="[A-Za-z\s]+" required>
                    </div>
                    <div class="form-group">
                        <label for="estado">Estado:</label>
                        <input type="text" class="form-control" name="estado" id="estado" maxlength="50" value="${endereco.estado}" pattern="[A-Za-z\s]+" required>
                    </div>      
                    <div class="form-group">
                        <label for="fone">Telefone Fixo:</label>
                        <input type="text" class="form-control" name="fone" id="fone" maxlength="13" value="${telefone.telefone}" pattern="[(?[0-9]{2})?[0-9]{4}-?[0-9]{4}]">
                        <small>Ex.: (00)0000-0000 </small>
                    </div>               
                    <div class="form-group">
                        <label for="cel">Celular:</label>
                        <input type="text" class="form-control" name="cel" id="cel" maxlength="14" value="${telefone.celular}" pattern="[(?[0-9]{2})?[0-9]{5}-?[0-9]{4}]">
                        <small>Ex.: (00)00000-0000 </small>
                    </div> 
                    <button type="submit" class="btn btn-primary">Alterar</button>        
                    <a href="login.jsp"><button type="button" class="btn btn-primary">Confirmar</button></a>
                </form>

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
