import {React, useEffect, useState} from 'react';
import axios from 'axios';

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

    console.log(products);

    if(products == null) return;

    return(
        <h1>hola</h1>
    );
} 

export default ProductList;