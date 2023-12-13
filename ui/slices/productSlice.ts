import { CaseReducer, PayloadAction, createSlice } from '@reduxjs/toolkit';
import { getAllProducts } from '../actions/product';

type State = any;
const increment: CaseReducer<State, PayloadAction<any>> = (state, action) => state + action.payload;

const productSlice = createSlice({
    name: 'product',
    initialState: {
        products: [],
    },
    reducers: {
        increment,
    },
    extraReducers: (builder: any) => {
        builder.addCase(getAllProducts.fulfilled, (state: State, action: any) => {
            state.products = action.payload;
        });
    },
});

export const productAction = productSlice.actions;
export default productSlice.reducer;
