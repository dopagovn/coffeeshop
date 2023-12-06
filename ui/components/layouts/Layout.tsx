import React from "react";
import Header from "./Header";
import Footer from "./Footer";
import Sidebar from "./Sidebar";
import Script from "next/script";

const Layout = ({ children }: any) => {
  return (
    <>
      <Sidebar />
      <main className="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg">
        <Header />
        <div className="content">{children}</div>
        <Footer />
      </main>
    </>
  );
};

export default Layout;
