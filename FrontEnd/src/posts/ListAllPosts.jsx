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
                    'title': 'Is compensation fair for a New Grad?',
                    'author': {
                        'name': 'foobar'
                    },
                    'content': 'I have been offered $X for a new grad role but I found out my male classmate was offered more' +
                        'Is this a fair compensation for my level?',
                    "categories" : [{
                        'label': 'compensation'
                    }, {
                        'label': 'companyY'
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