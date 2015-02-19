package cn.wagentim.buymanager.utils;

import java.io.IOException;
import java.util.Properties;

public enum LanguageManager
{
	instance;
	
	private Properties properties = null;
	
	public void loadLanguageFile(final String langFile)
	{
		properties = new Properties();
		try
		{
			properties.load(LanguageManager.class.getClassLoader().getResourceAsStream(langFile));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public String getReplaceText(String replTxtContent)
	{
		return properties.getProperty(replTxtContent);
	}
}
