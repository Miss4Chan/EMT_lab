import './App.css';
import React, {Component} from "react";
import Books from "../Books/books";
import Authors from "../Authors/authors";
import Header from "../Header/header";
import Countries from "../Countries/countries";
import libraryService from "../../repository/libraryRepository";
import {Navigate, Route, BrowserRouter as Router, Routes} from "react-router-dom";

class App extends Component{
    constructor(props) {
        super(props);
        this.state ={
            books:[],
            authors:[],
            countries:[],
            selected:{}
        }

    }
    // (Router) This is passing down of props, we take the elements of the App state and
    // pass them as props to the children of App-->
    render() {
        return(
            <Router>
                <main>
                    <div className={"container"}>
                        <Routes>
                            <Route path={"/books"} exact element={<Books books={this.state.books}/>}/>
                            <Route path={"/authors"} exact element={<Authors authors={this.state.authors}/>}/>
                            <Route path={"/countries"} exact element={<Countries countries={this.state.countries}/>}/>
                            <Route path="/" element={<Navigate replace to="/books"/>}/>
                        </Routes>
                    </div>
                </main>
            </Router>
        );
    }


    //Each of these methods calls a corresponding method on the libraryService object
    // and sets the state of the App component with the data that is returned by the API
    loadBooks = () => {
        libraryService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                });
            });
    }

    loadAuthors = () => {
        libraryService.fetchAuthors()
            .then((data) => {
                this.setState({

                    authors: data.data
                });
            });
    }

    loadCountries = () => {
        libraryService.fetchCountries()
            .then((data) => {
                this.setState({
                    countries: data.data
                });
            });
    }

    componentDidMount() {
        this.loadBooks();
        this.loadAuthors();
        this.loadCountries();
    }
}
export default App;
