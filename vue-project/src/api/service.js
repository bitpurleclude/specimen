import request from '@/util/request,js'

export function getallService() {
    return request.get('/api/getAllImgInfo');
}

export function getjpgService(id) {
    return request.get('/api/getImgByName', { params: id });
}

export function getsvgService(id) {
    return request.get('/api/GetSVGById', { params: id });
}