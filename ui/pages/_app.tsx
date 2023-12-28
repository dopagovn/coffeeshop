import type { AppProps } from 'next/app';
import Layout from '../components/layouts/dashboard/Layout';
import Head from 'next/head';
import Login from './login';
import Register from './register';
import { Provider } from 'react-redux';
import store from '../store';
import { PersistGate } from 'redux-persist/integration/react';
import { persistStore } from 'redux-persist';
import Home from './home';
import Order from './order';
import Shop from './shop';
import LayoutCustomer from '../components/layouts/home/Layout';

export default function App({ Component, pageProps }: AppProps) {
    const persistor = persistStore(store);

    switch (Component) {
        case Login:
            return (
                <Provider store={store}>
                    <PersistGate persistor={persistor}>
                        <Login />
                    </PersistGate>
                </Provider>
            );
        case Register:
            return <Register />;
        case Order:
            return <Order />;
        case Home:
            return (
                <>
                <Head>
                    <title>Home</title>
                    <meta charSet="utf-8" />
                    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                    <meta httpEquiv="x-ua-compatible" content="ie=edge" />
                </Head>
                <Provider store={store}>
                    <PersistGate persistor={persistor}>
                        <LayoutCustomer>
                            <Component {...pageProps} />
                        </LayoutCustomer>
                    </PersistGate>
                </Provider>
            </>);

case Shop:
    return (
        <>
        <Head>
            <title>Product</title>
            <meta charSet="utf-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
            <meta httpEquiv="x-ua-compatible" content="ie=edge" />
        </Head>
        <Provider store={store}>
            <PersistGate persistor={persistor}>
                <LayoutCustomer>
                    <Component {...pageProps} />
                </LayoutCustomer>
            </PersistGate>
        </Provider>
    </>);
        default:
    }

    return (
        <>
            <Head>
                <title>Dashboard | Graindashboard UI Kit</title>
                <meta charSet="utf-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta httpEquiv="x-ua-compatible" content="ie=edge" />
            </Head>
            <Provider store={store}>
                <PersistGate persistor={persistor}>
                    <Layout>
                        <Component {...pageProps} />
                    </Layout>
                </PersistGate>
            </Provider>
        </>
    );
}
