<%-- 
    Document   : cadastro
    Created on : 12/12/2019, 14:39:27
    Author     : Adlla Katarine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro Usando JSP</h1>
        <form action="ServletLoginCadastro" method="POST">
            Email:
            <input type="text" name="email"><br>
            Senha:
            <input type="password" name="senha"><br>
            <input type="submit" name="tipo" value="Cadastrar">
        </form>
    </body>
</html>
