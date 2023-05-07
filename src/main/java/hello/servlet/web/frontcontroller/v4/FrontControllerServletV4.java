package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/members/*")
public class FrontControllerServletV4 extends HttpServlet {

	private Map<String, ControllerV4> controllerMap = new HashMap<>();

	public FrontControllerServletV4() {
		controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
		controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
		controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		ControllerV4 controller = controllerMap.get(requestURI);
		if (controller == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		Map<String, String> paraMap = createParaMap(req);
		Map<String, Object> model = new HashMap<>();
		String viewName = controller.process(paraMap, model);
		MyView myView = viewResolver(viewName);
		myView.render(model, req, resp);
	}

	private MyView viewResolver(String viewName) {
		return new MyView("/WEB-INF/views/" + viewName + ".jsp");
	}

	private Map<String, String> createParaMap(HttpServletRequest req) {
		Map<String, String> paraMap = new HashMap<>();
		req.getParameterNames().asIterator()
				.forEachRemaining(key -> paraMap.put(key, req.getParameter(key)));
		return paraMap;
	}
}
