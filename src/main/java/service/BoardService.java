package main.java.service;

import main.java.controller.DbConnection;
import main.java.model.Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by junghk on 2016. 7. 27..
 */
public class BoardService implements BoardRepository{

    private static List<Board> boardList = new ArrayList<>();

    @Override
    public List<Board> findAll(){
        //return boardList;

        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        List<Board> list = new ArrayList<>();
        String sql = "SELECT * FROM BOARD order by seq desc";

        try {
            connection = DbConnection.makeConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Board boardLists = new Board(resultSet.getString("seq"),resultSet.getString("title"),resultSet.getString("writer"),resultSet.getString("content"));
                list.add(boardLists);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeConnection(connection, resultSet, preparedStatement);
        }


        return list;
    }

    @Override
    public Board findOne(String seq){

        Board board = null;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String sql = "";

        try {
            connection = DbConnection.makeConnection();
            sql = "SELECT * FROM BOARD WHERE seq = ? order by seq desc";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, seq);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                board = new Board(resultSet.getString("seq"), resultSet.getString("title"), resultSet.getString("writer"), resultSet.getString("content"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeConnection(connection, resultSet, preparedStatement);
        }

        return board;
    }

    @Override
    public void create(Board board){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "";

        try {
            connection = DbConnection.makeConnection();
            sql = "insert into board (title, writer, content) values (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, board.getTitle());
            preparedStatement.setString(2, board.getWriter());
            preparedStatement.setString(3, board.getContent());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeConnection(connection,preparedStatement);
        }
    }

    @Override
    public void update(Board board, String seq){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "";

        try {
            connection = DbConnection.makeConnection();
            sql = "update board set title = ?, writer=?, content=? where seq = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, board.getTitle());
            preparedStatement.setString(2, board.getWriter());
            preparedStatement.setString(3, board.getContent());
            preparedStatement.setString(4, seq);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeConnection(connection,preparedStatement);
        }
    }

    @Override
    public void delete(String seq) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM BOARD WHERE SEQ = ?";

        try {
            connection = DbConnection.makeConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, seq);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeConnection(connection, preparedStatement);
        }

    }

    @Override
    public List<Board> searchBoards(String findPart, String findCont){
        List<Board> boards = new ArrayList<>();

        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String sql = "";

        try {
            connection = DbConnection.makeConnection();
            if(findPart.equals("all")) {
                sql = "select * from board where title like ? or writer like ? or content like ? order by seq desc";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%"+findCont+"%");
                preparedStatement.setString(2, "%"+findCont+"%");
                preparedStatement.setString(3, "%"+findCont+"%");
            } else {
                if(findPart.equals("title")) sql = "select * from board where title like ? order by seq desc";
                else if(findPart.equals("writer")) sql = "select * from board where writer like ? order by seq desc";
                else if(findPart.equals("content")) sql = "select * from board where content like ? order by seq desc";

                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%"+findCont+"%");
            }
            resultSet =  preparedStatement.executeQuery();

            while(resultSet.next()) {
                Board board = new Board(resultSet.getString("seq"),resultSet.getString("title"),resultSet.getString("writer"),resultSet.getString("content"));
                boards.add(board);
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeConnection(connection, resultSet, preparedStatement);
        }

        return boards;
    }
}
