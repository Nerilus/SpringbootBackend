import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter as Router } from "react-router-dom";
import App from './App';
import './scss/styles.scss'
import * as bootstrap from 'bootstrap'
import { Provider } from "react-redux";
import store from "./redux/store";


 const rootElement = document.getElementById('root');
ReactDOM.render(
    <Provider store={store}>
        <Router>
            <App />,
        </Router>
    </Provider>,
    rootElement
); 