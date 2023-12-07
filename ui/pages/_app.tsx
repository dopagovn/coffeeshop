import type { AppProps } from 'next/app';
import Layout from '../components/layouts/Layout';
import Head from 'next/head';
import Login from './login'
import Register from './register'




export default function App({ Component, pageProps }: AppProps) {


    if (Component === Login) {
        return <Login />
    }
    if (Component === Register) {
        return <Register />
    }


    return(
        <>
            <Head>
                <title>Dashboard | Graindashboard UI Kit</title>
                <meta charSet="utf-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta httpEquiv="x-ua-compatible" content="ie=edge" />
            </Head>

                <Layout>
                    <Component {...pageProps} />
                </Layout>

        </>
    );
}
