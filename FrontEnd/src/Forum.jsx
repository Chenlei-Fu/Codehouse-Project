import {Component} from "react";
import {Route, useRouteMatch} from "react-router";
import {Switch} from "react-router-dom";
import ListAllPosts from "./posts/ListAllPosts";
import ListByTag from "./posts/ListByTag";
import UploadPost from "./posts/upload/UploadPost";
import PostDetails from "./posts/PostDetails";

class Forum extends Component {
    //let { path, url } = useRouteMatch();
    render() {
    return (
        <div>
            <div className="header">
                <h1>Discussion Board</h1>
            </div>
            <div className="content" id="content">
                <Switch>
                    <Route exact path="/forum" component={ListAllPosts} />
                    <Route exact path="/forum/tag/:tagLabel" component={ListByTag} />
                    <Route exact path="/forum/new" component={UploadPost} />
                    <Route exact path="/forum/post/:postId" component={PostDetails} />
                </Switch>
            </div>
        </div>
    );
}
}

export default Forum;