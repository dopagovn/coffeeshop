import { CaseReducer, PayloadAction, createSlice } from '@reduxjs/toolkit';
import { getAllProducts } from '../actions/product';

type State = any;
const increment: CaseReducer<State, PayloadAction<any>> = (state, action) => state + action.payload;

const productSlice = createSlice({
    name: 'product',
    initialState: {
        data: [],
    },
    reducers: {
        increment,
    },
    extraReducers: (builder: any) => {
        builder.addCase(getAllProducts.fulfilled, (state: State, action: any) => {
            state.data = action.payload;
        });
    },
});

export default productSlice.reducer;
