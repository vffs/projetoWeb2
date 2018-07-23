<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Vitrine Informática</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="css/descricao.css">
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
                            <li><a href="contato.jsp" id="linkcontato">Contato</a></li>
                            <li><a href="quem-somos.jsp" id="linkquemsomos">Quem Somos</a></li>
                            <li  class="active"><a href="politica.html" id="linkpoliticas">Política do Site</a></li>
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

            <h2>Política do Site</h2>
            <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut lobortis, nisi vel varius posuere, elit turpis efficitur elit, ut aliquam dolor purus a quam. Nunc non fringilla diam. Maecenas sed urna nisi. Pellentesque maximus, libero a sodales sollicitudin, leo dolor consectetur nisi, et commodo sem libero quis nulla. Nam bibendum, arcu non euismod lacinia, tellus sem dignissim quam, ut pellentesque metus metus eget tellus. Nam varius arcu sit amet lorem sollicitudin mollis. Fusce hendrerit, leo in dictum placerat, urna mi dictum tortor, vel ullamcorper est eros aliquam velit. Phasellus bibendum vestibulum efficitur. Sed viverra lobortis felis sed volutpat. Curabitur interdum massa et tristique finibus. Nunc vel porttitor est. Duis imperdiet augue ut scelerisque rutrum. Fusce in tortor et metus suscipit ultricies a non orci. Praesent ornare rhoncus justo vitae maximus. Sed id accumsan nunc, vitae vulputate neque. Aliquam vitae ex lacus.</p>
            <p>Etiam bibendum nisi nunc. Nunc pellentesque augue at risus tincidunt lobortis. Duis ac erat sed leo dictum vestibulum. Vivamus sed lorem diam. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris laoreet arcu euismod nibh placerat dapibus. Phasellus accumsan volutpat malesuada. Aenean non orci porttitor, dignissim dui at, tincidunt ante. Maecenas ut tortor non nibh hendrerit fringilla lacinia non tellus. Aliquam est quam, tristique ut ornare vel, pulvinar ac ipsum. Nullam sit amet dui interdum, vulputate urna porttitor, lacinia ligula. Quisque tristique, nisl in aliquet sollicitudin, lectus mauris rhoncus ante, quis rutrum ligula ante nec magna. Ut a molestie arcu. Donec sit amet augue sit amet erat aliquam porta vel et nisi. Nam a porttitor purus, sed porta mauris.
            </p>

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
