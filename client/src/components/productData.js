import React from 'react';

import { Card, CardHeader, CardContent } from '@material-ui/core';


const ProductData = (product) => {
    
    const {name, description, price} = product.product;
    console.log(product.product);
    if(product == null) return;

    return(
        <Card>
            <CardHeader>
                <h1>{name}</h1>
            </CardHeader>
            <CardContent>
                {description}
            </CardContent>
        </Card>
    );
}

export default ProductData;