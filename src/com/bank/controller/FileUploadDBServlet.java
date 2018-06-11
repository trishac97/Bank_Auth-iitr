package com.bank.controller;

import java.io.IOException;
import java.io.InputStream;
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
import javax.servlet.http.Part;

import com.bank.dao.bankDAO;
import com.bank.model.UploadDetails;
 
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class FileUploadDBServlet extends HttpServlet {
     
	private static final long serialVersionUID = 1L;
    
    public FileUploadDBServlet() {
        super();
    }
     
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
    	String acc_no=request.getParameter("acc_no");
        String password = request.getParameter("password");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }

        UploadDetails up=new UploadDetails();
        up.setAcc_no(acc_no);
        up.setPassword(password);
        up.setFirst_name(first_name);
        up.setLast_name(last_name);
        up.setPhoto(inputStream);
        bankDAO u=new bankDAO();
        String servermsg="Something went wrong! Please try after sometime.";
        String nextviewpage;
        boolean replyfromdao=u.upload(up);
        if(replyfromdao) {
        	System.out.println("Successful!!");
        	request.setAttribute("servermsg", servermsg);
	    	nextviewpage ="login.jsp";
        }
        else {
        	System.out.println("Not successful");
        	request.setAttribute("servermsg", servermsg);
	    	nextviewpage ="registration.jsp";

        }
        
  		    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
  	     	rd.forward(request, response);
    }
    
}