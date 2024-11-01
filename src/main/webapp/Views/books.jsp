<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Book</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Add Book</h1>
<form action="addBook" method="POST">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required>
    <label for="author">Author:</label>
    <input type="text" id="author" name="author" required>
    <label for="shelf_id">Shelf ID:</label>
    <input type="number" id="shelf_id" name="shelf_id" required>
    <button type="submit">Add Book</button>
</form>
</body>
</html>
