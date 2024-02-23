package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OmikujiServlet")
public class OmikujiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public OmikujiServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 氏名をリクエストパラメータから取得
        String name = request.getParameter("name");

        // 入力項目チェック（バリデーション）
        List<String> errors = new ArrayList<String>();

        if (name == null || name.equals("")) { /* 氏名 */
            errors.add("氏名を入力してください");
        }

        // 入力内容にエラーがあったかどうか
        if (errors.size() > 0) {
            // JSPにエラー内容を送る
            request.setAttribute("errors", errors);
        } else {
            // 氏名をリクエストスコープに入れる
            request.setAttribute("name", name);

            // おみくじの結果をリクエストスコープに入れる
            String[] results = { "大吉", "吉", "中吉", "小吉", "末吉", "凶" };
            String result = results[(int) (Math.random() * 6)];
            request.setAttribute("result", result);
        }

        // 結果画面へフォワード
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/omikuji_result.jsp");
        rd.forward(request, response);
    }

}