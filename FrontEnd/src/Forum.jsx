import React, {Component} from "react";
import {Route, useRouteMatch} from "react-router";
import {Link, NavLink, Switch} from "react-router-dom";
import ListAllPosts from "./posts/ListAllPosts";
import ListByTag from "./posts/ListByTag";
import UploadPost from "./posts/upload/UploadPost";
import PostDetails from "./posts/PostDetails";
import {Button, Card, Col, Container, ListGroup, ListGroupItem, Row} from "react-bootstrap";
import CardHeader from "react-bootstrap/CardHeader";


class Forum extends Component {
    constructor(props) {
        super(props);
        console.log(props);
        this.state={
            currentUser: '',
            categories:[],
            authenticated: false,

        }
        this.loadCategories = this.loadCategories.bind(this);
        this.groupItem = this.groupItem.bind(this);
    }
    componentDidUpdate(nextProps) {
        if(!this.props.authenticated && nextProps.authenticated) {
            this.setState({authenticated : this.props.authenticated})
        }
        if (!this.props.currentUser && nextProps.currentUser) {
            this.setState({currentUser : this.props.currentUser})
        }
    }

    componentDidMount() {
        this.loadCategories()
    }

    groupItem(to) {
        // Conditionally wrapping content into a link
        const ContentTag = to ? Link : 'div';

        return (
            <ListGroupItem>
                <ContentTag to={{pathname: to,
                    state: { authenticated: this.props.authenticated, currentUser: this.props.currentUser},}}>
                    to
                </ContentTag>
            </ListGroupItem>

        );
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
    render() {
        return (
            <div className="home-container">
                    <Container fluid="xl">
                        <Row className="justify-content-md-center">
                            <Col xs={15} md={10} className="justify-content-md-center">
                                <h1>Discussion Board</h1>
                            </Col>
                            <Col xs={3} md={2}>
                                <Button variant="secondary" ><Link to={{
                                    pathname: '/forum/new',
                                    state: { authenticated: this.state.authenticated, currentUser: this.state.currentUser},
                                }}> Create New Post </Link> </Button>
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
                                                            <ListGroup.Item action href={"/forum/tag/" + category.label}>
                                                                {category.label}
                                                            </ListGroup.Item>
                                                        )
                                                    })
                                                }
                                            </ListGroup>
                                        </Card>

                                    </Col>
                                    <Col xs={12} md={8}>
                                        <Switch>
                                            <Route exact path="/forum" authenticated={this.state.authenticated} currentUser={this.state.currentUser} component={ListAllPosts} />
                                            <Route path="/forum/tag/:tagLabel" render={(props) => <ListByTag {...props} authenticated={this.props.authenticated} currentUser={this.props.currentUser} baseRoute="/forum" />} />
                                            <Route path="/forum/new" render={(props) => <UploadPost {...props} currentUser={this.props.currentUser} baseRoute="/forum" />} />
                                            <Route exact path="/forum/post/:postId" authenticated={this.state.authenticated} currentUser={this.state.currentUser} component={PostDetails} />
                                        </Switch>
                                    </Col>
                                </Row>
                            </Container>
                        </div>
                    </Container>
            </div>
        )
    }
    //let { path, url } = useRouteMatch();
    //                                             <Route exact path="/forum/new" authenticated={this.props.authenticated} currentUser={this.props.currentUser} component={UploadPost} />
}



export default Forum;