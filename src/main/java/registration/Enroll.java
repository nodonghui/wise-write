package registration;

public class Enroll {

    final int serialNum;
    final String line;
    final String writer;
    public Enroll(int serialNum,String line,String writer) {
        this.line=line;
        this.writer=writer;
        this.serialNum=serialNum;
    }

    public int getSerialNum(){
        return serialNum;
    }

    public String getLine(){
        return line;
    }

    public String getWriter() {
        return writer;
    }

    public String toString() {
        String printEnroll=serialNum + " / " + writer + " / " + line;
        return printEnroll;
    }
}
