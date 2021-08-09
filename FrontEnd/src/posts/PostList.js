import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import {Button, Container, Table} from "react-bootstrap";

function selectTagStyle(tag) {
    const number = (tag.trim().length + 4) % 5;
    return `post-category-${number+1}`;
}

//Writes the list of posts
function PostList(props) {
    return(
        <div>
            { /*A wrapper for all the blog posts*/ }

            <Container fluid = "lg">
                <h1 className="content-subhead">{props.label}</h1>
                <Table striped bordered hover size="sm">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Categories</th>
                    </tr>
                    </thead>
                    <tbody>


                    {
                        //Iterates to display each post in decreasing order of publication
                        props.list.map(function(post){
                            return (

                                <tr>
                                    <td>
                                        {post.id}
                                    </td>
                                    <td>
                                        <h6> {post.title}</h6>
                                    </td>

                                    <td>
                                        <i> {post.author.name}</i>
                                    </td>

                                    <td>
                                        {
                                            post.categories.map(function(category){
                                                return (
                                                    <Button variant="secondary" href={"/forum/tag/"+category.label}>
                                                        {category.label} </Button>
                                                    /*
                                                    <Link key={category.label} to={"/forum/tag/"+category.label}
                                                          className={`post-category ${selectTagStyle(category.label)}`}>{category.label} </Link>*/
                                                )
                                            })
                                        }
                                    </td>
                                </tr>
                            )
                        })
                    }

                    </tbody>

                </Table>
            </Container>

            </div>
    )
}

export default PostList;

