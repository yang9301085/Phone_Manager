package col; /**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2021/6/9 1:01 下午
 * @Created by 杨启仁
 */

import dao.MobileDao;
import mod.Mobile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShopServlet", value = "/ShopServlet")
public class ShopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model=request.getParameter("model");
        Mobile mobile=new MobileDao().selectByModel(model);
        HttpSession session=request.getSession();
        session.setAttribute("whichMobile",mobile);
        request.getRequestDispatcher("mall/shop.jsp").forward(request,response);
    }
}
