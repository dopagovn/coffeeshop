'use client';

import Link from 'next/link';
import { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { getAllProducts } from '../../actions/product.jsx';


const Login = () => {


    // const {data} = useSelector(state => state.product);

    const { data } = useSelector(state => state.product);

    const dispatch = useDispatch();


    useEffect(() => {
        dispatch(getAllProducts());
    }, [])



    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');

    const handleUserNameChange = (e) => {
        setUserName(e.target.value);
    };

    const handlePasswordChange = (e) => {
        setPassword(e.target.value);
    };

    const handleSignIn = () => {

        console.log('User Name:', userName);
        console.log('Password:', password);
    };
    return (
        <>
            <div>
                <div className="container position-sticky z-index-sticky top-0">
                    <div className="row">
                        <div className="col-12">
                            {/* Navbar */}
                            <nav className="navbar navbar-expand-lg blur blur-rounded top-0 z-index-3 shadow position-absolute my-3 py-2 start-0 end-0 mx-4">
                                <div className="container-fluid pe-0">
                                    <a
                                        className="navbar-brand font-weight-bolder ms-lg-0 ms-3 "
                                        href="../pages/dashboard.html"
                                    >

                                        Soft UI Dashboard

                                    </a>
                                    <button
                                        className="navbar-toggler shadow-none ms-2"
                                        type="button"
                                        data-bs-toggle="collapse"
                                        data-bs-target="#navigation"
                                        aria-controls="navigation"
                                        aria-expanded="false"
                                        aria-label="Toggle navigation"
                                    >
                                        <span className="navbar-toggler-icon mt-2">
                                            <span className="navbar-toggler-bar bar1" />
                                            <span className="navbar-toggler-bar bar2" />
                                            <span className="navbar-toggler-bar bar3" />
                                        </span>
                                    </button>
                                    <div className="collapse navbar-collapse" id="navigation">
                                        <ul className="navbar-nav mx-auto ms-xl-auto me-xl-7">
                                            <li className="nav-item">
                                                <Link className="nav-link me-2" href="register">
                                                    <i className="fas fa-user-circle opacity-6 text-dark me-1" />
                                                    Sign Up
                                                </Link>
                                            </li>
                                            <li className="nav-item">
                                                <Link className="nav-link me-2" href="/login">
                                                    <i className="fas fa-key opacity-6 text-dark me-1" />
                                                    Sign In
                                                </Link>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </nav>
                            {/* End Navbar */}
                        </div>
                    </div>
                </div>
                <main className="main-content  mt-0">
                    <section>
                        <div className="page-header min-vh-75">
                            <div className="container">
                                <div className="row">
                                    <div className="col-xl-4 col-lg-5 col-md-6 d-flex flex-column mx-auto">
                                        <div className="card card-plain mt-8">
                                            <div className="card-header pb-0 text-left bg-transparent">
                                                <h3 className="font-weight-bolder text-info text-gradient">
                                                    Welcome back
                                                </h3>
                                                <p className="mb-0">Enter your UserName and Password to sign in</p>
                                            </div>
                                            <div className="card-body">
                                                <form role="form">
                                                    <label>UserName</label>
                                                    <div className="mb-3">
                                                        <input
                                                            type="text"
                                                            className="form-control"
                                                            placeholder="userName"
                                                            aria-label="userName"

                                                            value={userName}
                                                            onChange={handleUserNameChange}
                                                        />
                                                    </div>
                                                    <label>Password</label>
                                                    <div className="mb-3">
                                                        <input
                                                            type="email"
                                                            className="form-control"
                                                            placeholder="Password"
                                                            aria-label="Password"

                                                            value={password}
                                                            onChange={handlePasswordChange}
                                                        />
                                                    </div>
                                                    <div className="form-check form-switch">
                                                        <input
                                                            className="form-check-input"
                                                            type="checkbox"
                                                            id="rememberMe"
                                                            defaultChecked
                                                        />
                                                        <label className="form-check-label" htmlFor="rememberMe">
                                                            Remember me
                                                        </label>
                                                    </div>
                                                    <div className="text-center">
                                                        <button
                                                            type="button"
                                                            className="btn bg-gradient-info w-100 mt-4 mb-0"
                                                        >
                                                            Sign in
                                                        </button>
                                                    </div>
                                                </form>
                                            </div>
                                            <div className="card-footer text-center pt-0 px-lg-2 px-1">
                                                <p className="mb-4 text-sm mx-auto">
                                                    Don't have an account?
                                                    <Link
                                                        href="/register"
                                                        className="text-info text-gradient font-weight-bold"
                                                    >
                                                        Sign up
                                                    </Link>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="col-md-6">
                                        <div className="oblique position-absolute top-0 h-100 d-md-block d-none me-n8">
                                            <div
                                                className="oblique-image bg-cover position-absolute fixed-top ms-auto h-100 z-index-0 ms-n6"
                                                style={{
                                                    backgroundImage: 'url("../assets/img/curved-images/curved6.jpg")',
                                                }}
                                            />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </main>
            </div>

            {/* script */}
        </>
    );
};

export default Login;
