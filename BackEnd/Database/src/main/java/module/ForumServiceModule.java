package module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import model.CategoryData;
import model.PostData;
import model.UserData;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import sun.java2d.pipe.RegionIterator;

import javax.inject.Named;

public class ForumServiceModule extends AbstractModule {
    @Override
    protected void configure() {

    }

    @Provides
    @Singleton
    public DynamoDbClient provideDynamoDbClient(final AwsCredentialsProvider awsCredentialsProvider,
                                                final Region region) {
        return DynamoDbClient.builder()
                .credentialsProvider(awsCredentialsProvider)
                .region(region)
                .build();
    }

    @Provides
    @Singleton
    public DynamoDbEnhancedClient provideDynamoDbEnhancedClient(final DynamoDbClient dynamoDbClient) {
        return DynamoDbEnhancedClient.builder().dynamoDbClient(dynamoDbClient).build();
    }

    @Provides
    @Named("userTableName")
    public String provideUserTableName() {
        return "userTableName";
    }

    @Provides
    @Named("postTableName")
    public String providePostTableName() {
        return "postTableName";
    }

    @Provides
    @Named("categoryTableName")
    public String provideCategoryTableName() {
        return "categoryTableName";
    }


    @Provides
    @Singleton
    public DynamoDbTable<UserData> provideUserDataTable(final DynamoDbEnhancedClient dynamoDbEnhancedClient,
                                                        @Named("userTableName") final String tableName) {
        return dynamoDbEnhancedClient.table(tableName, TableSchema.fromBean(UserData.class));
    }

    @Provides
    @Singleton
    public DynamoDbTable<PostData> provideUserDataTable(final DynamoDbEnhancedClient dynamoDbEnhancedClient,
                                                        @Named("postTableName") final String tableName) {
        return dynamoDbEnhancedClient.table(tableName, TableSchema.fromBean(PostData.class));
    }

    @Provides
    @Singleton
    public DynamoDbTable<CategoryData> provideUserDataTable(final DynamoDbEnhancedClient dynamoDbEnhancedClient,
                                                                 @Named("categoryTableName") final String tableName) {
        return dynamoDbEnhancedClient.table(tableName, TableSchema.fromBean(CategoryData.class));
    }
}

