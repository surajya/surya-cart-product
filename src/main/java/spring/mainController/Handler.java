package spring.mainController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpServletRequest;
import spring.Modal.Product;
import spring.dao.ProductDao;

@Controller
public class Handler {

	@Autowired
	private ProductDao pd;

	@RequestMapping("/")
	public String home(Model m) {
		List<Product> allProduct = pd.getAllProduct();
		m.addAttribute("products", allProduct);

		return "/index";
	}

	@RequestMapping("/addProduct")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		return "add_product_form";
	}

	@RequestMapping("/delete/{pid}")
	public RedirectView deleteProduct(@PathVariable("pid") int id,
			HttpServletRequest request) {

		pd.deleteProduct(id);
		RedirectView rv = new RedirectView();
		rv.setUrl(request.getContextPath() + "/");
		return rv;
	}

	@RequestMapping(value = "handleProductForm", method = RequestMethod.POST)
	public RedirectView handleForm(@ModelAttribute Product product,
			HttpServletRequest request) {
		System.out.println(product);
		pd.createProduct(product);
		RedirectView rv = new RedirectView();
		rv.setUrl(request.getContextPath() + "/");
		return rv;
	}

	@RequestMapping(value = "/update/{pid}")
	public String updateElement(@PathVariable("pid") int id, Model m) {
		Product product = this.pd.getProduct(id);
		m.addAttribute("product", product);
		return "update_product";
	}

	// @RequestMapping(value="/udpateValue", method=RequestMethod.POST)
	// public RedirectView udpdateEl() {
	//
	// }
}
