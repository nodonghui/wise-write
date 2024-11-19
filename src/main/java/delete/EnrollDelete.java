package delete;

import registration.Enroll;

import java.util.Map;

public class EnrollDelete {


    public void deleteData(int id,Map<Integer, Enroll> enrolls) {

        vaildationId(id,enrolls);
        enrolls.remove(id);

    }

    void vaildationId(int id,Map<Integer, Enroll> enrolls) {
        if(!enrolls.containsKey(id)) {
            throw new IllegalArgumentException(id+"번 명언은 존재하지 않습니다.");
        }
    }
}
