# BACKEND


## APIS

```
BASE_URL = https://localhost:8080/
```

### Posts
**Post**
```
{    
    postTitle: 'Hi',
    postBody: 'Hey',
    postOwnerId: 1,
    categories: ['cate1', 'cate2']
}
https://localhost:8080/posts
```

**GET** \
Get All Posts:
```
https://localhost:8080/posts/getAllPosts
```

Get Post By User:
```
{    
    postOwnerId: 1
}
https://localhost:8080/posts/getPostByUser
```

Get Post By Categories:
```
{    
    category: 'cate1'
}
https://localhost:8080/posts/getPostByCategory
```


### Comments
**Post** \
Create Comments
```
{    
    commentBody: 'Body',
    commentOwnerId: 1,
    commentParentPostId: 2
}
https://localhost:8080/comments
```
Get Comments By Post Id:
```
{    
    commentParentPostId: 1
}
https://localhost:8080/posts/comments/getAllComments
```

