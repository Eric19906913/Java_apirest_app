import React from 'react';
import { AppBar, Toolbar, IconButton, Typography, Button } from '@material-ui/core';
import {
    Link
  } from 'react-router-dom';

const Layout = () =>{
    return(
        <AppBar position="static">
            <Toolbar>
                <Typography variant="h6">
                    <Link to="/">Marketplace</Link>
                </Typography>
                <Button color="inherit">
                    <Link to="/">Home</Link>
                </Button>
                <Button color="inherit">
                    <Link to="/admin">Administration</Link>
                </Button>
                <IconButton edge="start" color="inherit" aria-label="menu">
                </IconButton>
            <Button color="inherit">Login</Button>
            </Toolbar>
        </AppBar>
    );
}

export default Layout;