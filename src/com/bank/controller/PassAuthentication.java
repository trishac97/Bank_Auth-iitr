package com.bank.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bank.dao.bankDAO;
import com.bank.model.UploadDetails;
 
@WebServlet("/passAuth")
public class PassAuthentication extends HttpServlet {
     
	private static final long serialVersionUID = 1L;
    
    public PassAuthentication() {
        super();
    }
     
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
    	HttpSession session = request.getSession(true);
	       String acc_no=(String)session.getAttribute("acc_no"); 
	       System.out.println("Acc_no"+acc_no);

	       String password=request.getParameter("password");
	       System.out.println("pass"+password);

	       String servermsg="INVALID ACCOUNT NUMBER OR PASSWORD";
      
        String nextviewpage="";
        UploadDetails up=new UploadDetails();
        up.setAcc_no(acc_no);
        up.setPassword(password);
        bankDAO u=new bankDAO();
        boolean replyfromdao=u.passAuth(up);
	       System.out.println("Reply from dao"+replyfromdao);

        if(replyfromdao) {
        	System.out.println("Successful!!");
	    	nextviewpage ="Welcome.jsp";
        
        }
        else {
        	request.setAttribute("servermsg", servermsg);
	    	nextviewpage ="login.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
      	rd.forward(request, response);
        
        
    }
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    	{
    		doPost(request,response);
    	}
        
 	   
    
    
}