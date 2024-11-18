import Input.CommandInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    static CommandInput commandInput =new CommandInput();

    static String inputValue;

    public static void main(String args[]) {
        //program start
        init();
        System.out.println("== 명언 앱 ==");
        while(true) {
            InputProcess();

            if(inputValue.equals("종료")) { break; }
        }
    }

    public static void init(){


    }

    public static void InputProcess() {
        try {
            inputValue=commandInput.userInput();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


}
