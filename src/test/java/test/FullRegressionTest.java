package test;


import com.application.ApplicationSetup;
import com.model.search.SearchModel;
import com.model.search.SearchRamblerModel;
import com.model.setup.SetupModel;
import com.model.setup.SetupTemplateModel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.model.search.SearchTestModel;
import com.application.MyListener;

/**
 * Created by Admin on 03.03.15.
 */

@Listeners(com.application.MyListener.class)
public class FullRegressionTest extends ApplicationSetup {

    private int DELAY_BTW_REPEATING = 20000;

    @Test
    public void test1() {


        while (true) {
            try {
                SetupTemplateModel.getInstance().loadURL("http://www.rambler.ru");
                SearchRamblerModel.getInstance().makeSearch();


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
