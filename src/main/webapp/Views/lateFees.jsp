<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Late Fees Management</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Late Fees Management</h1>
<form action="LateFeesServlet" method="post">
    <label for="bookId">Book ID:</label>
    <input type="text" id="bookId" name="bookId" required><br>

    <label for="daysLate">Days Late:</label>
    <input type="number" id="daysLate" name="daysLate" required><br>

    <button type="submit">Calculate Fee</button>
</form>
</body>
</html>
