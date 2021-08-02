import {React, useState, useEffect, Fragment} from 'react';
import axios from 'axios';
import UserData from './userData';

const UsersList = () => {
    const url = "http://localhost:8080/api/";

    const [users, setUsers] = useState([]);

    useEffect(() => {
        axios.get(`${url}users`)
        .then((response) => {
        setUsers(response.data);
        })
    }, []);
    
    if(users == null) return;

    return(
        <Fragment>
            <h1>User List</h1>
            {
            users.map((user) => (
                <UserData
                    key={user.id}
                    user={user}>
                </UserData>
            ))
            }
        </Fragment>
        
    );
}

export default UsersList;