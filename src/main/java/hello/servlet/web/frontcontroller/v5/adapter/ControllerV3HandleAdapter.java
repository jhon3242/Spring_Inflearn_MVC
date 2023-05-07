package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandleAdapter implements MyHandlerAdapter {

	@Override
	public boolean support(Object handler) {
		return (handler instanceof ControllerV3);
	}

	@Override
	public ModelView handle(HttpServletRequest req, HttpServletResponse resp, Object handler) {
		ControllerV3 controller = (ControllerV3) handler;
		Map<String, String> paraMap = createParaMap(req);
		ModelView modelView = controller.process(paraMap);
		return modelView;
	}

	private Map<String, String> createParaMap(HttpServletRequest req) {
		Map<String, String> paraMap = new HashMap<>();
		req.getParameterNames().asIterator()
				.forEachRemaining(key -> paraMap.put(key, req.getParameter(key)));
		return paraMap;
	}
}
