import React from 'react'
import { useLocation, useParams } from 'react-router-dom';

const Profile = () => {
    const {username} = useParams();
    
    const {search} = useLocation();
    const query = new URLSearchParams(search);

    const sort=query.get('sort');
    console.log(sort);

    return (
        <>
    <div>프로필페이지입니다</div>
    <p>{username}의 프로필</p>
    </>
  )
}

export default Profile