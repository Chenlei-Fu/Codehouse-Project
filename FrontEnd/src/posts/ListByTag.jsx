//List posts by Tag
import React, {Component} from "react";
import PostList from "./PostList";

class ListByTag extends Component {

    constructor(props) {
        super(props);
        this.state = {list:[]};
        this.loadPosts = this.loadPosts.bind(this);
    }

    componentDidMount() {
        this.loadPosts();
    }

    //Retrieve data via GET request and re-render page
    loadPosts() {
        /*
        $.ajax({
            url:"http://localhost:8080/api/posts/tag/"+this.props.match.params.tagLabel,
            dataType:"json",
            success:function(response){
                //Update list and re-render page
                this.setState({list:response});
            }.bind(this)
        });*/
    }

    render() {
        const label = `Topics about ${this.props.match.params.tagLabel}`;
        return(
            <PostList list={this.state.list} label={label} />
        );
    }

}

export default ListByTag;