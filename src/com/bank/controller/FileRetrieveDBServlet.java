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
 
@WebServlet("/retrieveServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class FileRetrieveDBServlet extends HttpServlet {
     
	private static final long serialVersionUID = 1L;
    
    public FileRetrieveDBServlet() {
        super();
    }
     
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
    	String acc_no=request.getParameter("acc_no");
    	
      
        InputStream inputStream = null; // input stream of the upload file
        
        UploadDetails up=new UploadDetails();
        up.setAcc_no(acc_no);
       
        
        bankDAO u=new bankDAO();
        
        byte[ ] imgData=u.retrieve(up);
        if(imgData!=null) {
        	 HttpSession session = request.getSession(true);
      	   session.setAttribute("acc_no", acc_no);
        	response.setContentType("image/jpeg");
        	
        	OutputStream o = response.getOutputStream();

        	o.write(imgData);

        	o.flush();

        	o.close(); 
        
        }
        
    }
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    	{
    		doPost(request,response);
    	}

    
    
    
}