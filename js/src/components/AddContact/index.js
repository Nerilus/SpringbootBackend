import axios from "axios";
import React, { useState } from "react";
import {  useDispatch } from "react-redux";
import { useHistory } from "react-router";
import { addNewContent } from "../../redux/actions";
// import isURL from 'validator/lib/isURL';

const AddPost = () => {
  const [url, setUrl] = useState("");
  const [word, setWord] = useState("");
  const dispatch = useDispatch();
  const history = useHistory();
  const [err, setErr] = useState('');


  const submitForm = (e) =>{
    setUrl(e.target.value);
    if(isURL(url)){
      setErr('valid url');
    } else {
      setErr('Invalid URL');
    }
    e.preventDefault();
   
    const data = {
      url: url,
      word: word
    };
    
    axios.post("http://localhost:8080/api/content/check",data).then(() => {
      dispatch(addNewContent(data));
      history.push("/")
    });
  }
  return (
    <div className="container-fluid"
      >
      <h1 className="text-center text-dark py-3 display-2"></h1>
      <div className="row">
        <div className="col-md-6 p-5 mx-auto shadow">
          <form>
            <div className="form-group" >
              <input
                className="form-control"
                type="text"
                placeholder="url"
                value={url}
          onChange={(e) => setUrl(e.target.value)}
              />
                    <p
                    style={{
                      color:"red",
                    }}
                    >{err}</p>
            </div>
            <div className="form-group">
              <textarea
                className="form-control"
                type="text"
                placeholder="word"
                value={word}
                maxLength={15}
          onChange={(e) => setWord(e.target.value)}
              />
            </div>
            <div className="form-group">
              <button
                className="btn btn-block btn-dark"
                type="submit"
                onClick={submitForm}
              >
              VALIDEZ
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};


export default AddPost;
