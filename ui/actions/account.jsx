import { createAsyncThunk } from '@reduxjs/toolkit';
import ApiService from '../utils/api';

export const getAllAccounts = createAsyncThunk('accounts/get', async (data) => {
  const response = await ApiService.get(`/accounts`);
  return response;
})