<%-- 
    Document   : index
    Created on : 12/12/2019, 14:39:15
    Author     : Adlla Katarine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        <%
        String mensagem = null;
        if(request.isRequestedSessionIdValid() == false){
           mensagem = "O que você deseja?";
        }else{
            session.invalidate();
            mensagem = "Seu tempo expirou. Por favor, faça o login novamento ou se cadastre!";
        }
        out.print("<p>" + mensagem + "</p>");
        %>
        
        <p><a href="cadastro.jsp">Fazer Cadastro</a></p>
        <p><a href="login.jsp">Fazer Login</a></p>