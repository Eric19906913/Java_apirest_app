import {React, Fragment} from 'react';
import Layout from './components/layout';
import UserList from './components/usersList';
import ProductList from './components/productList';
import './App.css';

function App() {
  return (
    <Fragment>
      <Layout>
      </Layout>
      <UserList>
      </UserList>
    </Fragment>
  );
}

export default App;
