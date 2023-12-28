'use client';
import React from 'react';
import Header from './Header';
import Footer from './Footer';
import Sidebar from './Sidebar';
import { ScriptWithCleanup } from '../../../utils/ScriptWithCleanup';

const Layout = ({ children }: any) => {
    return (
        <>
            <Sidebar />
            <main className="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg">
                <Header />
                <div className="content">{children}</div>
                <Footer />
                <div>
                    <div className="fixed-plugin">
                        <a className="fixed-plugin-button text-dark position-fixed px-3 py-2">
                            <i className="fa fa-cog py-2" />
                        </a>
                        <div className="card shadow-lg ">
                            <div className="card-header pb-0 pt-3 ">
                                <div className="float-start">
                                    <h5 className="mt-3 mb-0">Soft UI Configurator</h5>
                                    <p>See our dashboard options.</p>
                                </div>
                                <div className="float-end mt-4">
                                    <button className="btn btn-link text-dark p-0 fixed-plugin-close-button">
                                        <i className="fa fa-close" />
                                    </button>
                                </div>
                                {/* End Toggle Button */}
                            </div>
                            <hr className="horizontal dark my-1" />
                            <div className="card-body pt-sm-3 pt-0">
                                {/* Sidebar Backgrounds */}
                                <div>
                                    <h6 className="mb-0">Sidebar Colors</h6>
                                </div>
                                <a href="#" className="switch-trigger background-color">
                                    <div className="badge-colors my-2 text-start">
                                        <span
                                            className="badge filter bg-gradient-primary active"
                                            data-color="primary"
                                            onClick={(e) => sidebarColor(e.target)}
                                        />
                                        <span
                                            className="badge filter bg-gradient-dark"
                                            data-color="dark"
                                            onClick={(e) => sidebarColor(e.target)}
                                        />
                                        <span
                                            className="badge filter bg-gradient-info"
                                            data-color="info"
                                            onClick={(e) => sidebarColor(e.target)}
                                        />
                                        <span
                                            className="badge filter bg-gradient-success"
                                            data-color="success"
                                            onClick={(e) => sidebarColor(e.target)}
                                        />
                                        <span
                                            className="badge filter bg-gradient-warning"
                                            data-color="warning"
                                            onClick={(e) => sidebarColor(e.target)}
                                        />
                                        <span
                                            className="badge filter bg-gradient-danger"
                                            data-color="danger"
                                            onClick={(e) => sidebarColor(e.target)}
                                        />
                                    </div>
                                </a>
                                {/* Sidenav Type */}
                                <div className="mt-3">
                                    <h6 className="mb-0">Sidenav Type</h6>
                                    <p className="text-sm">Choose between 2 different sidenav types.</p>
                                </div>
                                <div className="d-flex">
                                    <button
                                        className="btn bg-gradient-primary w-100 px-3 mb-2 active"
                                        data-class="bg-transparent"
                                        onClick={(e) => {
                                            sidebarType(e.target);
                                        }}
                                    >
                                        Transparent
                                    </button>
                                    <button
                                        className="btn bg-gradient-primary w-100 px-3 mb-2 ms-2"
                                        data-class="bg-white"
                                        onClick={(e) => {
                                            sidebarType(e.target);
                                        }}
                                    >
                                        White
                                    </button>
                                </div>
                                <p className="text-sm d-xl-none d-block mt-2">
                                    You can change the sidenav type just on desktop view.
                                </p>
                                {/* Navbar Fixed */}
                                <div className="mt-3">
                                    <h6 className="mb-0">Navbar Fixed</h6>
                                </div>
                                <div className="form-check form-switch ps-0">
                                    <input
                                        className="form-check-input mt-1 ms-auto"
                                        type="checkbox"
                                        id="navbarFixed"
                                        onClick={(e) => navbarFixed(e.target)}
                                    />
                                </div>
                                <hr className="horizontal dark my-sm-4" />
                                <a
                                    className="btn bg-gradient-dark w-100"
                                    href="https://www.creative-tim.com/product/soft-ui-dashboard-pro"
                                >
                                    Free Download
                                </a>
                                <a
                                    className="btn btn-outline-dark w-100"
                                    href="https://www.creative-tim.com/learning-lab/bootstrap/license/soft-ui-dashboard"
                                >
                                    View documentation
                                </a>
                                <div className="w-100 text-center">
                                    <a
                                        className="github-button"
                                        href="https://github.com/creativetimofficial/soft-ui-dashboard"
                                        data-icon="octicon-star"
                                        data-size="large"
                                        data-show-count="true"
                                        aria-label="Star creativetimofficial/soft-ui-dashboard on GitHub"
                                    >
                                        Star
                                    </a>
                                    <h6 className="mt-3">Thank you for sharing!</h6>
                                    <a
                                        href="https://twitter.com/intent/tweet?text=Check%20Soft%20UI%20Dashboard%20made%20by%20%40CreativeTim%20%23webdesign%20%23dashboard%20%23bootstrap5&url=https%3A%2F%2Fwww.creative-tim.com%2Fproduct%2Fsoft-ui-dashboard"
                                        className="btn btn-dark mb-0 me-2"
                                        target="_blank"
                                    >
                                        <i className="fab fa-twitter me-1" aria-hidden /> Tweet
                                    </a>
                                    <a
                                        href="https://www.facebook.com/sharer/sharer.php?u=https://www.creative-tim.com/product/soft-ui-dashboard"
                                        className="btn btn-dark mb-0 me-2"
                                        target="_blank"
                                    >
                                        <i className="fab fa-facebook-square me-1" aria-hidden /> Share
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
            <ScriptWithCleanup src="/assets/js/soft-ui-dashboard.js" onLoad={() => console.log('Stripe script loaded')}/>
        </>
    );
};

export default Layout;
