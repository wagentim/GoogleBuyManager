package cn.wagentim.buymanager.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import cn.wagentim.buymanager.helper.contents.IContentHandler;

public final class FileHelper
{
	public static String readFile(final String filePath, final Charset charSet, IContentHandler contentHandler)
	{
		if( !Validator.isNullOrEmpty(filePath) )
		{
			return StringConstants.EMPTY_STRING;
		}
		
		FileInputStream fin = null;
		InputStreamReader reader = null;
		BufferedReader br = null;
		
		try
		{
			fin = new FileInputStream(filePath);
			reader = new InputStreamReader(fin, charSet);
			br = new BufferedReader(reader);
			
			String str;
			StringBuffer sb = new StringBuffer();
			 
			while ((str = br.readLine()) != null) 
			{
			    sb.append(contentHandler.processLine(str));
			}
			
			br.close();
			reader.close();
			fin.close();
			
			return sb.toString();
			
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if( null != fin )
			{
				fin = null;
			}
			
			if( null != reader )
			{
				reader = null;
			}
			
			if( null != br )
			{
				br = null;
			}
		}
		
		return StringConstants.EMPTY_STRING;
	}
}
