import org.junit.Test;
import org.junit.runner.notification.RunListener;

import static org.junit.Assert.*;

public class TestOffByOne {


    static OffByOne offByOne  = new OffByOne();
    @Test
    public void testOffByOne() {
        assertTrue(offByOne.equalChars('a','b'));
    }
}
