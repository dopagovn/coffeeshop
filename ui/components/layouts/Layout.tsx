import React from "react";
import Header from "./Header";
import Footer from "./Footer";
import Sidebar from "./Sidebar";
import Script from "next/script";

const Layout = ({ children }: any) => {
  return (
    <>
      <Header />
      <main className="main">
        <Sidebar />
        <div className="content">{children}</div>
      </main>
      <Footer />
    </>
  );
};

export default Layout;
