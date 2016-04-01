package test;


import com.application.ApplicationSetup;
import com.data.Beans;
import com.data.WebDriverUtil;
import com.model.search.SearchModel;
import com.model.search.web.SearchRamblerModel;
import com.model.setup.SetupModel;
import com.model.setup.SetupTemplateModel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Admin on 03.03.15.
 */

@Listeners(com.application.MyListener.class)
public class FullRegressionTest extends ApplicationSetup {

    public static final int MAX_AMOUNT_OF_TABS = 20;
    private int DELAY_BTW_REPEATING = 2000;
    private String email = "igor7301@gmail.com";
    private String password = "";

    private void loginToSurfEarner() {
        ((SetupModel) getBean("setupTemplateModel")).printTestMessage();

        ((SetupModel) getBean("setupTemplateModel")).loadURL("http://www.surfearner.com/login/");
        ((SetupModel) getBean("setupTemplateModel")).loginToSurfEarner(email, password);



    }

    @Test
    public void test1() {


        ((SetupModel) getBean("setupTemplateModel")).setMessage("TEST1");
        loginToSurfEarner();

        ((SetupModel) getBean("setupTemplateModel")).loadURL("http://www.rambler.ru");
        ((SearchRamblerModel) getBean("searchRamblerModel")).makeSearch();
//        SetupTemplateModel.getInstance().loadURL("http://www.rambler.ru");
//        SearchRamblerModel.getInstance().makeSearch();

        int i = 0 ;
        while (true) {
            try {

                if (i < MAX_AMOUNT_OF_TABS) {
                    SearchRamblerModel.getInstance().chooseRandomResult();
                    new WebDriverUtil().makeActivityInAllTabs();
                }
                else {
                    new WebDriverUtil().closeAllTabs();
                    SearchRamblerModel.getInstance().makeSearch();
                    i = 0;
                }

                i++;
            }
            catch (Exception e) {
                e.printStackTrace();
            }

//            ((SearchTestModel) getBean("searchTestModel")).setA("http://www.rambler.ru");
//            ((SearchModel) getBean("searchTestModel")).makeSearch();


            try {
                Thread.sleep(DELAY_BTW_REPEATING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test2() {
        loginToSurfEarner();
        while (true) {
            try {
                ((SetupModel) getBean("setupTemplateModel")).loadURL("http://www.google.com");
                ((SearchModel) getBean("searchGoogleModel")).makeSearch();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(DELAY_BTW_REPEATING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void test3(){
        loginToSurfEarner();
        while (true) {
            try {
                ((SetupModel) getBean("setupTemplateModel")).loadURL("http://www.yandex.ru");
                ((SearchModel) getBean("searchYandexModel")).makeSearch();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(DELAY_BTW_REPEATING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test4() {
        loginToSurfEarner();
        while (true) {
            try {
                ((SetupModel) getBean("setupTemplateModel")).loadURL("http://www.expedia.com");
                ((SearchModel) getBean("searchTestModel")).makeSearch();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(DELAY_BTW_REPEATING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
