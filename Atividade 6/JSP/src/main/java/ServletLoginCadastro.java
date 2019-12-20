/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Adlla Katarine
 */
@WebServlet(urlPatterns = {"/ServletLoginCadastro"})
public class ServletLoginCadastro extends HttpServlet {

    Map<String, String> cadastro = new HashMap();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        if(request.getParameter("tipo").equalsIgnoreCase("Cadastrar")){
            if(!cadastro.containsKey(request.getParameter("email"))){
                cadastro.put(request.getParameter("email"), request.getParameter("senha"));
                response.sendRedirect("login.jsp");
            } else{
                PrintWriter out = response.getWriter();  
                out.println("<script type=\"text/javascript\">");  
                out.println("alert('Esta conta já existe. Tente novamente.');");  
                out.print("location.href = 'http://localhost:8080/JSP/index.jsp'");
                out.println("</script>");
            }
        } else{
            if(cadastro.containsKey(request.getParameter("email"))){
                if(cadastro.get(request.getParameter("email")).equals(request.getParameter("senha"))){
                    HttpSession session = request.getSession(true);
                    session.setAttribute("email", request.getParameter("email"));
                    response.sendRedirect("exibicao.jsp");
                } else{
                    PrintWriter out = response.getWriter();    
                    out.println("<script type=\"text/javascript\">");  
                    out.println("alert('Login ou senha inválidos. Tente novamente.');");  
                    out.print("location.href = 'http://localhost:8080/JSP/login.jsp'");
                    out.println("</script>");
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}