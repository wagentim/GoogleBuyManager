package cn.wagentim.buymanager.entities.managers;


public enum DataManager
{
    instance;
    private static final CustomerManager cmg = new CustomerManager();
    

    public CustomerManager getCustomerManager()
    {
        return cmg;
    }
}

