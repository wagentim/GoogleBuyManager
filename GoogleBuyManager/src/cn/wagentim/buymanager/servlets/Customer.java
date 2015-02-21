package cn.wagentim.buymanager.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wagentim.buymanager.entities.CustomerEntity;
import cn.wagentim.buymanager.entities.managers.DataManager;
import cn.wagentim.buymanager.utils.Constants;
import cn.wagentim.buymanager.utils.Parser;
import cn.wagentim.buymanager.utils.Utils;

public class Customer extends HttpServlet implements IOperation
{

	/**
	 *
	 */
	private static final long serialVersionUID = 5591315481909842399L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();

		    int requiredOperation = Parser.parserOperation(request);

		    switch(requiredOperation)
		    {
		        case CUSTOMER_OPERATION_GET_ALL_CUSTOMERS:
		        	response.setContentType("application/json");
		        	response.setCharacterEncoding("utf-8");
		        	String jsonObject = DataManager.instance.getCustomerManager().getCustomersAsString();
		            out.print(jsonObject);
		            break;
		        case CUSTOMER_OPERATION_GET_CUSTOMER:
		            break;
		        case CUSTOMER_OPERATION_ADD_NEW_CUSTOMER:
		        	CustomerEntity customer = Parser.getCustomer(request);
		        	boolean ok = DataManager.instance.getCustomerManager().addCustomer(customer);
		        	if( ok )
		        	{
		        		response.setStatus(HttpServletResponse.SC_OK);
		        	}
		        	else
		        	{
		        		response.setStatus(HttpServletResponse.SC_PRECONDITION_FAILED);
		        	}
		            break;
		    }
		    
		    out.flush();
	}

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int requiredOperation = Parser.parserOperation(request);
		PrintWriter out = response.getWriter();

	    switch(requiredOperation)
	    {
	        case CUSTOMER_OPERATION_ADD_NEW_CUSTOMER:
	        	
	        	CustomerEntity customer = Parser.getCustomer(request);
	        	boolean ok = DataManager.instance.getCustomerManager().addCustomer(customer);
	        	if( ok )
	        	{
	        		response.setStatus(HttpServletResponse.SC_OK);
	        	}
	        	else
	        	{
	        		response.setStatus(HttpServletResponse.SC_PRECONDITION_FAILED);
	        	}
	            break;
	    }
	    
	    out.flush();
	}

}
