package co.com.tactusoft.crm.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.RedirectStrategy;

public class CustomSuccessRedirection implements RedirectStrategy {
	 
    @Override
    public void sendRedirect(HttpServletRequest request, HttpServletResponse response,
            String url) throws IOException {
 
       
            response.sendRedirect("/home/a");
       
    }
}