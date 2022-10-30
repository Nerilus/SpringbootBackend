import axios from 'axios';

const CONTENT_API_BASE_URL = "http://localhost:8080/api/content"
const DELETE_API_BASE_URL = "http://localhost:8080/api/"

class contentService{

    getAllContents(){
        return axios.get(CONTENT_API_BASE_URL);
    }
    addContent(content){
        return axios.post(CONTENT_API_BASE_URL, content);
    }

    getContentById(contentId){
        return axios.get(CONTENT_API_BASE_URL + '/' + contentId);
    }
    updateContent(content, contentId){
        return axios.put(CONTENT_API_BASE_URL + '/' + contentId, content)
    }
    deleteContent(contentId){
        return axios.delete(DELETE_API_BASE_URL + '/' + contentId);
    }
    
}
export default new contentService;