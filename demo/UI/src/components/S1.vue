<template>
    <div class="login-management">
      <!-- 現在のログイン情報エリア -->
      <div class="area current-login-area">
        <h2 class="area-title">現在のログイン情報</h2>
        <div class="form-group">
          <label class="form-label">社員ID:</label>
          <span class="form-value">{{ currentLogin.employeeId }}</span>
        </div>
        <div class="form-group">
          <label class="form-label">所属会社ID:</label>
          <span class="form-value">{{ currentLogin.companyId }}</span>
        </div>
        <div class="form-group">
          <label class="form-label">所属組織:</label>
          <span class="form-value">{{ currentLogin.organization }}</span>
        </div>
      </div>
  
      <!-- 新規ログイン実施エリア -->
      <div class="area new-login-area">
        <h2 class="area-title">新規ログイン実施</h2>
        <div class="form-group">
          <label class="form-label">社員ID:</label>
          <input 
            type="text" 
            v-model="newLogin.employeeId" 
            class="form-input" 
            placeholder="社員IDを入力してください"
          />
        </div>
        <div class="form-actions">
          <button @click="performNewLogin" class="btn btn-primary">ログイン</button>
        </div>
      </div>
  
      <!-- ログイン情報更新エリア -->
      <div class="area login-update-area">
        <h2 class="area-title">ログイン情報更新</h2>
        <div class="button-group">
          <button @click="goToSearchTop" class="btn btn-secondary">学習者検索TOPへ</button>
          <button @click="goToReviewList" class="btn btn-secondary">要検討リストへ</button>
        </div>
      </div>
  
      <!-- ログアウトエリア -->
      <div class="area logout-area">
        <button @click="logout" class="btn btn-danger">ログアウト</button>
      </div>
    </div>
  </template>
  
  <script>
  import { useRouter } from 'vue-router';
  
  const router = useRouter();
  export default {
    name: 'ログイン情報管理',
    data() {
      return {
        currentLogin: {
          employeeId: 'E12345',
          companyId: 'C001',
          organization: '人事部'
        },
        newLogin: {
          employeeId: ''
        }
      }
    },
    methods: {
      performNewLogin() {
        // 新規ログイン処理
        if (this.newLogin.employeeId) {
          console.log('新規ログイン:', this.newLogin.employeeId);
          // ここに実際のログイン処理を追加
          // 例: this.$store.dispatch('auth/login', this.newLogin.employeeId);
        } else {
          alert('社員IDを入力してください');
        }
      },
      goToSearchTop() {
        // 学習者検索TOPへ遷移
        console.log('学習者検索TOPへ遷移します');
        // 例: this.$router.push('/search');
        router.push('/s2');
      },
      goToReviewList() {
        // 要検討リストへ遷移
        console.log('要検討リストへ遷移します');
        // 例: this.$router.push('/review-list');
      },
      logout() {
        // ログアウト処理
        console.log('ログアウトします');
        // 例: this.$store.dispatch('auth/logout');
        // this.$router.push('/login');
        router.push('/s1');
      }
    }
  }
  </script>
  
  <style scoped>
  .login-management {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
    font-family: 'Hiragino Sans', 'Meiryo', sans-serif;
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
    margin-bottom: 10px;
    align-items: center;
  }
  
  .form-label {
    width: 120px;
    font-weight: bold;
  }
  
  .form-value {
    flex: 1;
  }
  
  .form-input {
    flex: 1;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  
  .button-group {
    display: flex;
    gap: 10px;
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
  
  .btn-danger {
    background-color: #dc3545;
    color: white;
  }
  
  .logout-area {
    text-align: right;
  }
  </style>