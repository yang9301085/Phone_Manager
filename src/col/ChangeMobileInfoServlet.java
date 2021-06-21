package col; /**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2021/6/1 7:40 下午
 * @Created by 杨启仁
 */

import dao.MobileDao;
import mod.Mobile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChangeMobileInfoServlet", value = "/ChangeMobileInfoServlet")
public class ChangeMobileInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        String model=request.getParameter("model");
        Double value= Double.valueOf(request.getParameter("value"));
        String factory=request.getParameter("factory");
        Mobile mobile=new Mobile(id,model,factory,value);
        HttpSession session=request.getSession();
        if (new MobileDao().updateMobile(mobile)){
            session.setAttribute("mobileInfo",mobile);
            request.getRequestDispatcher("mobile/changeMobile.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
    }
}
