package web;

import dao.IDao;
import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IDao<Product> productDao;

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productDao.findAll());
        return "products"; // JSP : products.jsp
    }

    @GetMapping("/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct"; // JSP : addProduct.jsp
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productDao.create(product);
        return "redirect:/products";
    }
}
