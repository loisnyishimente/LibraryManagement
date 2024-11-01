package servelt;

import model.Book;
import services.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookService(); // Initialize your book service
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            int availableCount = Integer.parseInt(request.getParameter("availableCount"));

            Book book = new Book(0, title, author, availableCount); // ID generation should be handled
            bookService.addBook(book);
            response.sendRedirect("home.jsp"); // Redirect to home page after adding
        }
    }
}
