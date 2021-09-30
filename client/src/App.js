import {React, Fragment} from 'react';
import {
  BrowserRouter as Router,
  Switch,
  Route,
} from 'react-router-dom';
import Layout from './components/layout';
import UserList from './components/usersList';
import ProductList from './components/productList';
import './App.css';

function App() {
  return (
    <Fragment>
      <Router>
      
      <Layout>
      </Layout>
        
        <Switch>
          <Route exact path="/">
            <ProductList />
          </Route>
          <Route path="/admin">
            <UserList />
          </Route>
        </Switch>
      
      </Router>
    </Fragment>
  );
}

export default App;
