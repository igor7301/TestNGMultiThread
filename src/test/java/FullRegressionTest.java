import com.application.AllureFailureTestListener;
import com.application.ApplicationSetup;
import com.model.search.SearchModel;
import com.model.setup.SetupModel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.model.search.SearchTestModel;

/**
 * Created by Admin on 03.03.15.
 */

@Listeners(AllureFailureTestListener.class)
public class FullRegressionTest extends ApplicationSetup {

    @Test
    public void test1(){
        ((SetupModel)getBean("setupTemplateModel")).loadURL("http://www.rambler.ru");
        ((SearchModel)getBean("searchRamblerModel")).makeSearch();

        ((SearchTestModel)getBean("searchTestModel")).setA("http://www.rambler.ru");
        ((SearchModel)getBean("searchTestModel")).makeSearch();
        throw new RuntimeException("exception");


    }

    @Test
    public void test2(){
        ((SetupModel)getBean("setupTemplateModel")).loadURL("http://www.google.com");
        ((SearchTestModel)getBean("searchTestModel")).makeSearch();
    }

    @Test
    public void test3(){
        ((SetupModel)getBean("setupTemplateModel")).loadURL("http://www.hotwire.ru");
        ((SearchModel)getBean("searchTestModel")).makeSearch();
    }

    @Test
    public void test4(){
        ((SetupModel)getBean("setupTemplateModel")).loadURL("http://www.expedia.com");
        ((SearchModel)getBean("searchTestModel")).makeSearch();
    }
}
