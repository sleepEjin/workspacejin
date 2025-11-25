import React from 'react'
import styled from 'styled-components'

 const ProfileCard = (props) => {
    
    const profileCard = props.members;
        return (
        <tr>
            <td>{profileCard.member_name}</td>
            <td>{profileCard.age}</td>
            <td>{profileCard.isOnline}</td>
        </tr>
    )
}

export default ProfileCard