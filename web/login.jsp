<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <div class="form-container">
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
      <label>Email</label>
      <input type="email" name="email" required>
      
      <label>Password</label>
      <input type="password" name="password" required>
      
      <button type="submit" class="btn primary">Login</button>
    </form>
    <p>Don?t have an account? <a href="register.jsp">Register</a></p>
  </div>
</body>
</html>
