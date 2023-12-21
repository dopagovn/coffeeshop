import { CaseReducer, PayloadAction, createSlice } from '@reduxjs/toolkit';
import { getProductById } from '../../actions/product';

type State = any;
const increment: CaseReducer<State, PayloadAction<any>> = (state, action) => state + action.payload;

const productSlice = createSlice({
    name: 'product',
    initialState: {
        code: 0,
        product: {},
        message: '',
        status: '',
    },
    reducers: {
        increment,
    },
    extraReducers: (builder: any) => {
        builder.addCase(getProductById.fulfilled, (state: State, action: any) => {
            state.product = action.payload.data;
            state.code = action.payload.code;
            state.message = action.payload.message;
            state.status = action.payload.status;
        });
    },
});

export const productAction = productSlice.actions;
export default productSlice.reducer;
