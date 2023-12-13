import React from 'react';
import { useEffect, useState } from 'react';
import ApiService from '../pages/table'
import { useDispatch, useSelector } from 'react-redux';
import { getAllProducts } from '../actions/product.jsx';
import { getAllAccounts } from '../actions/account';
import { getAllCategories } from '../actions/category';


const Table = () => {
    const { products } = useSelector(state => state.product)
    const { accounts } = useSelector(state => state.account)
    const { categorys } = useSelector(state => state.category)


    // console.log(data1)

    const dispatch = useDispatch();


    useEffect(() => {
        dispatch(getAllProducts());
        dispatch(getAllAccounts());
        dispatch(getAllCategories());
    }, [dispatch])

    const getCategoryNameById = (categoryId) => {
        const category = categorys.find((data) => data.id === categoryId);
        return category ? category.name : 'Unknown Category';
    };
    return (
        <div>
            <div className="container-fluid py-4">
                {/* bảng product */}
                <div className="row">
                    <div className="col-12">
                        <div className="card mb-4">
                            <div className="card-header px-4 ">
                            <div    className="row gx-6">
                            <div className="col-6">
                                    <h6>Products table</h6>
                                </div>
      <div className="col-6"> {/* Change col-sm to col-sm-auto */}
        <div className="input-container ms-12">
          <input type="text" name="text" className="input" />
          <label className="label">Search</label>
          <div className="top-line" />
          <div className="under-line" />
        </div>
    </div>
                            </div>
     

                            </div>
                            <div className="card-body px-0 pt-0 pb-2">
                                <div className="table-responsive p-0">
                                    <table className="table align-items-center mb-0">
                                        <thead>
                                            <tr>
                                                <th className="text-uppercase text-secondary text-xxs text-center font-weight-bolder opacity-7">
                                                    ID
                                                </th>
                                                <th className="text-uppercase text-secondary text-xxs text-center font-weight-bolder opacity-7 ps-2">
                                                    Tên
                                                </th>
                                                <th className="text-uppercase text-secondary text-xxs text-center font-weight-bolder opacity-7 ps-2">
                                                    Loại
                                                </th>
                                                <th className="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                                    Số Lượng
                                                </th>

                                                <th className="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                                    Giá
                                                </th>
                                                <th className="text-secondary opacity-7" />
                                            </tr>
                                        </thead>
                                        <tbody>
                                            {products.map((product, index) => (
                                                <tr key={index}>
                                                    <td>
                                                        <p className="text-center font-weight-bold mb-0">{product.id}</p>
                                                    </td>

                                                    <td>
                                                        <div className="d-flex px-6 py-1">
                                                            <div>
                                                                <img
                                                                    src={product.productImage}
                                                                    className="avatar avatar-sm me-3"
                                                                    alt={product.productName}
                                                                />
                                                            </div>
                                                            <div className="d-flex flex-column justify-content-center">
                                                                <h6 className="mb-0 text-sm">{product.productName}</h6>
                                                                <p className="text-xs text-secondary mb-0">
                                                                    {product.productDescription}
                                                                </p>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <p className="text-center font-weight-bold mb-0">
                                                            {getCategoryNameById(product.categoryId)}
                                                        </p>
                                                    </td>
                                                    <td>
                                                        <p className="text-center font-weight-bold mb-0">{product.stockQuantity}</p>
                                                    </td>
                                                    <td className="align-middle text-center text-sm">
                                                        <span className="badge badge-sm bg-gradient-success">{product.productPrice} ₫</span>
                                                    </td>
                                                </tr>
                                            ))}

                                        </tbody>
                                    </table>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                {/* bảng category */}
                <div className="row">
                    <div className="col-12">
                        <div className="card mb-4">
                            <div className="card-header pb-0">
                                <h6>Category table</h6>
                            </div>
                            <div className="card-body px-0 pt-0 pb-2">
                                <div className="table-responsive p-0">
                                    <table className="table align-items-center mb-0">
                                        <thead>
                                            <tr>
                                                <th className="text-uppercase text-secondary text-xxs text-center font-weight-bolder opacity-7">
                                                    ID
                                                </th>
                                                <th className="text-uppercase text-secondary text-xxs text-center font-weight-bolder opacity-7 ps-2">
                                                    Tên
                                                </th>

                                                <th className="text-secondary opacity-7" />
                                            </tr>
                                        </thead>
                                        <tbody>
                                            {categorys.map((category, index) => (
                                                <tr key={index}>
                                                    <td>
                                                        <p className="text-center font-weight-bold mb-0">{category.id}</p>
                                                    </td>
                                                    <td>
                                                        <p className="text-center font-weight-bold mb-0">{category.name}</p>
                                                    </td>

                                                </tr>
                                            ))}

                                        </tbody>
                                    </table>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    );
};

export default Table;
