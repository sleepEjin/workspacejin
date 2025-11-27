import {useContext} from "react";

const UserContext = React.createContext();

export const UserProvider = ({children}) => {

    const user = {
        name: "최지원",
        age: 45,
        role: "관리자"
    }

    return (
        <UserContext.Provider value={user}>
            {children}
        </UserContext.Provider>
    )
}

export const useUser = () => {
    return useContext(UserContext);
}