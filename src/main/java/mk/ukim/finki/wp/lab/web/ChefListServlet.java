package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.service.ChefService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ChefListServlet", urlPatterns = "/listChefs")
public class ChefListServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final ChefService chefService;

    public ChefListServlet(SpringTemplateEngine springTemplateEngine, ChefService chefService) {
        this.springTemplateEngine = springTemplateEngine;
        this.chefService = chefService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        context.setVariable("chefs", chefService.listChefs());

        springTemplateEngine.process("listChefs.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String chefIdParam = req.getParameter("chefId");

        if (chefIdParam == null || chefIdParam.isEmpty()) {
            resp.sendRedirect("/listChefs?errorMessage=No data");
            return;
        }

        resp.sendRedirect("/dish?chefId=" + chefIdParam);
    }

}
