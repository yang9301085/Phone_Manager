package col; /**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2021/6/1 4:33 下午
 * @Created by 杨启仁
 */

import dao.MobileDao;
import mod.Mobile;
import mod.PageBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MobileListServlet", value = "/MobileListServlet")
public class MobileListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageBean<Mobile> pageBean=new PageBean<>("tb_mobile");
        List<Mobile> list=null;
        if (request.getParameter("index")!=null){
            int index= Integer.parseInt(request.getParameter("index"));
            if (index>0){
                index=index*5;
                list=new MobileDao().searchMobileByIndex(index);
            }else {
                list=new MobileDao().searchMobileByIndex(0);
            }
        }else {
            list=new MobileDao().searchMobileByIndex(0);
        }
        HttpSession session= request.getSession();
        session.setAttribute("pageBean",pageBean);
        session.setAttribute("modelList",list);
        request.getRequestDispatcher("mobile/mobileList.jsp").forward(request,response);
    }
}
