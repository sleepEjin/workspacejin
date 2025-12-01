import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { UserProvider } from './contexts/UserContext';
import UserList from './pages/UserList';
import UserDetail from './pages/UserDetail';
import UserRegistration from './pages/UserRegistration';
import NotFound from './pages/NotFound';
import styled from 'styled-components';

const Container = styled.div`
  margin: 0 auto;
  padding: 20px;
  font-family: sans-serif;
  align-items: center;
`;

function App() {
  return (
    <UserProvider>
      <BrowserRouter>
        <Container>
          <Routes>
            <Route path="/" element={<UserList />} />
            <Route path="/user" element={<UserRegistration />} />
            <Route path="/user/:id" element={<UserDetail />} />
            <Route path="*" element={<NotFound />} />
          </Routes>
        </Container>
      </BrowserRouter>
    </UserProvider>
  );
}

export default App;