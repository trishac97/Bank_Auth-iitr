package com.bank.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.model.UploadDetails;

public class bankDAO {
	public boolean upload(UploadDetails docobj) {
		Connection connectionobject = null;
		PreparedStatement pst = null;
		boolean f = false;
		try
		{
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        //connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	 
	         //JDBC STEP 3
	         //CREATE QUERY
	         pst = connectionobject.prepareStatement("insert into bank_details values (?,?,?,?,?)");
		     
		     pst.setString(1, docobj.getAcc_no());
		     pst.setString(2, docobj.getPassword());
		     pst.setString(3, docobj.getFirst_name());
		     pst.setString(4, docobj.getLast_name());
		     pst.setBlob(5, docobj.getPhoto(null));
		    
		     //JDBC STEP 4
		     //EXECUTE QUERY
		     int i = pst.executeUpdate();		     
		     if(i > 0 )
		    	 f = true;
           
	    }catch(SQLException e){System.out.print(e.toString());}
	     finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return f;
		
	}
	public boolean passAuth(UploadDetails docobj) {
		Connection connectionobject = null;
		PreparedStatement pst = null;
		boolean f = false;
		ResultSet rs=null;
		try
		{
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		       System.out.println("Acc_no in dao"+docobj.getAcc_no());
 
	      
	         pst = connectionobject.prepareStatement("select password from bank_details where acc_no=?");
		     
		     pst.setString(1, docobj.getAcc_no());
		 
		     rs = pst.executeQuery();		     
		     while(rs.next()) {
		    	if(rs.getString(1).equals(docobj.getPassword())) {
		    		f=true;
		    		return f;
		    	}
		    
		     }
		     
           
	    }catch(SQLException e){System.out.print(e.toString());}
	     finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		return f;
		
		
	}
	public byte[ ] retrieve(UploadDetails docobj) throws IOException {
		Connection connectionobject = null;
		PreparedStatement pst = null;
		boolean f = false;
		ResultSet rs=null;
		Blob image = null;
		byte[ ] imgData = null ;
		try
		{
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        //connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	 
	         //JDBC STEP 3
	         //CREATE QUERY
	         pst = connectionobject.prepareStatement("select photo from bank_details where acc_no=?");
		     
		     pst.setString(1, docobj.getAcc_no());
		    
		    
		     //JDBC STEP 4
		     //EXECUTE QUERY
		     rs = pst.executeQuery();	
		      while(rs.next()) {

		    	 image = rs.getBlob(1);

		    	 imgData = image.getBytes(1,(int)image.length());
		    	 }
		     
			    	  
		    	  
           
	    }catch(SQLException e){System.out.print(e.toString());}
	     finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
   	 return imgData;
	
	}
	
}
