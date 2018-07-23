<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Vitrine Informática</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="css/forms.css">
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
                        <a class="navbar-brand" href="index.jsp"><img src="img/logo.png" alt="Vitrine Informática" id="logo"></a>
                    </div>

                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav navbar-left">
                            <li class="active"><a href="contato.jsp" id="linkcontato">Contato</a></li>
                            <li><a href="quem-somos.jsp" id="linkquemsomos">Quem Somos</a></li>
                            <li><a href="politica.jsp" id="linkpoliticas">Política do Site</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="carrinho.jsp" id="linkcarrinho"><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho <span class="badge">${carrinho.totalDeItens}</span></a></li>
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
            <div class="container-fluid">

                <form action="Contato" method="post">
                    <h2>Contato</h2>
                    <small style="color:green">${alerta}</small>
                    <div class="form-group">
                        
                        <label for="nome">Nome:</label>
                        <input type="text" class="form-control" name="nome" placeholder="Informe seu nome..." maxlength="50" pattern="[a-zA-Z\s]+" required>
                    </div>
                    <div class="form-group">
                        <label for="mail">E-mail:</label>
                        <input type="email" class="form-control" name="email" placeholder="Informe seu E-mail..." maxlength="30" required>
                    </div>
                    <div class="form-group">
                        <label for="assunto">Assunto:</label>
                        <input type="text" class="form-control" name="assunto" placeholder="Informe seu E-mail..." maxlength="30" required>
                    </div>
                    <div class="form-group">
                        <label for="msg">Mensagem:</label>
                        <textarea class="form-control" name="msg" rows="5" placeholder="Digite sua mensagem..." required></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Enviar</button>        
                    <button type="reset" class="btn btn-primary">Limpar</button>
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
