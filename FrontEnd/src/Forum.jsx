import {Component} from "react";
import {Route, useRouteMatch} from "react-router";
import {Switch} from "react-router-dom";
import ListAllPosts from "./posts/ListAllPosts";
import ListByTag from "./posts/ListByTag";
import UploadPost from "./posts/upload/UploadPost";
import PostDetails from "./posts/PostDetails";
import {Button, Col, Container, Row} from "react-bootstrap";

class Forum extends Component {
    //let { path, url } = useRouteMatch();
    render() {
    return (
        <Container fluid="xl">
            <div className="header">
                <Row>
                    <Col xs={15} md={10}>
                        <h1>Discussion Board</h1>
                    </Col>
                    <Col xs={3} md={2}>
                        <Button variant="secondary" href="/forum/new"> Create New Post </Button>
                    </Col>
                </Row>


            </div>
            <div className="content" id="content">
                <Switch>
                    <Route exact path="/forum" component={ListAllPosts} />
                    <Route exact path="/forum/tag/:tagLabel" component={ListByTag} />
                    <Route exact path="/forum/new" component={UploadPost} />
                    <Route exact path="/forum/post/:postId" component={PostDetails} />
                </Switch>
            </div>
        </Container>
    );
}
}

export default Forum;