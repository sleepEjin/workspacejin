import styled from 'styled-components';
import { Link } from 'react-router-dom';

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 60vh;
  text-align: center;
`;

const Title = styled.h1`
  font-size: 4rem;
  color: #ddd;
  margin: 0;
`;

const HomeLink = styled(Link)`
  margin-top: 20px;
  text-decoration: none;
  color: blue;
  font-weight: bold;
`;

const NotFound = () => {
  return (
    <Container>
      <Title>404</Title>
      <h2>페이지를 찾을 수 없습니다.</h2>
      <p>요청하신 페이지가 존재하지 않거나 삭제되었습니다.</p>
      <HomeLink to="/">홈으로 가기</HomeLink>
    </Container>
  );
};

export default NotFound;