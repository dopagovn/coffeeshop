import { CaseReducer, PayloadAction, createSlice } from '@reduxjs/toolkit';
import { getAllCategories } from '../actions/category';

type State = any;
const increment: CaseReducer<State, PayloadAction<any>> = (state, action) => state + action.payload;

const categorySlice = createSlice({
    name: 'category',
    initialState: {
        code: 0,
        categories: [],
        message: '',
        status: '',
    },
    reducers: {
        increment,
    },
    extraReducers: (builder: any) => {
        builder.addCase(getAllCategories.fulfilled, (state: State, action: any) => {
            state.categories = action.payload.data;
            state.code = action.payload.code;
            state.message = action.payload.message;
            state.status = action.payload.status;
        });
    },
});

export const categoryAction = categorySlice.actions;
export default categorySlice.reducer;
