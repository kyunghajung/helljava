package main.java.service;

import main.java.model.Board;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junghk on 2016. 7. 27..
 */
public class BoardService {

    private static List<Board> boardList = new ArrayList<>();

    public List<Board> findAll(){
        return boardList;
    }

    public Board findOne(String seq){

        for(Board board : boardList){
            if(board.getSeq().equals(seq)) {
                return board;
            }
        }

        return null;
    }

    public void create(Board board){
        boardList.add(board);
        Integer seq = boardList.lastIndexOf(boardList) + 1;
        board.setSeq(seq+"");
    }

    public void update(Board board, String seq){
        for(Board boards : boardList){
            if(boards.getSeq().equals(seq)) {
                boards.setContent(board.getContent());
                boards.setTitle(board.getTitle());
            }
        }
    }

    public List<Board> searchBoards(String findPart, String findCont){
        List<Board> boards = new ArrayList<>();

        if(findPart.equals("title")) {
            for(Board board : boardList){
                if(board.getTitle().contains(findCont)) boards.add(board);
            }
        }else if(findPart.equals("writer")){
            for(Board board : boardList){
                if(board.getWriter().contains(findCont)) boards.add(board);
            }
        }else if(findPart.equals("content")){
            for(Board board : boardList){
                if(board.getContent().contains(findCont)) boards.add(board);
            }

        } else {
            for(Board board : boardList){
                if(board.getContent().contains(findCont)) boards.add(board);
                if(board.getWriter().contains(findCont)) boards.add(board);
                if(board.getContent().contains(findCont)) boards.add(board);
            }
        }

        return boards;
    }
}
