import { React, useState, useEffect } from 'react';
import axios from 'axios';
import { DataGrid } from '@material-ui/data-grid';

const UsersList = () => {

    const url = "http://localhost:8080/api/";
    const [users, setUsers] = useState([]);
    
    const columns = [
        { 
            field: 'id', 
            headerName: 'ID', 
            width: 100 },
        {
            field: 'name',
            headerName: 'First name',
            width: 200,
            editable: false,
        },
        {
            field: 'username',
            headerName: 'Username',
            width: 200,
            editable: false,
        },
        {
            field: 'email',
            headerName: 'Email',
            width: 200,
            editable: false,
        },
        {
            field: 'password',
            headerName: 'Password',
            width: 600,
            editable: false,
        },
      ];

    useEffect(() => {
        axios.get(`${url}users`)
        .then((response) => {
        setUsers(response.data);
        })
    }, []);

    return(
        <div style={{ height:600, width: '80%', margin:50,  }}>
            <DataGrid
                rows={users}
                columns={columns}
                pageSize={10}
                checkboxSelection
                disableSelectionOnClick
            />
        </div>
        
    );
}

export default UsersList;