package registration;

public class Enroll {

    final int serialNum;
    String line;
    String writer;
    public Enroll(int serialNum,String line,String writer) {
        this.line=line;
        this.writer=writer;
        this.serialNum=serialNum;
    }

    public void setLine(String line) {
        this.line=line;
    }

    public void setWriter(String writer) {
        this.writer=writer;
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
