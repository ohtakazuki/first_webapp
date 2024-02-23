package test;

import java.io.IOException;
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 文字化け防止のおまじない
        request.setCharacterEncoding("UTF-8");

        // リクエストパラメータ a, b を受け取って整数値に変換
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));

        // 斜辺を計算
        double c = Math.sqrt(a * a + b * b);

        // a, b, c の値をビューに送る
        request.setAttribute("a", a);
        request.setAttribute("b", b);
        request.setAttribute("c", c);

        // ビューを指定してフォワード
        var rd = request.getRequestDispatcher("/WEB-INF/calc_c.jsp");
        rd.forward(request, response);
    }
}
