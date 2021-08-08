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

import static model.ForumSchema.USER_ID;
import static model.ForumSchema.USER_NAME;
import static model.ForumSchema.USER_EMAIL;
import static model.ForumSchema.USER_PASSWORD;

@DynamoDbBean
@NoArgsConstructor
@Builder
@Setter
@Getter
@AllArgsConstructor
@DynamoDBDocument
public class UserData {

    @NonNull
    @Getter(onMethod_ = {@DynamoDbPartitionKey, @DynamoDBAttribute(attributeName = USER_ID)})
    private Long userId;

    @DynamoDBAttribute(attributeName =  USER_NAME)
    private String userName;

    @DynamoDBAttribute(attributeName = USER_PASSWORD)
    private String userPassword;

    @DynamoDBAttribute(attributeName = USER_EMAIL)
    private String userEmail;
}
