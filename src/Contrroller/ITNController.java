package Contrroller;

import DAO.ITNDao;
import Model.ITNModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Ruzal on 3/29/2017.
 */
@Controller
@RequestMapping(value = "/itncontroller")
public class ITNController {
    int id;

    @Autowired
    ITNDao itnDao;

    @RequestMapping(value = "/display",method = RequestMethod.GET)
    public String doGet(ModelMap modelMap){

        modelMap.addAttribute("model",itnDao.display());
        return "viewAll";
    }


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String doInsert(@ModelAttribute(value = "model") ITNModel model,BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("error");
            return "error";
        } else {
            String choice = model.getButton();

            switch (choice) {

                case "submit":
                    System.out.println("Enter post success");
                    itnDao.insert(model);
                    return "success";


                case "update":
                    model.setId(id);
                    itnDao.update(model);
                    return "success";

            }

            System.out.println("switch case failure");
            return null;
        }
    }

    @RequestMapping(value = "/update")
    public String doUpdate(HttpServletResponse response,HttpServletRequest request, ModelMap modelmap){


        ITNModel model= new ITNModel();
        String params=request.getParameter("action");
        int sid = Integer.parseInt(request.getParameter("editid"));
        this.id=sid;
        model.setId(sid);

        if(params.equals("update")){

//            modelMap.addAttribute("updateform",itnDao.update(model));
            return "updateForm";

        }else if (params.equals("delete")){

            int status=itnDao.delete(id);
            if (status>0){
                try {
                    PrintWriter ps=response.getWriter();
                    ps.print("<script>alert('Deleted');</script>");
                    return "redirect:/itncontroller/display";

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }





}
