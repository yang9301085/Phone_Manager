package col; /**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2021/6/1 8:02 下午
 * @Created by 杨启仁
 */

import dao.MobileDao;
import mod.Mobile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterMobileServlet", value = "/RegisterMobileServlet")
public class RegisterMobileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Mobile mobile=new Mobile(
                request.getParameter("model"),
                request.getParameter("factory"),
                Double.valueOf(request.getParameter("value"))
        );
        HttpSession session=request.getSession();
        if (new MobileDao().insertMobile(mobile)){
            session.setAttribute("isSuccess",true);
        }else {
            session.setAttribute("isSuccess",false);
        }
        request.getRequestDispatcher("mobile/registerMobile.jsp").forward(request,response);
    }
}
