import {React, Fragment} from 'react';
import Dashboard from './components/dashboard';
import UserList from './components/usersList';
import ProductList from './components/productList';
import './App.css';

function App() {
  return (
    <Fragment>
      <Dashboard>
      </Dashboard>
      <UserList>
      </UserList>
      <ProductList>   
      </ProductList>
    </Fragment>
  );
}

export default App;
