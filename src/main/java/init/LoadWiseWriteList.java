package init;

import registration.Enroll;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class LoadWiseWriteList {

    public LoadWiseWriteList() {
    }

    public Map<Integer,Enroll> loadEnrolls() {

        String directoryPath = "db/wiseSaying";
        File directory = new File(directoryPath);
        Map<Integer,Enroll> enrolls=new LinkedHashMap<>();

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if(file.getPath().endsWith(".txt")) { continue;}
                Enroll enroll=parseJsonData(file);
                enrolls.put(enroll.getId(),enroll);
            }
        }

        return enrolls;
    }

    Enroll parseJsonData(File file) {

        int id=0;
        String content="";
        String writer="";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {

                if(!(line.startsWith("{") || line.startsWith("}"))) {
                    String modifyLine=line.trim();
                    if(modifyLine.endsWith(",")) { modifyLine = modifyLine.substring(0, modifyLine.length() - 1);}
                    String [] splitData=modifyLine.split(":");

                    String name=parseName(splitData[0]);

                    modifyLine=splitData[1].trim();
                    if(name.equals("id")) { id=Integer.parseInt(modifyLine); }
                    if(name.equals("line")) { content=modifyLine.substring(1,modifyLine.length()-1); }
                    if(name.equals("writer")) { writer=modifyLine.substring(1,modifyLine.length()-1); }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return new Enroll(id,content,writer);
    }

    String parseName(String line) {
        String modifyLine=line.trim();
        modifyLine=modifyLine.substring(1,modifyLine.length()-1);
        return modifyLine;
    }
}
