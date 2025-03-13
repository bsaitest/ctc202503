<template>
    <div class="training-search">
      <!-- 研修検索エリア -->
      <section class="section">
        <h2>研修検索</h2>
        <div class="form-group">
          <label>キーワード:</label>
          <input type="text" v-model="searchData.keyword" />
        </div>
        <div class="form-group">
          <label>研修開催日:</label>
          <div class="date-group">
            <label>FROM:</label>
            <input type="date" v-model="searchData.fromDate" />
            <label>TO:</label>
            <input type="date" v-model="searchData.toDate" />
          </div>
        </div>
        <div class="button-group">
          <button @click="search" class="primary-button">検索</button>
          <button @click="clear" class="secondary-button">クリア</button>
        </div>
      </section>
  
      <!-- 研修カテゴリ選択エリア -->
      <section class="section">
        <h2>大・中分類カテゴリ一覧</h2>
        <div class="category-grid">
          <div v-for="(category, index) in categories" :key="index" class="category-box">
            <h3>{{ category.name }}</h3>
            <ul>
              <li v-for="(subCategory, subIndex) in category.subCategories" :key="subIndex">
                <a :href="'/category/' + subCategory.id">{{ subCategory.name }}</a>
              </li>
            </ul>
          </div>
        </div>
      </section>
  
      <!-- ヘッダーフッターエリア -->
      <section class="section">
        <button @click="goToLogin" class="primary-button">ログイン画面へ</button>
      </section>
    </div>
  </template>
  
  <script setup lang="ts">
  import { ref } from 'vue';
  
  const searchData = ref({
    keyword: '',
    fromDate: '',
    toDate: ''
  });
  
  const categories = ref([
    {
      name: 'A',
      subCategories: [
        { id: 1, name: 'A1' },
        { id: 2, name: 'A2' }
      ]
    },
    {
      name: 'B',
      subCategories: [
        { id: 3, name: 'B1' },
        { id: 4, name: 'B2' }
      ]
    },
    {
      name: 'C',
      subCategories: [
        { id: 5, name: 'C1' },
        { id: 6, name: 'C2' }
      ]
    },
    // 他のカテゴリをここに追加
  ]);
  
  const search = () => {
    // 検索処理をここに追加
  };
  
  const clear = () => {
    searchData.value.keyword = '';
    searchData.value.fromDate = '';
    searchData.value.toDate = '';
  };
  
  const goToLogin = () => {
    // ログイン画面へ移動する処理をここに追加
  };
  </script>
  
  <style scoped>
  .training-search {
    max-width: 800px;
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
    margin-bottom: 1rem;
    color: #333;
    font-size: 1.25rem;
  }
  
  .form-group {
    margin-bottom: 1rem;
  }
  
  .date-group {
    display: flex;
    gap: 1rem;
    align-items: center;
  }
  
  .button-group {
    display: flex;
    gap: 1rem;
  }
  
  .category-grid {
    display: flex;
    flex-wrap: wrap;
    gap: 1rem;
  }
  
  .category-box {
    flex: 1 1 calc(33.333% - 1rem);
    border: 1px solid #ddd;
    padding: 1rem;
    box-sizing: border-box;
  }
  
  .category-box h3 {
    margin-top: 0;
    margin-bottom: 1rem;
  }
  
  .primary-button {
    background: #4CAF50;
    color: white;
  }
  
  .secondary-button {
    background: #2196F3;
    color: white;
  }
  </style>