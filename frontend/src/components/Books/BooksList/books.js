import React from "react"
import BooksTerm from "../BooksTerm/booksTerm";
import {Link} from "react-router-dom";

const books = (props) =>
{
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Category</th>
                            <th scope={"col"}>Author</th>
                            <th scope={"col"}>Available Copies</th>
                            <th scope={"col"}>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.books.map((term) => {
                            return (
                                <BooksTerm term={term} onDelete={props.onDelete} onEdit={props.onEdit} onMark={props.onMark}/>
                            );
                        })}
                        </tbody>
                    </table>
                </div>
                <div className="col mb-3">
                    <div className="row">
                        <div className="col-sm-12 col-md-12">
                            <Link className={"btn btn-block addAndSave"} to={"/books/add"}>Add new product</Link>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    );
}
export default books;