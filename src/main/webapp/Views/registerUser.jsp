<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/styles.css">
    <title>User Registration</title>
</head>
<body>
<div class="container">
    <h2>User Registration</h2>
    <form action="registerUser" method="POST">
        <label for="username">Username:</label>
        <input type="text" id="username" name="user_name" required> <!-- Updated name attribute to user_name -->

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <label for="role">Role:</label>
        <select id="role" name="role" required>
            <option value="librarian">Librarian</option>
            <option value="student">Student</option>
            <option value="teacher">admin</option>
        </select>

        <label for="villageId">Village ID:</label>
        <input type="text" id="villageId" name="village_id" required> <!-- Added village_id field -->

        <label for="membershipType">Membership Type:</label>
        <select id="membershipType" name="membershipType" required>
            <option value="Gold">Gold (5 books)</option>
            <option value="Silver">Silver (3 books)</option>
            <option value="Striver">Striver (2 books)</option>
        </select>

        <button type="submit">Register</button>
    </form>

    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
    <div style="color: red;">
        <p><%= errorMessage %></p>
    </div>
    <%
        }
    %>
</div>
</body>
</html>
