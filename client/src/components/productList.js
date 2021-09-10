import {React, useEffect, useState, Fragment} from 'react';
import { Grid } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';
import axios from 'axios';
import ProductData from './productData';

const useStyles = makeStyles((theme) => ({
    root: {
      flexGrow: 1,
    },
    paper: {
      padding: theme.spacing(1),
      textAlign: 'center',
      color: theme.palette.text.secondary,
    },
  }));


const ProductList = () =>{
    const classes = useStyles();
    const url = "http://localhost:8080/api/";

    const [products, setProducts] = useState([]);

    useEffect(() => {
        axios.get(`${url}products`)
        .then((response) => {
            setProducts(response.data)
        })
        .catch((error) => console.log(error))
    }, [])

    if(products == null) return;

    return(
        <Fragment>
            {
            products.map((product) => (
                <Grid key={product.id} item xs={4}>
                    <ProductData
                        key={product.id}
                        product={product}
                    >   
                    </ProductData>
                </Grid>
            ))
            }     
        </Fragment> 
    );
} 

export default ProductList;