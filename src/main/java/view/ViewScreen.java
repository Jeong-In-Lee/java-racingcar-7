package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ViewScreen {
    public List<String> getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String runTimes = Console.readLine();
        return Arrays.asList(carNamesInput, runTimes);
    }

    public void printRace(String name, int distance) {
        System.out.println(name + " : " + "-".repeat(distance));
    }

}