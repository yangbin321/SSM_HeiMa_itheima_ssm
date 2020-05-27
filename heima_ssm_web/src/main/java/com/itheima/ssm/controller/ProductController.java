package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-07 20:25
 * @Description
 */

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;



    /**
     * 保存产品信息
     * @param product
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        //保存后，去刷新一下数据，调用查询所有产品信息的方法
        return "redirect:findAll.do";
    }

    /**
     * 查询所有产品信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {
        //建立视图
        ModelAndView mv = new ModelAndView();
        //调用查询的方法返回list集合
        List<Product> ps = productService.findAll();
        //将list集合添加到productList中，可以在jsp页面使用
        mv.addObject("productList",ps);
        //跳转到这个界面
        mv.setViewName("product-list1");
        return mv;
    }
}
