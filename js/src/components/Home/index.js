import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useDispatch } from 'react-redux';
import { Link } from 'react-router-dom';
import { deleteContent } from "../../redux/actions";

const Home = () => {
  const [contents, setContents] = useState([]);
  const dispatch = useDispatch();

  function loadContents() {
    axios.get("http://localhost:8080/api/content").then((res) => {
      setContents(res.data.reverse());
    });
  }


  useEffect(() => {
    loadContents();
  }, []);
  return (
    
    <div>
    <div className="col-md-12 py-2">
      <nav className="navbar bg-dark navbar-dark">
        <Link to={"/"} className="navbar-brand ml-5">
          Content-filter
        </Link>
      </nav>
    </div>
         <div className="container">
         <Link to="/add" className="btn btn-primary btn-lg">
              Add Content
            </Link>
          <div className="row d-flex flex-column">
           
            <div className="col-md-10 mx-auto my-4">
              <table className="table table-hover">
                <thead className="table-header bg-dark text-white">
                  <tr>
                    <th scope="col">Url</th>
                    <th scope="col">Word</th>
                    <th scope="col">Action</th>
                    <th scope="col"></th>
                  </tr>
                </thead>
                <tbody>
  
                {contents.map((data, index) => (
                      <tr  key={index}>
                        <td>{data.url}</td>
                        <td>{data.word}</td>
                        <td>
                          <button
                          onClick={() => dispatch(deleteContent(data.id))}
                            type="button"
                            to={"#"}
                            className="btn btn-sm btn-danger"
                          >
                            Delete
                          </button>
                        </td>
                      </tr>
                      ))}
                </tbody>
              </table>
            </div>
          </div>
        </div>
    </div>
  )
}

export default Home

