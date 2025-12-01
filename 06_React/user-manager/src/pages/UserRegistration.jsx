import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import { useUsers } from '../contexts/UserContext';

const Form = styled.form`
  display: flex;
  flex-direction: column;
  gap: 15px;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 8px;
`;

const Input = styled.input`
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
`;

const Select = styled.select`
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
`;

const ErrorMsg = styled.span`
  color: red;
  font-size: 0.8rem;
`;

const Button = styled.button`
  padding: 12px;
  
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
`;

const UserRegistration = () => {
  const navigate = useNavigate();
  const { addUser } = useUsers();
  
  const [input, setInput] = useState({ name: '', age: '', status: 'offline' });
  const [error, setError] = useState('');

  const handleChange = (e) => {
    const { name, value } = e.target;
    setInput({ ...input, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    
    if (!input.name.trim() || !input.age) {
      setError('이름과 나이를 모두 입력해주세요.');
      return;
    }

    addUser(input);
    navigate('/');
  };

  return (
    <div>
      <h2>새 유저 등록</h2>
      <Form onSubmit={handleSubmit}>
        <label>이름</label>
        <Input 
          name="name" 
          value={input.name} 
          onChange={handleChange} 
          placeholder="이름 입력" 
        />

        <label>나이</label>
        <Input 
          name="age" 
          type="number"
          value={input.age} 
          onChange={handleChange} 
          placeholder="나이 입력" 
          min="1"
        />

        <label>상태</label>
        <Select name="status" value={input.status} onChange={handleChange}>
          <option value="offline">오프라인</option>
          <option value="online">온라인</option>
        </Select>

        {error && <ErrorMsg>{error}</ErrorMsg>}

        <Button type="submit">등록하기</Button>
        <Button type="button" $cancel onClick={() => navigate('/')}>취소</Button>
      </Form>
    </div>
  );
};

export default UserRegistration;