package com.fuzzyAQP.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;





public class AESencryptDecrypt {

	    private static final java.lang.String ALGORITHM = "AES";
	    private static final String TRANSFORMATION = "AES";
	 
	    public static String encrypt(File inputFile) throws Exception 
	    {
	    	String outName = inputFile.getName();
	
			if (outName.indexOf(".") > 0)
				outName = outName.substring(0, outName.lastIndexOf("."));
				System.out.println("file name :"+ outName);
			
			outName = outName+".aes";
			System.out.println("get parent : "+ inputFile.getParent());
			
			String outputFile = inputFile.getParent()+File.separator+System.currentTimeMillis()+outName;
			File f = new File(outputFile);
			System.out.println("output file location  "+ f);
			
	        doCrypto(Cipher.ENCRYPT_MODE, inputFile, f);
	        System.out.println("File Encrypted.");
	        System.out.println(f.getName());
	        String encryptfile =f.getName();
	        return f.getName();
	    }
	 
	    public static String decrypt(File inputFile, File outputFile) throws Exception 
	    {

	    	doCrypto(Cipher.DECRYPT_MODE, inputFile, outputFile);
	        System.out.println(inputFile+"File Dencrypted."+outputFile);
	        return outputFile.getName();
	        
	    }
	   
	    public static String encryptAfterEdit(File inputFile, String outputFile) throws Exception 
	    {
	
			File f = new File(outputFile);
			System.out.println("output file location  "+ f);
			
	        doCrypto(Cipher.ENCRYPT_MODE, inputFile, f);
	        System.out.println("File Encrypted.");
	        System.out.println(f.getName());
	        
	        inputFile.delete();
	        
	        return f.getName();
	    }
	 
	    private static void doCrypto(int cipherMode, File inputFile, File outputFile) throws Exception
	    {
	        try {
	        	 String key = "AESencryptionDES";
	        	
	            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
	            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
	            cipher.init(cipherMode, secretKey);
	             
	            
	            FileInputStream inputStream = new FileInputStream(inputFile);
	            byte[] inputBytes = new byte[(int) inputFile.length()];
	            inputStream.read(inputBytes);
	             
	            byte[] outputBytes = cipher.doFinal(inputBytes);
	             
	            FileOutputStream outputStream = new FileOutputStream(outputFile);
	            outputStream.write(outputBytes);
	             
	            inputStream.close();
	            outputStream.close();
	            
	            
	        }
	        catch (Exception e) {
				e.printStackTrace();
			}
	        
	            
	    }
	    
	 /*   public static void main(String args[]) throws Exception
	    {
	    	doCrypto();
	    }*/
}
