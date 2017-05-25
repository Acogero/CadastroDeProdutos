<%-- 
    Document   : P�gina principal
    Created on : 22/05/2017, 15:51:42
    Author     : Marcos Vinicius A. Moreira
    E-mail     : louis.seipher@gmail.com
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Produto"%>
<%@page import="DAO.ProdutoDAO"%>
<%@page import="DAO.IProduto"%>
<% 
    IProduto dao = new ProdutoDAO();
    Produto p = new Produto();
    List<Produto> listaProdutos = dao.read();
%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>P�gina principal</title>

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
            <!--
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a>
                <li><a href="#">Page 1</a>
                <li><a href="#">Page 2</a>
            </ul>
            -->
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-log-out"></span>Sair</a></li>
            </ul>
        </div>
    </nav>
    
    <!-- ESQUERDA -->
    <div class="container-fluid">
        <div class="row content">
            <div class="col-sm-3">
                <div class="panel-body">
                    <form role="form" method="POST" action="ControleProduto">
                        <fieldset>
                            <h3> Cadastro de Produto </h3>
                            <div class="form-group">
                                <input class="form-control" placeholder="Nome do produto" name="nome" type="text" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Quantidade" name="qtd" type="number" autofocus>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Pre�o" name="preco" autofocus>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <input type="submit" class="btn btn-lg btn-success btn-block" value="Cadastrar"/>
                            <br>
                            <input type="hidden" name="acao" value="Cadastrar"/>
                        </fieldset>
                    </form>
                </div>
            </div>
            
            <!-- DIREITA -->
            <div class="col-sm-4 well">
                <h3><center>Todos os produtos</center></h3>
                <% for(Produto j: listaProdutos){ %>
                <tr>                    
                    <td>C�digo: <%=j.getIdProduto()%></td><br>
                    <td>Nome: <%=j.getNome()%> </td><br>
                    <td>Quantidade: <%=j.getQuantidade()%></td><br>
                    <td>Pre�o:<%=j.getPreco()%></td><br>
                    <td>------------------------------------------</td><br>
                <%}%>
                </tr>
            </div>
        </div>
    </div>
    
    
    
    <footer class="container-fluid well">
        <p>Posted by: Acogero Vinicius</p>
        <p>Contact information: <a href="mailto:louis.seipher@gmail.com">louis.seipher@gmail.com</a>.</p>
    </footer>
    
    <!-- Bootstrap Core JavaScript -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
