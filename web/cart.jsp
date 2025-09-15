<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Cart</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <main class="container">
    <h2>Your Cart</h2>
    <table class="cart-table">
      <thead>
        <tr>
          <th>Product</th><th>Price</th><th>Qty</th><th>Subtotal</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Product 1</td>
          <td>?999</td>
          <td><input type="number" value="1" min="1"></td>
          <td>?999</td>
        </tr>
        <tr>
          <td>Product 2</td>
          <td>?1,299</td>
          <td><input type="number" value="2" min="1"></td>
          <td>?2,598</td>
        </tr>
      </tbody>
    </table>
    <p class="total">Total: ?3,597</p>
    <a href="checkout.jsp" class="btn primary">Proceed to Checkout</a>
  </main>
</body>
</html>
