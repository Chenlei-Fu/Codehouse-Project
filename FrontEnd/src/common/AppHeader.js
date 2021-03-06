import React, { Component } from 'react';
import { Link, NavLink } from 'react-router-dom';
import './AppHeader.css';
import {Container, Nav, Navbar} from "react-bootstrap";

class AppHeader extends Component {
    render() {
        return (
            <Navbar bg="light" expand="lg">
                <Container>
                    <Navbar.Brand href="/">Circles</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link as={Link} to={{
                                pathname: '/',
                                state: { authenticated: this.props.authenticated, currentUser: this.props.currentUser},
                            }} >Home</Nav.Link>
                            <Nav.Link as={Link} to={{
                                pathname: '/forum',
                                state: { authenticated: this.props.authenticated, currentUser: this.props.currentUser},
                            }}>Forum</Nav.Link>
                        </Nav>
                            <Nav className="app-nav">
                                { this.props.authenticated ? (
                                    <ul>
                                        <li>
                                            <NavLink to="/profile">Profile</NavLink>
                                        </li>
                                        <li>
                                            <a onClick={this.props.onLogout}>Logout</a>
                                        </li>
                                    </ul>
                                ): (
                                    <ul>
                                        <li>
                                            <NavLink to="/login">Login</NavLink>
                                        </li>
                                        <li>
                                            <NavLink to="/signup">Signup</NavLink>
                                        </li>
                                    </ul>
                                )}
                            </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>

        )
    }
}

export default AppHeader;