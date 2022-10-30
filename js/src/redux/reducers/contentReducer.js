import * as actionTypes from '../actions/type';


export const contentsReducers = (state = [], action) => {

    switch (action.type) {
        case actionTypes.ADDNEW_CONTENT:
            return [action.payload, ...state]
        case actionTypes.GETALL_CONTENT:
            return action.payload
        case actionTypes.TOGGLE_CONTENT:
            return state.map(content => (
                content._id === action.payload._id ? { ...content, done: !content.done } : content
            ))
        case actionTypes.DELETE_CONTENT:
            return state.filter(content => content._id !== action.payload._id);
        
        default: 
            return state;
    }
}