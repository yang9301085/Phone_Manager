package col; /**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2021/6/1 2:47 下午
 * @Created by 杨启仁
 */

import dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ForgetPwdServlet", value = "/ForgetPwdServlet")
public class ForgetPwdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String pwd=request.getParameter("pwd");
        String nameStr = new String(name.getBytes("ISO-8859-1"),"utf-8");
        System.out.println("ForgetPwdServlet"+nameStr);
        HttpSession session=request.getSession();
        if (new UserDao().selectUserByName(nameStr)){
            if (new UserDao().updateUserPwd(nameStr,pwd)){
                session.setAttribute("pwdChanged","pwdChange");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }else {
            session.setAttribute("isOldUser","isOldUser");
            request.getRequestDispatcher("forget.jsp").forward(request,response);
        }
    }
}
