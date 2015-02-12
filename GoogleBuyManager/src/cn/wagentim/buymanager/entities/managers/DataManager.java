package cn.wagentim.buymanager.entities.managers;

public enum DataManager
{
    instance;

    private CustomerManager cmg = new CustomerManager();

    public CustomerManager getCustomerManager()
    {
        return cmg;
    }

}
