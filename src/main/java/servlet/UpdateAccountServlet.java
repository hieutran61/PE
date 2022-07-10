
package servlet;

import DAO.DAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

@WebServlet(name = "UpdateAccountServlet", urlPatterns = {"/updateAccount"})
public class UpdateAccountServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account a = (Account)session.getAttribute("a");
        if (a != null) 
        {
            String username = request.getParameter("username");
            DAO dao = new DAO();
            Account acc = dao.getAccount(username);
            request.setAttribute("acc", acc);

            request.getRequestDispatcher("updateAccount.jsp").forward(request, response);
        }
        else response.sendRedirect("login");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String role = request.getParameter("role");
        String status = request.getParameter("status");
        System.out.println("begin UPDATEACCOUNT");
        
        DAO dao = new DAO();
        dao.updateAccount(username, password, fullname, role, status);   
        response.sendRedirect("account");
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
