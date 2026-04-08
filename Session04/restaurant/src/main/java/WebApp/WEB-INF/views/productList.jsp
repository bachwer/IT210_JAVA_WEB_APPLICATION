<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Product List</title>
    <style>
        body {
            font-family: Arial;
            margin: 40px;
        }
        .box {
            border: 1px solid #ccc;
            padding: 20px;
            width: 300px;
            border-radius: 8px;
            background-color: #f9f9f9;
        }
        h2 {
            color: #333;
        }
    </style>
</head>
<body>

<div class="box">
    <h2>Kết quả tìm kiếm</h2>

    <p><strong>Category:</strong> ${category}</p>
    <p><strong>Limit:</strong> ${limit}</p>
    <p><strong>Message:</strong> ${message}</p>
</div>

</body>
</html>