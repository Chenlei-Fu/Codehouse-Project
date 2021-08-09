import React, {Component} from "react";
import {Route, useRouteMatch} from "react-router";
import {Switch} from "react-router-dom";
import ListAllPosts from "./posts/ListAllPosts";
import ListByTag from "./posts/ListByTag";
import UploadPost from "./posts/upload/UploadPost";
import PostDetails from "./posts/PostDetails";
import {Button, Card, Col, Container, ListGroup, Row} from "react-bootstrap";
import CardHeader from "react-bootstrap/CardHeader";

class Forum extends Component {
    constructor(props) {
        super(props);
        this.state={
            categories:[]
        }
        this.loadCategories = this.loadCategories.bind(this);
    }

    componentDidMount() {
        this.loadCategories()
    }

    loadCategories() {
        const categories = [{
                'label': 'compensation',
            }, {
                'label': 'companyY'
            }, {
                'label': 'women in tech'
            }]
        this.setState({categories: categories});
    }
    //let { path, url } = useRouteMatch();
    render() {
    return (


            <Container fluid="xl">
                    <Row className="justify-content-md-center">
                        <Col xs={15} md={10} className="justify-content-md-center">
                            <h1>Discussion Board</h1>
                        </Col>
                        <Col xs={3} md={2}>
                            <Button variant="secondary" href="/forum/new"> Create New Post </Button>
                        </Col>
                    </Row>



                <div className="content" id="content">
                    <Container>
                        <Row>
                    <Col xs={6} md={4}>
                        <Card>
                            <CardHeader>
                                Categories
                            </CardHeader>
                            <ListGroup>
                                {
                                    this.state.categories.map(function(category){
                                        return(
                                            <ListGroup.Item action href={"/forum/tag/"+category.label}>{category.label}</ListGroup.Item>
                                        )
                                    })
                                }
                            </ListGroup>
                        </Card>

                    </Col>
                    <Col xs={12} md={8}>
                    <Switch>
                        <Route exact path="/forum" component={ListAllPosts} />
                        <Route exact path="/forum/tag/:tagLabel" component={ListByTag} />
                        <Route exact path="/forum/new" component={UploadPost} />
                        <Route exact path="/forum/post/:postId" component={PostDetails} />
                    </Switch>
                    </Col>
                        </Row>
                    </Container>
                </div>
        </Container>

    );
}
}

export default Forum;