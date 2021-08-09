import React, {Component} from "react";
import {Card, Container} from "react-bootstrap";
import CardHeader from "react-bootstrap/CardHeader";

class PostDetails extends Component {

    render() {
        return(
            <Container fluid="lg">
                <Card>
                    <CardHeader>
                        Hello World
                    </CardHeader>
                    <Card body>
                        This is a post
                    </Card>
                </Card>
            </Container>

            )

    }
}
export default PostDetails;