package cn.wagentim.buymanager.entities.managers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import cn.wagentim.buymanager.entities.CustomerEntity;
import cn.wagentim.buymanager.entities.IEntityStatus;
import cn.wagentim.buymanager.utils.Utils;

public class CustomerManager implements ICustomerStatement
{
	private final String PERSISTENCE_UNIT_NAME = "transactions-optional";
	private final List<CustomerEntity> customers;

    public CustomerManager()
    {
        customers = new CopyOnWriteArrayList<>(getAllCustomersFromDB());
    }

    public void addCustomer(CustomerEntity customer)
    {
    	if( null == customer || customers.contains(customer) )
    	{
    		return;
    	}
    	customer.setStatus(IEntityStatus.STATUS_NEW);
   	    customers.add(customer);
    }

    private EntityManager getEntitiyManager()
    {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }

	private synchronized void addNewCustomerToDB(CustomerEntity customer)
    {
	    EntityManager em = getEntitiyManager();

	    try
	    {
	        em.getTransaction().begin();
	        em.persist(customer);
	        em.getTransaction().commit();
	    }
	    finally
	    {
	        em.close();
	    }
    }

	public CustomerEntity getCustomerWithUserName(final String userName)
	{
	    if( null != customers && customers.size() > 0 )
	    {
	        for( int i = 0; i < customers.size(); i++ )
	        {
	            CustomerEntity ce;

	            if( userName.equals( ( ce = customers.get(i)).getAlias()) )
	            {
	                return ce;
	            }
	        }
	    }

	    return null;
	}

    @SuppressWarnings("unchecked")
    private List<CustomerEntity> getAllCustomersFromDB()
    {
        List<CustomerEntity> result = null;
        EntityManager em = getEntitiyManager();
        try
        {
            result = em.createQuery(GET_ALL_CUSTOMERS).getResultList();
        }
        finally
        {
            em.close();
        }

        return result;
    }

    public String getCustomersAsString()
    {
        return Utils.toJson(customers);
    }

}
