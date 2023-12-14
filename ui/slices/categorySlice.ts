import { createSlice, PayloadAction } from '@reduxjs/toolkit';
import { getAllCategories } from '../actions/category'; // Import your category actions

type State = any;

const categorySlice = createSlice({
    name: 'category',
    initialState: {
        categorys: [],
    },
    reducers: {},
    extraReducers: (builder: any) => {
        builder.addCase(getAllCategories.fulfilled, (state: State, action: PayloadAction<any>) => {
            state.categorys = action.payload;
        });
    },
});

export default categorySlice.reducer;
