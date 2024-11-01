<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Location Management</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1>Create Location</h1>
<form action="LocationController" method="post">
    <label for="province">Province:</label>
    <input type="text" id="province" name="province" required>

    <label for="district">District:</label>
    <input type="text" id="district" name="district" required>

    <label for="sector">Sector:</label>
    <input type="text" id="sector" name="sector" required>

    <label for="cell">Cell:</label>
    <input type="text" id="cell" name="cell" required>

    <label for="village">Village:</label>
    <input type="text" id="village" name="village" required>

    <input type="submit" value="Create Location">
</form>
</body>
</html>
