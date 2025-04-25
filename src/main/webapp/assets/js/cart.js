let cart = [];

function addToCart(id, name, price) {
  const idx = cart.findIndex(item => item.coffeeId == id);
  if (idx !== -1) {
    cart[idx].quantity += 1;
  } else {
    cart.push({ coffeeId: id, name, price: Number(price), quantity: 1 });
  }
  renderCart();
}

function removeFromCart(coffeeId) {
  cart = cart.filter(item => item.coffeeId != coffeeId);
  renderCart();
}

function renderCart() {
  const area = document.getElementById('cart-area');
  area.innerHTML = '';

  if (cart.length === 0) {
    area.innerHTML = '<p class="cart-empty">장바구니가 비어있습니다.</p>';
    return;
  }

  cart.forEach(item => {
    const row = document.createElement('div');
    row.classList.add('cart-row');

    const info = document.createElement('div');
    info.classList.add('cart-info');

    const name = document.createElement('div');
    name.classList.add('name');
    name.textContent = item.name;

    const quantity = document.createElement('div');
    quantity.classList.add('quantity');
    quantity.textContent = `${item.quantity}개`;

    info.appendChild(name);
    info.appendChild(quantity);

    const delBtn = document.createElement('button');
    delBtn.classList.add('cart-btn');
    delBtn.textContent = '삭제';
    delBtn.onclick = () => removeFromCart(item.coffeeId);

    row.appendChild(info);
    row.appendChild(delBtn);

    area.appendChild(row);
  });

  const total = cart.reduce((sum, item) => sum + item.price * item.quantity, 0);

  const totalRow = document.createElement('div');
  totalRow.classList.add('cart-total');

  const totalLabel = document.createElement('div');
  totalLabel.textContent = '총 금액';

  const totalPrice = document.createElement('div');
  totalPrice.textContent = total + '원';

  totalRow.appendChild(totalLabel);
  totalRow.appendChild(totalPrice);
  area.appendChild(totalRow);
}

async function submitOrder() {
  if (cart.length === 0) {
    alert('장바구니가 비어있습니다.');
    return;
  }

  const orderData = {
    email: document.getElementById('email')?.value,
    address: document.getElementById('address').value,
    postcode: document.getElementById('postcode').value,
    cart: cart
  };

  try {
    const response = await fetch('/order', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'X-CSRF-TOKEN': csrfToken
      },
      body: JSON.stringify(orderData)
    });

    if (response.redirected) {
      window.location.href = response.url;
    } else if (response.ok) {
      alert('주문이 완료되었습니다.');
      location.href = '/coffee/order-result';
    } else {
      const message = await response.text();
      alert('주문 실패: ' + message);
    }
  } catch (e) {
    alert('에러 발생: ' + e.message);
  }
}

document.addEventListener("DOMContentLoaded", () => {
  cart = [];
  renderCart();
});
