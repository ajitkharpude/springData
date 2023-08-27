package com.example.demo.Controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.repo.UserRepo;

public class SecurityGuard extends OncePerRequestFilter {

	@Autowired
	JwtUtil jwtUtil;
	@Autowired
	UserRepo userRepo;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s = request.getRequestURI();
		if (s.startsWith("/login")) {
			filterChain.doFilter(request, response);
		} else {
			String str[] = s.split("/");
			String token = str[str.length - 1];
			String nm = jwtUtil.extractUsername(token);
			System.out.println(nm + "hi");
			userRepo.findByUsername(nm);
			
			
			
             
		}
	}

}
