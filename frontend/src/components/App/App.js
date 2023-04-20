import './App.css';
import React, {Component} from "react";
import Books from "../Books/BooksList/books";
import Authors from "../Authors/authors";
import Header from "../Header/header";
import Countries from "../Countries/countries";
import BooksAdd from "../Books/BooksAdd/booksAdd";
import BooksEdit from "../Books/BooksEdit/booksEdit";
import Categories from "../Categories/categories";
import libraryService from "../../repository/libraryRepository";
import {Navigate, Route, BrowserRouter as Router, Routes} from "react-router-dom";

class App extends Component{
    constructor(props) {
        super(props);
        this.state ={
            books:[],
            authors:[],
            countries:[],
            categories:[],
            selectedBook:{},
            isDarkMode: false
        }

    }
    // (Router) This is passing down of props, we take the elements of the App state and
    // pass them as props to the children of App
    render() {
        return(
            <div className="App">
            <Router>
                <Header isDarkMode={this.state.isDarkMode} toggleDarkMode={this.toggleDarkMode}/>
                <main>
                    <header>
                    <div className={"container"}>
                        <Routes>
                            <Route path={"/books/add"} exact element={
                                <BooksAdd categories={this.state.categories} authors={this.state.authors} onAddBook={this.addBook}/>}/>
                            <Route path={"/books/edit/:id"} exact element={
                                <BooksEdit categories={this.state.categories} authors={this.state.authors} onEditBook={this.editBook} book={this.state.selectedBook}/>}/>
                            <Route path={"/books"} exact element={
                                <Books books={this.state.books} onDelete={this.deleteBook} onEdit={this.getBook} onMark={this.markAsTaken}/>}/>
                            <Route path={"/authors"} exact element={<Authors authors={this.state.authors}/>}/>
                            <Route path={"/countries"} exact element={<Countries countries={this.state.countries}/>}/>
                            <Route path={"/categories"} exact element={<Categories categories={this.state.categories}/>}/>
                            <Route path="/" element={<Navigate replace to="/books"/>}/>
                        </Routes>
                    </div>
                    </header>
                </main>
            </Router>
            </div>
        );
    }
    toggleDarkMode = () => {
        this.setState(prevState => ({ isDarkMode: !prevState.isDarkMode }));
    }
    componentDidUpdate() {
        const body = document.querySelector('body');
        if (this.state.isDarkMode) {
            body.classList.add('dark-mode');
        } else {
            body.classList.remove('dark-mode');
        }
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
    loadCategories = () => {
        libraryService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                });
            });
    }
    deleteBook = (id) => {
        libraryService.deleteBook(id)
            .then((data)=>{
                this.loadBooks();
            });
    }
    addBook = (name, category, authorId, availableCopies) => {
        libraryService.addBook(name, category, authorId, availableCopies)
            .then(() => {
                this.loadBooks();
            })
    }

    getBook = (id) => {
        libraryService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook : data.data
                })
            })
    }

    editBook = (id, name, category, authorId, availableCopies) => {
        libraryService.editBook(id, name, category, authorId, availableCopies)
            .then(() => this.loadBooks())
    }

    markAsTaken = (id) => {
        libraryService.markAsTaken(id)
            .then(() => {
                this.loadBooks()
            });
    }

    componentDidMount() {
        this.loadBooks();
        this.loadAuthors();
        this.loadCountries();
        this.loadCategories();
    }
}
export default App;
