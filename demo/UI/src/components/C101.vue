<template>
    <div class="login-stub-container">
      <!-- 現在のログイン情報エリア -->
      <div class="login-info-area">
        <h2>現在のログイン情報</h2>
        <div class="info-row">
          <label>社員ID:</label>
          <span>{{ loginInfo.employeeId || '未ログイン' }}</span>
        </div>
        <div class="info-row">
          <label>所属会社ID:</label>
          <span>{{ loginInfo.companyId || '未ログイン' }}</span>
        </div>
        <div class="info-row">
          <label>所属組織:</label>
          <span>{{ loginInfo.organizationId || '未ログイン' }}</span>
        </div>
      </div>
  
      <!-- 新規ログイン実施エリア -->
      <div class="new-login-area">
        <h2>新規ログイン実施</h2>
        <div class="input-row">
          <label>社員ID:</label>
          <input 
            type="text" 
            v-model="employeeIdInput" 
            placeholder="社員IDを入力してください"
          />
        </div>
      </div>
  
      <!-- ログイン情報更新エリア -->
      <div class="login-update-area">
        <h2>ログイン情報更新</h2>
        <button @click="navigateToSearch" :disabled="!isEmployeeIdValid">学習者検索TOPへ</button>
        <button @click="navigateToReviewList" :disabled="!isEmployeeIdValid">要検討リストへ</button>
      </div>
  
      <!-- ログアウトエリア -->
      <div class="logout-area">
        <h2>ログアウト</h2>
        <button @click="logout">ログアウト</button>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'LoginStub',
    data() {
      return {
        loginInfo: {
          employeeId: '',
          companyId: '',
          organizationId: ''
        },
        employeeIdInput: ''
      };
    },
    computed: {
      isEmployeeIdValid() {
        return this.employeeIdInput.trim().length > 0;
      }
    },
    methods: {
      // 初期表示処理
      async initializeScreen() {
        try {
          const response = await axios.post('/lmsscs0100/init');
          if (response.data) {
            this.loginInfo = response.data;
          }
        } catch (error) {
          console.error('初期表示処理でエラーが発生しました:', error);
          this.$message.error('データの取得に失敗しました。');
        }
      },
      
      // 学習者検索TOPへボタンクリック処理
      async navigateToSearch() {
        if (!this.isEmployeeIdValid) {
          this.$message.warning('社員IDを入力してください。');
          return;
        }
        
        try {
          await axios.post('/lmsscs0100/navigateToSearch', {
            employeeId: this.employeeIdInput
          });
          this.$router.push('/LMSSCS0200');
        } catch (error) {
          console.error('学習者検索TOP画面への遷移でエラーが発生しました:', error);
          this.$message.error('処理に失敗しました。');
        }
      },
      
      // 要検討リストへボタンクリック処理
      async navigateToReviewList() {
        if (!this.isEmployeeIdValid) {
          this.$message.warning('社員IDを入力してください。');
          return;
        }
        
        try {
          await axios.post('/lmsscs0100/navigateToReviewList', {
            employeeId: this.employeeIdInput
          });
          this.$router.push('/LMSSCS0400');
        } catch (error) {
          console.error('要検討リスト画面への遷移でエラーが発生しました:', error);
          this.$message.error('処理に失敗しました。');
        }
      },
      
      // ログアウトボタンクリック処理
      async logout() {
        try {
          await axios.post('/lmsscs0100/logout');
          this.loginInfo = {
            employeeId: '',
            companyId: '',
            organizationId: ''
          };
          this.$message.success('ログアウトしました。');
        } catch (error) {
          console.error('ログアウト処理でエラーが発生しました:', error);
          this.$message.error('ログアウトに失敗しました。');
        }
      }
    },
    mounted() {
      this.initializeScreen();
    }
  };
  </script>
  
  <style scoped>
  .login-stub-container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
    font-family: 'Hiragino Sans', 'Hiragino Kaku Gothic ProN', 'Meiryo', sans-serif;
  }
  
  .login-info-area,
  .new-login-area,
  .login-update-area,
  .logout-area {
    background-color: #f5f5f5;
    border-radius: 8px;
    padding: 15px;
    margin-bottom: 20px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }
  
  h2 {
    font-size: 18px;
    margin-top: 0;
    margin-bottom: 15px;
    padding-bottom: 8px;
    border-bottom: 1px solid #ddd;
    color: #333;
  }
  
  .info-row,
  .input-row {
    display: flex;
    margin-bottom: 10px;
    align-items: center;
  }
  
  label {
    width: 120px;
    font-weight: bold;
    text-align: right;
    padding-right: 15px;
  }
  
  span {
    flex: 1;
  }
  
  input {
    flex: 1;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
  }
  
  button {
    padding: 10px 15px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-weight: bold;
    font-size: 14px;
    transition: background-color 0.3s;
    margin-right: 10px;
  }
  
  button:disabled {
    background-color: #cccccc;
    cursor: not-allowed;
  }
  
  button:not(:disabled) {
    background-color: #4c75b0;
    color: white;
  }
  
  button:not(:disabled):hover {
    background-color: #3a5c8a;
  }
  
  .logout-button {
    background-color: #d9534f;
    color: white;
  }
  
  .logout-button:hover {
    background-color: #c9302c;
  }
  </style>