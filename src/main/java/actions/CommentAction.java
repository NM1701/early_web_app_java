package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.CommentView;
import actions.views.ReportView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import services.CommentService;

/**
 * コメントに関する処理を行うActionクラス
 */
public class CommentAction extends ActionBase{

    private CommentService service;

    /**
     * メソッドを実行する
     */
    @Override
    public void process() throws ServletException, IOException{

        service = new CommentService();

        //メソッド実行
        invoke();
        service.close();
    }

    /**
     * コメント一覧画面の表示
     * @throws ServletException
     * @throws IOException
     */
    public void index() throws ServletException, IOException{

        //指定の日報に対するコメントのうち、指定ページの分を一覧画面に表示するコメントデータを取得
        String report_id = getRequestParam(AttributeConst.REP_ID);
        ReportView report = new ReportView();
        report.setId(toNumber(report_id));
        int page = getPage();
        List<CommentView> comments = service.getMinePerPage(report, page);

        //指定の日報へのコメント件数を取得
        long commentsCount = service.countAllMine(report);

        putRequestScope(AttributeConst.COMMENTS, comments); //取得したコメントデータ
        putRequestScope(AttributeConst.COM_COUNT, commentsCount); //指定の日報への全てのコメントデータの件数
        putRequestScope(AttributeConst.PAGE, page); //ページ数
        putRequestScope(AttributeConst.MAX_ROW, JpaConst.COM_PER_PAGE); //1ページに表示するコメントの数

        //セッションにフラッシュメッセージが設定されている場合はリクエストスコープに移し替え、セッションからは削除する
        String flush = getSessionScope(AttributeConst.FLUSH);
        if (flush != null) {
            putRequestScope(AttributeConst.FLUSH, flush);
            removeSessionScope(AttributeConst.FLUSH);
        }

        //一覧画面を表示
        forward(ForwardConst.FW_COM_INDEX);
    }

}
