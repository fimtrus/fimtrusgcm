package com.fimtrus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sss1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Enumeration names = req.getAttributeNames();
		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		while ( names.hasMoreElements() ) {
			String c = (String) names.nextElement();
			nameList.add(c);
			valueList.add(c);
		}
	}

}
