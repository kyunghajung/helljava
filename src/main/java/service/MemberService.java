package main.java.service;

import main.java.model.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junghk on 2016. 7. 28..
 */
public class MemberService implements MemberRepository{

    private static List<Member> memberList = new ArrayList<>();

    @Override
    public void join(Member member){

    }

    @Override
    public Member loginCheck(String id, String pwd) {

        Member loginMember = new Member();

        for(Member member : memberList){
            if(member.getId().equals(id)) {
                if(member.getPwd().equals(pwd)){
                    loginMember.setId(id);
                    loginMember.setId(pwd);
                }
            }
        }
        return loginMember;
    }
}
