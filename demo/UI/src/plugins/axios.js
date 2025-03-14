import axios from 'axios';

const apiClient = axios.create({
  // baseURL: import.meta.env.VITE_API_BASE_URL,
  baseURL: "http://localhost:8080",
  headers: {
    'Content-Type': 'application/json',
    'Accept': 'application/json',
    'timeout': 30000
  }
});


// // インターセプターを設定して、すべてのリクエストURLにプレフィックスを追加
// apiClient.interceptors.request.use(config => {
//   config.url = `/api${config.url}`;
//   return config;
// });

// console.log("baseURL=" + apiClient.baseURL);
export default apiClient;