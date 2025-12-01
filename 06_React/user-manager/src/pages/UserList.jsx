import styled from 'styled-components';
import { Link, useNavigate } from 'react-router-dom';
import { useUsers } from '../contexts/UserContext';

const Header = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
`;

const AddButton = styled.button`
  background-color: #4CAF50;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
`;

const UserCard = styled.div`
  border: 1px solid #ddd;
  padding: 15px;
  margin-bottom: 10px;
  border-radius: 8px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  cursor: pointer;
  transition: 0.2s;
`;

const StatusBadge = styled.span`
  font-size: 0.8rem;
  padding: 4px 8px;
  border-radius: 12px;
  background-color: white;
  color: black;
`;

const UserList = () => {
  const { users } = useUsers();
  const navigate = useNavigate();

  return (
    <div>
      <Header>
        <h1>유저 리스트</h1>
        <AddButton onClick={() => navigate('/user')}>+ 유저 등록</AddButton>
      </Header>
      
      {users.length === 0 ? (
        <p>등록된 유저가 없습니다.</p>
      ) : (
        users.map(user => (
          <UserCard key={user.id} onClick={() => navigate(`/user/${user.id}`)}>
            <div>
              <strong>{user.name}</strong> ({user.age}세)
            </div>
            <StatusBadge $status={user.status}>
              {user.status === 'online' ? '온라인' : '오프라인'}
            </StatusBadge>
          </UserCard>
        ))
      )}
    </div>
  );
};

export default UserList;