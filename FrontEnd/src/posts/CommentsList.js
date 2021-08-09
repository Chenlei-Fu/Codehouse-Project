//Writes the list of posts
import {Button, Card, Col, Container, Row, Table} from "react-bootstrap";
import React from "react";
import CardHeader from "react-bootstrap/CardHeader";

function CommentsList(props) {
    return (
        <div>
            { /*A wrapper for all the blog posts*/ }

            <Container fluid = "lg">



                    {
                        //Iterates to display each post in decreasing order of publication
                        props.list.map(function(comment){
                            return (
                            <Card bg="secondary" style={{ width: '40rem'}} className="mb-2" >
                                <CardHeader>
                                    <Row>
                                        <Col xs={14} md={9}>
                                            {comment.commentOwnerId}
                                        </Col>
                                        <Col xs={4} md={3}>
                                            {comment.createTime}
                                        </Col>
                                    </Row>

                                </CardHeader>
                                <Card body>
                                    {comment.content}
                                </Card>
                            </Card>

                            )
                        })
                    }


            </Container>

        </div>
    )
}

export default CommentsList;