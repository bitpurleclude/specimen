import request from '@/util/request,js'

export function getallService() {
    return request.get('/api/getAllImgInfo');
}

export function getjpgService(imgId) {
    console.log(imgId);
    return request.post('/api/getImgById', imgId ,{ responseType: 'blob' });
}

export function getsvgService(id) {
    return request.get('/api/GetSVGById', { params: id });
}