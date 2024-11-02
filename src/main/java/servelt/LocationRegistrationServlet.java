package servelt;

import services.LocationService;
import dao.LocationDao;
import utils.DatabaseConnection;
import model.Location;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LocationRegistrationServlet", urlPatterns = {"/registerLocation"})
public class LocationRegistrationServlet extends HttpServlet {
    private LocationService locationService;

    @Override
    public void init() throws ServletException {
        try {
            LocationDao locationDao = new LocationDao(DatabaseConnection.getConnection());
            locationService = new LocationService(locationDao);
        } catch (Exception e) {
            throw new ServletException("Failed to initialize LocationService", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String parentIdParam = request.getParameter("parent_id"); // Make sure the parameter name matches your form

            // Check if the parameter is not null and is a valid integer
            Integer parentId = null;
            if (parentIdParam != null && !parentIdParam.isEmpty()) {
                parentId = Integer.parseInt(parentIdParam); // This is where the exception occurs if parentIdParam is null or empty
            }
            response.sendRedirect("success.jsp");
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid parent ID format. Please provide a valid number.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}
