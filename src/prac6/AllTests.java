package prac6;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CompaniaTest.class, DNITest.class, LinkedOrderListTest.class,
        PasajeroTest.class, VueloTest.class })
public class AllTests {

}
