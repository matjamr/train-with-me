import { createContext, useReducer } from "react";
import { userReducer } from "./UserReducer";

const UserContext = createContext();

const defaultState = {
  user: {
    email: "",
    password: "",
    firstname: "",
    lastname: "",
    token: "",
  },
};

const UserProvider = ({ children }) => {
  const [state, dispatch] = useReducer(userReducer, defaultState);

  return (
    <UserContext.Provider
      value={{
        ...state,
        dispatch,
      }}
    >
      {children}
    </UserContext.Provider>
  );
};

export default UserProvider;
export { UserContext };
