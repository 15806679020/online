import axios from 'axios'

const service = axios.create({
    //URL = baseURL+requestURL
    baseURL:"http://127.0.0.1:8081",
    //请求超时时间
    timeout:5000
})

export default service