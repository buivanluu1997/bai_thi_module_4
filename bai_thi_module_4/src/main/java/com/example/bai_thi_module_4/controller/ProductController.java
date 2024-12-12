package com.example.bai_thi_module_4.controller;

import com.example.bai_thi_module_4.dto.ProductDTO;
import com.example.bai_thi_module_4.model.Product;
import com.example.bai_thi_module_4.service.ICategoryService;
import com.example.bai_thi_module_4.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String searchProducts(@RequestParam(required = false, defaultValue = "0") int page,
                                 @RequestParam(required = false, defaultValue = "5") int size,
                                 @RequestParam(required = false, defaultValue = "") String name,
                                 Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productService.searchProductByNameContaining(name, pageable);
        model.addAttribute("productPage", productPage);
        model.addAttribute("name", name);

        return "/product/search-list";
    }


    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("delete","Đã xoá sản phẩm thành công");
        return "redirect:/products";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categoryList", categoryService.findAll());
        return "/product/create";
    }

    @PostMapping("/create")
    public String createProduct(@Validated @ModelAttribute ProductDTO productDTO, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, Model model) {
        Product product = new Product();
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.findAll());
            return "/product/create";
        }
        BeanUtils.copyProperties(productDTO, product);
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("create", "Đã thêm sản phẩm thành công");
        return "redirect:/products";
    }
}
