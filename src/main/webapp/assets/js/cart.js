function addToCart(coffeeId) {
  fetch('/cart/add?id=' + coffeeId)
  .then(res => res.text())
  .then(result => {
    if (result === 'success') {
      loadCart(); // 장바구니 다시 불러오기
    } else {
      alert("상품을 추가할 수 없습니다.");
    }
  });
}

function removeFromCart(coffeeId) {
  fetch(`/cart/remove?id=${coffeeId}`)
  .then(res => res.text())
  .then(result => {
    if (result === 'success') {
      loadCart();
    } else {
      alert('삭제에 실패했습니다.');
    }
  });
}


function loadCart() {
  fetch('/cart/data')
  .then(res => res.json())
  .then(data => {
    const cartArea = document.getElementById('cart-area');
    cartArea.innerHTML = '';

    // 장바구니 항목 출력
    data.cartItems.forEach(item => {
      const row = document.createElement('div');
      row.className = 'row mb-2';

      const nameCol = document.createElement('div');
      nameCol.className = 'col-8';
      nameCol.textContent = item.name;

      const quantityCol = document.createElement('div');
      quantityCol.className = 'col-3';
      quantityCol.textContent = item.quantity + '개';

      const deleteCol = document.createElement('div');
      deleteCol.className = 'col-3 text-end';

      const delBtn = document.createElement('button');
      delBtn.className = 'btn btn-sm btn-outline-danger';
      delBtn.textContent = '삭제';
      delBtn.onclick = () => removeFromCart(item.coffeeId);
      deleteCol.appendChild(delBtn);

      row.appendChild(nameCol);
      row.appendChild(quantityCol);
      row.appendChild(deleteCol);
      cartArea.appendChild(row);
    });


    // 총금액 출력
    const totalRow = document.createElement('div');
    totalRow.className = 'row pt-2 pb-2 border-top';

    const labelCol = document.createElement('div');
    labelCol.className = 'col';
    labelCol.innerHTML = `<h5>총금액</h5>`;

    const priceCol = document.createElement('div');
    priceCol.className = 'col text-end';
    priceCol.textContent = data.totalPrice + '원';

    totalRow.appendChild(labelCol);
    totalRow.appendChild(priceCol);
    cartArea.appendChild(totalRow);
  });
}

document.addEventListener("DOMContentLoaded", loadCart);