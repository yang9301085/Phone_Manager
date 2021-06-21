package col; /**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2021/5/25 5:28 下午
 * @Created by 杨启仁
 */

import dao.UserDao;
import mod.PageBean;
import mod.User;
import util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "UserManServlet", value = "/UserManServlet")
public class UserManServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao=new UserDao();
        List<User> list=new ArrayList<>();
        if (request.getParameter("index")!=null){
            int index= Integer.parseInt(request.getParameter("index"));
            System.out.println("index="+index);
            if (index>0){
                index=index*5;
                list=userDao.searchByPageIndex(index);
            }else {
                list=userDao.searchByPageIndex(0);
            }
        }else {
            list=userDao.searchByPageIndex(0);
        }
        System.out.println("UserManServlet::list"+list);
        HttpSession session=request.getSession();
        session.setAttribute("userList",list);
        request.getRequestDispatcher("user/userList.jsp").forward(request,response);
    }
}
