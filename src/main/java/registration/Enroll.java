package registration;

public class Enroll {

    final int id;
    String line;
    String writer;
    public Enroll(int id,String line,String writer) {
        this.line=line;
        this.writer=writer;
        this.id=id;
    }

    public void setLine(String line) {
        this.line=line;
    }

    public void setWriter(String writer) {
        this.writer=writer;
    }

    public int getId(){
        return id;
    }

    public String getLine(){
        return line;
    }

    public String getWriter() {
        return writer;
    }

    public String toString() {
        String printEnroll=id + " / " + writer + " / " + line;
        return printEnroll;
    }
}
