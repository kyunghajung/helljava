package main.java.model;

/**
 * Created by junghk on 2016. 7. 27..
 */
public class Board {

    // 순번, 제목, 글쓴이, 내용

    private String  seq;     // 순번
    private String  title;   // 제목
    private String  writer;  // 글쓴이
    private String  content; // 내용

    public Board(){

    }

    public Board(String seq, String title, String writer, String content) {
        this.seq = seq;
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Board{" +
                "seq=" + seq +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}


