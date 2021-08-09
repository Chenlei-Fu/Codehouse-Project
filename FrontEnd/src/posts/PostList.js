import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import {Button, Container, Table} from "react-bootstrap";

function selectTagStyle(tag) {
    const number = (tag.trim().length + 4) % 5;
    return `post-category-${number+1}`;
}

function Td({ children, to }) {
    // Conditionally wrapping content into a link
    const ContentTag = to ? Link : 'div';

    return (
        <td>
            <ContentTag to={to}>{children}</ContentTag>
        </td>
    );
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

                                <tr key={post.id}>
                                    <Td to={`/forum/post/${post.id}`}>
                                        {post.id}
                                    </Td>
                                    <Td to={`/forum/post/${post.id}`}>
                                        <h6> {post.postTitle}</h6>
                                    </Td>

                                    <Td to={`/forum/post/${post.id}`}>
                                        <i> {post.postOwnerId}</i>
                                    </Td>

                                    <Td>
                                        {
                                            post.categories.map(function(category){
                                                return (
                                                    <Button style={{margin:'0.5em'}} variant="secondary" href={"/forum/tag/"+category}>
                                                        {category} </Button>
                                                    /*
                                                    <Link key={category.label} to={"/forum/tag/"+category.label}
                                                          className={`post-category ${selectTagStyle(category.label)}`}>{category.label} </Link>*/
                                                )
                                            })
                                        }
                                    </Td>
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

