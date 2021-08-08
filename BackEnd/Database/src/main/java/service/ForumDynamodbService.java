package service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import model.CategoryData;
import model.PostData;
import model.UserData;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class ForumDynamodbService {
    @NonNull
    private final DynamoDbTable<UserData> userTable;

    @NonNull
    private final DynamoDbTable<PostData> postTable;

    @NonNull
    private final DynamoDbTable<CategoryData> categoryDataTable;

    /**
     * Scan all post items from Table
     * */
    public List<PostData> scanAllPostItems() {
        final List<PostData> items = new ArrayList<PostData>();
        try {
            final Iterator<PostData> iterator =  postTable.scan().items().iterator();
            while(iterator.hasNext()) {
                final PostData rec = iterator.next();
                items.add(rec);
            }
        } catch (final AmazonServiceException ex) {
            System.out.println("scanAllPostItems throw AmazonServiceException");
        } catch (final AmazonClientException ex) {
            System.out.println("scanAllPostItems throw AmazonClientException");
        }
        return items;
    }

    /**
     * Put new post Item to Table
     * */
    public void putPostItem(final PostData postData) {
        try {
            postTable.updateItem(postData);
        } catch (final AmazonServiceException ex) {
            System.out.println("putItem throw AmazonServiceException");
        } catch (final AmazonClientException ex) {
            System.out.println("putItem throw AmazonClientException");
        }
    }

    /**
     * Scan all user items from Table
     * */
    public List<UserData> scanAllUserItems() {
        final List<UserData> items = new ArrayList<UserData>();
        try {
            final Iterator<UserData> iterator =  userTable.scan().items().iterator();
            while(iterator.hasNext()) {
                final UserData rec = iterator.next();
                items.add(rec);
            }
        } catch (final AmazonServiceException ex) {
            System.out.println("scanAllPostItems throw AmazonServiceException");
        } catch (final AmazonClientException ex) {
            System.out.println("scanAllPostItems throw AmazonClientException");
        }
        return items;
    }

    /**
     * Put new user Item to Table
     * */
    public void putCateItem(final UserData userData) {
        try {
            userTable.updateItem(userData);
        } catch (final AmazonServiceException ex) {
            System.out.println("putItem throw AmazonServiceException");
        } catch (final AmazonClientException ex) {
            System.out.println("putItem throw AmazonClientException");
        }
    }

    /**
     * Scan all CategoryData items from Table
     * */
    public List<CategoryData> scanAllCategoryItems() {
        final List<CategoryData> items = new ArrayList<CategoryData>();
        try {
            final Iterator<CategoryData> iterator =  categoryDataTable.scan().items().iterator();
            while(iterator.hasNext()) {
                final CategoryData rec = iterator.next();
                items.add(rec);
            }
        } catch (final AmazonServiceException ex) {
            System.out.println("scanAllPostItems throw AmazonServiceException");
        } catch (final AmazonClientException ex) {
            System.out.println("scanAllPostItems throw AmazonClientException");
        }
        return items;
    }

    /**
     * Put new CategoryData Item to Table
     * */
    public void putCategoryItem(final CategoryData categoryData) {
        try {
            categoryDataTable.updateItem(categoryData);
        } catch (final AmazonServiceException ex) {
            System.out.println("putItem throw AmazonServiceException");
        } catch (final AmazonClientException ex) {
            System.out.println("putItem throw AmazonClientException");
        }
    }
}
