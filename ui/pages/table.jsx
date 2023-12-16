import React from 'react';
import { useEffect, useState } from 'react';
import ApiService from '../pages/table';
import { useDispatch, useSelector } from 'react-redux';
import { createProduct, deleteProduct, getAllProducts } from '../actions/product.jsx';
import { getAllAccounts } from '../actions/account';
import { getAllCategories } from '../actions/category';
import { Modal } from 'react-bootstrap';


// import Image from 'next/image';

const Table = () => {
    
    const { products } = useSelector((state) => state.product);
    
    const { categories } = useSelector((state) => state.category);
    const [searchTerm, setSearchTerm] = useState('');
    const [showModal, setShowModal] = useState(false);
    const [productImage, setProductImage] = useState(false);


    useEffect(() => {
      
    
      return () => {
        productImage && URL.revokeObjectURL(productImage.preview);
      }
    }, [productImage])
    


    const [newProduct, setNewProduct] = useState({
        categoryId: '1',
        productName: '',
        productDescription: '',
        productPrice: '',
        productImage: '',
        stockQuantity: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;

        setNewProduct({ ...newProduct, [name]: value });
    };

    const handleImageChange = (e) => {
        const file = e.target.files[0];
        file.preview =  URL.createObjectURL(file)
        setProductImage(file)
        console.log(URL.createObjectURL(file))
      };

      const handleSubmit = async (e) => {
        e.preventDefault();
    
        // Tạo một đối tượng FormData để gửi tệp hình ảnh
        const formData = new FormData();
        formData.append('image', productImage); // 'image' nên phù hợp với trường được mong đợi trong API của bạn
    
        // Thêm các trường dữ liệu khác vào FormData
        formData.append('categoryId', newProduct.categoryId);
        formData.append('productName', newProduct.productName);
        formData.append('productDescription', newProduct.productDescription);
        formData.append('productPrice', newProduct.productPrice);
        formData.append('stockQuantity', newProduct.stockQuantity);
    
        try {
            // Gửi dữ liệu form đến điểm cuối API bằng ApiService hoặc bất kỳ thư viện HTTP nào (axios, fetch, v.v.)
            const response = await ApiService.uploadImage('/upload-image', formData);
    
            // Xử lý phản hồi từ API theo cách cần thiết
            console.log('Hình ảnh đã được tải lên thành công:', response);
    
            // Phần còn lại của mã của bạn...
        } catch (error) {
            console.error('Lỗi khi tải lên hình ảnh:', error);
        }
    };
    
      
    const handleDelete = (id) => {
        dispatch(deleteProduct(id))
            .then(() => {
                setDeleteSuccess(true);
                setTimeout(() => {
                    setDeleteSuccess(false);
                }, 3000); // Hide alert after 3 seconds
                dispatch(getAllProducts());
            })
            .catch((error) => {
                console.error('Error deleting product:', error);
            });
    };

    const dispatch = useDispatch();

    useEffect(() => {
        dispatch(getAllProducts());
        dispatch(getAllAccounts());
        dispatch(getAllCategories());
    }, [dispatch]);

    const filteredProducts = products.filter((product) =>
        product.productName.toLowerCase().includes(searchTerm.toLowerCase()),
    );

    const getCategoryNameById = (categoryId) => {
        const category = categories.find((data) => data.id === categoryId);
        return category ? category.name : 'Unknown Category';
    };

    const handleShowModal = () => {
        setShowModal(true);
    };

    const handleCloseModal = () => {
        setShowModal(false);
    };
    const [deleteSuccess, setDeleteSuccess] = useState(false);
    return (
        <div>
            <div className="container-fluid py-4">
                {deleteSuccess && (
                    <div className="alert alert-success alert-dismissible fade show" role="alert">
                        <span className="alert-icon">
                            <i className="ni ni-like-2" />
                        </span>
                        <span className="alert-text">
                            <strong>Success!</strong> Product deleted successfully.
                        </span>
                        <button
                            type="button"
                            className="btn-close"
                            onClick={() => setDeleteSuccess(false)}
                            aria-label="Close"
                        >
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                )}

                {/* bảng product */}
                <div className="row">
                    <div className="col-12">
                        <div className="card mb-4">
                            <div className="card-header px-4 ">
                                <div className="row gx-6 align-items-center">
                                    <div className="col-6">
                                        <h6>Products table</h6>
                                    </div>
                                    <div className="col-6 d-flex justify-content-end">
                                        {/* search*/}
                                        <div className="input-container  ms-6">
                                            <input
                                                type="text"
                                                name="text"
                                                className="input"
                                                value={searchTerm}
                                                onChange={(e) => setSearchTerm(e.target.value)}
                                            />
                                            <label className="label">Search</label>
                                            <div className="top-line" />
                                            <div className="under-line" />
                                        </div>
                                        {/* create-prouct */}

                                        <div tabIndex={0} className="plusButton col-2 mx-4" onClick={handleShowModal}>
                                            <svg
                                                className="plusIcon"
                                                xmlns="http://www.w3.org/2000/svg"
                                                viewBox="0 0 30 30"
                                            >
                                                <g mask="url(#mask0_21_345)">
                                                    <path d="M13.75 23.75V16.25H6.25V13.75H13.75V6.25H16.25V13.75H23.75V16.25H16.25V23.75H13.75Z" />
                                                </g>
                                            </svg>
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
                                            {filteredProducts.map((product, index) => (
                                                <tr key={index}>
                                                    <td>
                                                        <p className="text-center font-weight-bold mb-0">
                                                            {product.id}
                                                        </p>
                                                    </td>

                                                    <td>
                                                        <div className="d-flex px-6 py-1">
                                                            <div>
                                                                <image
                                                                    src={product.imageFileName}
                                                                    alt={product.imageFileName}
                                                                    width={50}
                                                                    height={50}
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
                                                        <p className="text-center font-weight-bold mb-0">
                                                            {product.stockQuantity}
                                                        </p>
                                                    </td>
                                                    <td className="align-middle text-center text-sm">
                                                        <span className="badge badge-sm bg-gradient-success">
                                                            {product.productPrice} ₫
                                                        </span>
                                                    </td>
                                                    <td className="align-middle text-center text-sm">
                                                        <div className="ms-auto text-end">
                                                            <button
                                                                className="btn btn-link text-danger text-gradient px-3 mb-0"
                                                                onClick={() => handleDelete(product.id)}
                                                            >
                                                                <i className="far fa-trash-alt me-2" />
                                                                Delete
                                                            </button>
                                                            <a className="btn btn-link text-dark px-3 mb-0" href="#">
                                                                <i
                                                                    className="fas fa-pencil-alt text-dark me-2"
                                                                    aria-hidden="true"
                                                                />
                                                                Edit
                                                            </a>
                                                        </div>
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
                                            {categories.map((category, index) => (
                                                <tr key={index}>
                                                    <td>
                                                        <p className="text-center font-weight-bold mb-0">
                                                            {category.id}
                                                        </p>
                                                    </td>
                                                    <td>
                                                        <p className="text-center font-weight-bold mb-0">
                                                            {category.name}
                                                        </p>
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
            <Modal show={showModal} onHide={handleCloseModal} size="lg">
                <Modal.Header closeButton>
                    <Modal.Title>Create New Product</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <div className="formbold-main-wrapper">
                        <div className="formbold-form-wrapper">
                            <div>
                                <div className="formbold-input-wrapp formbold-mb-3">
                                    <label htmlFor="firstname" className="formbold-form-label">
                                        Name
                                    </label>
                                    <div>
                                        <input
                                            type="text"
                                            name="productName"
                                            id="productName"
                                            value={newProduct.productName}
                                            placeholder="Last name"
                                            className="formbold-form-input"
                                            onChange={handleChange}
                                        />
                                    </div>
                                </div>
                                <div className="formbold-mb-3">
                                    <label className="formbold-form-label">Loại</label>
                                    <select
                                        className="formbold-form-input"
                                        name="categoryId"
                                        id="categoryId "
                                        onChange={handleChange}
                                        value={newProduct.categoryId}
                                    >
                                        {categories.map((category) => (
                                            <option key={category.id} value={category.id}>
                                                {category.name}
                                            </option>
                                        ))}
                                    </select>
                                </div>
                                <div className="formbold-mb-3">
                                    <label htmlFor="address" className="formbold-form-label">
                                        Mô tả
                                    </label>
                                    <textarea
                                        id="productDescription"
                                        name="productDescription"
                                        onChange={handleChange}
                                        value={newProduct.productDescription}
                                    ></textarea>
                                </div>
                                <div className="formbold-mb-3">
                                    <label htmlFor="age" className="formbold-form-label">
                                        Giá
                                    </label>
                                    <input
                                        type="text"
                                        name="productPrice"
                                        id="price"
                                        className="formbold-form-input"
                                        onChange={handleChange}
                                        value={newProduct.productPrice}
                                    />
                                </div>
                                <div className="formbold-mb-3">
                                    <label htmlFor="stockQuantity" className="formbold-form-label">
                                        Số Lượng
                                    </label>
                                    <input
                                        type="text"
                                        name="stockQuantity"
                                        id="stockQuantity"
                                        className="formbold-form-input"
                                        onChange={handleChange}
                                        value={newProduct.stockQuantity}
                                    />
                                </div>

                                {/* <div className="formbold-mb-3">
                                    <label htmlFor="productImage" className="formbold-form-label">
                                        Ảnh
                                    </label>
                                    <input
                                        type="text"
                                        name="productImage"
                                        id="productImage"
                                        className="formbold-form-input"
                                        onChange={handleChange}
                                        value={newProduct.productImage}
                                    />
                                </div> */}
                                
                                <input type="file" id="file-upload" required  onChange={(e) => handleImageChange(e)}/>
                                {productImage&&(
                                    <img src={productImage.preview} alt='' width="30%"/>
                                )}
                                <button className="formbold-btn" onClick={handleSubmit}>
                                    Submit
                                </button>
                            </div>
                        </div>
                    </div>
                </Modal.Body>
            </Modal>
        </div>
    );
};

export default Table;
