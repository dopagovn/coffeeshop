import { Html, Head, Main, NextScript } from "next/document";
import Script from "next/script";

export default function Document() {
  return (
    <Html>
      <Head>
        <link
          rel="apple-touch-icon"
          sizes="76x76"
          href="/assets/img/apple-icon.png"
        />
        <link rel="icon" type="image/png" href="/assets/img/favicon.png" />
        {/*     Fonts and icons     */}
        <link
          href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
          rel="stylesheet"
        />
        {/* Nucleo Icons */}
        <link href="/assets/css/nucleo-icons.css" rel="stylesheet" />
        <link href="/assets/css/nucleo-svg.css" rel="stylesheet" />
        {/* Font Awesome Icons */}
        <link href="/assets/css/nucleo-svg.css" rel="stylesheet" />
        {/* CSS Files */}
        <link
          id="pagestyle"
          href="/assets/css/soft-ui-dashboard.css?v=1.0.3"
          rel="stylesheet"
        />
      </Head>

      <body className="g-sidenav-show bg-gray-100">
        <Main />
        <NextScript />
        <Script strategy="lazyOnload" src="/assets/js/core/popper.min.js" />
        <Script strategy="lazyOnload" src="/assets/js/core/bootstrap.min.js" />
        <Script
          strategy="lazyOnload"
          src="/assets/js/plugins/perfect-scrollbar.min.js"
        />
        <Script
          strategy="lazyOnload"
          src="/assets/js/plugins/smooth-scrollbar.min.js"
        />
        <Script
          strategy="beforeInteractive"
          src="/assets/js/plugins/chartjs.min.js"
        />
        <Script
          strategy="lazyOnload"
          async
          defer
          src="https://buttons.github.io/buttons.js"
        />
        <Script
          strategy="beforeInteractive"
          async
          src="/assets/js/soft-ui-dashboard.min.js?v=1.0.3"
        />
        <Script
          strategy="lazyOnload"
          async
          src="https://kit.fontawesome.com/42d5adcbca.js"
        ></Script>
        <Script strategy="lazyOnload">
          {`var win = navigator.platform.indexOf('Win') > -1;
    if (win && document.querySelector('#sidenav-scrollbar')) {
      var options = {
        damping: '0.5'
      }
      Scrollbar.init(document.querySelector('#sidenav-scrollbar'), options);
    }`}
        </Script>
      </body>
    </Html>
  );
}
