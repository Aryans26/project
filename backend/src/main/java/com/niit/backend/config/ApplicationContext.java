package com.niit.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.backend.Dao.AuthenticationDao;
import com.niit.backend.Dao.BillingAddressDao;
import com.niit.backend.Dao.CardDao;
import com.niit.backend.Dao.CartDao;
import com.niit.backend.Dao.CartItemsDao;
import com.niit.backend.Dao.CategoryDao;
import com.niit.backend.Dao.OrderDao;
import com.niit.backend.Dao.OrderItemsDao;
import com.niit.backend.Dao.PaymentDao;
import com.niit.backend.Dao.ProductDao;
import com.niit.backend.Dao.ShippingAddressDao;
import com.niit.backend.Dao.SupplierDao;
import com.niit.backend.Dao.UsersDao;
import com.niit.backend.DaoImpl.AuthenticationDaoImpl;
import com.niit.backend.DaoImpl.BillingAddressDaoImpl;
import com.niit.backend.DaoImpl.CardDaoImpl;
import com.niit.backend.DaoImpl.CartDaoImpl;
import com.niit.backend.DaoImpl.CartItemsDaoImpl;
import com.niit.backend.DaoImpl.CategoryDaoImpl;
import com.niit.backend.DaoImpl.OrderDaoImpl;
import com.niit.backend.DaoImpl.OrderItemsDaoImpl;
import com.niit.backend.DaoImpl.PaymentDaoImpl;
import com.niit.backend.DaoImpl.ProductDaoImpl;
import com.niit.backend.DaoImpl.ShippingAddressDaoImpl;
import com.niit.backend.DaoImpl.SupplierDaoImpl;
import com.niit.backend.DaoImpl.UsersDaoImpl;
import com.niit.backend.model.BillingAddress;
import com.niit.backend.model.Card;
import com.niit.backend.model.Cart;
import com.niit.backend.model.CartItem;
import com.niit.backend.model.Category;
import com.niit.backend.model.Order;
import com.niit.backend.model.OrderItems;
import com.niit.backend.model.Payment;
import com.niit.backend.model.Product;
import com.niit.backend.model.ShippingAddress;
import com.niit.backend.model.Supplier;
import com.niit.backend.model.Users;
import com.niit.backend.model.Authentication;
@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class ApplicationContext 
{

	@Bean("dataSource")
	public DataSource getDataSource() 
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");

		// Properties connectionProperties=new Properties();
		// connectionProperties.setProperty("hibernate.show_sql", "true");
		// connectionProperties.setProperty("hibernate.dialect",
		// "org.hibernate.dialect");
		return dataSource;
	}

	private Properties getHibernateProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.connection.pool_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}

	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) 
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(BillingAddress.class);
		sessionBuilder.addAnnotatedClass(Card.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(OrderItems.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(CartItem.class);
		sessionBuilder.addAnnotatedClass(Order.class);
		sessionBuilder.addAnnotatedClass(Payment.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Users.class);
		sessionBuilder.addAnnotatedClass(Authentication.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(ShippingAddress.class);
	
		return sessionBuilder.buildSessionFactory();
	}

	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		System.out.println("printing session factory here : "+sessionFactory);
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("printing transactionManager factory here : "+transactionManager);
		return transactionManager;
	}



   	@Autowired
   	@Bean("categoryDao")
   	public CategoryDao getCategoryDao(SessionFactory sessionFactory) 
   	{
   		return new CategoryDaoImpl(sessionFactory);
   	}
     
   	@Autowired
   	@Bean("productDao")
   	public ProductDao getProductDao(SessionFactory sessionFactory) 
   	{
   		return new ProductDaoImpl(sessionFactory);
   	}
   	
   	@Autowired
   	@Bean("supplierDao")
   	public SupplierDao getSupplierDao(SessionFactory sessionFactory) 
   	{
   		return new SupplierDaoImpl(sessionFactory);
   	}
  
   	@Autowired
   	@Bean("usersDao")
   	public UsersDao getUsersDao(SessionFactory sessionFactory) 
   	{
   		return new UsersDaoImpl(sessionFactory);
   	}

   	@Autowired
   	@Bean("authenticationDao")
   	public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory) 
   	{
   		return new AuthenticationDaoImpl(sessionFactory);
   	}
  
	@Autowired
	@Bean("billingAddressDao")
	public BillingAddressDao getbillingAddressDao(SessionFactory sessionFactory) {
		return new BillingAddressDaoImpl(sessionFactory);
	}
	
    @Autowired
	@Bean("orderitemsDao")
	public OrderItemsDao getorderitemsDao(SessionFactory sessionFactory) 
    {
    return new OrderItemsDaoImpl(sessionFactory);
	}
    
	@Autowired
	@Bean("cardDao")
	public CardDao getCardDao(SessionFactory sessionFactory)
	{
		return new CardDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("paymentDao")
	public PaymentDao getPaymentDao(SessionFactory sessionFactory) 
	{
		return new PaymentDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("shippingAddressDao")
	public ShippingAddressDao getshippingAddressDao(SessionFactory sessionFactory)
	{
		return new ShippingAddressDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("cartDao")
	public CartDao getcartDao(SessionFactory sessionFactory) 
	{
		return new CartDaoImpl(sessionFactory);

	}
    @Autowired
	@Bean("orderDao")
	public OrderDao getorderDao(SessionFactory sessionFactory)
    {
	return new OrderDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("cartItemDao")
	public CartItemsDao getCartItemDao(SessionFactory sessionFactory) 
	{
		return new CartItemsDaoImpl(sessionFactory);
	}
}