package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// [status-line]
		response.setStatus(HttpServletResponse.SC_OK);

		// [response-headers]
//		response.setHeader("Content-Type", "text/plain;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("My-header", "hello"); // 임의의 헤더도 지정 가능

		// [편의 메서드]
//		content(response);
//		cookie(response);
//		redirect(response);

		// [message-body]
		response.getWriter().write("ok");
	}

	/**
	 * Content-Type : text/plain;charset=utf-8
	 * Content-Length : 2
	 *
	 */
	private void content(HttpServletResponse response){
//		response.setHeader("Content-Type","text /plain;charset=utf-8");
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
//		response.setContentLength(2);  // (생략시 자동 생성)
	}

	/**
	 * Set-Cookie: myCookie=good; Max-Age=600;
	 * response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
	 */
	private void cookie(HttpServletResponse response){
		Cookie cookie = new Cookie("myCookie", "good");
		cookie.setMaxAge(600);  // 600초
		response.addCookie(cookie);
	}

	/**
	 *  Location: /basic/hello-form.html
	 */
	private void redirect(HttpServletResponse response){
		response.setStatus(HttpServletResponse.SC_FOUND);
		response.setHeader("Location", "/basic/hello-form.html");
	}
}
