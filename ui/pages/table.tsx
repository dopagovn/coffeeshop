import React from 'react';

type Props = {};

const Table = (props: Props) => {
    return (
        <div>
            <div className="container-fluid py-4">
                <div className="row">
                    <div className="col-12">
                        <div className="card mb-4">
                            <div className="card-header pb-0">
                                <h6>Authors table</h6>
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
                                            <tr>
                                                <td>
                                                    <p className="text-center font-weight-bold mb-0">1</p>

                                                </td>
                                                <td>
                                                    <div className="d-flex px-2 py-1">
                                                        <div>
                                                            <img
                                                                src="../assets/img/thaixanh.jpg"
                                                                className="avatar avatar-sm me-3"
                                                                alt="user1"
                                                            />
                                                        </div>
                                                        <div className="d-flex flex-column justify-content-center">
                                                            <h6 className="mb-0 text-sm">Trà Sữa</h6> {/*  phan loai*/}
                                                            <p className="text-xs text-secondary mb-0">
                                                                Thái Xanh
                                                            </p>{/*  Name*/}
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <p className="text-center font-weight-bold mb-0">5</p>

                                                </td>
                                                <td className="align-middle text-center text-sm">
                                                    <span className="badge badge-sm bg-gradient-success">50.000đ</span>
                                                </td>

                                            </tr>

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
