<template>
    <div class="training-search">
      <!-- ヘッダーエリア -->
      <div class="header-area">
        <button @click="goToSearchTop" class="btn btn-header">検索TOP画面へ</button>
      </div>
  
      <!-- 研修検索エリア -->
      <div class="area search-area">
        <h2 class="area-title">研修検索</h2>
        <div class="form-group">
          <label class="form-label">キーワード:</label>
          <input 
            type="text" 
            v-model="searchParams.keyword" 
            class="form-input" 
            placeholder="キーワードを入力してください"
          />
        </div>
        <div class="form-group">
          <label class="form-label">研修開催日:</label>
          <div class="date-range">
            <input 
              type="date" 
              v-model="searchParams.dateFrom" 
              class="form-input date-input"
            />
            <span class="date-separator">〜</span>
            <input 
              type="date" 
              v-model="searchParams.dateTo" 
              class="form-input date-input"
            />
          </div>
        </div>
        <div class="form-actions">
          <button @click="search" class="btn btn-primary">検索</button>
          <button @click="clearSearch" class="btn btn-secondary">クリア</button>
        </div>
      </div>
  
      <!-- 検索条件結果サマリ -->
      <div class="area search-summary">
        <div class="summary-row">
          <div class="summary-group">
            <label class="summary-label">表示件数:</label>
            <select v-model="displayCount" class="form-select">
              <option value="10">10件</option>
              <option value="20">20件</option>
              <option value="50">50件</option>
              <option value="100">100件</option>
            </select>
          </div>
          <div class="summary-group">
            <label class="summary-label">検索条件:</label>
            <span class="summary-value">{{ searchSummary }}</span>
          </div>
        </div>
        <div class="summary-row">
          <div class="summary-group">
            <label class="summary-label">検索結果件数:</label>
            <span class="summary-value">{{ resultCount }}件</span>
          </div>
        </div>
      </div>
  
      <!-- 研修・コース一覧 -->
      <div class="area result-area">
        <table class="result-table">
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
            <tr v-for="(course, index) in courses" :key="index">
              <td>{{ course.type }}</td>
              <td>{{ course.status }}</td>
              <td><a href="#" @click.prevent="viewCourseDetail(course.code)">{{ course.code }}</a></td>
              <td><a href="#" @click.prevent="viewCourseDetail(course.code)">{{ course.title }}</a></td>
              <td>{{ course.required }}</td>
              <td>{{ course.category }}</td>
              <td><span class="color-tag" :style="{ backgroundColor: course.tagColor }"></span></td>
              <td>{{ course.totalHours }}時間</td>
            </tr>
          </tbody>
        </table>
      </div>
  
      <!-- ページング -->
      <div class="pagination-area">
        <button @click="goToFirstPage" class="btn btn-pagination" :disabled="currentPage === 1">
          <span class="pagination-icon">≪</span>
        </button>
        <button @click="goToPrevPage" class="btn btn-pagination" :disabled="currentPage === 1">
          <span class="pagination-icon">＜</span>
        </button>
        <div class="page-numbers">
          <button 
            v-for="page in displayPages" 
            :key="page" 
            @click="goToPage(page)" 
            class="btn btn-page" 
            :class="{ 'btn-page-active': currentPage === page }"
          >
            {{ page }}
          </button>
        </div>
        <button @click="goToNextPage" class="btn btn-pagination" :disabled="currentPage === totalPages">
          <span class="pagination-icon">＞</span>
        </button>
        <button @click="goToLastPage" class="btn btn-pagination" :disabled="currentPage === totalPages">
          <span class="pagination-icon">≫</span>
        </button>
      </div>
  
      <!-- フッターエリア -->
      <div class="footer-area">
        <button @click="goToSearchTop" class="btn btn-footer">検索TOP画面へ</button>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: '研修検索',
    data() {
      return {
        searchParams: {
          keyword: '',
          dateFrom: '',
          dateTo: ''
        },
        displayCount: 20,
        resultCount: 0,
        currentPage: 1,
        totalPages: 5,
        courses: [
          {
            type: '集合研修',
            status: '受付中',
            code: 'TR001',
            title: 'プロジェクトマネジメント基礎',
            required: '必修',
            category: 'マネジメント',
            tagColor: '#ff9900',
            totalHours: 6
          },
          {
            type: 'eラーニング',
            status: '受付中',
            code: 'EL002',
            title: 'ビジネスコミュニケーション',
            required: '選択',
            category: 'ビジネススキル',
            tagColor: '#3399ff',
            totalHours: 3
          },
          {
            type: '集合研修',
            status: '締切',
            code: 'TR003',
            title: 'リーダーシップ研修',
            required: '必修',
            category: 'リーダーシップ',
            tagColor: '#33cc33',
            totalHours: 12
          },
          {
            type: 'eラーニング',
            status: '受付中',
            code: 'EL004',
            title: 'データ分析入門',
            required: '選択',
            category: 'IT技術',
            tagColor: '#cc66ff',
            totalHours: 4
          },
          {
            type: '集合研修',
            status: '受付中',
            code: 'TR005',
            title: 'チームビルディング',
            required: '選択',
            category: 'マネジメント',
            tagColor: '#ff9900',
            totalHours: 8
          }
        ]
      }
    },
    computed: {
      searchSummary() {
        let summary = [];
        if (this.searchParams.keyword) {
          summary.push(`キーワード: ${this.searchParams.keyword}`);
        }
        if (this.searchParams.dateFrom || this.searchParams.dateTo) {
          let dateRange = '研修開催日: ';
          dateRange += this.searchParams.dateFrom ? this.searchParams.dateFrom : '指定なし';
          dateRange += ' 〜 ';
          dateRange += this.searchParams.dateTo ? this.searchParams.dateTo : '指定なし';
          summary.push(dateRange);
        }
        return summary.length > 0 ? summary.join(' / ') : '指定なし';
      },
      displayPages() {
        const pages = [];
        const maxVisiblePages = 5;
        
        if (this.totalPages <= maxVisiblePages) {
          for (let i = 1; i <= this.totalPages; i++) {
            pages.push(i);
          }
        } else {
          let startPage = Math.max(1, this.currentPage - Math.floor(maxVisiblePages / 2));
          let endPage = startPage + maxVisiblePages - 1;
          
          if (endPage > this.totalPages) {
            endPage = this.totalPages;
            startPage = Math.max(1, endPage - maxVisiblePages + 1);
          }
          
          for (let i = startPage; i <= endPage; i++) {
            pages.push(i);
          }
        }
        
        return pages;
      }
    },
    created() {
      this.resultCount = this.courses.length;
    },
    methods: {
      search() {
        console.log('検索を実行します:', this.searchParams);
        // 実際の検索処理をここに実装
        this.resultCount = this.courses.length;
      },
      clearSearch() {
        this.searchParams = {
          keyword: '',
          dateFrom: '',
          dateTo: ''
        };
      },
      viewCourseDetail(code) {
        console.log('コース詳細を表示:', code);
        // 詳細画面への遷移処理をここに実装
      },
      goToPage(page) {
        this.currentPage = page;
      },
      goToFirstPage() {
        this.currentPage = 1;
      },
      goToPrevPage() {
        if (this.currentPage > 1) {
          this.currentPage--;
        }
      },
      goToNextPage() {
        if (this.currentPage < this.totalPages) {
          this.currentPage++;
        }
      },
      goToLastPage() {
        this.currentPage = this.totalPages;
      },
      goToSearchTop() {
        console.log('検索TOP画面へ遷移します');
        // TOP画面への遷移処理をここに実装
        // 例: this.$router.push('/search-top');
      }
    }
  }
  </script>
  
  <style scoped>
  .training-search {
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
    font-family: 'Hiragino Sans', 'Meiryo', sans-serif;
  }
  
  .header-area,
  .footer-area {
    display: flex;
    justify-content: flex-end;
    margin: 10px 0;
  }
  
  .area {
    background-color: #f5f5f5;
    padding: 15px;
    margin-bottom: 20px;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }
  
  .area-title {
    font-size: 18px;
    margin-top: 0;
    margin-bottom: 15px;
    padding-bottom: 8px;
    border-bottom: 1px solid #ddd;
    color: #333;
  }
  
  .form-group {
    display: flex;
    margin-bottom: 15px;
    align-items: center;
  }
  
  .form-label {
    width: 120px;
    font-weight: bold;
  }
  
  .form-input {
    flex: 1;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  
  .date-range {
    display: flex;
    align-items: center;
    flex: 1;
  }
  
  .date-input {
    width: 160px;
    flex: initial;
  }
  
  .date-separator {
    margin: 0 10px;
  }
  
  .form-select {
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    min-width: 100px;
  }
  
  .form-actions {
    display: flex;
    gap: 10px;
    justify-content: flex-end;
    margin-top: 20px;
  }
  
  .btn {
    padding: 8px 16px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-weight: bold;
  }
  
  .btn-primary {
    background-color: #4c75b0;
    color: white;
  }
  
  .btn-secondary {
    background-color: #6c757d;
    color: white;
  }
  
  .btn-header,
  .btn-footer {
    background-color: #556b2f;
    color: white;
  }
  
  .summary-row {
    display: flex;
    margin-bottom: 10px;
  }
  
  .summary-group {
    display: flex;
    align-items: center;
    margin-right: 30px;
  }
  
  .summary-label {
    font-weight: bold;
    margin-right: 10px;
  }
  
  .result-table {
    width: 100%;
    border-collapse: collapse;
  }
  
  .result-table th,
  .result-table td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
  }
  
  .result-table th {
    background-color: #f2f2f2;
    font-weight: bold;
  }
  
  .result-table tr:nth-child(even) {
    background-color: #f9f9f9;
  }
  
  .result-table a {
    color: #0066cc;
    text-decoration: none;
  }
  
  .result-table a:hover {
    text-decoration: underline;
  }
  
  .color-tag {
    display: inline-block;
    width: 20px;
    height: 20px;
    border-radius: 4px;
  }
  
  .pagination-area {
    display: flex;
    justify-content: center;
    margin: 20px 0;
    align-items: center;
  }
  
  .btn-pagination {
    background-color: #f8f9fa;
    color: #333;
    border: 1px solid #ddd;
    margin: 0 2px;
    padding: 5px 10px;
  }
  
  .btn-pagination:hover:not(:disabled) {
    background-color: #e9ecef;
  }
  
  .btn-pagination:disabled {
    opacity: 0.5;
    cursor: not-allowed;
  }
  
  .page-numbers {
    display: flex;
    margin: 0 10px;
  }
  
  .btn-page {
    background-color: #f8f9fa;
    color: #333;
    border: 1px solid #ddd;
    margin: 0 2px;
    padding: 5px 10px;
  }
  
  .btn-page-active {
    background-color: #4c75b0;
    color: white;
    border: 1px solid #4c75b0;
  }
  
    .pagination-icon {
        font-size: 1.2rem;
    }
    
  </style>