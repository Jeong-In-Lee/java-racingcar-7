package racingcar;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import view.ViewScreen;

public class ViewScreenTest {
    private final ViewScreen viewScreen = new ViewScreen();

    @Test
    void 입력_정상_작동() {
        String input = "pobi,woni,jun\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals(Arrays.asList("pobi,woni,jun", "5"), viewScreen.getInput());
    }

    @ParameterizedTest
    @CsvSource({"pobi,0,pobi :", "woni,2,woni : --", "a,5,a : -----"})
    void 자동차_하나의_경주_상황_출력(String name, String strDistance, String expectedOutput) {
        int intDistance = parseInt(strDistance);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        viewScreen.printRace(name, intDistance);
        assertEquals(expectedOutput, outputStream.toString().trim());
        System.setOut(originalOut);
    }
}
