package col; /**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2021/5/23 1:38 下午
 * @Created by 杨启仁
 */

import dao.MobileDao;
import dao.UserDao;
import mod.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao=new UserDao();
        String name=request.getParameter("usrName");
        String pwd=request.getParameter("pwd");
        String str = new String(name.getBytes("ISO-8859-1"),"utf-8");
        User user=new User();
        user.setName(str);
        user.setPassword(pwd);
        user.setId(userDao.selectUserInfoByName(str).getId());
        user.setBalance(userDao.selectUserInfoByName(str).getBalance());
        System.out.println("LoginServlet"+user);
        boolean isTrue=userDao.loginCheck(user);
        if (isTrue){
            HttpSession session=request.getSession();
            session.setAttribute("loginUser",user.getName());
            if (userDao.checkUserRole(user.getName())){
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }else {
                session.setAttribute("userInfo",user);
                session.setAttribute("mobileList",new MobileDao().searchAllMobile());
                request.getRequestDispatcher("mall/mall.jsp").forward(request,response);
            }
        }
        else{
            request.setAttribute("fail","登陆失败");
            request.getRequestDispatcher("login.jsp").forward(request,response);

        }
    }
}
