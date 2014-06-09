package com.wso2.demoapp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

import com.wso2.demoapp.hibernate.HibernateUtil;
import com.wso2.demoapp.model.Customer;

@WebServlet("/customers")
public class CustomerDataSource extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(CustomerDataSource.class.getName());

	public final Logger logger = Logger.getLogger(CustomerDataSource.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	                                                                              throws ServletException,
	                                                                              IOException {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		Transaction tx = session.beginTransaction();

		String strSql = "from Customer";
		Query query = session.createQuery(strSql);
		List resultList = query.list();
		tx.commit();

		List<Customer> customerList = new ArrayList<Customer>();
		for (Iterator iterator = resultList.iterator(); iterator.hasNext();) {
			Customer cust = (Customer) iterator.next();
			customerList.add(cust);
		}

		response.setContentType("text/html");
		request.setAttribute("customerList", customerList);

		if (log.isDebugEnabled()) {
			for (Customer c : customerList) {
				log.debug("Customer: " + c.getCustId() + ", " + c.getFirstName() + ", " +
				          c.getLastName() + ", " + c.getEmail());
			}
		}
		request.getRequestDispatcher("/WEB-INF/customers_view.jsp").forward(request, response);
	}

}
