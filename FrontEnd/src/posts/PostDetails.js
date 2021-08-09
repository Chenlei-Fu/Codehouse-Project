import React, {Component} from "react";
import {Button, Card, Col, Container, Form, Row} from "react-bootstrap";
import CardHeader from "react-bootstrap/CardHeader";
import PostList from "./PostList";
import CommentsList from "./CommentsList";

class PostDetails extends Component {

    constructor() {
        super();
        this.state = {
            postTitle: '',
            postBody: '',
            postAuthor: '',
            commentList:[],
            postCategories:[],
            newComment: ''};
        this.loadPost = this.loadPost.bind(this);
        this.handleCommentSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount() {
        this.setState({
            newComment: ''
        })
        this.loadPost();
    }

    handleSubmit(event) {
        this.loadPost();
    }

    // Retrieve data via GET request and re-render page
    loadPost() {
        console.log("I'm here");
        /*
        $.ajax({
            url:"http://localhost:8080/api/posts",
            dataType:"json",
            success:function(response){
                //Update list and re-render page
                response=
                this.setState({list:response});
            }.bind(this)
        });*/
        const post =
            {
                'id': '1',
                'title': 'Is compensation fair for a New Grad?',
                'createTime': 'May 27, 2021 03:00pm UTC',
                'author': {
                    'name': 'foobar'
                },
                'content': 'I have been offered $X for a new grad role but I found out my male classmate was offered more' +
                    'Is this a fair compensation for my level?',
                "categories" : [{
                    'label': 'compensation',
                }, {
                    'label': 'companyY'
                }, {
                    'label': 'women in tech'
                }]
            };

        const comment = [
            {
                'post_id': '1',
                'comment_id':'1',
                'commentOwnerId': '2',
                'createTime': 'May 27, 2021 04:00pm UTC',
                'content': 'Hey! I would say that is rather low for a new grad as someone with 2 years of experience at ' +
                    'CompanyA. I would negotiate more. Also I would definitely' +
                    'try to join X org within the company since it has great mentorship' +
                    'for women. Feel free to DM me for any more tips!'
            },
            {
                'post_id': '1',
                'comment_id':'1',
                'commentOwnerId': '3',
                'createTime': 'May 27, 2021 05:23pm UTC',
                'content': 'Agree with above commenter. Definitely negotiate more!'
            }
        ]
        this.setState({
            newComment: '',
            postAuthor:post.author.name,
            postBody:post.content,
            postCreateTime:post.createTime,
            postTitle:post.title,
            postCategories:post.categories,
            commentList:comment});
    }

    render() {
        return(
            <div> <div>here </div>
            <Container fluid="lg">
                <Card className="mb-2">
                    <CardHeader>

                        <Row>
                            <Col xs={14} md={9}>
                                <h6> {this.state.postTitle}{"\n"} </h6>
                                by <i> {this.state.postAuthor} </i>
                            </Col>
                            <Col xs={4} md={3}>
                                {this.state.postCreateTime}
                            </Col>
                        </Row>
                    </CardHeader>
                    <Card.Body>
                        {this.state.postBody}
                    </Card.Body>
                    <Card.Footer>
                        <div className="mb-2">
                            {
                                this.state.postCategories.map(function(category){
                                    return (
                                        <Button class="btn-block" style={{margin: '0.5em'}} variant="secondary" size="sm" href={"/forum/tag/"+category.label}>
                                            {category.label} </Button>

                                    )
                                })
                            }
                        </div>
                    </Card.Footer>
                </Card>
                <CommentsList list={this.state.commentList} />
                <Form style={{ width: '50rem'}} onSubmit={this.handleSubmit}>
                    <Form.Group className="mb-3" controlId="postTitle" value={this.state.newComment} onChange={this.handleChange}>
                        <Form.Label>New Comment</Form.Label>
                        <Form.Control required as="textarea" rows={3} />
                    </Form.Group>
                    <Button variant="primary" type="submit" onSubmit={(e) => this.handleSubmit(e)}>
                        Submit
                    </Button>
                </Form>
            </Container>
            </div>
        )

    }
}
export default PostDetails;