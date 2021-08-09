import React, {Component} from "react";
import {Button, Container, Form} from "react-bootstrap";
import {createPost} from "../../util/APIUtils";

class UploadPost extends Component {
    constructor(props) {
        super(props);
        this.state={
            postTitle: ' ',
            postBody: ' ',
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        //debugger;
        this.setState({
            postTitle: event.target.postTitle,
            postValue: event.target.postValue});
    }

    handleSubmit(event) {
       // const form = currentTarget;
        console.log("Title: " + this.state.postTitle);
        console.log(" Body:" + this.state.postBody);
        alert('An essay was submitted: ' + this.state.postTitle + this.state.postBody);
        const postData = {
            postTitle: 'Hi',
            postBody: 'Hey',
            postOwnerId: 1,
            categories: 'CompanyA'
        };

        createPost(postData)
            .then(response => {
                console.log(response);
            }).catch(error => {
            if(error.status === 401) {
                console.log((error));
            } else {
                console.log(error.message);
            }
        });
        event.preventDefault();
    }

    render() {
        return(
            <Container fluid="md">
                <Form>
                    <Form.Group className="mb-3" controlId="postTitle" value={this.state.postTitle} onChange={this.handleChange}>
                        <Form.Label>Title</Form.Label>
                        <Form.Control required as="textarea" rows={1} />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="postBody" value={this.state.postBody} onChange={this.handleChange}>
                        <Form.Label>Example textarea</Form.Label>
                        <Form.Control required as="textarea" rows={3} />
                    </Form.Group>
                    <Button variant="primary" type="submit" onSubmit={() => this.handleSubmit()}>
                        Submit
                    </Button>
                </Form>

            </Container>

        )

    }
}

export default UploadPost;