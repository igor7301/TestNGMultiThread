import application.ApplicationSetup;
import org.testng.annotations.Test;
import model.search.SearchHotel;

/**
 * Created by Admin on 03.03.15.
 */
public class FullRegressionTest extends ApplicationSetup {

    @Test
    public void test1(){
        ((SearchHotel)getBean("searchHotel")).loadUrl("http://www.rambler.ru");
        ((SearchHotel)getBean("searchHotel")).setA("RAMBLER");
        ((SearchHotel)getBean("searchHotel")).makeSearch();
    }

    @Test
    public void test2(){
        ((SearchHotel)getBean("searchHotel")).loadUrl("http://www.google.com");
        ((SearchHotel)getBean("searchHotel")).makeSearch();
    }

    @Test
    public void test3(){
        ((SearchHotel)getBean("searchHotel")).loadUrl("http://www.hotwire.ru");
        ((SearchHotel)getBean("searchHotel")).makeSearch();
    }

    @Test
    public void test4(){
        ((SearchHotel)getBean("searchHotel")).loadUrl("http://www.expedia.com");
        ((SearchHotel)getBean("searchHotel")).makeSearch();
    }
}
