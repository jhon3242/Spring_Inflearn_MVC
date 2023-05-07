package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

	MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public ModelView process(Map<String, String> paraMap) {
		String username = paraMap.get("username");
		int age = Integer.parseInt(paraMap.get("age"));
		Member member = new Member(username, age);

		// 회원 저장
		memberRepository.save(member);

		ModelView modelView = new ModelView("save-result");
		modelView.getModel().put("member", member);
		return modelView;
	}
}
