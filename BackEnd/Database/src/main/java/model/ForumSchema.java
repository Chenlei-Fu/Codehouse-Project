package model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import lombok.Getter;
import lombok.NonNull;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

public class ForumSchema {
    /**
     * Hide constructor
     * */
    private ForumSchema() {

    }

    /**
     * id, name, password and email of user items
     * */
    public static final String USER_ID = "userId";
    public static final String USER_NAME = "userName";
    public static final String USER_PASSWORD = "password";
    public static final String USER_EMAIL = "userEmail";

    /**
     * id, tile, body, owner and category of post items
     * */
    public static final String POST_ID = "postId";
    public static final String POST_TITLE = "postTitle";
    public static final String POST_BODY = "postBody";
    public static final String POST_OWNER = "postOwner";
    public static final String POST_CATEGORY = "postCategory";

    /**
     * id, name and count for category items
     * */
    public static final String CATEGORY_ID = "categoryID";
    public static final String CATEGORY_NAME = "categoryName";
    public static final String CATEGORY_COUNT = "categoryCount";
}
