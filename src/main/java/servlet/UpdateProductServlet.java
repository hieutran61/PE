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
import model.Product;

@MultipartConfig
@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/updateProduct"})
public class UpdateProductServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account a = (Account)session.getAttribute("a");
        if (a != null) 
        {
            String productId = request.getParameter("productId");
            DAO dao = new DAO();
            Product prduct = dao.getProduct(productId);
            request.setAttribute("pro", prduct);
            System.out.println("product: " + prduct);

            request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
        }
        else response.sendRedirect("login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        String quantity = request.getParameter("quantity");
        String price = request.getParameter("price");
        String image= "";
        
        String userCreate = request.getParameter("userCreate");
        //setting date
        long millis = System.currentTimeMillis();
        Date dateCreate = new Date(millis);
        
        Part part = request.getPart("image");
        //Upload Image
        String realPath = request.getServletContext().getRealPath("/images");
        System.out.println("Real path: " + realPath );  //Print real path
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        if (!fileName.equals(""))
        {
            if (!Files.exists(Paths.get(realPath)))
            {
                Files.createDirectory(Paths.get(realPath));
            }
            part.write(realPath + "/" + fileName);
            image = fileName;
        }
        
        
        System.out.println("Image " + image);  //print image name
        DAO dao = new DAO();
        dao.updateProduct(productId, productName, quantity, price, image, userCreate, dateCreate);
        response.sendRedirect("product");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
