import Input.CommandInput;
import registration.Enroll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {

    static CommandInput commandInput =new CommandInput();

    static String inputValue;
    static BufferedReader br;
    static int serialNumber;

    static List<Enroll> enrolls;

    public static void main(String args[]) {
        //program start

        System.out.println("== 명언 앱 ==");
        init();
        while(true) {
            try {
                System.out.print("명령) ");
                inputValue=commandInput.userInput();

                if(inputValue.equals("종료")) { break; }
                if(inputValue.equals("등록")) { enrollProcess(); }
                if(inputValue.equals("목록")) { viewProcess(); }
            } catch (IOException e) {
                System.err.print(e.getMessage());
            }



        }
    }

    public static void init(){
        br=new BufferedReader(new InputStreamReader(System.in));
        serialNumber=1;
        enrolls=new ArrayList<>();
    }


    public static void enrollProcess() throws IOException {
        System.out.print("명언 : ");
        String line=br.readLine();
        System.out.print("작가 : ");
        String writer= br.readLine();

        enrolls.add(new Enroll(serialNumber,line,writer));
        System.out.println(serialNumber+"번 명언이 등록되었습니다.");
        serialNumber+=1;

    }

    public static void viewProcess() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for(Enroll e : enrolls) {
            System.out.println(e.toString());
        }
    }


}
