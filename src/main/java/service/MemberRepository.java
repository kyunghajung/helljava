package main.java.service;

import main.java.model.Member;

/**
 * Created by junghk on 2016. 7. 28..
 */
public interface MemberRepository {

    void join(Member member);

    Member loginCheck(String id, String pwd);

    String idCheck(String id);
}
