import React from "react";

const Footer = () => {
  return (
    <>
      <footer className="footer pt-3  ">
        <div className="container-fluid">
          <div className="row align-items-center justify-content-lg-between">
            <div className="col-lg-6 mb-lg-0 mb-4">
              <div className="copyright text-center text-sm text-muted text-lg-start">
                © , made with <i className="fa fa-heart" /> by &nbsp;
                <a
                  href="https://www.google.com"
                  className="font-weight-bold"
                  target="_blank"
                >
                  Lucky team &nbsp;
                </a>
                for a better coffee shop.
              </div>
            </div>
          </div>
        </div>
      </footer>
    </>
  );
};

export default Footer;
