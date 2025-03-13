<script setup lang="ts">
import { reactive } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

// Single data model containing all component data
const searchModel = reactive({
  form: {
    keyword: '',
    dateFrom: '',
    dateTo: ''
  },
  categories: [
    {
      id: 1,
      name: '大分類カテゴリ 1',
      subCategories: [
        { id: 11, name: '中分類カテゴリ 1-1' },
        { id: 12, name: '中分類カテゴリ 1-2' },
        { id: 13, name: '中分類カテゴリ 1-3' }
      ]
    },
    {
      id: 2,
      name: '大分類カテゴリ 2',
      subCategories: [
        { id: 21, name: '中分類カテゴリ 2-1' },
        { id: 22, name: '中分類カテゴリ 2-2' }
      ]
    }
  ]
});

const navigateToLogin = () => {
  router.push('/');
};

const handleSearch = () => {
  // Implement search logic
};

const handleClear = () => {
  searchModel.form.keyword = '';
  searchModel.form.dateFrom = '';
  searchModel.form.dateTo = '';
};
</script>

<template>
  <div class="search-top">
    <!-- Header with Login Button -->
    <header class="header">
      <button @click="navigateToLogin" class="return-button">ログイン画面へ</button>
    </header>
    
    <!-- Training Search Area -->
    <section class="section">
      <h2>研修検索</h2>
      <div class="search-form">
        <div class="form-group">
          <label>キーワード:</label>
          <input type="text" v-model="searchModel.form.keyword" placeholder="キーワードを入力" />
        </div>
        <div class="form-group">
          <label>研修開催日:</label>
          <div class="date-range">
            <input type="date" v-model="searchModel.form.dateFrom" />
            <span>～</span>
            <input type="date" v-model="searchModel.form.dateTo" />
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
        <div v-for="category in searchModel.categories" :key="category.id" class="major-category">
          <h3>{{ category.name }}</h3>
          <div class="sub-categories">
            <a 
              v-for="subCategory in category.subCategories" 
              :key="subCategory.id" 
              href="#" 
              class="sub-category"
            >
              {{ subCategory.name }}
            </a>
          </div>
        </div>
      </div>
    </section>

  </div>
</template>

<style scoped>
.search-top {
  width: 100%;
  margin: 0 auto;
  position: relative;
}

.header {
  position: absolute;
  top: 1px;
  right: 1px;
  z-index: 10;
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
