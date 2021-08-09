import React, {Component} from "react";
import {Alert, Button, Container, Form} from "react-bootstrap";
import {createPost} from "../../util/APIUtils";

class UploadPost extends Component {
    constructor(props) {
        super(props);
        this.state={
            postTitle: ' ',
            postBody: ' ',
            showAlert: true,
            categories: [{
                'key' : 'CompanyA',
                'value': 'CompanyA',
                'selected': false
            }, {
                'key' : 'CompanyB',
                'value': 'CompanyB',
                'selected': false
            }],
            categoriesChosen: []

        }
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    setShow(alertStatus) {
        this.setState({
            showAlert: alertStatus
        })
    }

    handleChange(event) {
       // debugger;
        this.setState({
            [event.target.id]: event.target.value});
    }

    handleSubmit(event) {
       // const form = currentTarget;
        const postData = {
            postTitle: 'Is compensation fair for a New Grad?',
            postBody: 'I have been offered $X for a new grad role but I found out my male classmate was offered more' +
                'Is this a fair compensation for my level?',
            postOwnerId: 1,
            categories: [{
                'label': 'compensation'
            }, {
                'label': 'companyY'
            }]
        };

        createPost(postData)
            .then(response => {
                console.log(response);
            }).catch(error => {
            if(error.status === 401) {
                console.log((error));
            } else {
                console.log(error.message);
                this.setState({
                    showAlert: true
                })
            }
        });
        event.preventDefault();
    }

    render() {
        return(

            <Container fluid="md">
                <div>
                    {
                        this.state.showAlert?(
                            <Alert variant="danger" onClose={this.setShow(false)} dismissible>
                                <Alert.Heading>Oh snap! You got an error!</Alert.Heading>
                                <p>
                                    Hello
                                </p>
                            </Alert>):null
                    }
                </div>

                <Form onSubmit={this.handleSubmit}>
                    <Form.Group className="mb-3" controlId="postTitle" value={this.state.postTitle} onChange={this.handleChange}>
                        <Form.Label>Title</Form.Label>
                        <Form.Control required as="textarea" rows={1} />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="postBody" value={this.state.postBody} onChange={this.handleChange}>
                        <Form.Control required as="textarea" rows={5} />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="categories" value={this.state.categoriesChosen}>
                        <Form.Label>Tags</Form.Label>
                        <Form.Control as="select" multiple value={this.state.categories}>
                            {
                                this.state.categories.map(category => (
                                <option value={category.value}>
                                    {category.value}
                                </option>
                            ))}
                        </Form.Control>
                    </Form.Group>

                    <Button variant="primary" type="submit" onSubmit={(e) => this.handleSubmit(e)}>
                        Submit
                    </Button>
                </Form>

            </Container>

        )

    }
}

export default UploadPost;