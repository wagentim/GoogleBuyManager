package cn.wagentim.buymanager.servlets;

public interface IOperation
{
    public static final int OPERATION_UNKNOWN = -1;
    public static final int CUSTOMER_OPERATION_POST_CUSTOMER = 0;
    public static final int CUSTOMER_OPERATION_GET_ALL_CUSTOMERS = 1;
    public static final int CUSTOMER_OPERATION_DELETE_CUSTOMERS = 2;
    public static final int CUSTOMER_OPERATION_DELETE_ALL = 3;

}
