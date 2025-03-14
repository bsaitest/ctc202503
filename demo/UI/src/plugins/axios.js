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
console.log("baseURL=" + apiClient.baseURL);
export default apiClient;