import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ Tpdahp.TpdahpTest.class, Tpdohp.TpdohpTest.class, Tpfahp.TpfahpTest.class, 
    Twfahp.TwfahpTest.class })
public class AllTests {
}
