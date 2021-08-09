import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import model.UserData;
import module.ForumServiceModule;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import service.ForumDynamodbService;

@Log4j
@RequiredArgsConstructor(onConstructor = @__(@Inject))
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ForumDynamodbServiceTest {
    private Injector injector;
    private ForumDynamodbService forumDynamodbService;
    @BeforeAll
    public void setup() {
        injector = Guice.createInjector(new ForumServiceModule());
    }
    @Test
    public void test() {
        forumDynamodbService = injector.getInstance(ForumDynamodbService.class);
        UserData userData = UserData.builder()
                .userId(2L)
                .userName("yating")
                .userPassword("sdsafdsafx")
                .userEmail("")
                .build();
        forumDynamodbService.putUserItem(userData);
    }

}