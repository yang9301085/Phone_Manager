package col; /**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2021/6/9 8:16 下午
 * @Created by 杨启仁
 */

import dao.MobileDao;
import dao.OrderDao;
import dao.UserDao;
import mod.Mobile;
import mod.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserOrderServlet", value = "/UserOrderServlet")
public class UserOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> listModel=new MobileDao().searchMobileModel();
        List<String> listName=new UserDao().selectUserName();
        List<Order> orderList=new OrderDao().selectAllOrder();
        HttpSession session=request.getSession();
        session.setAttribute("listModel",listModel);
        session.setAttribute("listName",listName);
        session.setAttribute("orderList",orderList);
        request.getRequestDispatcher("userOrder.jsp").forward(request,response);
    }
}
