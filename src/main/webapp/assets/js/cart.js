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
    area.innerHTML = '<p>장바구니가 비어있습니다.</p>';
    return;
  }

  cart.forEach(item => {
    const row = document.createElement('div');
    row.className = 'row mb-2 align-items-center';

    // 상품 이름
    const nameCol = document.createElement('div');
    nameCol.className = 'col-7';
    nameCol.textContent = item.name;

    // 수량
    const qtyCol = document.createElement('div');
    qtyCol.className = 'col-2';
    qtyCol.textContent = item.quantity + '개';

    // 삭제 버튼
    const btnCol = document.createElement('div');
    btnCol.className = 'col-3 text-end';

    const delBtn = document.createElement('button');
    delBtn.className = 'btn btn-sm btn-outline-danger';
    delBtn.textContent = '삭제';
    delBtn.onclick = () => removeFromCart(item.coffeeId);

    btnCol.appendChild(delBtn);

    row.appendChild(nameCol);
    row.appendChild(qtyCol);
    row.appendChild(btnCol);

    area.appendChild(row);
  });

  // 총 금액 출력
  const total = cart.reduce((sum, i) => sum + i.price * i.quantity, 0);

  const totalRow = document.createElement('div');
  totalRow.className = 'row border-top pt-2';

  const totalLabelCol = document.createElement('div');
  totalLabelCol.className = 'col';
  totalLabelCol.innerHTML = '<b>총 금액</b>';

  const totalPriceCol = document.createElement('div');
  totalPriceCol.className = 'col text-end';
  totalPriceCol.textContent = total + '원';

  totalRow.appendChild(totalLabelCol);
  totalRow.appendChild(totalPriceCol);
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