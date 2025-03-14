<template>
  <div class="training-search">
    <!-- 検索TOP画面へボタン (右上角に配置) -->
    <div class="top-button-container">
      <button @click="goToSearchTop" class="primary-button">検索TOP画面へ</button>
    </div>

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
        <span>{{ searchData.keyword ? searchData.keyword : '指定なし' }} / {{ searchData.fromDate ? searchData.fromDate : '指定なし' }} - {{ searchData.toDate ? searchData.toDate : '指定なし' }}</span>
      </div>
      <div class="summary-group">
        <label>検索結果件数:</label>
        <span>{{ searchResults.length }}件</span>
      </div>
    </section>

    <!-- 研修・コース一覧 -->
    <section class="section">
      <h2>研修・コース一覧</h2>
      <table class="course-table">
        <thead>
          <tr>
            <th>種別</th>
            <th>受付状況</th>
            <th>コード</th>
            <th>タイトル</th>
            <th>必修区分</th>
            <th>カテゴリ</th>
            <th>付箋カラー</th>
            <th>研修合計時間数</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="course in searchResults" :key="course.code">
            <td>{{ course.type }}</td>
            <td>{{ course.status }}</td>
            <td><a :href="'/course/' + course.code">{{ course.code }}</a></td>
            <td><a :href="'/course/' + course.code">{{ course.title }}</a></td>
            <td>{{ course.required }}</td>
            <td>{{ course.category }}</td>
            <td>{{ course.color }}</td>
            <td>{{ course.totalHours }}時間</td>
          </tr>
        </tbody>
      </table>
    </section>

    <!-- ページング -->
    <section class="section paging-section">
      <div class="paging-group">
        <button @click="goToFirstPage" class="paging-button">最初のページへ</button>
        <button @click="goToPreviousPage" class="paging-button">前のページへ</button>
        <div class="page-number-selector">
          <select v-model="currentPage" @change="goToPage">
            <option v-for="page in totalPages" :key="page" :value="page">{{ page }}</option>
          </select>
          <span> / {{ totalPages }}ページ</span>
        </div>
        <button @click="goToNextPage" class="paging-button">次のページへ</button>
        <button @click="goToLastPage" class="paging-button">最後のページへ</button>
      </div>
    </section>
  </div>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue';

const searchData = ref({
  keyword: '',
  fromDate: '',
  toDate: '',
  displayCount: 10
});

const currentPage = ref(1);
const totalResults = ref(100); // 検索結果の総数
const totalPages = computed(() => Math.ceil(totalResults.value / searchData.value.displayCount));

const searchResults = ref([
  { code: 'C001', type: 'オンライン', status: '受付中', title: 'プログラミング入門', required: '必修', category: '技術', color: 'Red', totalHours: 10 },
  { code: 'C002', type: '集合研修', status: '受付中', title: 'リーダーシップ研修', required: '選択', category: 'ソフトスキル', color: 'Blue', totalHours: 20 },
  { code: 'C003', type: 'オンライン', status: '受付中', title: 'データベース設計', required: '必修', category: '技術', color: 'Green', totalHours: 30 },
  { code: 'C004', type: 'オンデマンド', status: '受付中', title: 'クラウドコンピューティング', required: '選択', category: '技術', color: 'Yellow', totalHours: 40 },
  { code: 'C005', type: '集合研修', status: '受付中', title: 'ビジネス英語', required: '必修', category: '語学', color: 'Purple', totalHours: 50 },
  { code: 'C006', type: 'オンデマンド', status: '受付中', title: 'セキュリティ基礎', required: '選択', category: '技術', color: 'Orange', totalHours: 60 },
  { code: 'C007', type: 'オンライン', status: '受付中', title: 'AIと機械学習', required: '必修', category: '技術', color: 'Pink', totalHours: 70 },
  { code: 'C008', type: '集合研修', status: '受付中', title: 'プロジェクト管理', required: '選択', category: 'マネジメント', color: 'Brown', totalHours: 80 },
  { code: 'C009', type: 'オンライン', status: '受付中', title: 'アジャイル開発', required: '必修', category: '技術', color: 'Gray', totalHours: 90 },
  { code: 'C010', type: 'オンデマンド', status: '受付中', title: 'ビジネスコミュニケーション', required: '選択', category: 'ソフトスキル', color: 'Black', totalHours: 100 }
]);

const search = () => {
  // 検索処理をここに追加
  currentPage.value = 1; // 検索時にページを初期化
};

const clear = () => {
  searchData.value.keyword = '';
  searchData.value.fromDate = '';
  searchData.value.toDate = '';
};

const goToPage = () => {
  // ページ移動の処理
};

const goToFirstPage = () => {
  currentPage.value = 1;
};

const goToPreviousPage = () => {
  if (currentPage.value > 1) {
    currentPage.value--;
  }
};

const goToNextPage = () => {
  if (currentPage.value < totalPages.value) {
    currentPage.value++;
  }
};

const goToLastPage = () => {
  currentPage.value = totalPages.value;
};

const goToSearchTop = () => {
  // 検索TOP画面へ移動する処理
};
</script>

<style scoped>
.training-search {
  max-width: 1200px;
  margin: 0 auto;
  padding: 2rem;
  position: relative;
}

.top-button-container {
  position: absolute;
  top: 0;
  right: 0;
  margin: 1rem;
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
  display: flex;
  align-items: center;
}

.form-group label {
  min-width: 100px;
}

.date-group {
  display: flex;
  gap: 1rem;
  align-items: center;
}

.button-group {
  display: flex;
  gap: 1rem;
  margin-top: 1rem;
}

.summary-group {
  margin-bottom: 1rem;
  display: flex;
  align-items: center;
}

.summary-group label {
  min-width: 100px;
  font-weight: bold;
}

.course-table {
  width: 100%;
  border-collapse: collapse;
}

.course-table th, .course-table td {
  padding: 0.75rem;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

.course-table th {
  background-color: #f2f2f2;
  font-weight: bold;
}

.paging-section {
  display: flex;
  justify-content: center;
}

.paging-group {
  display: flex;
  gap: 1rem;
  align-items: center;
}

.page-number-selector {
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

.paging-button {
  padding: 0.5rem 1rem;
  border-radius: 4px;
  border: none;
  cursor: pointer;
  font-weight: 500;
  background: #f2f2f2;
  color: #333;
}

.primary-button {
  background: #4CAF50;
  color: white;
  padding: 0.5rem 1rem;
  border-radius: 4px;
  border: none;
  cursor: pointer;
  font-weight: 500;
}

.secondary-button {
  background: #2196F3;
  color: white;
  padding: 0.5rem 1rem;
  border-radius: 4px;
  border: none;
  cursor: pointer;
  font-weight: 500;
}
</style>