package cn.wagentim.buymanager.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wagentim.buymanager.entities.CustomerEntity;
import cn.wagentim.buymanager.entities.managers.DataManager;
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
		            CustomerEntity customer = new CustomerEntity();
		            customer.setAddress("feng tai");
		            customer.setAlias("wagentim");
		            customer.setCity("beijing");
		            customer.setContury("china");
		            customer.setEmail("wagentim@gmail.com");
		            customer.setFirstName("Bin");
		            customer.setLastName("Huang");
		            customer.setPwd("huang78");
		            customer.setMd5(Utils.getMD5Encode(customer.getAlias(), customer.getPwd()));
		            customer.setProvince("beijing");
		            customer.setTelefon("012313213213");
		            customer.setValidationStart(String.valueOf(System.currentTimeMillis()));
		            customer.setZipcode("323323");
		            DataManager.instance.getCustomerManager().addCustomer(customer);
		            break;
		    }
		out.flush();
	}

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	}

}
