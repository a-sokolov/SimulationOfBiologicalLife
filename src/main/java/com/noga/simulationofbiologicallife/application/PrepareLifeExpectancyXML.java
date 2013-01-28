package com.noga.simulationofbiologicallife.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class PrepareLifeExpectancyXML {
	private static final String DETAIL = "<entry id=\"%d\" name=\"%s\"><avg>%s</avg><man>%s</man><woman>%s</woman></entry>\r\n";
	
	private BufferedReader reader = null;
	private BufferedWriter writer = null;
	
	private void header() throws IOException {
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
	}
	
	private void body() throws IOException {
		writer.write("<propertyList version=\"1.0\">\r\n<list>\r\n");
	}
	
	private void trailer() throws IOException {
		writer.write("</list>\r\n</propertyList>");
	}
	
	private void detail(String[] args) throws IOException {
		if(args.length != 5) {
			throw new Error("The number of the recording is not equal to 5");
		}
		
		writer.write(String.format(DETAIL, Integer.parseInt(args[0]), args[1], args[2], args[3], args[4]));
	}
	
	private void close() {
		try { if(reader != null) reader.close(); } catch (IOException ex) { ex.printStackTrace(); };
		try { if(writer != null) writer.close(); } catch (IOException ex) { ex.printStackTrace(); };
	}
	
	public void generate(String sourceDest, String targetDest) throws IOException {
		File source = new File(sourceDest);
		if (!source.exists()) {
			throw new Error("File \"" + sourceDest + "\" not exists");
		} else if (!source.canRead()) {
			throw new Error("File \"" + sourceDest + "\" can't read");
		}
		
		File target = new File(targetDest);
		if (!target.canWrite()) {
			throw new Error("File \"" + targetDest + "\" can't write");
		}
		
		try {
			reader = new BufferedReader(new FileReader(source));
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target), "UTF8")); 
			
			header();
			body();
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				detail(line.split("\t"));
			}
			
			trailer();
		} finally {
			close();
		}
	}
}
