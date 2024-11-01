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

@WebServlet("/registerUser")
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
        String phone = request.getParameter("phoneNumber");
        String username = request.getParameter("name");
        String email = request.getParameter("email");
        String membershipType = request.getParameter("membershipType");

        try {
            // Call registerUser method
            userService.registerUser(phone, username, email, membershipType);

            // Redirect to success page
            response.sendRedirect("registrationSuccess.jsp");
        } catch (Exception e) {
            // Handle registration errors
            request.setAttribute("errorMessage", "Registration failed: " + e.getMessage());
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        }
    }
}
