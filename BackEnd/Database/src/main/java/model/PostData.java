package model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import static model.ForumSchema.POST_ID;
import static model.ForumSchema.POST_BODY;
import static model.ForumSchema.POST_TITLE;
import static model.ForumSchema.POST_CATEGORY;
import static model.ForumSchema.POST_OWNER;

@DynamoDbBean
@NoArgsConstructor
@Builder
@Setter
@Getter
@AllArgsConstructor
@DynamoDBDocument
public class PostData {
    @NonNull
    @Getter(onMethod_ = {@DynamoDbPartitionKey, @DynamoDBAttribute(attributeName = POST_ID)})
    private Long postId;

    @DynamoDBAttribute(attributeName =  POST_TITLE)
    private String postTitle;

    @DynamoDBAttribute(attributeName =  POST_BODY)
    private String postBody;

    @DynamoDBAttribute(attributeName =  POST_OWNER)
    private String postOwner;

    @DynamoDBAttribute(attributeName =  POST_CATEGORY)
    private CategoryData postCategory;
}
