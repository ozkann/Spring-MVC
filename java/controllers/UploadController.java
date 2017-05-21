package controllers;

import java.io.File;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.DbConnect;
import model.UploadedFile;






@Controller
public class UploadController {

	
	@RequestMapping("UploadForm")
	public ModelAndView getUploadForm(@ModelAttribute("uploadedFile") UploadedFile uploadedFile,BindingResult result) {
		return new ModelAndView("uploadForm");
	}
	

	@RequestMapping("/Album")
	public String getAlbum() {

	    return "album";
	}

	
	@RequestMapping("Upload")
	public ModelAndView fileUploaded(@ModelAttribute("uploadedFile") UploadedFile uploadedFile,BindingResult result) {
		InputStream inputStream = null;
		OutputStream outputStream = null;

		MultipartFile file = uploadedFile.getFile();
		

		String fileName = file.getOriginalFilename();
		
		String description = uploadedFile.getDescription();
		
		Timestamp uploadDate = new Timestamp(System.currentTimeMillis());
		Timestamp uTime = new Timestamp(new java.util.Date().getTime());
		
		
		
		
		double B=0;
		try {
			B = file.getBytes().length;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		double mbytes = B/(1024*1024);
		
		
		

		if (result.hasErrors()) {
			return new ModelAndView("uploadForm");
		}
		if (file.isEmpty()){
			
			return new ModelAndView("uploadForm","message","Please select image !");
			
		}

		try {
			inputStream = file.getInputStream();
			String path = "C:/Users/ozkan/files/";
			File newFile = new File(path + fileName);
			
			if (mbytes >2){
				System.out.println("image size too large"+ mbytes);
				return  new ModelAndView("uploadForm", "message", fileName+"&nbsp;"+"size:&nbsp;:"+mbytes+" !&nbsp;max image size to upload : 2MB");
			}
			if (newFile.exists()){
				return  new ModelAndView("uploadForm", "message", fileName+"&nbsp;"+"already exist !");
			}
			if (!newFile.exists() ) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
            	Connection conn = DbConnect.getConnect();
            	
				String query = "INSERT INTO album (image,imagepath, description, uploadedDate, utime)" + " values (?,?,?,?,?)";
				java.sql.PreparedStatement statement;
				try {
					statement = conn.prepareStatement(query);
					statement.setString(1,fileName);
					statement.setString(2,"C:/Users/ozkan/files/"+fileName );
					statement.setString(3,description);
					statement.setTimestamp(4, uploadDate);
					statement.setTimestamp(5, uTime);
					statement.execute();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

		
		
		System.out.println(fileName+description+"=>uoloaded on =>:"+uploadDate);
//		System.out.println(imageInfo.get(0).getDescription()+imageInfo.get(0).getFile().getOriginalFilename());
		description="";
		return  new ModelAndView("uploadForm", "message", fileName+"&nbsp;"+"upload with success!");
		
	}

}
