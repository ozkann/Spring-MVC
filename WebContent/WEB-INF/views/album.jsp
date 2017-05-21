<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.DbConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.Connection.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Album</title>
<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>



</head>
<body>

<div class="container">
    <div class="row">
            <div class="box clearfix">
            <h3>Images List </h3>
   			
            <table class="table table-hover" id="bootstrap-table">
                <thead>
                <tr>
                    <th>Image</th>
                    <th>Description</th>
                    <th>UploadDate</th>
                </tr>
                </thead>
                <tbody>
                
                
				
						<%
							Connection con = DbConnect.getConnect();
							String query = "select * from album order by uploadedDate desc, utime asc";
							java.sql.PreparedStatement statement;
							statement = con.prepareStatement(query);
							ResultSet rs= statement.executeQuery(query);
							while(rs.next())
							{
							%>
					<tr><td>
						<%
								out.println(rs.getString("image"));
						%>		
					</td><td>
						<%
								out.println(rs.getString("description"));
							
						%>
					</td><td>
								<%
								
								out.println(rs.getString("uploadedDate"));
								
								}
								rs.close();
								statement.close();
								con.close();
								%>
					
					
					
					</td></tr>
					

				</tbody>
				</table>
			
	
		</div>
		
	</div>
	
</div>

<%-- <img src="<%=request.getContextPath()%>/resources/images/whtsp.jpg" /> --%>


</body>
</html>