import {React, Fragment} from 'react';

const UserData = ((user) => {

    if(user == null) return;
    console.log(user);
    return(
        <Fragment>
            <div>
                <h1>{user.name}</h1>
            </div>
            <h2>{user.userName}</h2>
            <p>{user.email} last login: {user.lastLogin}</p>
        </Fragment>
    )
})

export default UserData;