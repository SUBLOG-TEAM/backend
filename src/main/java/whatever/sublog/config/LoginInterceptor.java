package whatever.sublog.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String sessionId = request.getHeader("Authorization");

        if (sessionId == null || sessionId.isEmpty()) {
            response.sendRedirect("/");
            return false;
        }
        Long memberId = (Long) request.getSession().getAttribute(sessionId);
        if (memberId == null) {
            response.sendRedirect("/");
            return false;
        }
        request.setAttribute("memberId", memberId);
        return true;
    }
}
