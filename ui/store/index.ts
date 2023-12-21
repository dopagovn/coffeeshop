import { Tuple, combineReducers, configureStore } from '@reduxjs/toolkit';
import { persistReducer } from 'redux-persist';
import thunk, { ThunkMiddleware } from 'redux-thunk';
import storage from 'redux-persist/lib/storage';
import productListReducer from '../slices/productSlice/productListSlice';
import productCreateEdit from '../slices/productSlice/productSlice';
import categoryListReducer from '../slices/categorySlice/categoryListSlice';
import categoryCreateEdit from '../slices/categorySlice/categorySlice';
import accountReducer from '../slices/accountSlice';


export type RootState = ReturnType<typeof reducer>;

const persistConfig = {
    key: 'root',
    storage,
};

const productsReducer = combineReducers({
    productCreateEdit: productCreateEdit,
    productList: productListReducer,
});
const categoriesReducer = combineReducers({
    categoryCreateEdit: categoryCreateEdit,
    categoryList: categoryListReducer,
});

const reducer = combineReducers({
    category: categoriesReducer,
    product: productsReducer,
    account: accountReducer,
});

const persistedReducer = persistReducer(persistConfig, reducer);

type ThunkType = ThunkMiddleware<RootState, any>;

const store = configureStore({
    reducer: persistedReducer,
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware({
            thunk: true,
        }),
});

export default store;