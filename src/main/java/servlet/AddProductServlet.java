package servlet;

import DAO.DAO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Account;


@MultipartConfig
@WebServlet(name = "AddProductServlet", urlPatterns = {"/addProduct"})
public class AddProductServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account a = (Account)session.getAttribute("a");
        if (a != null) 
        {
            request.getRequestDispatcher("addProduct.jsp").forward(request, response);
        }
        else response.sendRedirect("login");
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productName = request.getParameter("productName");
        String quantity = request.getParameter("quantity");
        String price = request.getParameter("price");
        String image="";
        String userCreate = request.getParameter("userCreate");
        //setting date
        long millis = System.currentTimeMillis();
        Date dateCreate = new Date(millis);
                
        Part part = request.getPart("image");
        //Upload Image
        String realPath = request.getServletContext().getRealPath("/images");
        System.out.println("Real path: " + realPath );  //Print real path
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();

        if (!Files.exists(Paths.get(realPath)))
        {
            Files.createDirectory(Paths.get(realPath));
        }

        part.write(realPath + "/" + fileName);

        image = fileName;
        System.out.println(image);  //print image name
        DAO dao = new DAO();
        dao.addProduct(productName, quantity, price, image, userCreate, dateCreate);
        response.sendRedirect("product");
        
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
