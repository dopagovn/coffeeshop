'use client';

import React, { useEffect } from 'react';

type Props = {
    isEdit: any;
    setIsEdit: any;
    categoryData: any;
    setCategoryData: any;
    onCreateProduct: any;
    handleChangeCategory: any;
    categories: any;
    handleClose: any;
    onImageChange: any;
};

const CategoryModal = (props: Props) => {
    return (
        <div
            className="modal fade"
            id="categoryModal"
            tabIndex={-1}
            role="dialog"
            aria-labelledby="categoryModalLabel"
            aria-hidden="true"
        >
            <div className="modal-dialog modal-dialog-centered" role="document">
                <div className="modal-content">
                    <div className="modal-header">
                        <h5 className="modal-title" id="categoryModalLabel">
                            {props.isEdit ? 'Update' : 'Create'} Category
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
                                        Category Name
                                    </label>
                                    <input
                                        type="text"
                                        name="categoryName"
                                        className="form-control"
                                        placeholder="Category name"
                                        value={props.categoryData.name}
                                        onChange={props.handleChangeCategory}
                                    />
                                </div>
                            </div>
                            <div className="col">
                                <div className="form-group">
                                    <label htmlFor="" className="form-contol-label">
                                        Product name
                                    </label>

                                    <ul className="list-group list-group-flush">
                                        <li className="list-group-item">Cras justo odio</li>
                                        <li className="list-group-item">Dapibus ac facilisis in</li>
                                        <li className="list-group-item">Morbi leo risus</li>
                                        <li className="list-group-item">Porta ac consectetur ac</li>
                                        <li className="list-group-item">Vestibulum at eros</li>
                                    </ul>
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
                        <button type="button" className="btn bg-gradient-primary" onClick={props.onCreateProduct}>
                            Save changes
                        </button>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default CategoryModal;
