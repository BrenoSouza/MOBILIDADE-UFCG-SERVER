package com.server.controllers;



import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.server.entities.Form;
import com.server.response.Response;

@Controller
@RequestMapping(value = "/pdf")
public class PdfController {

	private String text =null;
	
	@PostMapping("/")
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
