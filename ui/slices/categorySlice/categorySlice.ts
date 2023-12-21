// categorySlice.ts
import { CaseReducer, PayloadAction, createSlice } from '@reduxjs/toolkit';
import { getCategoryById } from '../../actions/category';

type State = any;

const increment: CaseReducer<State, PayloadAction<any>> = (state, action) => state + action.payload;

const categorySlice = createSlice({
    name: 'category', // Đảm bảo tên slice là 'category'
    initialState: {
        code: 0,
        categoryItem: {},
        message: '',
        status: '',
    },
    reducers: {
        increment,
    },
    extraReducers: (builder: any) => {
        builder.addCase(getCategoryById.fulfilled, (state: State, action: any) => {
            state.categoryItem = action.payload.data;
            state.code = action.payload.code;
            state.message = action.payload.message;
            state.status = action.payload.status;
        });
    },
});

export const categoryAction = categorySlice.actions;
export default categorySlice.reducer;
