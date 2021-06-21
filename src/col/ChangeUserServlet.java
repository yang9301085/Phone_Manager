package col; /**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2021/5/27 7:48 下午
 * @Created by 杨启仁
 */

import dao.UserDao;
import mod.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChangeUserServlet", value = "/ChangeUserServlet")
public class ChangeUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        UserDao userDao=new UserDao();
        User user=userDao.searchById(id);
        user.setId(id);
        System.out.println("ChangeUserServlet"+user);
        HttpSession session=request.getSession();
        session.setAttribute("userInfo",user);
        request.getRequestDispatcher("user/changeUser.jsp").forward(request,response);
    }
}
