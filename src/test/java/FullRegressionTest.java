import application.ApplicationSetup;
import model.search.SearchModel;
import model.search.SearchRamblerModel;
import model.setup.SetupModel;
import model.setup.SetupTemplateModel;
import org.testng.annotations.Test;
import model.search.SearchTestModel;

/**
 * Created by Admin on 03.03.15.
 */
public class FullRegressionTest extends ApplicationSetup {

    @Test
    public void test1(){
        ((SetupModel)getBean("setupTemplateModel")).loadURL("http://www.rambler.ru");
        ((SearchModel)getBean("searchRamblerModel")).makeSearch();

        ((SearchTestModel)getBean("searchTestModel")).setA("http://www.rambler.ru");
        ((SearchModel)getBean("searchTestModel")).makeSearch();


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
