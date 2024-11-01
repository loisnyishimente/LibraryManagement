<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Check Books in Room</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Check Books in Room</h1>
<form action="CheckBooksServlet" method="post">
    <label for="room">Room:</label>
    <input type="text" id="room" name="room" required><br>

    <button type="submit">Check Books</button>
</form>
</body>
</html>
