package com.Service;



import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;



/**
 * Created by Adi on 9/18/2015.
 */
public class CorsFilter implements Filter {

    public void destroy(){
        // TODO Auto-generated method stub
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        httpServletResponse.addHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE, PUT");
        httpServletResponse.addHeader("Access-Control-Max-Age","3600");
        httpServletResponse.addHeader("Access-Control-Allow-Headers","x-requested-with, X-Auth-Token, Content-Type");

        chain.doFilter(request, response);
    }

    public void init(FilterConfig chain) throws ServletException {
        // TODO Auto-generated method stub

    }




}
