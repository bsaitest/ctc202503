<!-- Vue.jsコンポーネント -->
<template>
    <div class="training-search-system">
      <!-- ヘッダー -->
      <header class="header">
        <h1>研修検索システム</h1>
        <div class="header-buttons">
          <button @click="navigateToLogin" class="login-button">ログイン画面へ</button>
        </div>
      </header>
  
      <!-- メインコンテンツ -->
      <main class="main-content">
        <!-- 研修検索エリア -->
        <section class="search-area">
          <h2 class="area-title">研修検索</h2>
          <div class="search-form">
            <div class="form-group">
              <label for="keyword">キーワード</label>
              <input type="text" id="keyword" class="text-input" placeholder="キーワードを入力">
            </div>
            
            <div class="form-group">
              <label for="date-range">研修開催日</label>
              <div class="date-range">
                <input type="date" id="date-from" class="date-input">
                <span class="date-separator">〜</span>
                <input type="date" id="date-to" class="date-input">
              </div>
            </div>
            
            <div class="button-group">
              <button class="search-button">検索</button>
              <button class="clear-button">クリア</button>
            </div>
          </div>
        </section>
  
        <!-- 研修カテゴリ選択エリア -->
        <section class="category-area">
          <h2 class="area-title">大・中分類カテゴリ一覧</h2>
          
          <div class="category-container">
            <!-- 大分類カテゴリ（3つごとに改行） -->
            <div class="category-row">
              <!-- 大分類A -->
              <div class="major-category">
                <div class="major-category-label">Aカテゴリ</div>
                <div class="minor-categories">
                  <a href="#" class="minor-category">中分類A-1</a>
                  <a href="#" class="minor-category">中分類A-2</a>
                  <a href="#" class="minor-category">中分類A-3</a>
                </div>
              </div>
              
              <!-- 大分類B -->
              <div class="major-category">
                <div class="major-category-label">Bカテゴリ</div>
                <div class="minor-categories">
                  <a href="#" class="minor-category">中分類B-1</a>
                  <a href="#" class="minor-category">中分類B-2</a>
                </div>
              </div>
              
              <!-- 大分類C -->
              <div class="major-category">
                <div class="major-category-label">Cカテゴリ</div>
                <div class="minor-categories">
                  <a href="#" class="minor-category">中分類C-1</a>
                  <a href="#" class="minor-category">中分類C-2</a>
                  <a href="#" class="minor-category">中分類C-3</a>
                  <a href="#" class="minor-category">中分類C-4</a>
                </div>
              </div>
            </div>
            
            <div class="category-row">
              <!-- 大分類D -->
              <div class="major-category">
                <div class="major-category-label">Dカテゴリ</div>
                <div class="minor-categories">
                  <a href="#" class="minor-category">中分類D-1</a>
                </div>
              </div>
              
              <!-- 大分類E -->
              <div class="major-category">
                <div class="major-category-label">Eカテゴリ</div>
                <div class="minor-categories">
                  <a href="#" class="minor-category">中分類E-1</a>
                  <a href="#" class="minor-category">中分類E-2</a>
                </div>
              </div>
              
              <!-- 大分類F -->
              <div class="major-category">
                <div class="major-category-label">Fカテゴリ</div>
                <div class="minor-categories">
                  <a href="#" class="minor-category">中分類F-1</a>
                  <a href="#" class="minor-category">中分類F-2</a>
                  <a href="#" class="minor-category">中分類F-3</a>
                </div>
              </div>
            </div>
          </div>
        </section>
      </main>
  
      <!-- フッター -->
      <footer class="footer">
        <p>© 2025 次期LMS システム</p>
      </footer>
    </div>
  </template>
  
  <script>
  import { useRouter } from 'vue-router';
  
  const router = useRouter();
  export default {
    name: 'TrainingSearchSystem',
    data() {
      return {
        keyword: '',
        dateFrom: '',
        dateTo: '',
        // カテゴリのサンプルデータ
        majorCategories: [
          {
            id: 'A',
            name: 'Aカテゴリ',
            minorCategories: [
              { id: 'A1', name: '中分類A-1' },
              { id: 'A2', name: '中分類A-2' },
              { id: 'A3', name: '中分類A-3' }
            ]
          },
          {
            id: 'B',
            name: 'Bカテゴリ',
            minorCategories: [
              { id: 'B1', name: '中分類B-1' },
              { id: 'B2', name: '中分類B-2' }
            ]
          },
          // その他のカテゴリ...
        ]
      };
    },
    methods: {
      search() {
        // 検索処理
        console.log('検索実行');
        this.$router.push('/lmsscs0220');
      },
      clear() {
        // フォームクリア処理
        this.keyword = '';
        this.dateFrom = '';
        this.dateTo = '';
      },
      navigateToLogin() {
        // ログイン画面への遷移
        console.log('ログイン画面へ遷移');
        this.$router.push('/');
      }
    }
  };
  </script>
  
  <style scoped>
  .training-search-system {
    font-family: 'Hiragino Kaku Gothic ProN', 'メイリオ', sans-serif;
    max-width: 1920px;
    min-width: 768px;
    margin: 0 auto;
    padding: 20px;
  }
  
  /* ヘッダー */
  .header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 30px;
    padding-bottom: 10px;
    border-bottom: 1px solid #ddd;
  }
  
  .login-button {
    background-color: #4CAF50;
    color: white;
    border: none;
    padding: 8px 16px;
    border-radius: 4px;
    cursor: pointer;
  }
  
  /* メインコンテンツ */
  .area-title {
    font-size: 1.2rem;
    margin-bottom: 15px;
    padding-left: 10px;
    border-left: 5px solid #4CAF50;
  }
  
  /* 研修検索エリア */
  .search-area {
    background-color: #f9f9f9;
    padding: 20px;
    border-radius: 8px;
    margin-bottom: 30px;
  }
  
  .search-form {
    display: flex;
    flex-direction: column;
    gap: 15px;
  }
  
  .form-group {
    display: flex;
    align-items: center;
  }
  
  .form-group label {
    width: 120px;
    font-weight: bold;
  }
  
  .text-input {
    flex: 1;
    padding: 8px;
    border: 1px solid #ddd;
    border-radius: 4px;
  }
  
  .date-range {
    display: flex;
    align-items: center;
    gap: 10px;
  }
  
  .date-input {
    padding: 8px;
    border: 1px solid #ddd;
    border-radius: 4px;
  }
  
  .button-group {
    display: flex;
    gap: 15px;
    margin-top: 15px;
    margin-left: 120px;
  }
  
  .search-button {
    background-color: #2196F3;
    color: white;
    border: none;
    padding: 8px 20px;
    border-radius: 4px;
    cursor: pointer;
  }
  
  .clear-button {
    background-color: #f5f5f5;
    border: 1px solid #ddd;
    padding: 8px 20px;
    border-radius: 4px;
    cursor: pointer;
  }
  
  /* カテゴリエリア */
  .category-area {
    background-color: #f9f9f9;
    padding: 20px;
    border-radius: 8px;
  }
  
  .category-container {
    display: flex;
    flex-direction: column;
    gap: 20px;
  }
  
  .category-row {
    display: flex;
    gap: 20px;
  }
  
  .major-category {
    flex: 1;
    border: 1px solid #ddd;
    border-radius: 4px;
    overflow: hidden;
  }
  
  .major-category-label {
    background-color: #e1f5fe;
    padding: 10px;
    font-weight: bold;
    text-align: center;
  }
  
  .minor-categories {
    padding: 15px;
    display: flex;
    flex-direction: column;
    gap: 10px;
  }
  
  .minor-category {
    color: #2196F3;
    text-decoration: none;
  }
  
  .minor-category:hover {
    text-decoration: underline;
  }
  
  /* フッター */
  .footer {
    margin-top: 50px;
    padding-top: 20px;
    border-top: 1px solid #ddd;
    text-align: center;
    font-size: 0.9rem;
    color: #666;
  }
  </style>