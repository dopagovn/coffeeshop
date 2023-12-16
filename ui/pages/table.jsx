import { useEffect, useState } from 'react';
import ApiService from '../pages/table';
import { useDispatch, useSelector } from 'react-redux';
import { createProduct, deleteProduct, getAllProducts, getProductById } from '../actions/product.jsx';
import { getAllAccounts } from '../actions/account';
import { getAllCategories } from '../actions/category';
import { viewEditProductForm } from '../constants/formState.ts';
import Modal from '../components/modal/product.tsx';



// import Image from 'next/image';

const Table = () => {
    const { products } = useSelector((state) => state.product.productList);
    const { product } = useSelector((state) => state.product.productCreateEdit);
    const { categories } = useSelector((state) => state.category);
    const [searchTerm, setSearchTerm] = useState('');
    const [isEdit, setIsEdit] = useState(false);

    const [productData, setProductData] = useState(viewEditProductForm);

    const handleButtonCreateProduct = () => {
        setProductData({ ...viewEditProductForm });
        setIsEdit(false);
    }

    const handleButtonEditProduct = (id) => {
        dispatch(getProductById(id));
        setProductData(product);
        setIsEdit(true);
    }

    const handleChange = (e) => {
        const { name, value } = e.target;
        setProductData({
            ...productData,
            [name]: value,
        });
    };

    const onCreateProduct = async (e) => {

        await dispatch(createProduct(productData));

        // Đóng modal sau khi submit
        handleCloseModal();

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

        const handleDelete = async (id) => {
            await dispatch(deleteProduct(id));
            await dispatch(getAllProducts());
        };

        const dispatch = useDispatch();

        useEffect(() => {
            dispatch(getAllProducts());
            dispatch(getAllAccounts());
            dispatch(getAllCategories());
        }, [dispatch]);

        const filteredProducts = products.filter((products) =>
            products.productName.toLowerCase().includes(searchTerm.toLowerCase()),
        );

        const getCategoryNameById = (categoryId) => {
            const category = categories.find((data) => data.id === categoryId);
            return category ? category.name : 'Unknown Category';
        };

        return (

            <div className="container-fluid py-4">
                <Modal isEdit={isEdit} setIsEdit={setIsEdit} onCreateProduct={onCreateProduct} productData={productData} setProduct={setProductData} handleChange={handleChange} />

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

                                        <button type='button' data-bs-toggle="modal" tabIndex={0} onClick={handleButtonCreateProduct} data-bs-target="#exampleModal" className="plusButton col-2 mx-4" >
                                            <svg
                                                className="plusIcon"
                                                xmlns="http://www.w3.org/2000/svg"
                                                viewBox="0 0 30 30"
                                            >
                                                <g mask="url(#mask0_21_345)">
                                                    <path d="M13.75 23.75V16.25H6.25V13.75H13.75V6.25H16.25V13.75H23.75V16.25H16.25V23.75H13.75Z" />
                                                </g>
                                            </svg>
                                        </button>
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
                                                                    src={product.productImage}
                                                                    alt={product.productName}
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
                                                            <button data-bs-toggle="modal" tabIndex={0} className="btn btn-link text-dark px-3 mb-0" onClick={() => handleButtonEditProduct(product.id)} data-bs-target="#exampleModal" >
                                                                <i
                                                                    className="fas fa-pencil-alt text-dark me-2"
                                                                    aria-hidden="true"
                                                                />
                                                                Edit
                                                            </button>
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

        );
    };
}

export default Table;
