import React, {Component} from "react";
import ReactPaginate from "react-paginate";
import BooksTerm from "../BooksTerm/booksTerm"
import {Link} from "react-router-dom";

class Books extends Component{
    constructor(props) {
        super(props);

        this.state = {
            page:0,
            size:5
        }
    }

    render() {

        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const pageCount = Math.ceil(this.props.books.length / this.state.size)
        const books = this.getBooksPage(offset, nextPageOffset);

        return(
            <div className={"container mm-4 mt-5"}>
                <div className={"row"}>
                    <div className={"row"}>
                        <table className={"table table-striped"}>
                            <thead>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Category</th>
                            <th scope={"col"}>Author</th>
                            <th scope={"col"}>Available copies</th>
                            <th></th>
                            </thead>
                            <tbody>
                            {books}
                            </tbody>
                        </table>
                    </div>
                    <div className="col mb-3">
                        <div className="row">
                            <div className="col-sm-12 col-md-12">
                                <Link className={"btn btn-block addAndSave"} to={"/books/add"}>Add new book</Link>
                            </div>
                        </div>
                    </div>
                </div>
                <ReactPaginate  pageCount={pageCount}
                                pageRangeDisplayed={5}
                                marginPagesDisplayed={2}
                                onPageChange={this.handlePageClick}
                                containerClassName={'pagination m-4 justify-content-center'}
                                pageClassName={'page-item'}
                                pageLinkClassName={'page-link'}
                                activeClassName={'active'}
                                previousClassName={'page-item'}
                                nextClassName={'page-item'}
                                previousLinkClassName={'page-link'}
                                nextLinkClassName={'page-link'}
                                breakClassName={'page-item disabled'}
                                breakLinkClassName={'page-link'}
                                disabledClassName={'disabled'}
                />
            </div>
        );
    }

    handlePageClick = (data) => {
        let selected = data.selected;
        this.setState({
            page: selected
        })
    }

    getBooksPage = (offset, nextPageOffset) => {
        return this.props.books.map((term) => {
            return (
                <BooksTerm term={term} onDelete={this.props.onDelete} onEdit={this.props.onEdit} onMark={this.props.onMark}/>
            );
        }).filter((book,  index) => {
            return index >=offset && index < nextPageOffset;
        })
    }
}

export default Books;