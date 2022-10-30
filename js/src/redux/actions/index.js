import axios from 'axios';

import { ADDNEW_CONTENT, GETALL_CONTENT, TOGGLE_CONTENT,  DELETE_CONTENT, TOGGLE_TAB } from './type';

const API_URL = 'http://localhost:8080/api';

export const addNewContent = (data) => async (dispatch) => {
    try {
        const res = await axios.post(`${API_URL}/content/check`,{ data });
        dispatch({ type: ADDNEW_CONTENT , payload: res.data });
    } catch (error) {
        console.log('Error while calling addNewContent API ', error.message);
    }
}

export const getAllContents = () => async (dispatch) => {
    try {
        const res = await axios.get(`${API_URL}/content`);

        dispatch({ type: GETALL_CONTENT , payload: res.data });
    } catch (error) {
        console.log('Error while calling getAllContent API ', error.message);
    }
}

export const toggleContent = (id) => async (dispatch) => {
    try {
        const res = await axios.get(`${API_URL}/${id}`);

        dispatch({ type: TOGGLE_CONTENT , payload: res.data });
    } catch (error) {
        console.log('Error while calling getAllContent API ', error.message);
    }
}


export const deleteContent = (id) => async (dispatch) => {
    try {
        const res = await axios.delete(`${API_URL}/${id}`);

        dispatch({ type: DELETE_CONTENT , payload: res.data });
    } catch (error) {
        console.log('Error while calling deletecontent API ', error.message);
    }
}

export const toggleTab = (tab) => async (dispatch) => {
    dispatch({ type: TOGGLE_TAB, selected: tab })
}


