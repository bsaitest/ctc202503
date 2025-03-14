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

    <!-- 検索条件結果サマリ -->
    <section class="section">
      <div class="summary-group">
        <label>表示件数:</label>
        <select v-model="searchData.displayCount">
          <option value="10">10</option>
          <option value="20">20</option>
          <option value="50">50</option>
        </select>
      </div>
      <div class="summary-group">
        <label>検索条件:</label>
        <span>{{ searchData.keyword }} / {{ searchData.fromDate }} - {{ searchData.toDate }}</span>
      </div>
      <div class="summary-group">
        <label>検索結果件数:</label>
        <span>{{ searchResults.length }}</span>
      </div>
    </section>

    <!-- 研修・コース一覧 -->
    <section class="section">
      <h2>研修・コース一覧</h2>
      <ul>
        <li v-for="course in searchResults" :key="course.code">
          <div class="course-item">
            <span class="label">種別:</span>
            <span>{{ course.type }}</span>
            <span class="label">受付状況:</span>
            <span>{{ course.status }}</span>
            <span class="label">コード:</span>
            <a :href="'/course/' + course.code">{{ course.code }}</a>
            <span class="label">タイトル:</span>
            <a :href="'/course/' + course.code">{{ course.title }}</a>
            <span class="label">必修区分:</span>
            <span>{{ course.required }}</span>
            <span class="label">カテゴリ:</span>
            <span>{{ course.category }}</span>
            <span class="label">付箋カラー:</span>
            <span>{{ course.color }}</span>
            <span class="label">研修合計時間数:</span>
            <span>{{ course.totalHours }}</span>
          </div>
        </li>
      </ul>
    </section>

    <!-- ページング -->
    <section class="section">
      <div class="paging-group">
        <button @click="goToFirstPage" class="paging-button">最初のページへ</button>
        <button @click="goToPreviousPage" class="paging-button">前のページへ</button>
        <button @click="goToNextPage" class="paging-button">次のページへ</button>
        <button @click="goToLastPage" class="paging-button">最後のページへ</button>
      </div>
    </section>

    <!-- ヘッダーフッターエリア -->
    <section class="section">
      <button @click="goToSearchTop" class="primary-button">検索TOP画面へ</button>
    </section>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';

const searchData = ref({
  keyword: '',
  fromDate: '',
  toDate: '',
  displayCount: 10
});

const searchResults = ref([
  { code: 'C001', type: 'Type1', status: '受付中', title: 'Course 1', required: '必修', category: 'Category1', color: 'Red', totalHours: 10 },
  { code: 'C002', type: 'Type2', status: '受付中', title: 'Course 2', required: '選択', category: 'Category2', color: 'Blue', totalHours: 20 },
  { code: 'C003', type: 'Type3', status: '受付中', title: 'Course 3', required: '必修', category: 'Category3', color: 'Green', totalHours: 30 },
  { code: 'C004', type: 'Type4', status: '受付中', title: 'Course 4', required: '選択', category: 'Category4', color: 'Yellow', totalHours: 40 },
  { code: 'C005', type: 'Type5', status: '受付中', title: 'Course 5', required: '必修', category: 'Category5', color: 'Purple', totalHours: 50 },
  { code: 'C006', type: 'Type6', status: '受付中', title: 'Course 6', required: '選択', category: 'Category6', color: 'Orange', totalHours: 60 },
  { code: 'C007', type: 'Type7', status: '受付中', title: 'Course 7', required: '必修', category: 'Category7', color: 'Pink', totalHours: 70 },
  { code: 'C008', type: 'Type8', status: '受付中', title: 'Course 8', required: '選択', category: 'Category8', color: 'Brown', totalHours: 80 },
  { code: 'C009', type: 'Type9', status: '受付中', title: 'Course 9', required: '必修', category: 'Category9', color: 'Gray', totalHours: 90 },
  { code: 'C010', type: 'Type10', status: '受付中', title: 'Course 10', required: '選択', category: 'Category10', color: 'Black', totalHours: 100 }
]);

const search = () => {
  // 検索処理をここに追加
};

const clear = () => {
  searchData.value.keyword = '';
  searchData.value.fromDate = '';
  searchData.value.toDate = '';
};

const goToFirstPage = () => {
  // 最初のページへ移動する処理をここに追加
};

const goToPreviousPage = () => {
  // 前のページへ移動する処理をここに追加
};

const goToNextPage = () => {
  // 次のページへ移動する処理をここに追加
};

const goToLastPage = () => {
  // 最後のページへ移動する処理をここに追加
};

const goToSearchTop = () => {
  // 検索TOP画面へ移動する処理をここに追加
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

.summary-group {
  margin-bottom: 1rem;
}

.course-item {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
  margin-bottom: 1rem;
}

.label {
  font-weight: bold;
  min-width: 120px;
}

.paging-group {
  display: flex;
  gap: 1rem;
}

.paging-button {
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
  background: #2196F3;
  color: white;
}
</style>