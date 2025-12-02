<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Tùy Chỉnh Sandwich</title>
  <style>
    /* VARIABLES (Tuỳ chỉnh màu dễ dàng hơn) */
    :root {
      --base-bg: #f5f7fa;        /* Nền Xám Xanh Pastel */
      --card-bg: #ffffff;        /* Nền Card trắng */
      --primary-color: #5d9cec;  /* Xanh Dương Pastel */
      --secondary-color: #ec87c0;/* Hồng Pastel */
      --text-color: #4a5568;     /* Màu chữ Xám đậm */
      --shadow-color: rgba(0, 0, 0, 0.08);
    }

    /* Thiết lập font chữ và căn giữa form */
    body {
      background-color: var(--base-bg);
      font-family: 'Open Sans', sans-serif;
      color: var(--text-color);
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: flex-start;
      min-height: 100vh;
    }

    .sandwich-form {
      max-width: 700px; /* Tăng chiều rộng để chứa Grid */
      width: 90%;
      margin: 40px auto;
      padding: 30px;
      border: none;
      border-radius: 15px;
      background-color: var(--card-bg);
      box-shadow: 0 15px 30px var(--shadow-color);
    }

    /* Tiêu đề chính */
    .sandwich-form h2 {
      text-align: center;
      color: var(--primary-color);
      margin-bottom: 35px;
      font-weight: 700;
      font-size: 2em;
    }

    /* Container cho các Card Gia vị */
    .category-container {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(280px, 1fr)); /* Bố cục Grid linh hoạt */
      gap: 25px;
    }

    /* Card Gia vị (Thay thế Fieldset) */
    .category-card {
      padding: 20px;
      border: 1px solid #e0e0e0;
      border-radius: 10px;
      background-color: #fcfcfc;
      transition: box-shadow 0.3s, border-color 0.3s;
    }
    .category-card:hover {
      box-shadow: 0 5px 15px rgba(93, 156, 236, 0.15);
      border-color: var(--primary-color);
    }

    /* Tiêu đề Card (Thay thế Legend) */
    .category-card h3 {
      font-size: 1.2em;
      font-weight: bold;
      margin-top: 0;
      margin-bottom: 15px;
      color: var(--secondary-color); /* Màu Hồng */
      border-bottom: 2px solid var(--secondary-color);
      padding-bottom: 5px;
    }

    /* Nhãn cho Checkbox */
    .sandwich-form label {
      display: flex;
      align-items: center;
      margin-bottom: 10px;
      cursor: pointer;
      padding: 5px 0;
      border-radius: 3px;
      transition: background-color 0.2s;
    }

    /* Checkbox input */
    .sandwich-form input[type="checkbox"] {
      margin-right: 12px;
      width: 16px;
      height: 16px;
      accent-color: var(--primary-color);
      border: 1px solid var(--primary-color);
      box-shadow: 0 0 0 1px var(--primary-color);
      transition: box-shadow 0.1s;
    }

    /* Tùy chọn con (Sub-options) */
    .sub-options {
      border-left: 3px solid #d2e4f8; /* Đường kẻ phân biệt */
      padding-left: 15px;
      margin-top: 5px;
      margin-bottom: 10px;
    }

    .sub-label {
      font-size: 0.9em;
      color: var(--text-color);
      margin-left: 10px;
    }

    /* Nút Submit */
    .submit-btn {
      display: block;
      width: 100%;
      padding: 14px;
      margin-top: 30px;
      background-color: var(--primary-color);
      color: white;
      border: none;
      border-radius: 8px;
      font-size: 1.1em;
      font-weight: bold;
      cursor: pointer;
      transition: background-color 0.3s, transform 0.2s, box-shadow 0.3s;
    }

    .submit-btn:hover {
      background-color: #4a89dc;
      box-shadow: 0 5px 15px rgba(93, 156, 236, 0.4);
      transform: translateY(-2px);
    }

    .submit-btn:active {
      background-color: #3b76a0;
      transform: translateY(0);
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
    }
  </style>
</head>
<body>
<form action="add" method="post" class="sandwich-form">
  <h2>🥪 Tùy Chỉnh Sandwich Theo Sở Thích</h2>

  <div class="category-container">

    <div class="category-card">
      <h3>🥫 1. Sốt và Phết (Sauces & Spreads)</h3>

      <label><input type="checkbox" name="sauces" value="mayonnaise"> Mayonnaise</label>
      <label><input type="checkbox" name="sauces" value="ketchup"> Ketchup (Tương cà)</label>
      <label><input type="checkbox" name="sauces" value="chili-sauce"> Chili Sauce (Tương ớt)</label>

      <div class="sub-options">
        <label><input type="checkbox" name="sauces" value="mustard"> Mustard (Mù tạt)</label>
        <label class="sub-label"><input type="checkbox" name="sauces" value="dijon"> → Dijon Mustard</label>
        <label class="sub-label"><input type="checkbox" name="sauces" value="honey-mustard"> → Honey Mustard</label>
      </div>

      <label><input type="checkbox" name="sauces" value="pesto"> Pesto (Sốt Pesto)</label>
    </div>

    <div class="category-card">
      <h3>🥬 2. Rau củ và Thảo mộc (Veggies & Herbs)</h3>

      <label><input type="checkbox" name="veggies" value="lettuce"> Lettuce (Xà lách)</label>
      <label><input type="checkbox" name="veggies" value="tomato"> Tomato (Cà chua)</label>
      <label><input type="checkbox" name="veggies" value="pickles"> Pickles (Dưa chuột muối)</label>
      <label><input type="checkbox" name="veggies" value="jalapenos"> Jalapeños (Ớt Jalapeño)</label>
      <label><input type="checkbox" name="veggies" value="red-onion"> Red Onion (Hành tây đỏ)</label>
    </div>

    <div class="category-card">
      <h3>✨ 3. Gia vị Khác (Other Seasonings)</h3>

      <label><input type="checkbox" name="seasoning" value="salt"> Salt (Muối)</label>
      <label><input type="checkbox" name="seasoning" value="pepper"> Black Pepper (Tiêu đen)</label>
      <label><input type="checkbox" name="seasoning" value="olive-oil"> Olive Oil (Dầu ô liu)</label>
    </div>

  </div> <button type="submit" class="submit-btn">Hoàn tất Đặt Sandwich</button>
</form>
</body>
</html>