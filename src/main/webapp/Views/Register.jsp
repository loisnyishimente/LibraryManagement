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
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="phoneNumber">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <label for="membershipType">Membership Type:</label>
        <select id="membershipType" name="membershipType" required>
            <option value="Gold">Gold (5 books)</option>
            <option value="Silver">Silver (3 books)</option>
            <option value="Striver">Striver (2 books)</option>
        </select>

        <button type="submit">Register</button>
    </form>

</div>
</body>
</html>
