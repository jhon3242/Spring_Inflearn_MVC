package hello.servlet.web.springmvc.v1;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SpringMemberListControllerV1 {
	MemberRepository memberRepository = MemberRepository.getInstance();

	@RequestMapping("/springmvc/v1/members")
	public ModelAndView process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("SpringMemberListControllerV1.process");
		ModelAndView mv = new ModelAndView("members");
		mv.addObject("members", memberRepository.findAll());
		return mv;
	}
}
