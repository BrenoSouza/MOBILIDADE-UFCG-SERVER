package com.server.controllers;



import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.server.response.Response;

@Controller
@RequestMapping(value = "/pdf")
@CrossOrigin(origins = "*")
public class PdfController {

	private String text =null;
	
	@PostMapping(headers = "content-type=multipart/*")
	public ResponseEntity<Response<String>> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
			
		try (PDDocument document = PDDocument.load((file.getBytes()))) {
			
            document.getClass();            
           
            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);
                text = pdfFileInText;

            }

        }
		
		// Response object.
		Response<String> response =  new Response<String>();
		
		// Add form to the object response.
		response.setData(text);
		
		return ResponseEntity.ok(response);
	}
	
}
