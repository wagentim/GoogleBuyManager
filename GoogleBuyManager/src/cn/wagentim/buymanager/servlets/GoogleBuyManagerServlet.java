package cn.wagentim.buymanager.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wagentim.buymanager.helper.contents.TemplateLineHandler;
import cn.wagentim.buymanager.utils.Constants;
import cn.wagentim.buymanager.utils.HTMLHelper;
import cn.wagentim.buymanager.utils.LanguageManager;
import cn.wagentim.buymanager.utils.Parser;
import cn.wagentim.buymanager.utils.Utils;

public class GoogleBuyManagerServlet extends HttpServlet
{
	/**
	 *
	 */
	private static final long serialVersionUID = -1211150249383728726L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException
	{
	    String authID = Parser.parserAuthID(req);
	    
	    if( authID.length() <= 0 )
	    {
	    	resp.sendRedirect("login.html");
	    }
	    else
		{
	    	Utils.setAuthCookie(resp, authID);
	        resp.sendRedirect("order.html");
		}
	}
}
