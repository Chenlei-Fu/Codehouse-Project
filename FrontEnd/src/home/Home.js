import React, { Component } from 'react';
import './Home.css';
import {createPoll} from "../util/APIUtils";

class Home extends Component {
    componentDidMount() {
        // Simple POST request with a JSON body using fetch
        const postData = {
            postTitle: 'Hi',
            postBody: 'Hey',
            postOwnerId: 1
        };

        createPoll(postData)
            .then(response => {
                console.log(response);
            }).catch(error => {
            if(error.status === 401) {
                console.log((error));
            } else {
                console.log(error.message);
            }
        });
    }
    render() {
        return (
            <div className="home-container">
                <div className="container">
                    <h1 className="home-title">Connect Four</h1>
                </div>
            </div>
        )
    }
}

export default Home;
