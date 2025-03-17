<template>
    <div class="login-management">
      <!-- 現在のログイン情報エリア -->
      <div class="area current-login-area">
        <h2 class="area-title">現在のログイン情報</h2>
        <div class="form-group">
          <label class="form-label">社員ID:</label>
          <span class="form-value">{{ loginData.employeeId }}</span>
        </div>
        <div class="form-group">
          <label class="form-label">所属会社ID:</label>
          <span class="form-value">{{ loginData.companyId }}</span>
        </div>
        <div class="form-group">
          <label class="form-label">所属組織:</label>
          <span class="form-value">{{ loginData.organizationId }}</span>
        </div>
      </div>
  
      <!-- 新規ログイン実施エリア -->
      <div class="area new-login-area">
        <h2 class="area-title">新規ログイン実施</h2>
        <div class="form-group">
          <label class="form-label">社員ID:</label>
          <input 
            type="text" 
            v-model="newEmployeeId" 
            class="form-input" 
            placeholder="社員IDを入力してください"
          />
        </div>
      </div>
  
      <!-- ログイン情報更新エリア -->
      <div class="area login-update-area">
        <h2 class="area-title">ログイン情報更新</h2>
        <div class="button-group">
          <button @click="navigateToSearch" class="btn btn-secondary">学習者検索TOPへ</button>
          <button @click="navigateToReviewList" class="btn btn-secondary">要検討リストへ</button>
        </div>
      </div>
  
      <!-- ログアウトエリア -->
      <div class="area logout-area">
        <h2 class="area-title">ログアウト</h2>
        <button @click="logout" class="btn btn-danger">ログアウト</button>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        loginData: {
          employeeId: '',
          companyId: '',
          organizationId: ''
        },
        newEmployeeId: ''
      };
    },
    methods: {
      async navigateToSearch() {
        if (!this.newEmployeeId) {
          alert('社員IDを入力してください');
          return;
        }
        try {
          const response = await axios.post('/lmsscs0100/navigateToSearch', { employeeId: this.newEmployeeId });
          this.loginData = response.data;
          window.location.href = '/LMSSCS0200';
        } catch (error) {
          console.error(error);
        }
      },
      async navigateToReviewList() {
        if (!this.newEmployeeId) {
          alert('社員IDを入力してください');
          return;
        }
        try {
          const response = await axios.post('/lmsscs0100/navigateToReviewList', { employeeId: this.newEmployeeId });
          this.loginData = response.data;
          window.location.href = '/LMSSCS0400';
        } catch (error) {
          console.error(error);
        }
      },
      async logout() {
        try {
          await axios.post('/lmsscs0100/logout');
          this.loginData = {
            employeeId: '',
            companyId: '',
            organizationId: ''
          };
          window.location.href = '/lmsscs0100';
        } catch (error) {
          console.error(error);
        }
      }
    },
    async mounted() {
      try {
        const response = await axios.post('/lmsscs0100/init');
        this.loginData = response.data;
      } catch (error) {
        console.error(error);
      }
    }
  };
  </script>
  
  <style scoped>
  .login-management {
    max-width: 1920px;
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
    text-align: left;
  }
  
  .form-group {
    display: flex;
    margin-bottom: 10px;
    align-items: center;
  }
  
  .form-label {
    width: 120px;
    font-weight: bold;
    text-align: left;
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
    flex-direction: column; /* ボタンを縦に並べる */
    gap: 10px;
    align-items: flex-end; /* ボタンを右側に配置 */
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