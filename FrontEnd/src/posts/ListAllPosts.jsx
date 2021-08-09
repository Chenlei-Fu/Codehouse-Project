import React, { Component } from 'react';
import PostList from "./PostList";
//List all posts
class ListAllPosts extends Component {

    constructor() {
        super();
        this.state = {list:[]};
        this.loadPosts = this.loadPosts.bind(this);
    }

    componentDidMount() {
        this.loadPosts();
    }

    // Retrieve data via GET request and re-render page
    loadPosts() {
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
        const response = [
                {
                    'id': '1',
                    'title': 'hello world',
                    'author': {
                        'name': 'foobar'
                    },
                    'content': 'Yay!',
                    "categories" : [{
                        "label": "CompanyA"
                    }]
                },
                ];
            this.setState({list:response});
    }

    render() {
        return (
            <PostList list={this.state.list} label="Forum Topics" />
        );
    }
}
export default ListAllPosts;