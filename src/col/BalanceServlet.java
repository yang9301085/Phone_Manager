package col; /**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2021/6/10 7:25 上午
 * @Created by 杨启仁
 */

import dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BalanceServlet", value = "/BalanceServlet")
public class BalanceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String str = new String(name.getBytes("ISO-8859-1"),"utf-8");
        Double balance= Double.valueOf(request.getParameter("chargeText"));
        Double oldBalance= Double.valueOf(request.getParameter("balance"));
        HttpSession session=request.getSession();
        if (new UserDao().updateBalanceById(id,oldBalance+balance)){
            session.setAttribute("bName",str);
            session.setAttribute("balance",new UserDao().getBalance(id));
        }else {
            session.setAttribute("error",false);
        }
        request.getRequestDispatcher("mall/charge.jsp").forward(request,response);
    }
}
