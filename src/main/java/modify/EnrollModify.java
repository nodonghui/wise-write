package modify;

import registration.Enroll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class EnrollModify {
    BufferedReader br;
    public EnrollModify() {
        br=new BufferedReader(new InputStreamReader(System.in));
    }

    public void modifyData(int id, Map<Integer, Enroll> enrolls) throws IOException {

        vaildationId(id,enrolls);

        Enroll enroll=enrolls.get(id);
        modifyEnroll(enroll);

    }

    void vaildationId(int id,Map<Integer, Enroll> enrolls) {
        if(!enrolls.containsKey(id)) {
            throw new IllegalArgumentException(id+"번 명언은 존재하지 않습니다.");
        }
    }

    void modifyEnroll(Enroll enroll) throws IOException {

        System.out.println("명언(기존) : "+ enroll.getLine());
        System.out.print("명언 : ");
        String line= br.readLine();
        enroll.setLine(line);
        System.out.println("작가(기존) : " + enroll.getWriter());
        System.out.print("작가 : ");
        String writer= br.readLine();
        enroll.setWriter(writer);
    }
}
