package model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import static model.ForumSchema.CATEGORY_ID;
import static model.ForumSchema.CATEGORY_NAME;
import static model.ForumSchema.CATEGORY_COUNT;

@DynamoDbBean
@NoArgsConstructor
@Builder
@Setter
@Getter
@AllArgsConstructor
@DynamoDBDocument
public class CategoryData {
    @NonNull
    @Getter(onMethod_ = {@DynamoDbPartitionKey, @DynamoDBAttribute(attributeName = CATEGORY_ID)})
    private Long categoryId;

    @DynamoDBAttribute(attributeName =  CATEGORY_NAME)
    private String categoryName;

    @DynamoDBAttribute(attributeName =  CATEGORY_COUNT)
    private Long categoryCount;
}
