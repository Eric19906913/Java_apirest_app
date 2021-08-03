import {React, useEffect, useState, Fragment} from 'react';
import axios from 'axios';
import ProductData from './productData';

const ProductList = () =>{
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
                <ProductData
                    key={product.id}
                    product={product}
                >
                </ProductData>
            ))
            }     
        </Fragment> 
    );
} 

export default ProductList;