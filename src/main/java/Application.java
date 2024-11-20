import Input.CommandInput;
import delete.EnrollDelete;
import init.LoadWiseWriteList;
import modify.EnrollModify;
import registration.Enroll;
import reset.ResetDatabase;
import updateDatabase.DeleteEnroll;
import updateDatabase.WriteEnroll;
import updateDatabase.WriteId;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Application {

    static CommandInput commandInput =new CommandInput();
    static EnrollDelete enrollDelete = new EnrollDelete();
    static EnrollModify enrollModify= new EnrollModify();
    static WriteId writeId=new WriteId();
    static WriteEnroll writeEnroll=new WriteEnroll();
    static DeleteEnroll deleteEnroll=new DeleteEnroll();
    static ResetDatabase resetDatabase=new ResetDatabase();
    static LoadWiseWriteList loadWiseWriteList=new LoadWiseWriteList();

    static String inputValue;
    static BufferedReader br;
    static int id;

    static Map<Integer,Enroll> enrolls;

    public static void main(String args[]) {
        //program start

        System.out.println("== 명언 앱 ==");
        init();
        while(true) {
            try {
                System.out.print("명령) ");
                inputValue=commandInput.userInput();

                if(inputValue.equals("종료")) {
                    writeId.makeFile(id-1);
                    break;
                }
                if(inputValue.equals("등록")) { enrollProcess(); }
                if(inputValue.equals("목록")) { viewProcess(); }
                if(inputValue.startsWith("삭제")) { deleteProcess(); }
                if(inputValue.startsWith("수정")) { modifyProcess(); }
                if(inputValue.equals("초기화")) { resetProcess(); break;}
            } catch (IOException e) {
                System.err.print(e.getMessage());
            }



        }
    }

    public static void init(){
        br=new BufferedReader(new InputStreamReader(System.in));

        id=writeId.loadFile();
        if(id==-1) {
            id=1;
        }

        enrolls=loadWiseWriteList.loadEnrolls();
    }


    public static void enrollProcess() throws IOException {
        System.out.print("명언 : ");
        String line=br.readLine();
        System.out.print("작가 : ");
        String writer= br.readLine();
        Enroll enroll=new Enroll(id,line,writer);
        enrolls.put(id,enroll);
        System.out.println(id+"번 명언이 등록되었습니다.");
        id+=1;
        writeEnroll.wirteFile(enroll);

    }

    public static void viewProcess() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (Map.Entry<Integer, Enroll> entry : enrolls.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }

    public static void deleteProcess() {
        String cmd=inputValue;

        try {
            int id=splitData(cmd);
            enrollDelete.deleteData(id,enrolls);
            System.out.println(id+"번 명언이 삭제되었습니다.");
            deleteEnroll.deleteDatabaseData(id);

        } catch (NumberFormatException e) {
            System.out.println("삭제 명령어 형식을 맞춰주세요");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }



    public static void modifyProcess() {
        String cmd=inputValue;

        try {
            int id=splitData(cmd);
            enrollModify.modifyData(id,enrolls);
            Enroll enroll=enrolls.get(id);
            System.out.println(id+"번 명언이 수정되었습니다.");
            //수정된 내용 db반영
            writeEnroll.wirteFile(enroll);
        } catch (NumberFormatException e) {
            System.out.println("삭제 명령어 형식을 맞춰주세요");
        }
        catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int splitData(String cmd) {
        String[] splitData1=inputValue.split("\\?");
        if(splitData1.length !=2) {throw new IllegalArgumentException("삭제 명령어 형식을 맞춰주세요.");}
        String[] splitData2=splitData1[1].split("=");
        if(splitData2.length !=2) {throw  new IllegalArgumentException("삭제 명령어 형식을 맞춰주세요");}

        return Integer.parseInt(splitData2[1]);
    }

    public static void resetProcess() {
        resetDatabase.reset();
        enrolls.clear();
    }



}
