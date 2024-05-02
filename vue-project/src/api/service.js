import request from '@/util/request,js'

export function getallService() {
    return request.get('/api/getAllImgInfo');
}

export function getjpgService(name) {
    return request.get('/api/getImgByName', { params: name });
}

export function getsvgService(id) {
    return request.get('/api/GetSVGById', { params: id });
}