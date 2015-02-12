package cn.wagentim.buymanager.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wagentim.buymanager.utils.Parser;

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
	        resp.sendRedirect("order.html");
		}
	}
}
