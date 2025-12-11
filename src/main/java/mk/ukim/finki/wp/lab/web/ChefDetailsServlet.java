//package mk.ukim.finki.wp.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.model.Chef;
//import mk.ukim.finki.wp.lab.model.Dish;
//import mk.ukim.finki.wp.lab.service.ChefService;
//import mk.ukim.finki.wp.lab.service.DishService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "ChefDetailsServlet", urlPatterns = "/chefDetails")
//public class ChefDetailsServlet extends HttpServlet {
//    private final ChefService chefService;
//    private final DishService dishService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public ChefDetailsServlet(ChefService chefService, DishService dishService, SpringTemplateEngine springTemplateEngine) {
//        this.chefService = chefService;
//        this.dishService = dishService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String chefIdParam = req.getParameter("chefId");
//        String dishIdParam = req.getParameter("dishId");
//
//        if(chefIdParam == null) {
//            resp.sendRedirect("/listChefs?errorMessage=No chef selected");
//            return;
//        }
//
//        if(dishIdParam == null) {
//            resp.sendRedirect("/listDishes?errorMessage=No dish selected");
//            return;
//        }
//
//        Long chefId = Long.parseLong(chefIdParam);
//        Chef chef = chefService.findById(chefId);
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//
//        context.setVariable("chef", chef);
//
//        springTemplateEngine.process("chefDetails.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String chefIdParam = req.getParameter("chefId");
//        String dishIdParam = req.getParameter("dishId");
//
//        if(chefIdParam == null || dishIdParam == null) {
//            resp.sendRedirect("/listChefs?errorMessage=Missing data");
//            return;
//        }
//
//        Long chefId = Long.parseLong(chefIdParam);
//
//        Chef chef = chefService.findById(chefId);
//        Dish dish = dishService.findByDishId(dishIdParam);
//
//        if(dish == null || chef == null) {
//            resp.sendRedirect("/listChefs?errorMessage=Missing data");
//            return;
//        }
//
//        chefService.addDishToChef(chefId, dishIdParam);
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//        context.setVariable("chef", chef);
//        context.setVariable("dishes",chef.getDishes());
//        springTemplateEngine.process("chefDetails.html", context, resp.getWriter());
//    }
//}
