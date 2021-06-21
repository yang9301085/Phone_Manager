package col; /**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2021/6/1 5:52 下午
 * @Created by 杨启仁
 */

import dao.MobileDao;
import dao.UserDao;
import mod.Mobile;
import mod.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChangeMobileServlet", value = "/ChangeMobileServlet")
public class ChangeMobileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        MobileDao mobileDao=new MobileDao();
        Mobile mobile=mobileDao.searchById(id);
        System.out.println("ChangeMobileServlet"+mobile);
        HttpSession session=request.getSession();
        session.setAttribute("mobileInfo",mobile);
        request.getRequestDispatcher("mobile/changeMobile.jsp").forward(request,response);
    }
}
