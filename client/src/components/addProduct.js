import { React } from 'react';
import { TextField, Box } from '@mui/material';


const AddProduct = () =>{
    return(
        <Box
            component="form"
            sx={{
                '& .MuiTextField-root': { m: 1, width: '25ch' },
            }}
            noValidate
            autoComplete="off"
        >
            <TextField
                required
                id="product-name"
                label="Product name"
            />
            <TextField
                required
                id="product-description"
                label="Product description"
            />
            <TextField
                id="product-price"
                label="Price"
                type="number"
                InputLabelProps={{
                    shrink: true,
                }}
            />
            <TextField
                id="product-quantity"
                label="Quantity"
                type="number"
                InputLabelProps={{
                    shrink: true,
                }}
            />
        </Box>
    )
}

export default AddProduct;