import { createAsyncThunk } from '@reduxjs/toolkit';
import ApiService from '../utils/api';

export const getAllProducts = createAsyncThunk('products/get', async (data) => {
  const response = await ApiService.get(`/products`);
  return response;
})