import { createAsyncThunk } from '@reduxjs/toolkit';
import ApiService from '../utils/api';

// Tạo action để gửi request API

export const getAllProducts = createAsyncThunk('products/get', async () => {
    const response = await ApiService.get(`/products`);
    return response;
});

export const createProduct = createAsyncThunk('product/post', async (data) => {
    const response = await ApiService.post('/product', data);
    return response;
});
export const deleteProduct = createAsyncThunk('product/delete', async (id) => {
    const response = await ApiService.delete(`/product/${id}`);
    return response;
});
