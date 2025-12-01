import { createContext, useState, useContext } from 'react';

const UserContext = createContext();

const initialUsers = [
  { id: 1, name: '홍길동', age: 25, status: 'online' },
  { id: 2, name: '김길동', age: 33, status: 'offline' },
  { id: 3, name: '홍길삼', age: 22, status: 'online' },
];

export function UserProvider({ children }) {
  const [users, setUsers] = useState(initialUsers);

  const addUser = (user) => {
   const maxId = users.length > 0 
      ? Math.max(...users.map(u => u.id))
      : 0;

    const nextId = maxId + 1;
    const newUser = { ...user, id: nextId };
    setUsers([...users, newUser]);
  };

  const deleteUser = (id) => {
    setUsers(users.filter((user) => user.id !== parseInt(id)));
  };

  return (
    <UserContext.Provider value={{ users, addUser, deleteUser }}>
      {children}
    </UserContext.Provider>
  );
}

export const useUsers = () => useContext(UserContext);