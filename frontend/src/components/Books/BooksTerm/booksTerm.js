import React from 'react';
import {Link} from "react-router-dom";
const booksTerm = (props) => {
    return(
        <tr>
            <td scope={"col"}>{props.term.name}</td>
            <td scope={"col"}>{props.term.category}</td>
            <td scope={"col"}>{props.term.author.name + " " + props.term.author.surname}</td>
            <td scope={"col"}>{props.term.availableCopies}</td>
            <td scope={"col"} className={"text-right"}>
                <Link className={"btn MainActionBtn m-1"} onClick={()=>props.onMark(props.term.id)}>Mark as Taken</Link>
                <Link className={"btn edtBtn m-1"} onClick={() => props.onEdit(props.term.id)} to={`/books/edit/${props.term.id}`}>Edit</Link>
                <a title={"Delete"} className={"btn dltBtn m-1"} onClick={() => props.onDelete(props.term.id) }>Delete</a>
            </td>
        </tr>
    )
}

export default booksTerm;