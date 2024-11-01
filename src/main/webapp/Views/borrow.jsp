<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/styles.css">
    <title>Borrow Book</title>
</head>
<body>
<div class="container">
    <h2>Borrow Book</h2>
    <form action="borrowBook" method="POST">
        <label for="user_id">User ID:</label>
        <input type="text" id="user_id" name="user_id" required>

        <label for="book_id">Book ID:</label>
        <input type="text" id="book_id" name="book_id" required>

        <button type="submit">Borrow</button>
    </form>
    <c:if test="${not empty errorMessage}">
        <div class="error-message">${errorMessage}</div>
    </c:if>
</div>
</body>
</html>
