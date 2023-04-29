package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.CommentView;
import constants.MessageConst;

/**
 * コメントインスタンスに設定されている値のバリデーションを行うクラス
 */
public class CommentValidator {

    /**
     * コメントインスタンスの各項目についてバリデーションを行う
     * @param cv コメントインスタンス
     * @return エラーのリスト
     */
    public static List<String> validate(CommentView cv){
        List<String> errors = new ArrayList<String>();

        // コメント内容のチェック
        String commentError = validateComment(cv.getComment());
        if (!commentError.equals("")) {
            errors.add(commentError);
        }

        return errors;
    }

    /**
     * コメントに入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param comment コメント
     * @return エラーメッセージ
     */

    private static String validateComment(String comment) {
        if (comment == null || comment.equals("")) {
            return MessageConst.E_NOCOMMENT.getMessage();
        }

        //入力値がある場合は空文字を返す
        return "";
    }
}