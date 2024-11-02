package servelt;

import services.UserService;
import dao.UserDao;
import utils.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserRegistrationServlet", urlPatterns = {"/registerUser"})
public class UserRegistrationServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        try {
            UserDao userDao = new UserDao(DatabaseConnection.getConnection());
            userService = new UserService(userDao);
        } catch (Exception e) {
            throw new ServletException("Failed to initialize UserService", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters from the request
        String name = request.getParameter("user_name");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String villageId = request.getParameter("village_id"); // Assuming you will have a field for village ID

        try {
            // Call registerUser method
            userService.registerUser(name, password, role, villageId);

            // Redirect to success page
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            // Handle registration errors
            request.setAttribute("errorMessage", "Registration failed: " + e.getMessage());
            request.getRequestDispatcher("registerUser.jsp").forward(request, response);
        }
    }
}
