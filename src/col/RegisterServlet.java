package col; /**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2021/5/28 7:39 下午
 * @Created by 杨启仁
 */

import dao.UserDao;
import mod.User;
import sun.nio.ch.sctp.SendFailed;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if (new UserDao().checkUserName(new String(request.getParameter("userName").getBytes("ISO-8859-1"),"utf-8"))){
            boolean isUser=new String(request.getParameter("isUser").getBytes("ISO-8859-1"),"utf-8").equals("管理员");
            //String name, String password, String email, String gender, boolean isBus
            User user=new User(
                    new String(request.getParameter("userName").getBytes("ISO-8859-1"),"utf-8"),
                    request.getParameter("pwd"),
                    request.getParameter("email"),
                    request.getParameter("sex"),
                    isUser
            );

    //        user.setName(new String(request.getParameter("userName").getBytes("ISO-8859-1"),"utf-8"));
            if (new UserDao().registerUser(user)){
                session.setAttribute("isSuccess",true);
            }else {
                session.setAttribute("isSuccess",false);
            }
        }else {
            session.setAttribute("isOnly",false);

        }

        response.sendRedirect("register.jsp");
    }
}
