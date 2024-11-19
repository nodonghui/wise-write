package Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandInput {

    String inputValue;

    public String userInput() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        inputValue=br.readLine();
        //필요시 입력에 대한 예외처리

        return inputValue;
    }
}
