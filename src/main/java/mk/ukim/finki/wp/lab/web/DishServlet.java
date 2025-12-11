//package mk.ukim.finki.wp.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.model.Chef;
//import mk.ukim.finki.wp.lab.service.ChefService;
//import mk.ukim.finki.wp.lab.service.DishService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "DishServlet", urlPatterns = "/dish")
//public class DishServlet extends HttpServlet {
//    private final DishService dishService;
//    private final ChefService chefService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public DishServlet(DishService dishService, ChefService chefService, SpringTemplateEngine springTemplateEngine) {
//        this.dishService = dishService;
//        this.chefService = chefService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String chefIdParam = req.getParameter("chefId");
//
//        if(chefIdParam == null) {
//            resp.sendRedirect("/listChefs?errorMessage=No data");
//            return;
//        }
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//
//        Long chefId = Long.parseLong(chefIdParam);
//        Chef chef = chefService.findById(chefId);
//
//        context.setVariable("chef", chef);
//        context.setVariable("dishes", dishService.listDishes());
//
//        springTemplateEngine.process("dishesList.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String chefIdParam = req.getParameter("chefId");
//        String dishId = req.getParameter("dishId");
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//
//        Chef chef = chefService.findById(Long.parseLong(chefIdParam));
//
//        context.setVariable("dishes",dishService.listDishes());
//        context.setVariable("chef",chef);
//        springTemplateEngine.process("dishesList.html", context, resp.getWriter());
//    }
//}
