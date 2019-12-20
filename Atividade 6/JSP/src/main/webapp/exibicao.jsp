<%-- 
    Document   : exibicao
    Created on : 12/12/2019, 14:39:48
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
        <%
        if(session.getAttribute("timeInicial") == null){
           session.setAttribute("timeInicial", session.getLastAccessedTime());
        }

        long timeAtual = (System.currentTimeMillis() - (long) session.getAttribute("timeInicial")) /1000;
        if(timeAtual >= 15){
            response.sendRedirect("index.jsp");
        } else{
            String email = (String)session.getAttribute("email");
            out.print("<h1> " + email + " está logado no sistema há " + timeAtual + " segundos!</h1>");
        }
        %>
    </body>
    
</html>