'use client';
import React from 'react';
import Header from './Header';
import Footer from './Footer';
import { ScriptWithCleanup } from '../../../utils/ScriptWithCleanup';
import Script from 'next/script';




const LayoutCustomer = ({ children }: any) => {
    return (
        <>
        
            <div data-bs-spy="scroll" data-bs-target="#navbar" data-bs-root-margin="0px 0px -40%" data-bs-smooth-scroll="true" tabIndex={0}></div>
            <Header/>
                <div className="content">{children}</div>

               
                <ScriptWithCleanup strategy="beforeInteractive" src="/assets/js/modernizr.js" />
                <ScriptWithCleanup strategy="beforeInteractive"  src="/assets/js/jquery.min.js" />
                <ScriptWithCleanup strategy="beforeInteractive"
                    src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
                    crossOrigin="anonymous"
                ></ScriptWithCleanup>
                <ScriptWithCleanup
                   strategy="beforeInteractive"
                    async
                    src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"
                ></ScriptWithCleanup>
                <ScriptWithCleanup strategy="beforeInteractive" src="/assets/js/Script.js" />
                <ScriptWithCleanup strategy="beforeInteractive" src="/assets/js/plugins.js" />
            <Footer/>

            

      
            
        </>
    );
};

export default LayoutCustomer;
