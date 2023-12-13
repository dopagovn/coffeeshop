import { createAsyncThunk } from '@reduxjs/toolkit';
import ApiService from '../utils/api';

// Tạo action để gửi request API

export const getAllProducts = createAsyncThunk('products/get', async () => {
  const response = await ApiService.get(`/products`);
  return response;
})
