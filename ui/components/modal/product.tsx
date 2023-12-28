'use client';

import React, { useEffect } from 'react';

type Props = {
    isEdit: any;
    setIsEdit: any;
    setProductData: any;
    productData: any;
    onCreateProduct: any;
    handleChangeProduct: any;
    categories: any;
    handleClose: any;
    onImageChange: any;
    onEditProduct: any;

};

const ProductModal = (props: Props) => {

    
    return (

        
        <div
            className="modal fade"
            id="exampleModal"
            tabIndex={-1}
            role="dialog"
            aria-labelledby="exampleModalLabel"
            aria-hidden="true"
        >
            <div className="modal-dialog modal-dialog-centered" role="document">
                <div className="modal-content">
                    <div className="modal-header">
                        <h5 className="modal-title" id="exampleModalLabel">
                            {props.isEdit ? 'Update' : 'Create'} Product
                        </h5>
                        <button
                            type="button"
                            className="btn-close text-dark"
                            data-bs-dismiss="modal"
                            aria-label="Close"
                        >
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div className="modal-body">
                        <div className="row">
                            <div className="col">
                                <div className="form-group">
                                    <label htmlFor="" className="form-contol-label">
                                        Product name
                                    </label>
                                    <input
                                        type="text"
                                        name="productName"
                                        className="form-control"
                                        placeholder="Product name"
                                        value={props.productData.productName}
                                        onChange={props.handleChangeProduct}
                                    />
                                </div>
                            </div>
                            <div className="col">
                                <div className="form-group">
                                    <label htmlFor="">Select category</label>
                                    <select
                                        name="categoryId"
                                        id=""
                                        className="form-control"
                                        value={props.productData.categoryId}
                                        onChange={props.handleChangeProduct}
                                    >
                                        {props.categories && props.categories.map((category: any) => (
                                            <option key={category.id} value={category.id}>
                                                {category.name}
                                            </option>
                                        ))}
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div className="row">
                            <div className="col">
                                <div className="form-group">
                                    <label htmlFor="" className="form-contol-label">
                                        Product description
                                    </label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        name="productDescription"
                                        placeholder="Product description"
                                        value={props.productData.productDescription}
                                        onChange={props.handleChangeProduct}
                                    />
                                </div>
                            </div>
                            <div className="col">
                                <div className="form-group">
                                    <label htmlFor="" className="form-contol-label">
                                        Product price
                                    </label>
                                    <div className="input-group">
                                        <input
                                            value={props.productData.productPrice}
                                            name="productPrice"
                                            type="text"
                                            className="form-control"
                                            onChange={props.handleChangeProduct}
                                        />
                                        <span className="input-group-text">VNĐ</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="row">
                            <div className="col">
                                <div className="form-group">
                                    <label htmlFor="" className="form-contol-label">
                                        Product image
                                    </label>
                                    <input type="file" name='productImage' onChange={props.onImageChange} className="form-control" />
                                </div>
                            </div>
                            <div className="col">
                                <div className="form-group">
                                    <label htmlFor="">Stock quantity</label>
                                    <input
                                        type="text"
                                        name="stockQuantity"
                                        className="form-control"
                                        placeholder="Stock quantity"
                                        value={props.productData.stockQuantity}
                                        onChange={props.handleChangeProduct}
                                    />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="modal-footer">
                        <button
                            type="button"
                            onClick={props.handleClose}
                            className="btn bg-gradient-secondary"
                            data-bs-dismiss="modal"
                        >
                            Close
                        </button>
                        <button
    type="button"
    className="btn bg-gradient-primary"
    
    onClick={props.isEdit ? () => props.onEditProduct(props.productData.id) : () => props.onCreateProduct()}
    
>
    {props.isEdit ? 'Update' : 'Save changes'}
</button>

                    </div>
                </div>
            </div>
        </div>
    );
};

export default ProductModal;
