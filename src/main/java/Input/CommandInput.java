package Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandInput {

    String inputValue;

    public String userInput() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.print("명령) ");
        inputValue=br.readLine();

        return inputValue;
    }
}
