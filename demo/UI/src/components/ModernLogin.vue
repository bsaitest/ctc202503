<script setup lang="ts">
import { ref, reactive, computed } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

// Form data
const formData = reactive({
  username: '',
  password: '',
  rememberMe: false
});

// Form validation
const errors = reactive({
  username: '',
  password: '',
  general: ''
});

// UI states
const isLoading = ref(false);
const showPassword = ref(false);

// Computed properties
const isFormValid = computed(() => {
  return formData.username.trim() !== '' && formData.password.trim() !== '';
});

// Form validation functions
const validateUsername = () => {
  if (formData.username.trim() === '') {
    errors.username = 'ユーザー名を入力してください';
    return false;
  }
  errors.username = '';
  return true;
};

const validatePassword = () => {
  if (formData.password.trim() === '') {
    errors.password = 'パスワードを入力してください';
    return false;
  }
  errors.password = '';
  return true;
};

// Form submission
const handleSubmit = async () => {
  // Validate form
  const isUsernameValid = validateUsername();
  const isPasswordValid = validatePassword();
  
  if (!isUsernameValid || !isPasswordValid) {
    return;
  }
  
  // Clear general error
  errors.general = '';
  
  // Show loading state
  isLoading.value = true;
  
  try {
    // Simulate API call
    await new Promise(resolve => setTimeout(resolve, 1000));
    
    // In a real application, you would make an API call here
    // const response = await axios.post('/api/login', {
    //   username: formData.username,
    //   password: formData.password
    // });
    
    // For demo purposes, we'll just simulate a successful login
    console.log('Login successful', formData);
    
    // Store user info in localStorage if rememberMe is checked
    if (formData.rememberMe) {
      localStorage.setItem('username', formData.username);
    } else {
      localStorage.removeItem('username');
    }
    
    // Navigate to dashboard or home page
    router.push('/search');
  } catch (error) {
    // Handle login error
    console.error('Login failed', error);
    errors.general = 'ログインに失敗しました。ユーザー名とパスワードを確認してください。';
  } finally {
    // Hide loading state
    isLoading.value = false;
  }
};

// Toggle password visibility
const togglePasswordVisibility = () => {
  showPassword.value = !showPassword.value;
};

// Check if there's a saved username on component mount
const checkSavedUsername = () => {
  const savedUsername = localStorage.getItem('username');
  if (savedUsername) {
    formData.username = savedUsername;
    formData.rememberMe = true;
  }
};

// Call this function when the component is mounted
checkSavedUsername();
</script>

<template>
  <div class="login-container">
    <div class="login-card">
      <!-- Logo and Header -->
      <div class="login-header">
        <div class="logo">
          <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
            <path d="M12 2L2 7l10 5 10-5-10-5z"></path>
            <path d="M2 17l10 5 10-5"></path>
            <path d="M2 12l10 5 10-5"></path>
          </svg>
        </div>
        <h1>ログイン</h1>
        <p>アカウント情報を入力してください</p>
      </div>
      
      <!-- Login Form -->
      <form @submit.prevent="handleSubmit" class="login-form">
        <!-- General Error Message -->
        <div v-if="errors.general" class="error-message general-error">
          {{ errors.general }}
        </div>
        
        <!-- Username Field -->
        <div class="form-group">
          <label for="username">ユーザー名</label>
          <div class="input-wrapper">
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
              <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
              <circle cx="12" cy="7" r="4"></circle>
            </svg>
            <input 
              type="text" 
              id="username" 
              v-model="formData.username"
              @blur="validateUsername"
              placeholder="ユーザー名を入力"
              :class="{ 'error': errors.username }"
            />
          </div>
          <span v-if="errors.username" class="error-message">{{ errors.username }}</span>
        </div>
        
        <!-- Password Field -->
        <div class="form-group">
          <label for="password">パスワード</label>
          <div class="input-wrapper">
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
              <rect x="3" y="11" width="18" height="11" rx="2" ry="2"></rect>
              <path d="M7 11V7a5 5 0 0 1 10 0v4"></path>
            </svg>
            <input 
              :type="showPassword ? 'text' : 'password'" 
              id="password" 
              v-model="formData.password"
              @blur="validatePassword"
              placeholder="パスワードを入力"
              :class="{ 'error': errors.password }"
            />
            <button 
              type="button" 
              class="toggle-password" 
              @click="togglePasswordVisibility"
              tabindex="-1"
            >
              <svg v-if="!showPassword" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                <path d="M1 12s4-8 11-8 11 8 11 8-4 8-11 8-11-8-11-8z"></path>
                <circle cx="12" cy="12" r="3"></circle>
              </svg>
              <svg v-else xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                <path d="M17.94 17.94A10.07 10.07 0 0 1 12 20c-7 0-11-8-11-8a18.45 18.45 0 0 1 5.06-5.94M9.9 4.24A9.12 9.12 0 0 1 12 4c7 0 11 8 11 8a18.5 18.5 0 0 1-2.16 3.19m-6.72-1.07a3 3 0 1 1-4.24-4.24"></path>
                <line x1="1" y1="1" x2="23" y2="23"></line>
              </svg>
            </button>
          </div>
          <span v-if="errors.password" class="error-message">{{ errors.password }}</span>
        </div>
        
        <!-- Remember Me & Forgot Password -->
        <div class="form-options">
          <div class="remember-me">
            <input type="checkbox" id="remember-me" v-model="formData.rememberMe" />
            <label for="remember-me">ログイン情報を保存</label>
          </div>
          <a href="#" class="forgot-password">パスワードをお忘れですか？</a>
        </div>
        
        <!-- Submit Button -->
        <button 
          type="submit" 
          class="login-button" 
          :disabled="!isFormValid || isLoading"
        >
          <span v-if="!isLoading">ログイン</span>
          <div v-else class="spinner"></div>
        </button>
      </form>
      
      <!-- Register Link -->
      <div class="register-link">
        <p>アカウントをお持ちでないですか？ <a href="#">新規登録</a></p>
      </div>
    </div>
  </div>
