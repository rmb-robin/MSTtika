package com.codebind;

import static org.junit.Assert.*;

import org.junit.Test;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;


public class AppTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		//public static void main(String[] args){
	        InputStream is = null;
	        OutputStream out =null;
	        //String outPutFile="E:/notice/errorpdf/1.txt";
	        String dirPathIn="C:/Users/Bryan/Documents/Rabhu/MST/PDFs/";
	        String dirPathOut="C:/Users/Bryan/Documents/Rabhu/MST/TXTs/";
	        File dir = new File(dirPathIn);
	        String[] filenames = dir.list();
	    
	        int lenFiles = filenames.length;
	        try {
	            for(int i=0;i<lenFiles;i++){
	            	System.out.println(i+" : "+filenames[i]);
	            	is = new BufferedInputStream(new FileInputStream(new File(dirPathIn+filenames[i])));
	                out= new FileOutputStream(dirPathOut+filenames[i]+".txt");
	                Parser parser = new AutoDetectParser();
	                ContentHandler handler = new BodyContentHandler(out);

	                Metadata metadata = new Metadata();

	                parser.parse(is, handler, metadata, new ParseContext());

	            }
	           /* Metadata metadata = new Metadata();
	            for (String name : metadata.names()) {
	                String value = metadata.get(name);

	                if (value != null) {
	                    System.out.println("Metadata Name:  " + name);
	                    System.out.println("Metadata Value: " + value);
	                }
	            }*/
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (TikaException e) {
	            e.printStackTrace();
	        } catch (SAXException e) {
	            e.printStackTrace();
	        } finally {
	            if (is != null) {
	                try {
	                    is.close();
	                    out.close();
	                } catch(IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	

}
