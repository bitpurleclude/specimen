import axios from 'axios'
import request from '@/util/request.js'

export function getjpgService(name) {
    return request.get('/getImgByName', { params: name });
}

export function getsvgService(id) {
    return request.get('/GetSVGById', { params: id });
}