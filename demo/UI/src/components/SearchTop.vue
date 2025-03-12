<script setup lang="ts">
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const keyword = ref('');
const dateFrom = ref('');
const dateTo = ref('');

const navigateToLogin = () => {
  router.push('/');
};

const handleSearch = () => {
  // Implement search logic
};

const handleClear = () => {
  keyword.value = '';
  dateFrom.value = '';
  dateTo.value = '';
};
</script>

<template>
  <div class="search-top">
    <!-- Training Search Area -->
    <section class="section">
      <h2>研修検索</h2>
      <div class="search-form">
        <div class="form-group">
          <label>キーワード:</label>
          <input type="text" v-model="keyword" placeholder="キーワードを入力" />
        </div>
        <div class="form-group">
          <label>研修開催日:</label>
          <div class="date-range">
            <input type="date" v-model="dateFrom" />
            <span>～</span>
            <input type="date" v-model="dateTo" />
          </div>
        </div>
        <div class="button-group">
          <button @click="handleSearch" class="primary-button">検索</button>
          <button @click="handleClear" class="secondary-button">クリア</button>
        </div>
      </div>
    </section>

    <!-- Category Selection Area -->
    <section class="section">
      <h2>大・中分類カテゴリ一覧</h2>
      <div class="category-container">
        <div class="major-category">
          <h3>大分類カテゴリ 1</h3>
          <div class="sub-categories">
            <a href="#" class="sub-category">中分類カテゴリ 1-1</a>
            <a href="#" class="sub-category">中分類カテゴリ 1-2</a>
            <a href="#" class="sub-category">中分類カテゴリ 1-3</a>
          </div>
        </div>
        <div class="major-category">
          <h3>大分類カテゴリ 2</h3>
          <div class="sub-categories">
            <a href="#" class="sub-category">中分類カテゴリ 2-1</a>
            <a href="#" class="sub-category">中分類カテゴリ 2-2</a>
          </div>
        </div>
      </div>
    </section>

    <!-- Header/Footer Area -->
    <footer class="footer">
      <button @click="navigateToLogin" class="return-button">ログイン画面へ</button>
    </footer>
  </div>
</template>

<style scoped>
.search-top {
  max-width: 1000px;
  margin: 0 auto;
  padding: 2rem;
}

.section {
  background: #fff;
  padding: 1.5rem;
  border-radius: 8px;
  margin-bottom: 1.5rem;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

h2 {
  margin-top: 0;
  margin-bottom: 1.5rem;
  color: #333;
}

.search-form {
  display: grid;
  gap: 1.5rem;
}

.form-group {
  display: grid;
  gap: 0.5rem;
}

.date-range {
  display: flex;
  gap: 1rem;
  align-items: center;
}

input {
  padding: 0.5rem;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.button-group {
  display: flex;
  gap: 1rem;
  margin-top: 1rem;
}

.category-container {
  display: grid;
  gap: 2rem;
}

.major-category {
  border: 1px solid #ddd;
  padding: 1rem;
  border-radius: 4px;
}

.major-category h3 {
  margin-top: 0;
  margin-bottom: 1rem;
  color: #333;
}

.sub-categories {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
}

.sub-category {
  color: #2196F3;
  text-decoration: none;
}

.sub-category:hover {
  text-decoration: underline;
}

.footer {
  margin-top: 2rem;
  text-align: center;
}

button {
  padding: 0.5rem 1rem;
  border-radius: 4px;
  border: none;
  cursor: pointer;
  font-weight: 500;
}

.primary-button {
  background: #4CAF50;
  color: white;
}

.secondary-button {
  background: #757575;
  color: white;
}

.return-button {
  background: #2196F3;
  color: white;
}
</style>