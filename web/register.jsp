<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Register</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <div class="form-container">
    <h2>Create Account</h2>
    <form action="RegisterServlet" method="post">
      <label>Name</label>
      <input type="text" name="name" required>
      
      <label>Email</label>
      <input type="email" name="email" required>
      
      <label>Password</label>
      <input type="password" name="password" required>
      
      <label>Phone</label>
      <input type="text" name="phone">
      
      <button type="submit" class="btn primary">Register</button>
    </form>
    <p>Already have an account? <a href="login.jsp">Login</a></p>
  </div>
</body>
</html>
