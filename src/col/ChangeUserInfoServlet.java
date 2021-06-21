package col; /**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2021/5/27 8:45 下午
 * @Created by 杨启仁
 */

import dao.UserDao;
import mod.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ChangeUserInfoServlet", value = "/ChangeUserInfoServlet")
public class ChangeUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String sex=request.getParameter("sex");
        User user=new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setName(new String(name.getBytes("ISO-8859-1"),"utf-8"));
        user.setEmail(email);
        user.setGender(new String(sex.getBytes("ISO-8859-1"),"utf-8"));
        UserDao userDao=new UserDao();
        System.out.println("38 ChangeUserInfoServlet"+user);
        int res=userDao.updateUserInfo(user);
        if (res>0){
            UserDao userDao1=new UserDao();
            List<User> list=new ArrayList<>();
            if (request.getParameter("index")!=null){
                int index= Integer.parseInt(request.getParameter("index"));
                System.out.println("index="+index);
                if (index>0){
                    index=(index+1)*5;
                    list=userDao1.searchByPageIndex(index);
                }else {
                    list=userDao1.searchByPageIndex(0);
                }
            }else {
                list=userDao1.searchByPageIndex(0);
                System.out.println("ChangeUserInfoServlet"+list);
            }
            HttpSession session=request.getSession();
            session.setAttribute("userList",list);
            session.setAttribute("flashTrue",true);
            request.getRequestDispatcher("user/changeUser.jsp").forward(request,response);
        }
        request.getRequestDispatcher("error.jsp").forward(request,response);
    }
}
