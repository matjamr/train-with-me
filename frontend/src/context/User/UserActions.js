import axios from "axios";

const BACKEND_URL = "http://localhost:8080";
const LOGIN_URL = "http://localhost:8050/api/v1/auth";

const securityWrapperFetch = axios.create({
  baseURL: LOGIN_URL,
});

export const loginUser = async (email, password) => {
  const response = await securityWrapperFetch
    .post(`${LOGIN_URL}/authenticate`, {
      email: email,
      password: password,
    })
    .catch((err) => {
      window.location = "/login";
    });

  return response.data.token;
};
