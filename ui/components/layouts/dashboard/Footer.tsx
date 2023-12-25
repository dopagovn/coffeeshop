import React from 'react';

const Footer = () => {
    return (
        <div>
           <footer id="footer" className="mt-5">
        <div className="container-lg">
          <div className="row justify-content-between py-5">
            <div className="col-lg-3 col-md-6 mb-5">
              <div className="footer-menu">
                <div className="footer-intro mb-2">
                  <h4 className="fs-2 fst-italic pb-2">Know Our Wing Tea</h4>
                  <p>We are the best tea supplier in the town. Our main motive is to make our beautiful people stay fit &amp; healthy everytime.</p>
                  <form id="form" className="mt-4 position-relative">
                    <input type="text" name="email" placeholder="Your Email Addresss" className="border-0 border-bottom bg-transparent w-100" />
                    <a href="#">
                      <svg className="send svg-primary position-absolute" width={20} height={20}>
                        <use xlinkHref="#send" />
                      </svg>
                    </a>
                  </form>
                </div>
              </div>
            </div>
            <div className="col-lg-2 col-md-6">
              <div className="footer-menu">
                <h5 className="widget-title fst-italic">Quick Links</h5>
                <ul className="menu-list list-unstyled">
                  <li className="menu-item fw-medium pb-2">
                    <a href="index.html" className="item-anchor">Home</a>
                  </li>
                  <li className="menu-item fw-medium pb-2">
                    <a href="about.html" className="item-anchor">About</a>
                  </li>
                  <li className="menu-item fw-medium pb-2">
                    <a href="shop.html" className="item-anchor">Shop</a>
                  </li>
                  <li className="menu-item fw-medium pb-2">
                    <a href="blog.html" className="item-anchor">Blogs</a>
                  </li>
                </ul>
              </div>
            </div>
            <div className="col-lg-2 col-md-6">
              <div className="footer-menu">
                <h5 className="widget-title fst-italic">Help</h5>
                <ul className="menu-list list-unstyled">
                  <li className="menu-item fw-medium pb-2">
                    <a href="faqs.html" className="item-anchor">Faqs</a>
                  </li>
                  <li className="menu-item fw-medium pb-2">
                    <a href="#" className="item-anchor">Store policy</a>
                  </li>
                  <li className="menu-item fw-medium pb-2">
                    <a href="#" className="item-anchor">Shipping &amp; returns</a>
                  </li>
                  <li className="menu-item fw-medium pb-2">
                    <a href="checkout.html" className="item-anchor">Checkout</a>
                  </li>
                  <li className="menu-item fw-medium pb-2">
                    <a href="#" className="item-anchor">Contact</a>
                  </li>
                </ul>
              </div>
            </div>
            <div className="col-lg-2 col-md-6">
              <div className="footer-menu">
                <h5 className="widget-title fst-italic">Social Links</h5>
                <div className="social-links">
                  <ul className="list-unstyled">
                    <li className="fw-medium pb-2">
                      <a href="#">Facebook </a>
                    </li>
                    <li className="fw-medium pb-2">
                      <a href="#">Instagram </a>
                    </li>
                    <li className="fw-medium pb-2">
                      <a href="#">Pinterest </a>
                    </li>
                    <li className="fw-medium pb-2">
                      <a href="#">Twitter </a>
                    </li>
                    <li className="fw-medium pb-2">
                      <a href="#">Youtube </a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div className="border-top py-4">
          <div className="container-lg">
            <div className="row justify-content-between">
              <div className="col-md-10">
                <p>©2023 Template designed by <a href="https://templatesjungle.com" target="_blank" className="fw-medium">TemplatesJungle</a>
                </p>
              </div>
              <div className="col-md-2">
                <a href="#" className="d-flex">
                  <svg className="arrow-up svg-primary position-absolute" width={20} height={20}>
                    <use xlinkHref="#arrow-up" />
                  </svg>
                  <span className="ps-4">Back to top</span>
                </a>
              </div>
            </div>
          </div>
        </div>
      </footer>
        </div>
    );
};

export default Footer;
