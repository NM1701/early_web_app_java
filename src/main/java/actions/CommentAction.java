package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.CommentView;
import actions.views.EmployeeView;
import actions.views.ReportView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import constants.MessageConst;
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

        //指定の日報に対するコメントのうち、指定ページの表示分（10個）のコメントデータを取得
        ReportView repView = (ReportView) getSessionScope(AttributeConst.REPORT);
        int page = getPage();
        List<CommentView> comments = service.getMinePerPage(repView, page);

        //指定の日報への全コメント件数を取得
        long commentsCount = service.countAllMine(repView);

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

    /**
     * コメント登録画面を表示する
     * @throws ServletException
     * @throws IOException
     */
    public void entryNew() throws ServletException, IOException{

        putRequestScope(AttributeConst.TOKEN, getTokenId()); //CSRF対策用トークン
        putRequestScope(AttributeConst.COMMENT, new CommentView()); //空のコメントインスタンス

        //新規登録画面を表示
        forward(ForwardConst.FW_COM_NEW);
    }

    /**
     * コメントの新規登録を行う
     * @throws ServletException
     * @throws IOException
     */
    public void create() throws ServletException, IOException {

        //CSRF対策 tokenのチェック
        if (checkToken()) {

            //セッションからログイン中の従業員情報、日報情報を取得
            EmployeeView empView = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);
            ReportView repView = (ReportView) getSessionScope(AttributeConst.REPORT);

            //パラメータの値をもとにコメント情報のインスタンスを作成する
            CommentView cv = new CommentView(
                    null,   //コメントid
                    repView,  //日報情報
                    empView,  //コメント従業員id
                    getRequestParam(AttributeConst.COM_CONTENT),    //コメント内容
                    null);  //コメント登録日時

            //コメント情報登録
            List<String> errors = service.create(cv);

            if (errors.size() > 0) {
                //登録中にエラーがあった場合

                putRequestScope(AttributeConst.TOKEN, getTokenId()); //CSRF対策用トークン
                putRequestScope(AttributeConst.COMMENT, cv);//入力されたコメント情報
                putRequestScope(AttributeConst.ERR, errors);//エラーのリスト

                //新規登録画面を再表示
                forward(ForwardConst.FW_COM_NEW);

            } else {
                //登録中にエラーがなかった場合
                //セッションに登録完了のフラッシュメッセージを設定
                putSessionScope(AttributeConst.FLUSH, MessageConst.I_REGISTERED.getMessage());

                //一覧画面にリダイレクト
                redirect(ForwardConst.ACT_COM, ForwardConst.CMD_INDEX, repView.getId());
            }
        }
    }

}
