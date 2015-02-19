package cn.wagentim.buymanager.utils;

import java.nio.charset.Charset;

import javax.servlet.http.HttpServletResponse;

import cn.wagentim.buymanager.helper.contents.IContentHandler;

public class HTMLHelper
{
    public static final String ErrorPage(String errorMessage)
    {
        return getBodyBefore().append(errorMessage).append(getBodyEnd()).toString();
    }

    private static final StringBuffer getBodyBefore()
    {
        return new StringBuffer().append("<html><header></header><body>");
    }

    private static final String getBodyEnd()
    {
        return "</body></html>";
    }

    /**
     * Fetching HTML content from template files and send back to client
     * 
     * @param name
     * @return
     */
    public static final String getTemplate(String name, IContentHandler contentHandler)
    {
    	if( Validator.isNullOrEmpty(name) )
    	{
    		return StringConstants.EMPTY_STRING;
    	}
    	
    	final String filePath = Constants.TEMPLATE_LOCATION + name + Constants.TEMPLAGE_SUFFIX;
    	
    	return FileHelper.readFile(filePath, Charset.forName("utf-8"), contentHandler);
    }
    
    public static void decoradeHTMLResponse(final HttpServletResponse response)
    {
    	response.setContentType(Constants.CONTENT_TYPE_HTML);
    	response.setCharacterEncoding(Constants.CONTENT_CHAR_SET_UTF8);
    }
}
