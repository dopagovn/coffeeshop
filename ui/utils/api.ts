import { API_URL } from '../constants/app-constant';
import notification, { NotifyTypes } from './modal/notification';

class ApiService {
    root: string;
    constructor() {
        this.root = API_URL;
        this.getFullApiLink = this.getFullApiLink.bind(this);
        this.parseErrorToMessage = this.parseErrorToMessage.bind(this);
    }

    getFullApiLink = (link: string) => {
        return this.root + link;
    };

    getRequestHeader = () => {
        return {
            'Content-Type': 'application/json',
        };
    };

    parseErrorToMessage = async (error: any) => {
        try {
            if (error) {
                const message = await error.json();
                if (message) {
                    return message.message;
                }
            }
        } catch {}
        return 'Network error';
    };

    handleErrorException = async (error: any) => {
        switch (error.status) {
            case 400:
                break;
            case 401:
                return undefined;
            case 403:
            case 404:
            case 409:
                break;
            default:
                break;
        }

        const message = await this.parseErrorToMessage(error);
        notification(NotifyTypes.ERROR, { message });
    };

    get = async (url: string) => {
        try {
            const uri = this.getFullApiLink(url);
            const headers = this.getRequestHeader();
            const response = await fetch(uri, {
                credentials: 'include',
                method: 'GET',
                headers,
            });

            if (!!response && response.status == 200) {
                return await response.json();
            }
            await this.handleErrorException(response);
        } catch (error) {
            await this.handleErrorException(error);
        }
        return undefined;
    };
    post = async (url: string, data: any) => {
        try {
            const uri = this.getFullApiLink(url);
            const headers = this.getRequestHeader();
            const response = await fetch(uri, {
                credentials: 'include',
                method: 'POST',
                headers,
                body: JSON.stringify(data),
            });

            if (!!response && response.status === 200) {
                return await response.json();
            }

            await this.handleErrorException(response);
        } catch (error) {
            await this.handleErrorException(error);
        }
        return undefined;
    };
    put = async (url: string, data: any) => {
        try {
            const uri = this.getFullApiLink(url);
            const headers = this.getRequestHeader();
            const response = await fetch(uri, {
                credentials: 'include',
                method: 'PUT',
                headers,
                body: JSON.stringify(data),
            });

            if (!!response && response.status === 200) {
                return await response.json();
            }

            await this.handleErrorException(response);
        } catch (error) {
            await this.handleErrorException(error);
        }
        return undefined;
    };

    delete = async (url: string) => {
        try {
            const uri = this.getFullApiLink(url);
            const headers = this.getRequestHeader();
            const response = await fetch(uri, {
                credentials: 'include',
                method: 'DELETE',
                headers,
            });

            if (!!response && response.status === 200) {
                return await response.json();
            }

            await this.handleErrorException(response);
        } catch (error) {
            await this.handleErrorException(error);
        }
        return undefined;
    };

    uploadImage = async (url: string, data: any) => {
        try {
            const uri = this.getFullApiLink(url);
            const headers = {
                'Content-Type': 'multipart/form-data',
                Accept: 'application/json',
            };

            const response = await fetch(uri, {
                credentials: 'include',
                method: 'POST',
                headers,
                body: data,
            });

            if (!!response && response.status === 200) {
                return await response.json();
            }

            await this.handleErrorException(response);
        } catch (error) {
            await this.handleErrorException(error);
        }
        return undefined;
    };
}

export default new ApiService();
