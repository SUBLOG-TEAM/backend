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
        String requestURI = request.getRequestURI();
        // 세션이 없으면 로그인 페이지로 이동
        if (sessionId == null || sessionId.isEmpty()) {
            // home 접근이면 통과
            if (requestURI.equals("/home")) {
                return true;
            }
            response.sendRedirect("/login");
            return false;
        }

        Long memberId = (Long) request.getSession().getAttribute(sessionId);
        // 유효하지 않은 세션이면 로그인 페이지로 이동
        if (memberId != null) {
            request.setAttribute("memberId", memberId);
        }
        // home 접근이면 통과
        else if (!requestURI.equals("/home")) {
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}
