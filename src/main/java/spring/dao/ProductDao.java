package spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import spring.Modal.Product;

@Component
public class ProductDao {
	@Autowired
	private HibernateTemplate hibernatetemplate;

	@Transactional
	public void createProduct(Product product) {
		this.hibernatetemplate.saveOrUpdate(product);
	}

	public List<Product> getAllProduct() {
		List<Product> products = this.hibernatetemplate.loadAll(Product.class);
		return products;
	}

	@Transactional
	public void deleteProduct(int pid) {
		Product p = this.hibernatetemplate.get(Product.class, pid);
		this.hibernatetemplate.delete(p);
	}

	public Product getProduct(int pid) {
		return this.hibernatetemplate.get(Product.class, pid);
	}
}
