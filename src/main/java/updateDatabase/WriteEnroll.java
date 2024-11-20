package updateDatabase;

import registration.Enroll;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class WriteEnroll {

    public WriteEnroll() {

    }

    public void wirteFile(Enroll enroll) {
        int id=enroll.getId();
        String filePath = "db/wiseSaying/"+String.valueOf(id)+".json";
        String content =makeJsonContent(enroll);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content); // 데이터 쓰기

        } catch (IOException e) {
            System.out.println(String.valueOf(id)+".json파일 작성 예외 발생");
        }
    }

    String makeJsonContent(Enroll enroll) {
        StringBuilder sb=new StringBuilder();

        Class<?> clazz = enroll.getClass();  // 클래스 정보 가져오기
        Field[] fields = clazz.getDeclaredFields();

        sb.append("{\n");
        for(int i=0;i<fields.length;i++) {
            Field field=fields[i];
            field.setAccessible(true);

            try {
                String name=field.getName();
                Object value=field.get(enroll);

                sb.append("  \"");
                sb.append(name); sb.append("\" : ");

                if(value instanceof String) {
                    sb.append("\"");
                    sb.append(value);
                    sb.append("\",\n");
                } else {
                    sb.append(value); sb.append(",\n");
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sb.setLength(sb.length()-2);
        sb.append("\n");
        sb.append("}\n");


        return  sb.toString();
    }




}
