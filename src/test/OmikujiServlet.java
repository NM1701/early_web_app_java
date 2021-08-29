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

/**
 * Servlet implementation class OmikujiServlet
 */
@WebServlet("/OmikujiServlet")
public class OmikujiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OmikujiServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータを取得する
        String username = request.getParameter("username");

        // おみくじ結果一覧の配列の用意
        String[] results = {"大吉", "吉", "中吉", "小吉", "末吉", "凶"};

        // おみくじ結果一覧の配列からランダムに結果を取得する
        String fortune = results[(int)(Math.random() * 6)];

        // 入力項目チェック（バリデーション）
        List<String> errors = new ArrayList<String>();

        if(username == null || username.equals("")) { /* 氏名 */
            errors.add("氏名を入力してください");
        }

        // 入力内容にエラー有無判定
        if(errors.size() > 0) {
            // omikuji_result.jspにエラー内容を送る
            request.setAttribute("errors", errors);
        }else {
            // omikuji_result.jspに値を送る
            request.setAttribute("username", username);
            request.setAttribute("fortune", fortune);
        }

        // ビューとなるJSP(omikuji_result.jsp)へのフォワード
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/omikuji_result.jsp");
        rd.forward(request, response);
    }
}