import React from 'react';


const UserData = ((user) => {

    if(user == null) return;
    console.log(user);
    return(
        <div>
            <div>
                <h1>{user.name}</h1>
            </div>
            <h2>{user.userName}</h2>
            <p>{user.email} last login: {user.lastLogin}</p>
        </div>
    )
})

export default UserData;