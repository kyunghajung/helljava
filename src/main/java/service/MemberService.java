package main.java.service;

import main.java.controller.DbConnection;
import main.java.model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by junghk on 2016. 7. 28..
 */
public class MemberService implements MemberRepository{

    //private static List<Member> memberList = new ArrayList<>();

    @Override
    public void join(Member member){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "";

        try {
            connection = DbConnection.makeConnection();
            sql = "insert into MEMBER (id, pwd) values (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getId());
            preparedStatement.setString(2, member.getPwd());
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeConnection(connection, resultSet, preparedStatement);
        }

    }

    @Override
    public String idCheck(String id){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "";
        String memYn = "N";

        try {
            connection = DbConnection.makeConnection();
            sql = "SELECT count(*) as memCount FROM MEMBER WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                if(resultSet.getInt("memCount") != 0) memYn = "Y";
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeConnection(connection, resultSet, preparedStatement);
        }
        return memYn;
    }



    
    @Override
    public Member loginCheck(String id, String pwd) {

        Member loginMember = new Member();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "";

        try {
            connection = DbConnection.makeConnection();
            sql = "SELECT count(*) as memCount FROM MEMBER WHERE id = ? and pwd = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, pwd);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                if(resultSet.getInt("memCount") != 0){
                    loginMember.setId(id);
                    loginMember.setPwd(pwd);
                } else {
                    loginMember = null;
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeConnection(connection, resultSet, preparedStatement);
        }

        return loginMember;
    }
}
