import com.company.Main;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BracesBalance {
    @Test
    public void isBacesCorrect() {
        assertEquals(Main.Answer.VALID.getAnswer(), Main.isBracketsCorrect("()[]{}"));
        assertEquals(Main.Answer.VALID.getAnswer(), Main.isBracketsCorrect("{()[[]]{}}"));
        assertEquals(Main.Answer.VALID.getAnswer(), Main.isBracketsCorrect("(({{[[]]}}))"));
        assertEquals(Main.Answer.WRONG_ORDER.getAnswer(), Main.isBracketsCorrect("(()"));
        assertEquals(Main.Answer.WRONG_ORDER.getAnswer(), Main.isBracketsCorrect("{]"));
        assertEquals(Main.Answer.WRONG_ORDER.getAnswer(), Main.isBracketsCorrect("()]"));
        assertEquals(Main.Answer.WRONG_CHAR.getAnswer(), Main.isBracketsCorrect(""));
    }
}
