package cn.wagentim.buymanager.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.wagentim.buymanager.entities.CustomerEntity;
import cn.wagentim.buymanager.servlets.IOperation;

public class Parser implements IOperation
{
    public static final String OPERATION = "opt";
    public static final String AUTH = "auth";
    public static final String USER_NAME = "usr";
    public static final String PASSWORD = "pwd";
    
    public static final int parserOperation( final HttpServletRequest request )
    {
        String result = "";

        if( null == request || null == (result = (String)request.getParameter(OPERATION)) || result.length() <= 0 )
        {
            return OPERATION_UNKNOWN;
        }

        return Integer.valueOf(result);
    }

    public static final String parserAuthID( final HttpServletRequest request )
    {
        String result = "";

        if( null == request || null == (result = (String)request.getParameter(AUTH)) || result.length() <= 0 )
        {
            return StringConstants.EMPTY_STRING;
        }

        return result;
    }

    /**
     * Parser user_name and password from the request
     * @param request
     * @return
     */
    public static final String[] getUserLoginInfo( final HttpServletRequest request )
    {
        if( null == request )
        {
            return null;
        }
        
        Map<String, String[]> parameters = request.getParameterMap();

        return new String[]{parameters.get(USER_NAME)[0], parameters.get(PASSWORD)[0]};
    }
    
    public static final CustomerEntity getCustomer(final HttpServletRequest request)
    {
    	Map<String, String[]> parameters = request.getParameterMap();
    	
    	CustomerEntity customer = new CustomerEntity();
    	customer.setId(Long.valueOf(parameters.get(Constants.CUSTOMER_UID)[0]));
    	customer.setAlias(parameters.get(Constants.CUSTOMER_ALISA)[0]);
    	customer.setFirstName(parameters.get(Constants.CUSTOMER_FIRST_NAME)[0]);
    	customer.setLastName(parameters.get(Constants.CUSTOMER_LAST_NAME)[0]);
    	customer.setTelefon(parameters.get(Constants.CUSTOMER_TELEPHONE)[0]);
    	customer.setEmail(parameters.get(Constants.CUSTOMER_EMAIL)[0]);
    	customer.setCountry(parameters.get(Constants.CUSTOMER_COUNTRY)[0]);
    	customer.setProvince(parameters.get(Constants.CUSTOMER_PROVINCE)[0]);
    	customer.setCity(parameters.get(Constants.CUSTOMER_CITY)[0]);
    	customer.setZipcode(parameters.get(Constants.CUSTOMER_ZIPCODE)[0]);
    	customer.setAddress(parameters.get(Constants.CUSTOMER_ADDRESS)[0]);
    	
    	return customer;
    }
}
