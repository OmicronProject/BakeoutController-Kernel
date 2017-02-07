package unit;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.After;

/**
 * Base class for all unit tests
 */
public abstract class UnitTestCase {
    /**
     * Set up a context for performing mocks using JMock
     */
    protected final Mockery context = new UnitTestingMockery();

    /**
     * Check that any mockeries set up were correctly used
     */
    @After
    public void assertGoodContext(){
        this.context.assertIsSatisfied();
    }

    /**
     * Extends the JUnit mockery with a synchronizer to allow for
     * multi-threaded testing.
     */
    private class UnitTestingMockery extends JUnit4Mockery {
        UnitTestingMockery(){
            setThreadingPolicy(new Synchroniser());
        }
    }
}
