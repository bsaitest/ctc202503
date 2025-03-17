<template>
  <div class="login-container">
    <!-- 現在のログイン情報 -->
    <div class="section">
      <div class="section-title">現在のログイン情報</div>
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

    <!-- 新規ログイン実施 -->
    <div class="section">
      <div class="section-title">新規ログイン実施</div>
      <div class="info-row">
        <div class="label">社員ID</div>
        <input type="text" class="input-field" v-model="employeeId">
      </div>
    </div>

    <!-- ログイン情報更新 -->
    <div class="section">
      <div class="section-title">ログイン情報更新</div>
      <button class="action-button" @click="goToSearchTop">学習者検索TOPへ</button>
      <button class="action-button" @click="goToReviewList">要検討リストへ</button>
    </div>

    <!-- ログアウト -->
    <div class="section">
      <div class="section-title">ログアウト</div>
      <button class="action-button logout-button" @click="logout">ログアウト</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'LoginInfoScreen',
  data() {
    return {
      employeeId: ''
    }
  },
  methods: {
    goToSearchTop() {
      console.log('学習者検索TOPへ移動します');
      // 実際の遷移処理をここに実装
    },
    goToReviewList() {
      console.log('要検討リストへ移動します');
      // 実際の遷移処理をここに実装
    },
    logout() {
      console.log('ログアウト処理を実行します');
      // 実際のログアウト処理をここに実装
    }
  }
}
</script>

<style scoped>
.login-container {
  border: 1px solid #000;
  width: 600px;
  margin: 20px auto;
  padding: 20px;
  font-family: sans-serif;
}

.section {
  margin-bottom: 30px;
}

.section-title {
  font-size: 16px;
  margin-bottom: 15px;
}

.info-row {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.label {
  width: 100px;
  text-align: right;
  margin-right: 10px;
}

.value {
  width: 80px;
  background-color: #e6e6fa;
  padding: 3px 5px;
}

.input-field {
  width: 260px;
  padding: 3px;
  border: 1px solid #000;
}

.action-button {
  display: block;
  width: 150px;
  padding: 5px 0;
  margin: 10px auto;
  background-color: #ffefd5;
  border: 1px solid #000;
  text-align: center;
  cursor: pointer;
}

.logout-button {
  background-color: #ffefd5;
}
</style>