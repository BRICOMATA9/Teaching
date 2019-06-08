package question1;

public class MemoireTest extends junit.framework.TestCase {

    private question1.Memoire m;

    public void setUp() {
        m = new question1.Memoire();
        m.ecrire("x", 1);
        m.ecrire("y", 1);
    }

    public void test_lectureMemoire() {
        assertEquals(1, m.lire("x").intValue());
        assertEquals("{x=1, y=1}", m.toString());
    }

    public void testException() {
        try {
            m.lire("z");
            fail("lire sans avoir écrit, doit engendrer une exception ???");
        } catch (Exception e) {
        }
    }
}