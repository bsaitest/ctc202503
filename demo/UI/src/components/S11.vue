<template>
    <div class="login-container">
      <div class="login-box">
        <div class="section">
          <h2>現在のログイン情報</h2>
          <div class="info-row">
            <div class="label">社員ID</div>
            <div class="value">XXXX</div>
          </div>
          <div class="info-row">
            <div class="label">所属会社ID</div>
            <div class="value">YYYY</div>
          </div>
          <div class="info-row">
            <div class="label">所属組織ID</div>
            <div class="value">ZZZZ</div>
          </div>
        </div>
  
        <div class="section">
          <h2>新規ログイン実施</h2>
          <div class="info-row">
            <div class="label">社員ID</div>
            <input type="text" class="input-field" v-model="newEmployeeId">
          </div>
        </div>
  
        <div class="section">
          <h2>ログイン情報更新</h2>
          <div class="button-row">
            <button class="action-button">学習者検索TOPへ</button>
          </div>
          <div class="button-row">
            <button class="action-button">要検討リストへ</button>
          </div>
        </div>
  
        <div class="section">
          <h2>ログアウト</h2>
          <div class="button-row">
            <button class="action-button logout-button">ログアウト</button>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'LoginInfo',
    data() {
      return {
        newEmployeeId: ''
      }
    },
    methods: {
      navigateToSearch() {
        // ここに学習者検索TOPへの遷移ロジックを実装
        console.log('学習者検索TOPへ遷移します');
      },
      navigateToReviewList() {
        // ここに要検討リストへの遷移ロジックを実装
        console.log('要検討リストへ遷移します');
      },
      logout() {
        // ここにログアウト処理を実装
        console.log('ログアウトします');
      }
    }
  }
  </script>
  
  <style scoped>
  .login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    font-family: sans-serif;
  }
  
  .login-box {
    width: 600px;
    border: 1px solid #000;
    padding: 20px;
  }
  
  .section {
    margin-bottom: 20px;
  }
  
  h2 {
    font-size: 16px;
    margin-bottom: 10px;
    font-weight: normal;
  }
  
  .info-row {
    display: flex;
    margin-bottom: 10px;
  }
  
  .label {
    width: 100px;
    text-align: right;
    padding-right: 10px;
  }
  
  .value {
    width: 100px;
    background-color: #e6e6fa;
    padding: 2px 5px;
  }
  
  .input-field {
    width: 260px;
    padding: 2px 5px;
  }
  
  .button-row {
    margin-top: 10px;
    display: flex;
    justify-content: center;
  }
  
  .action-button {
    width: 150px;
    padding: 5px;
    background-color: #ffefd5;
    border: 1px solid #000;
    text-align: center;
    cursor: pointer;
  }
  
  .logout-button {
    width: 150px;
  }
  </style>