<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register Location</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="container">
    <h2>Register Location</h2>
    <form action="registerLocation" method="POST">
        <label for="locationCode">Location Code:</label>
        <input type="text" id="locationCode" name="locationCode" required>

        <label for="locationName">Location Name:</label>
        <input type="text" id="locationName" name="locationName" required>

        <label for="locationType">Location Type:</label>
        <select id="locationType" name="locationType" required>
            <option value="Province">Province</option>
            <option value="District">District</option>
            <option value="Sector">Sector</option>
            <option value="Cell">Cell</option>
            <option value="Village">Village</option>
        </select>

        <button type="submit">Register Location</button>

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

