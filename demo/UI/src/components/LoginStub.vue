<script setup lang="ts">
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const loginData = ref({
  newEmployeeId: '',
  employeeId: '1234567890',
  companyId: 'COMP001',
  organization: '開発部'
});

const navigateToSearch = () => {
  router.push('/search');
};

const navigateToLogout = () => {
  window.sessionStorage.clear();
  router.push('/login');
}
</script>

<template>
  <div class="login-stub">
    <!-- Current Login Info Area -->
    <section class="section">
      <h2>現在のログイン情報</h2>
      <div class="info-grid">
        <div class="info-item">
          <span class="label">社員ID:</span>
          <span>{{ loginData.employeeId }}</span>
        </div>
        <div class="info-item">
          <span class="label">所属会社ID:</span>
          <span>{{ loginData.companyId }}</span>
        </div>
        <div class="info-item">
          <span class="label">所属組織:</span>
          <span>{{ loginData.organization }}</span>
        </div>
      </div>
    </section>

    <!-- New Login Area -->
    <section class="section">
      <h2>新規ログイン実施</h2>
      <div class="input-group">
        <label>社員ID:</label>
        <input type="text" v-model="loginData.newEmployeeId" />
      </div>
    </section>

    <!-- Login Info Update Area -->
    <section class="section">
      <h2>ログイン情報更新</h2>
      <div class="button-group">
        <button @click="navigateToSearch" class="primary-button">学習者検索TOPへ</button>
        <button class="secondary-button">要検討リストへ</button>
      </div>
    </section>

    <!-- Logout Area -->
    <section class="section">
      <button @click="navigateToLogout" class="danger-button">Logout</button>
    </section>
  </div>
</template>

<style scoped>
.login-stub {
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

.info-grid {
  display: grid;
  gap: 1rem;
}

.info-item {
  display: flex;
  gap: 1rem;
}

.label {
  font-weight: bold;
  min-width: 120px;
}

.input-group {
  display: flex;
  gap: 1rem;
  align-items: center;
}

.input-group input {
  padding: 0.5rem;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.button-group {
  display: flex;
  gap: 1rem;
}

button {
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

.danger-button {
  background: #f44336;
  color: white;
}
</style>