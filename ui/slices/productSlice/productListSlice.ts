import { CaseReducer, PayloadAction, createSlice } from '@reduxjs/toolkit';
import { getAllProducts } from '../../actions/product';

type State = any;
const increment: CaseReducer<State, PayloadAction<any>> = (state, action) => state + action.payload;

const productListSlice = createSlice({
    name: 'product',
    initialState: {
        code: 0,
        products: [],
        message: '',
        status: '',
    },
    reducers: {
        increment,
    },
    extraReducers: (builder: any) => {
        builder.addCase(getAllProducts.fulfilled, (state: State, action: any) => {
            state.products = action.payload.data;
            state.code = action.payload.code;
            state.message = action.payload.message;
            state.status = action.payload.status;
        });
    },
});

export const productAction = productListSlice.actions;
export default productListSlice.reducer;