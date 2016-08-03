package main.java.service;

import main.java.model.Board;

import java.util.List;

/**
 * Created by junghk on 2016. 8. 2..
 */
public interface BoardRepository {

    List<Board> findAll();

    Board findOne(String seq);

    void create(Board board);

    void update(Board board, String seq);

    void delete(String seq);

    List<Board> searchBoards(String findPart, String findCont);
}
