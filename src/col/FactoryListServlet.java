package col; /**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2021/7/6 12:10 下午
 * @Created by 杨启仁
 */

import dao.FactoryDao;
import mod.Factory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FactoryListServlet", value = "/FactoryListServlet")
public class FactoryListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Factory> list=new FactoryDao().selectAllFactory();
        HttpSession session=request.getSession();
        session.setAttribute("factoryList",list);
        request.getRequestDispatcher("mobile/factoryList.jsp").forward(request,response);
    }
}
