import { useEffect, useState } from 'react';

import { useDispatch, useSelector } from 'react-redux';
import { createProduct, deleteProduct, getAllProducts, getProductById } from '../actions/product.jsx';
import { getAllAccounts } from '../actions/account';
import { deleteCategoryById, getAllCategories, getCategoryById } from '../actions/category.jsx';
import { viewEditProductForm, viewEditCategoryForm } from '../constants/formState.ts';
import ProductModal from '../components/modal/product.tsx';
import CategoryModal from '../components/modal/category.tsx';
import ApiService from '../utils/api.ts';
import Alert from '../components/alert/index.jsx';


const Table = () => {
    const { products } = useSelector((state) => state.product.productList);
    const { product } = useSelector((state) => state.product.productCreateEdit);

    const { categories } = useSelector((state) => state.category.categoryList);
    const { categoryItem } = useSelector((state) => state.category.categoryCreateEdit);

    const [searchTerm, setSearchTerm] = useState('');
    const [searchCategory, setSearchCategory] = useState('');
    const [isEdit, setIsEdit] = useState(false);
    const [productData, setProductData] = useState(viewEditProductForm);
    const [categoryData, setCategoryData] = useState(viewEditCategoryForm);
    const [image, setImage] = useState(null);
    //alert
    const [showDeleteAlert, setShowDeleteAlert] = useState(false);

    const handleButtonCreateProduct = () => {
        setProductData({ ...viewEditProductForm });
        setIsEdit(false);
    };
    const handleButtonCreateCategory = () => {
        setCategoryData({ ...viewEditCategoryForm });
        setIsEdit(false);
    };
    //edit Product
    const handleButtonEditProduct = async (id) => {
        await dispatch(getProductById(id));
        setProductData(product);
        setIsEdit(true);
    };
    
    //edit category
    const handleButtonEditCategory = async (id) => {
        await dispatch(getCategoryById(id));
        setCategoryData(categoryItem);
        setIsEdit(true);
    };  

    const onImageChange = (e) => {
        if (e.target.files.length > 0) {
            const file = e.target.files[0];

            if (file instanceof File) {
                setProductData({
                    ...productData,
                });
                setImage(file);
            } else {
                console.error('Biến image không phải là đối tượng File hợp lệ.');
            }
        }
    };

    const handleChangeProduct = (e) => {
        const { name, value } = e.target;
        if (name === 'categoryId') {
            setProductData({
                ...productData,
                [name]: value,
            });
        } else {
            setProductData({
                ...productData,
                [name]: value,
            });
        }
    };



    const handleChangeCategory = (e) => {
        const { name, value } = e.target;
       
            setCategoryData({
                ...categoryData,
                [name]: value,
            });
       
        
    };

    const onCreateProduct = async () => {
        try {
            console.log(image);

            if (
                !productData.productName ||
                !productData.productDescription ||
                !productData.productPrice ||
                !productData.categoryId ||
                !image
            ) {
                console.error('Ảnh hoặc dữ liệu sản phẩm không hợp lệ.');
                return;
            }

            console.log('Sending request with data:', JSON.stringify(productData));

            // Tạo FormData mới và thêm dữ liệu vào đó
            const formData = new FormData();
            formData.append('productJson', JSON.stringify(productData));
            formData.append('file', image);

            const response = await ApiService.post('/product', formData);

            if (response) {
                console.log('Hình ảnh và dữ liệu đã được tải lên thành công.');
                dispatch(getAllProducts());
            } else {
                console.error('Response is undefined or null.');
            }
        } catch (error) {
            console.error('Lỗi khi tải lên hình ảnh và dữ liệu:', error);
        }
    };

//chỉnh sửa product
const onEditProduct = async (id) => {
    try {

        // delete productData.productImage;
        // delete productData.id;
        console.log(image)
        
        const formData = new FormData();
        formData.append('productJson', JSON.stringify(productData));
        formData.append('file', image);
        
        console.log(formData)
        
        const response = await ApiService.put(`/product/${id}`, formData);
        console.log('Sending request with edited data:', JSON.stringify(productData));

        if (response) {
            console.log('Hình ảnh và dữ liệu đã được cập nhật thành công.');
            dispatch(getAllProducts());
        } else {
            console.error('Response is undefined or null.');
        }
    } catch (error) {
        console.error('Lỗi khi cập nhật hình ảnh và dữ liệu:', error);
    }
};



    //delete Product
    const handleDeleteProduct = async (id) => {
        try {
            await dispatch(deleteProduct(id));
            await dispatch(getAllProducts());
            setShowDeleteAlert(true);

            setTimeout(() => {
                setShowDeleteAlert(false);
            }, 5000);
        } catch (error) {
            console.error('Lỗi khi xóa sản phẩm:', error);
        }
    };

    //delete category
    const handleDeleteCategory = async (id) => {
        try {
            await dispatch(deleteCategoryById(id));
            await dispatch(getAllCategories());
            setShowDeleteAlert(true);

            setTimeout(() => {
                setShowDeleteAlert(false);
            }, 5000);
        } catch (error) {
            console.error('Lỗi khi xóa sản phẩm:', error);
        }
    };

    const dispatch = useDispatch();

    useEffect(() => {
        dispatch(getAllProducts());
        dispatch(getAllAccounts());
        dispatch(getAllCategories());
    }, [dispatch]);

    // useEffect(() => {
    //     setProductData(product);
    //     setCategoryData(category);
    // }, [product, category]);

    //Tìm kiếm theo product
    const filteredProducts =
        products && products.filter((product) => product.productName.toLowerCase().includes(searchTerm.toLowerCase()));

    //tìm kiếm theo category
    const filteredCategories =
        categories &&
        categories.filter((category) => category.name.toLowerCase().includes(searchCategory.toLowerCase()));

    const getCategoryNameById = (categoryId) => {
        const category = categories.find((data) => data.id === categoryId);

        if (!category) {
            console.error(`Không tìm thấy loại sản phẩm với ID ${categoryId}`);
            return 'Loại sản phẩm không xác định';
        }

        return category.name;
    };
    const handleClose = () => {
        setIsEdit(false);
        setProductData(viewEditProductForm);
        setCategoryData(viewEditCategoryForm);
    };

    return (
        <>
            <div className="container-fluid py-4">
                <ProductModal
                    isEdit={isEdit}
                    setIsEdit={setIsEdit}
                    productData={productData}
                    setProductData={setProductData}
                    handleChangeProduct={handleChangeProduct}
                    categories={categories}
                    handleClose={handleClose}
                    onImageChange={onImageChange}
                    onCreateProduct={onCreateProduct}
                    onEditProduct={onEditProduct}
                />
                <CategoryModal
                    isEdit={isEdit}
                    setIsEdit={setIsEdit}
                    handleChangeCategory={handleChangeCategory}
                    categories={categories}
                    handleClose={handleClose}
                    onImageChange={onImageChange}
                    onCreateProduct={onCreateProduct}
                    categoryData={categoryData}
                />

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

                                        <button
                                            type="button"
                                            data-bs-toggle="modal"
                                            tabIndex={0}
                                            onClick={handleButtonCreateProduct}
                                            data-bs-target="#exampleModal"
                                            className="plusButton col-2 mx-4"
                                        >
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
                                            {filteredProducts &&
                                                filteredProducts.map((product, index) => (
                                                    <tr key={index}>
                                                        <td>
                                                            <p className="text-center font-weight-bold mb-0">
                                                                {product.id}
                                                            </p>
                                                        </td>

                                                        <td>
                                                            <div className="d-flex px-6 py-1">
                                                                <div>
                                                                    <img
                                                                        src={`/assets/img/${product.productImage}`}
                                                                        alt={product.productName}
                                                                        width={50}
                                                                        height={50}
                                                                        className="avatar avatar-sm rounded-circle me-2"
                                                                    />
                                                                </div>
                                                                <div className="d-flex flex-column justify-content-center">
                                                                    <h6 className="mb-0 text-sm">
                                                                        {product.productName}
                                                                    </h6>
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
                                                                    onClick={() => handleDeleteProduct(product.id)}
                                                                >
                                                                    <i className="far fa-trash-alt me-2" />
                                                                    Delete
                                                                </button>
                                                                <button
                                                                    data-bs-toggle="modal"
                                                                    tabIndex={0}
                                                                    className="btn btn-link text-dark px-3 mb-0"
                                                                    onClick={() => handleButtonEditProduct(product.id)}
                                                                    data-bs-target="#exampleModal"
                                                                >
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
                            <div className="card-header px-4 ">
                                <div className="row gx-6 align-items-center">
                                    <div className="col-6">
                                        <h6>Category Table</h6>
                                    </div>
                                    <div className="col-6 d-flex justify-content-end">
                                        {/* search*/}
                                        <div className="input-container  ms-6">
                                            <input
                                                type="text"
                                                name="text"
                                                className="input"
                                                value={searchCategory}
                                                onChange={(e) => setSearchCategory(e.target.value)}
                                            />
                                            <label className="label">Search</label>
                                            <div className="top-line" />
                                            <div className="under-line" />
                                        </div>
                                        {/* create-prouct */}

                                        <button
                                            type="button"
                                            data-bs-toggle="modal"
                                            tabIndex={0}
                                            onClick={handleButtonCreateCategory}
                                            data-bs-target="#categoryModal"
                                            className="plusButton col-2 mx-4"
                                        >
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
                                                    {filteredCategories &&
                                                        filteredCategories.map((category, index) => (
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
                                                                <td className="align-middle text-center text-sm">
                                                                    <div className="ms-auto text-end">
                                                                        <button
                                                                            className="btn btn-link text-danger text-gradient px-3 mb-0"
                                                                            onClick={() =>
                                                                                handleDeleteCategory(category.id)
                                                                            }
                                                                        >
                                                                            <i className="far fa-trash-alt me-2" />
                                                                            Delete
                                                                        </button>
                                                                        <button
                                                                            data-bs-toggle="modal"
                                                                            tabIndex={0}
                                                                            className="btn btn-link text-dark px-3 mb-0"
                                                                            onClick={() =>
                                                                                handleButtonEditCategory(category.id)
                                                                            }
                                                                            data-bs-target="#categoryModal"
                                                                        >
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
                    </div>
                </div>
            </div>

            {showDeleteAlert && (
                <Alert message="Xóa loại sản phẩm thành công" onClose={() => setShowDeleteAlert(false)} />
            )}
        </>
    );
};

export default Table;
