package cn.wagentim.buymanager.utils;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import cn.wagentim.buymanager.entities.CustomerEntity;
import cn.wagentim.buymanager.servlets.IOperation;

public class HttpHelper
{

    public static final int parserOperation( final HttpServletRequest request )
    {
        String result = "";

        if( null == request || null == (result = (String)request.getParameter(Constants.OPERATION)) || result.length() <= 0 )
        {
            return IOperation.OPERATION_UNKNOWN;
        }

        return Integer.valueOf(result);
    }

    public static final Cookie getAuthCookie( final HttpServletRequest request )
    {

        Cookie[] cookies = request.getCookies();
        if( Validator.isNullOrEmpty(cookies) )
        {
            return null;
        }

        for(Cookie c : cookies)
        {
            if( c.getName().equals(Constants.AUTH) )
            {
                return c;
            }
        }

        return null;
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

        return new String[]{parameters.get(Constants.USER_NAME)[0], parameters.get(Constants.PASSWORD)[0]};
    }

    public static final CustomerEntity getCustomer(final HttpServletRequest request, final boolean isNewEntity)
    {
    	Map<String, String[]> parameters = request.getParameterMap();

    	CustomerEntity customer = new CustomerEntity();

    	if( !isNewEntity )
    	{
    		customer.setId(Long.valueOf(parameters.get(Constants.CUSTOMER_UID)[0]));
    	}

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

	public static Long getUID(HttpServletRequest request)
	{
		String[] values = (String[]) request.getParameterMap().get(Constants.CUSTOMER_UID);

		return Long.valueOf(values[0]);
	}
}
