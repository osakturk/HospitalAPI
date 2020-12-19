package com.example.springboot.filter;

import com.example.springboot.util.RequestContext;
import com.example.springboot.util.ThreadLocal;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


@Component
@Order(1)
public class UserSelectionFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest hsr = (HttpServletRequest) request;
            String customerIdStr = hsr.getHeader("customerId");

            RequestContext context = ThreadLocal.safeGet();

            if (StringUtils.isNotBlank(customerIdStr)) {
                context.setCustomerId(Integer.valueOf(customerIdStr));
            }

            chain.doFilter(request, response);
        } finally {
            ThreadLocal.unset();
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void destroy() {
    }
}
