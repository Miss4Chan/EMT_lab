import React from 'react';
import {Link} from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import {faMoon} from "@fortawesome/free-solid-svg-icons";


const header = (props) => {
    // const toggleDarkMode = () => {
    //     const body = document.querySelector('body');
    //     const darkContainer = document.querySelector('#dark-container');
    //     body.classList.toggle('dark-mode');
    //     darkContainer.classList.toggle('dark-mode');
    // }
    return (
        <header>
            <nav className="navbar navbar-expand-md navbar-dark">
                <a className="navbar-brand" href="/books">Library</a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                        aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation"
                        style={{ background: 'none' }}>
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse justify-content-end" id="navbarCollapse">
                    <ul className="navbar-nav ml-auto">
                        <li className="nav-item">
                            <Link className="nav-link" to={"/books"}>Books</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to={"/authors"}>Authors</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to={"/countries"}>Countries</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to={"/categories"}>Categories</Link>
                        </li>
                        {/*<li className="nav-item">*/}
                        {/*    <button className="nav-link" onClick={toggleDarkMode}> <FontAwesomeIcon icon={faMoon} size="lg" style={{color: "#24c1e0",}} /> </button>*/}
                        {/*</li>*/}
                    </ul>
                </div>
            </nav>
        </header>
    )
}

export default header;