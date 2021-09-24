package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.Comment;

/**
 * コメントデータのDTOモデル⇔Viewモデルの変換を行うクラス
 */
public class CommentConverter {

    /**
     * ViewモデルのインスタンスからDTOモデルのインスタンスを作成する
     * @param cv CommentViewのインスタンス
     * @return Commentのインスタンス
     */
    public static Comment toModel(CommentView cv) {
        return new Comment(
                cv.getId(),
                ReportConverter.toModel(cv.getReport_id()),
                EmployeeConverter.toModel(cv.getEmployee()),
                cv.getComment(),
                cv.getCreatedAt());
    }

    /**
     * DTOモデルのインスタンスからViewモデルのインスタンスを作成する
     * @param c Commentのインスタンス
     * @return CommentViewのインスタンス
     */
    public static CommentView toView(Comment c) {

        if(c == null) {
            return null;
        }

        return new CommentView(
                c.getId(),
                ReportConverter.toView(c.getReport_id()),
                EmployeeConverter.toView(c.getEmployee()),
                c.getComment(),
                c.getCreatedAt());
    }

    /**
     * DTOモデルのリストからViewモデルのリストを作成する
     * @param list DTOモデルのリスト
     * @return Viewモデルのリスト
     */
    public static List<CommentView> toViewList(List<Comment> list){
        List<CommentView> evs = new ArrayList<>();

        for (Comment c : list) {
            evs.add(toView(c));
        }

        return evs;
    }

    /**
     * Viewモデルの全フィールドの内容をDTOモデルのフィールドにコピーする
     * @param c DTOモデル(コピー先)
     * @param cv Viewモデル(コピー元)
     */
    public static void copyViewModel(Comment c, CommentView cv) {
        c.setId(cv.getId());
        c.setReport_id(ReportConverter.toModel(cv.getReport_id()));
        c.setEmployee(EmployeeConverter.toModel(cv.getEmployee()));
        c.setComment(cv.getComment());
        c.setCreatedAt(cv.getCreatedAt());
    }

    /**
     * DTOモデルの全フィールドの内容をViewモデルのフィールドにコピーする
     * @param r DTOモデル(コピー元)
     * @param rv Viewモデル(コピー先)
     */
    public static void copyModelToView(Comment c, CommentView cv) {
    cv.setId(c.getId());
    cv.setReport_id(ReportConverter.toView(c.getReport_id()));
    cv.setEmployee(EmployeeConverter.toView(c.getEmployee()));
    cv.setComment(c.getComment());
    cv.setCreatedAt(c.getCreatedAt());
    }

}