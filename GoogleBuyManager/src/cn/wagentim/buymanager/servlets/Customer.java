package cn.wagentim.buymanager.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wagentim.buymanager.entities.CustomerEntity;
import cn.wagentim.buymanager.entities.managers.DataManager;
import cn.wagentim.buymanager.utils.HttpHelper;

public class Customer extends HttpServlet implements IOperation
{

	private static final long serialVersionUID = 5591315481909842399L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();

		int requiredOperation = HttpHelper.parserOperation(request);

		switch (requiredOperation)
		{
		case CUSTOMER_OPERATION_GET_ALL_CUSTOMERS:
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			String jsonObject = DataManager.instance.getCustomerManager()
					.getCustomersAsString();
			out.print(jsonObject);
			break;
		case CUSTOMER_OPERATION_DELETE_ALL:
			DataManager.instance.getCustomerManager().deleteAllCustomers();
			out.print("All Customers has been removed");
			break;
		}

		out.flush();
	}

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int requiredOperation = HttpHelper.parserOperation(request);
		PrintWriter out = response.getWriter();
		boolean ok = false;
		Long uid = HttpHelper.getUID(request);

	    switch(requiredOperation)
	    {
	        case CUSTOMER_OPERATION_POST_CUSTOMER:
	        	CustomerEntity customer = DataManager.instance.getCustomerManager().getCustomerWithID(uid);
	        	boolean isNewEntity = (null == customer ? true : false);
	        	customer = HttpHelper.getCustomer(request, isNewEntity);
	        	ok = DataManager.instance.getCustomerManager().postCustomer(customer, isNewEntity);
	            break;
	        case CUSTOMER_OPERATION_DELETE_CUSTOMERS:
	        	if( null != uid && uid > 0 )
	        	{
	        		ok = DataManager.instance.getCustomerManager().deleteCustomer(uid);
	        	}
	        	break;
	    }
	    
	    if( ok )
    	{
    		response.setStatus(HttpServletResponse.SC_OK);
    	}
    	else
    	{
    		response.setStatus(HttpServletResponse.SC_PRECONDITION_FAILED);
    	}
	    
	    out.flush();
	}

}
