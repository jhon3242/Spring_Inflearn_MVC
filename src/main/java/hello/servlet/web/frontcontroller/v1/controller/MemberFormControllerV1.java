package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFormControllerV1.process");
		String viewPath = "/WEB-INF/views/new-form.jsp";    // 뷰 경로
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);  // 해당 경로로 이동할거야
		dispatcher.forward(request, response);  // 실제로 이 (서블릿에서 JSP를 호출, 제어권을 넘겨줌)
	}
}
