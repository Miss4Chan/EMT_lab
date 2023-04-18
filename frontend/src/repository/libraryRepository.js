import axios from '../custom-axios/axios'

const LibraryService = { //makes HTTP requests to the API, the result is packed into an axios promise :)
    //Fetch all lists through api calls to the functions in the controllers
    fetchBooks: () => {
        return axios.get("/books");
    },
    fetchAuthors : () => {
        return axios.get("/authors");
    },
    fetchCountries: () => {
        return axios.get("/countries");
    },
    fetchCategories: () => {
        return axios.get("/categories");
    },
    //CRUD for Book
    deleteBook: (id) => {
        return axios.delete(`books/delete/${id}`) //backticks ` for getting id
    },
    addBook: (name,category,author,availableCopies) => {
        return axios.post("/books/add",{
            "name" : name,
            "category" : category,
            "authorId" : author,
            "availableCopies" : availableCopies});
    },
    editBook: (id,name,category,author,availableCopies) =>{
        return axios.put(`/books/edit/${id}`,{
                "name" : name,
                "category" : category,
                "authorId" : author,
                "availableCopies" : availableCopies
        })
        {}
    },
    getBook: (id) => {
        return axios.get(`/books/${id}`);
    },
    //Taken
    markAsTaken: (id) =>{
        return axios.put(`/books/markAsTaken/${id}`)
    }
}

export default LibraryService;