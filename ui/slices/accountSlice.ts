import { CaseReducer, PayloadAction, createSlice } from '@reduxjs/toolkit';
import { getAllAccounts } from '../actions/account'; // Make sure to import your account actions

type State = any;

const updateAccounts: CaseReducer<State, PayloadAction<any>> = (state, action) => {
 
  state.accounts = action.payload;
};

const accountSlice = createSlice({
  name: 'account',
  initialState: {
    accounts: [], 
  },
  reducers: {
    updateAccounts, 
  },
  extraReducers: (builder: any) => {
    builder.addCase(getAllAccounts.fulfilled, (state: State, action: any) => {
      
      state.accounts = action.payload;
    });
  },
});

export default accountSlice.reducer;
