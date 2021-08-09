import React, { Component } from 'react';
import './Home.css';
import Login from "../user/login/Login";
import Profile from "../user/profile/Profile";
class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            authenticated: false,
            currentUser: ""
        }
    }

    componentDidUpdate(nextProps) {
        debugger;
        if(!this.props.authenticated && nextProps.authenticated) {
            this.setState({authenticated : this.props.authenticated})
        }
        if (!this.props.currentUser && nextProps.currentUser) {
            this.setState({currentUser : this.props.currentUser})
        }
    }
    render() {
        return (
            <div className="home-container">
                <div className="container">
                    <h1 className="home-title">Welcome to our Connect Four Discussion Board!</h1>
                </div>
                { this.props.authenticated ? (
                        <Profile authenticated={this.state.authenticated} currentUser={this.state.currentUser}/>
                    ) : (<Login authenticated={this.state.authenticated} {...this.props}/>) }
            </div>
        )
    }
}

export default Home;
