package col; /**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2021/5/31 8:54 下午
 * @Created by 杨启仁
 */

import dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", value = "/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        System.out.println("DeleteUserServlet+ "+id);
        HttpSession session=request.getSession();
        if (new UserDao().deleteUserById(id)){
            session.setAttribute("isDelete",true);
        }else {
            session.setAttribute("isDelete",false);
        }
        request.getRequestDispatcher("user/userList.jsp").forward(request,response);
    }
}
