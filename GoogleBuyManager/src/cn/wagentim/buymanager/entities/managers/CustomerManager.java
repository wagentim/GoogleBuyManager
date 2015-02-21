package cn.wagentim.buymanager.entities.managers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import cn.wagentim.buymanager.entities.CustomerEntity;
import cn.wagentim.buymanager.utils.Utils;

public class CustomerManager implements ICustomerStatement
{
	private final String PERSISTENCE_UNIT_NAME = "transactions-optional";
	private List<CustomerEntity> customers;

    public CustomerManager()
    {
    	refreshList();
    }
    
    private void refreshList()
    {
    	if( null == customers )
    	{
    		customers = new CopyOnWriteArrayList<>(getAllCustomersFromDB());
    	}
    	else
    	{
    		customers.clear();
    		customers.addAll(getAllCustomersFromDB());
    	}
    }

    public boolean postCustomer(CustomerEntity customer)
    {
    	if( null == customer )
    	{
    		return false;
    	}
    	
    	if( customers.contains(customer) )
    	{
    		updateCustomer(customer);
    	}
    	else
    	{
    		addNewCustomerToDB(customer);
    	}
    	refreshList();
    	return true;
    }

    private void updateCustomer(CustomerEntity customer)
	{
    	Long id = customer.getId();
    	
    	for( int i = 0; i < customers.size(); i++ )
    	{
    		if(id.equals(customers.get(i).getId()))
    		{
    			customers.remove(i);
    		}
    	}
    	
    	customers.add(customer);
    	
    	mergeCustomer(customer);

	}
    
    private void mergeCustomer(final CustomerEntity customer)
    {
    	EntityManager em = getEntitiyManager();
    	try
    	{
    		em.getTransaction().begin();
    		em.merge(customer);
    		em.getTransaction().commit();
    	}
    	finally
    	{
    		em.close();
    		em = null;
    	}
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
			em = null;
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
        result = em.createQuery(GET_ALL_CUSTOMERS).getResultList();

        return result;
    }

    public String getCustomersAsString()
    {
        return Utils.toJson(customers);
    }
}
