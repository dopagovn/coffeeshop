import { Tuple, combineReducers, configureStore } from '@reduxjs/toolkit';
import { persistReducer } from 'redux-persist';
import thunk, { ThunkMiddleware } from 'redux-thunk';
import storage from 'redux-persist/lib/storage';
import productListReducer from '../slices/productListSlice';
import productCreateEdit from '../slices/productSlice';
import accountReducer from '../slices/accountSlice';
import categoryReducer from '../slices/categorySlice';

export type RootState = ReturnType<typeof reducer>;

const persistConfig = {
    key: 'root',
    storage,
};

const productsReducer = combineReducers({
    productCreateEdit: productCreateEdit,
    productList: productListReducer,
});

const reducer = combineReducers({
    product: productsReducer,
    account: accountReducer,
    category: categoryReducer,
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
