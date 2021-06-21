package col; /**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2021/6/1 5:52 下午
 * @Created by 杨启仁
 */

import dao.MobileDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteMobileServlet", value = "/DeleteMobileServlet")
public class DeleteMobileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (new MobileDao().deleteMobileById(Integer.parseInt(request.getParameter("id")))){
            request.getRequestDispatcher("mobile/mobileList.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
    }
}
