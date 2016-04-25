package com.haili.exam.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpGetRequest {
	/** 默认的缓冲区大小：4096字节 */
	private static int bufferSize = 4096;
	/** 缓冲字节数组，用于读写文件间的缓冲 */
	private static byte[] buffer = null;

    /**
     * Main
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        
        doGet1();
    }
    
    /**
     * Get Request
     * @return
     * @throws Exception
     */
    public static InputStream doGet() throws Exception {
        URL localURL = new URL("http://133.37.94.215/OAFCWeb/service/download?filename=kindeditor-4.1.10.zip");
        URLConnection connection = localURL.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;
        
        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        
        if (httpURLConnection.getResponseCode() >= 300) {
            throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
        }
        
        try {
            inputStream = httpURLConnection.getInputStream();
            System.out.println(httpURLConnection.getContentType());
//            System.out.println(httpURLConnection.getOutputStream());
            System.out.println(httpURLConnection.getContentLength());
            
        } finally {
            
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            
            if (inputStream != null) {
                inputStream.close();
            }
            
        }
        
        return inputStream;
    }
    
    public static String doGet1() throws Exception {
		buffer = new byte[bufferSize];
//		String url = "http://133.37.94.215/OAFCWeb/service/download?filename=hdfs.txt";
		String url = "http://133.37.94.216/OAFCWeb/service/download?filename=1440747093196_697.rar";
//		String url = "http://133.37.94.215/OAFCWeb/service/download?filename=kindeditor-4.1.10.zip";
    	URL localURL = new URL(url);
    	URLConnection connection = localURL.openConnection();
    	HttpURLConnection httpURLConnection = (HttpURLConnection)connection;
    	
    	httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
    	httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    	
    	String path = "C:\\Users\\Administrator\\Desktop\\" + "download-" + url.substring(url.indexOf("=")+1);
        File file = new File(path);
        FileOutputStream os = new FileOutputStream(file);

        
    	InputStream inputStream = null;
    	StringBuffer resultBuffer = new StringBuffer();
    	
    	if (httpURLConnection.getResponseCode() >= 300) {
    		throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
    	}
    	
    	char c;
    	try {
    		inputStream = httpURLConnection.getInputStream();
    		
    		int len = 0;
			while ((len = inputStream.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
    		
    		System.out.println("成功");
    	} finally {
    		
    		if (inputStream != null) {
    			inputStream.close();
    		}
    		
    	}
    	
    	return resultBuffer.toString();
    }
    
    
    
//    public static String doGet() throws Exception {
//    	URL localURL = new URL("http://133.37.94.215/OAFCWeb/service/download?filename=kindeditor-4.1.10.zip");
//    	URLConnection connection = localURL.openConnection();
//    	HttpURLConnection httpURLConnection = (HttpURLConnection)connection;
//    	
//    	httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
//    	httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//    	
//    	InputStream inputStream = null;
//    	InputStreamReader inputStreamReader = null;
//    	BufferedReader reader = null;
//    	StringBuffer resultBuffer = new StringBuffer();
//    	String tempLine = null;
//    	
//    	if (httpURLConnection.getResponseCode() >= 300) {
//    		throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
//    	}
//    	
//    	try {
//    		inputStream = httpURLConnection.getInputStream();
//    		inputStreamReader = new InputStreamReader(inputStream);
//    		reader = new BufferedReader(inputStreamReader);
//    		
//    		while ((tempLine = reader.readLine()) != null) {
//    			resultBuffer.append(tempLine);
//    		}
//    		
//    	} finally {
//    		
//    		if (reader != null) {
//    			reader.close();
//    		}
//    		
//    		if (inputStreamReader != null) {
//    			inputStreamReader.close();
//    		}
//    		
//    		if (inputStream != null) {
//    			inputStream.close();
//    		}
//    		
//    	}
//    	
//    	return resultBuffer.toString();
//    }
    
}

