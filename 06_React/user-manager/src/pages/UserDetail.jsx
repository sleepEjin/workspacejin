import { useParams, useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import { useUsers } from '../contexts/UserContext';

const Card = styled.div`
  border: 1px solid #ccc;
  padding: 30px;
  border-radius: 10px;
  text-align: center;
`;

const ButtonGroup = styled.div`
  margin-top: 20px;
  display: flex;
  justify-content: center;
  gap: 10px;
`;

const Button = styled.button`
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  color: white;
`;

const UserDetail = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const { users, deleteUser } = useUsers();

  const user = users.find(u => u.id === parseInt(id));

  const handleDelete = () => {
    if (window.confirm('정말 삭제하시겠습니까?')) {
      deleteUser(id);
      navigate('/');
    }
  };

  if (!user) return <div>존재하지 않는 유저입니다. <Button onClick={() => navigate('/')}>돌아가기</Button></div>;

  return (
    <div>
      <h2>유저 상세 정보</h2>
      <Card>
        <h3>{user.name}</h3>
        <p>나이: {user.age}세</p>
        <p>상태: {user.status === 'online' ? '온라인' : '오프라인'}</p>
        
        <ButtonGroup>
          <Button onClick={() => navigate('/')}>목록으로</Button>
          <Button $danger onClick={handleDelete}>삭제하기</Button>
        </ButtonGroup>
      </Card>
    </div>
  );
};

export default UserDetail;