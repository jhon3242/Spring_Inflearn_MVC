package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandleAdapter implements MyHandlerAdapter {
	@Override
	public boolean support(Object handler) {
		return (handler instanceof ControllerV4);
	}

	@Override
	public ModelView handle(HttpServletRequest req, HttpServletResponse resp, Object handler) {
		ControllerV4 controller = (ControllerV4) handler;
		Map<String, String> paraMap = createParaMap(req);
		HashMap<String, Object> model = new HashMap<>();
		String viewName = controller.process(paraMap, model);
		ModelView modelView = new ModelView(viewName);
		modelView.setModel(model);
		return modelView;
	}

	private Map<String, String> createParaMap(HttpServletRequest req) {
		Map<String, String> paraMap = new HashMap<>();
		req.getParameterNames().asIterator()
				.forEachRemaining(key -> paraMap.put(key, req.getParameter(key)));
		return paraMap;
	}
}
