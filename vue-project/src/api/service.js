import request from '@/util/request,js'

export function getallService() {
    return request.get('/api/getAllImgInfo');
}

export function getpngService(imgId) {
    console.log(imgId);
    return request.post('/api/getImgById', imgId ,{ responseType: 'blob' });
}

export function getsvgService(imgId) {
    return request.get('/api/GetSVGById', { params: id });
}