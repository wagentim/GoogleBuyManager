package cn.wagentim.buymanager.entities.managers;

public interface ICustomerStatement
{
	public static final String GET_ALL_CUSTOMERS = "select c from CustomerEntity c";
	public static final String GET_LAST_CUSTOMER = "select LAST from CustomerEntity c";
}
