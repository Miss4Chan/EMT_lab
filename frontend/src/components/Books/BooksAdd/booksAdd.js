import React from "react";
import {useNavigate} from 'react-router-dom';

const booksAdd = (props) => {

    const navigate = useNavigate();

    //Hooks used to keep some state in a stateless component
    const [formData, updateFormData] = React.useState({
        name : "",
        category: 1,
        author: 1,
        availableCopies: 0
    })

    const handleChange = (e) => {
        updateFormData({...formData,
            [e.target.name] : e.target.value.trim()})
    }

    //e is some type of event that is created for the input from the form
    const onFormSubmit = (e) => {
        const name = formData.name;
        const category = formData.category;
        const author = formData.author;
        const availableCopies = formData.availableCopies;

        props.onAddBook(name,category,author,availableCopies);
        navigate("/books");
    }

    return(
        <div className="row">
            <div className="col-md-5 mx-auto">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder="Enter product name"
                               onChange={handleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label>Author</label>
                        <select name="author" className="form-control" onChange={handleChange}>
                            {props.authors.map((term) =>
                                <option value={term.id}>{term.name + " " + term.surname}</option>
                            )}
                        </select>
                    </div>

                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {props.categories.map((term) =>
                                <option value={term}>{term}</option>
                            )}
                        </select>
                    </div>

                    <div className="form-group">
                        <label htmlFor="availableCopies">Available copies</label>
                        <input type="number"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder="availableCopies"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <br/>
                    <button id="submit" type="submit" className="btn btn-primary addAndSave">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default booksAdd;