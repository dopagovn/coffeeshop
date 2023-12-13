import { createAsyncThunk } from '@reduxjs/toolkit';
import ApiService from '../utils/api';

export const getAllCategories = createAsyncThunk('categories/getAll', async () => {
  const response = await ApiService.get(`/categories`);
  return response;
});

export const getCategoryById = createAsyncThunk('categories/getById', async (id) => {
  const response = await ApiService.get(`/category?id=${id}`);
  return response;
});

export const addCategory = createAsyncThunk('categories/add', async (category) => {
  const response = await ApiService.post('/category', category);
  return response;
});

export const deleteCategoryById = createAsyncThunk('categories/deleteById', async (id) => {
  const response = await ApiService.delete(`/category?id=${id}`);
  return response;
});

// Additional async thunks can be added based on your requirements
