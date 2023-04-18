import React from "react";

const countries = (props) => {
    return(
        <div className={"container mm-4 mt-5"}>
            <h1>Countries</h1>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Continent</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.countries.map((term) => { //map is a callback function. Term represents current element
                            console.log(term);
                            return(

                                <tr>
                                    <td>{term.name}</td>
                                    <td>{term.continent}</td>
                                </tr>
                            );
                        })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default countries;