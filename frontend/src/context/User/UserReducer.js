export const userReducer = (state, action) => {
  switch (action.type) {
    case "LOGIN_USER":
      return {
        ...state,
        token: action.payload.token,
      };
    default:
      return state;
  }
};
