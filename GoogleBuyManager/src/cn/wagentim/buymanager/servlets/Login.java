package cn.wagentim.buymanager.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wagentim.buymanager.entities.CustomerEntity;
import cn.wagentim.buymanager.entities.IEntityStatus;
import cn.wagentim.buymanager.entities.managers.DataManager;
import cn.wagentim.buymanager.utils.HttpHelper;
import cn.wagentim.buymanager.utils.Utils;
import cn.wagentim.buymanager.utils.Validator;

public class Login extends HttpServlet
{
    /**
     *
     */
    private static final long serialVersionUID = 3451323524278534824L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
//    	// parser the user name and password from request
//        String[] loginInfo = Parser.getUserLoginInfo(request);
//        
//        // check if empty
//        if( Validator.isNullOrEmpty(loginInfo) )
//        {
//            response.getWriter().write("User Name or Password Error!");
//            return;
//        }
//
//        final String userName = loginInfo[0];
//        final String pwd = loginInfo[1];
//
//        // check user name
//        CustomerEntity customer = DataManager.instance.getCustomerManager().getCustomerWithUserName(userName);
//
//        if( null == customer )
//        {
//        	// TODO redirect to the error page with error message
//            response.getWriter().write("The user is not registered!");
//            return;
//        }
//
//        // check password
//        if( !pwd.equals(customer.getPwd()) )
//        {
//        	// TODO redirect to the error page with error message
//            response.getWriter().write("The password is wrong!");
//            return;
//        }
//
//        // update Auth String
//        updateAuth(customer);
//
//        Utils.setAuthCookie(response, customer.getMd5());
//        response.sendRedirect("order.html");

    }


    private void updateAuth(CustomerEntity customer)
    {
        customer.setMd5( Utils.getMD5Encode(customer.getAlias(), customer.getPwd()) );
        customer.setStatus(IEntityStatus.CUSTOMER_STATUS_MODIFY);
    }
}
