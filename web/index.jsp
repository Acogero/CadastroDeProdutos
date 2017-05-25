<%-- 
    Document   : Página principal
    Created on : 22/05/2017, 15:51:42
    Author     : Marcos Vinicius A. Moreira
    E-mail     : louis.seipher@gmail.com
--%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Página principal</title>

    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Cadastro de Produtos</a>
            </div>
            
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a>
                <li><a href="#">Page 1</a>
                <li><a href="#">Page 2</a>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-log-out"></span>Sair</a></li>
            </ul>
        </div>
    </nav>
    
    <!-- DIREITA -->
    <div class="container-fluid">
        <div class="row content">
            <div class="col-sm-3">
                <div class="panel-body">
                    <form role="form" method="POST" action="ControleUsuario">
                        <fieldset>
                            <h3> Cadastro de Produto </h3>
                            <div class="form-group">
                                <input class="form-control" placeholder="Nome do produto" name="nome" type="text" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Quantidade" name="qtd" type="number" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Preço" name="preco" type="number" autofocus>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <input type="submit" class="btn btn-lg btn-success btn-block" value="Cadastrar"/>
                            <br>
                            <input type="hidden" name="acao" value="Cadastrar"/>
                        </fieldset>
                    </form>
                </div>
            </div>
            
            <!-- ESQUERDA -->
            <div class="col-sm-9">
                <h4><small>RECENT POSTS</small></h4>
                <hr>
                <h2>I Love Food</h2>
                <h5><span class="glyphicon glyphicon-time"></span> Post by Jane Dane, Sep 27, 2015.</h5>
                <h5><span class="label label-danger">Food</span> <span class="label label-primary">Ipsum</span></h5><br>
                <p>Food is my passion. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                <br><br>
            </div>
        </div>
    </div>
    
    
    
    <footer class="container-fluid">
        <p>Footer Text</p>
    </footer>
    
    <!-- Bootstrap Core JavaScript -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
