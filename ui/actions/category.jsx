import { createAsyncThunk } from '@reduxjs/toolkit';
import ApiService from '../utils/api';

export const getAllCategories = createAsyncThunk('categories/get', async () => {
  const response = await ApiService.get(`/categories`);
  return response;
});
export const addCategory = createAsyncThunk('categories/post', async (category) => {
  const response = await ApiService.post('/category', category);
  return response;
});
export const deleteCategoryById = createAsyncThunk('categories/delete', async (id) => {
  const response = await ApiService.delete(`/category/${id}`);
  return response;
});
export const getCategoryById = createAsyncThunk('category/get', async (id) => {
  const response = await ApiService.get(`/category/${id}`);
  return response;
})


// Additional async thunks can be added based on your requirements