</template>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f5f7fa;
  padding: 20px;
  font-family: 'Hiragino Sans', 'Meiryo', sans-serif;
}

.login-card {
  width: 100%;
  max-width: 420px;
  background-color: white;
  border-radius: 12px;
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.05);
  padding: 40px;
}

.login-header {
  text-align: center;
  margin-bottom: 30px;
}

.logo {
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
}

.logo svg {
  color: #4c75b0;
  width: 50px;
  height: 50px;
}

.login-header h1 {
  font-size: 24px;
  font-weight: 700;
  color: #333;
  margin-bottom: 10px;
}

.login-header p {
  color: #6c757d;
  font-size: 14px;
}

.login-form {
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 20px;
}

.form-group label {
  display: block;
  margin-bottom: 8px;
  font-size: 14px;
  font-weight: 600;
  color: #333;
}

.input-wrapper {
  position: relative;
  display: flex;
  align-items: center;
}

.input-wrapper svg {
  position: absolute;
  left: 12px;
  color: #6c757d;
}

.input-wrapper input {
  width: 100%;
  padding: 12px 12px 12px 40px;
  border: 1px solid #ddd;
  border-radius: 8px;
  font-size: 14px;
  transition: border-color 0.3s, box-shadow 0.3s;
}

.input-wrapper input:focus {
  outline: none;
  border-color: #4c75b0;
  box-shadow: 0 0 0 3px rgba(76, 117, 176, 0.1);
}

.input-wrapper input.error {
  border-color: #dc3545;
}

.toggle-password {
  position: absolute;
  right: 12px;
  background: none;
  border: none;
  cursor: pointer;
  color: #6c757d;
  padding: 0;
}

.error-message {
  display: block;
  color: #dc3545;
  font-size: 12px;
  margin-top: 5px;
}

.general-error {
  background-color: #f8d7da;
  color: #721c24;
  padding: 10px;
  border-radius: 8px;
  margin-bottom: 20px;
  text-align: center;
}

.form-options {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
  font-size: 14px;
}

.remember-me {
  display: flex;
  align-items: center;
}

.remember-me input {
  margin-right: 8px;
}

.forgot-password {
  color: #4c75b0;
  text-decoration: none;
}

.forgot-password:hover {
  text-decoration: underline;
}

.login-button {
  width: 100%;
  padding: 12px;
  background-color: #4c75b0;
  color: white;
  border: none;
  border-radius: 8px;
  font-size: 16px;
  font-weight: 600;
  cursor: pointer;
  transition: background-color 0.3s;
  display: flex;
  justify-content: center;
  align-items: center;
}

.login-button:hover {
  background-color: #3a5d8f;
}

.login-button:disabled {
  background-color: #a0b4d0;
  cursor: not-allowed;
}

.spinner {
  width: 20px;
  height: 20px;
  border: 3px solid rgba(255, 255, 255, 0.3);
  border-radius: 50%;
  border-top-color: white;
  animation: spin 1s ease-in-out infinite;
}

@keyframes spin {
  to {
    transform: rotate(360deg);
  }
}

.register-link {
  text-align: center;
  font-size: 14px;
  color: #6c757d;
}

.register-link a {
  color: #4c75b0;
  text-decoration: none;
  font-weight: 600;
}

.register-link a:hover {
  text-decoration: underline;
}

/* Responsive adjustments */
@media (max-width: 480px) {
  .login-card {
    padding: 30px 20px;
  }
  
  .form-options {
    flex-direction: column;
    align-items: flex-start;
    gap: 10px;
  }
}
</style>
