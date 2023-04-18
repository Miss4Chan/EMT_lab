import axios from '../custom-axios/axios'

const LibraryService = { //makes HTTP requests to the API, the result is packed into an axios promise :)
    fetchBooks: () => {
        return axios.get("/books");
    },
    fetchAuthors : () => {
        return axios.get("/authors");
    },
    fetchCountries: () => {
        return axios.get("/countries");
    }
}

export default LibraryService;