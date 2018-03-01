package ru.senla.bialevich.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ru.senla.bialevich.service.TokenHandler;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class StatelessAuthFilter implements Filter {
    private static final Logger LOG = Logger.getLogger(StatelessAuthFilter.class);
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rs = (HttpServletResponse) response;
        String token = req.getHeader("X-Auth-Token");

        Integer id = TokenHandler.getInstance().extractAuthId(token);

        if (id != null) {
            try {
                filterChain.doFilter(request, response);
            } catch (IOException | ServletException e) {
                LOG.error(e.getMessage());
            }
        } else {
            try {
                rs.sendError(401);
            } catch (IOException e) {
                LOG.error(e.getMessage());
            }
        }
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
