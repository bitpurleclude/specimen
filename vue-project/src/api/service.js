import request from '@/util/request,js'

export function getallService() {
    return request.get('/api/getAllImgInfo');
}

export function getjpgService(imgId) {
    console.log(imgId);
    const imgIdJsonString = JSON.stringify(imgId);
    console.log(imgIdJsonString);
    return request.post('/api/getImgById', { params: { imgIdJsonString } });
}

export function getsvgService(id) {
    return request.get('/api/GetSVGById', { params: id });
}