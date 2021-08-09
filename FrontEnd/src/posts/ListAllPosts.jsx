import React, { Component } from 'react';
import PostList from "./PostList";
import {createPost, listAllPosts} from "../util/APIUtils";
import Alert from "react-s-alert";
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
       // console.log("I'm here");
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
        let listAllResponse = '';
        listAllPosts()
            .then(response => {
                const dummyResponse = [
                    {
                        'postId': '1',
                        'postTitle': 'Is compensation fair for a New Grad?',
                        'postOwnerId': 'foobar',
                        'postBody': 'I have been offered $X for a new grad role but I found out my male classmate was offered more' +
                            'Is this a fair compensation for my level?',
                        "categories" : ['compensation', 'companyY']
                    },
                    {
                        'postId': '2',
                        'postTitle': 'Looking for new growth opportunities?',
                        'postOwnerId': 'foobar',
                        'postBody': 'I want to switch companies? Does anyone have suggestions of companies and teams with a diversity mission',
                        "categories" : ['job', 'companyY']
                    }
                ];

                //let joined = ;
                this.setState({list:dummyResponse.concat(response)});
            }).catch(error => {
            if(error.status === 401) {
                console.log((error));
            } else {
                console.log(error.message);
            }
        });
        //console.log(listAllResponse);



            //this.setState({list:response});
    }

    render() {
        return (
            <PostList list={this.state.list} label="Forum Topics" />
        );
    }
}
export default ListAllPosts;