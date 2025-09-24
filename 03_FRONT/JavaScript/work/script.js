// 요소 선택
const descriptionInput = document.getElementById('input-description');
const amountInput = document.getElementById('input-amount');
const typeButtons = document.querySelectorAll('.choose-buttons button');
const addButton = document.querySelector('.add-btn button');
const list = document.getElementById('cost-list');

const incomeDisplay = document.querySelector('.income .money');
const expenseDisplay = document.querySelector('.cost .money-cost');
const balanceDisplay = document.querySelector('.left .money');

const filterButtons = document.querySelectorAll('.filter-buttons button');

// 상태 관리

let transactions = [];
let currentType = 'income'; // 기본은 수입

// 초기 실행

loadFromLocalStorage();
renderList(transactions);
updateSummary();

// 유틸 함수

function generateId() {
  return Date.now();
}

function formatAmount(num) {
  return Number(num).toLocaleString() + '원';
}

function saveToLocalStorage() {
  localStorage.setItem('transactions', JSON.stringify(transactions));
}

function loadFromLocalStorage() {
  const data = localStorage.getItem('transactions');
  if (data) {
    transactions = JSON.parse(data);
  }
}

function getToday() {
  const today = new Date();
  return `${today.getFullYear()}년 ${today.getMonth() + 1}월 ${today.getDate()}일`;
}

// 렌더링

function renderList(data) {
  list.innerHTML = '';
  data.forEach((tx) => {
    const li = document.createElement('li');
    li.dataset.id = tx.id;
    li.innerHTML = `
      <span>${tx.date}</span>
      ${tx.description} - ${formatAmount(tx.amount)}
      <button class="delete-btn">삭제</button>
    `;
    li.classList.add(tx.type); // income 또는 expense로 클래스 추가
    list.appendChild(li);
  });
}

function updateSummary() {
  const income = transactions
    .filter(tx => tx.type === 'income')
    .reduce((sum, tx) => sum + Number(tx.amount), 0);

  const expense = transactions
    .filter(tx => tx.type === 'expense')
    .reduce((sum, tx) => sum + Number(tx.amount), 0);

  const balance = income - expense;

  incomeDisplay.textContent = formatAmount(income);
  expenseDisplay.textContent = formatAmount(expense);
  balanceDisplay.textContent = formatAmount(balance);
}

// 이벤트: 수입/지출 버튼 토글

typeButtons.forEach(btn => {
  btn.addEventListener('click', () => {
    typeButtons.forEach(b => b.classList.remove('active'));
    btn.classList.add('active');
    currentType = btn.textContent === '수입' ? 'income' : 'expense';
  });
});

// 이벤트: 항목 추가

addButton.addEventListener('click', () => {
  const description = descriptionInput.value.trim();
  const amount = amountInput.value.trim();

  if (!description || !amount || isNaN(amount) || Number(amount) <= 0) {
    alert('내용과 올바른 금액을 입력해주세요.');
    return;
  }

  const newTransaction = {
    id: generateId(),
    description,
    amount: Number(amount),
    type: currentType,
    date: getToday()
  };

  transactions.push(newTransaction);
  saveToLocalStorage();
  renderList(transactions);
  updateSummary();

  // 입력 초기화
  descriptionInput.value = '';
  amountInput.value = '';
});

// 이벤트: 삭제

list.addEventListener('click', (e) => {
  if (e.target.classList.contains('delete-btn')) {
    const id = e.target.closest('li').dataset.id;
    transactions = transactions.filter(tx => tx.id != id);
    saveToLocalStorage();
    renderList(transactions);
    updateSummary();
  }
});

// 이벤트: 필터 버튼

filterButtons.forEach(btn => {
  btn.addEventListener('click', () => {
    filterButtons.forEach(b => b.classList.remove('active'));
    btn.classList.add('active');

    const type = btn.textContent;

    if (type === '전체') {
      renderList(transactions);
    } else {
      const filtered = transactions.filter(tx => tx.type === (type === '수입' ? 'income' : 'expense'));
      renderList(filtered);
    }
  });
});
