
package servlet;

import DAO.DAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AddAccountServlet", urlPatterns = {"/addAccount"})
public class AddAccountServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addAccount.jsp").forward(request, response);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String account = request.getParameter("username");
        String password = request.getParameter("password");
        String re_password = request.getParameter("re_password");
        String fullname = request.getParameter("fullname");
        String role = request.getParameter("role");
        String status = request.getParameter("status");
        
        DAO dao = new DAO();
        dao.addAccount(account, password, fullname, role, status);   
        response.sendRedirect("account");
       
    }


    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
