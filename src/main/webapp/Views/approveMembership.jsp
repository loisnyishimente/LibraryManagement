<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Approve Membership</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Approve Membership Requests</h1>
<table>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Membership Type</th>
        <th>Action</th>
    </tr>
    <!-- Assume we have a list of pending memberships from the backend -->
    <tr>
        <td>John Doe</td>
        <td>john@example.com</td>
        <td>Gold</td>
        <td>
            <form action="ApproveMembershipServlet" method="post">
                <input type="hidden" name="userId" value="1">
                <button type="submit">Approve</button>
            </form>
        </td>
    </tr>
    <!-- Repeat for other members -->
</table>
</body>
</html>
