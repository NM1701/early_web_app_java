package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PythagorasServlet")
public class PythagorasServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PythagorasServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request.setCharacterEncoding("UTF-8");

        //リクエストパラメータa, bの受け取り
        String a = request.getParameter("a");
        String b = request.getParameter("b");

        // String型から実数値への変換
        double a_value = Double.parseDouble(a);
        double b_value = Double.parseDouble(b);

        // 斜辺の長さcの計算
        double c_value = Math.sqrt(Math.pow(a_value, 2) + Math.pow(b_value, 2));

        // リクエストスコープへa, b, cの値を格納
        request.setAttribute("a", a_value);
        request.setAttribute("b", b_value);
        request.setAttribute("c", c_value);

        // calc_c.jspへフォワード
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/calc_c.jsp");
        rd.forward(request,  response);
    }
}