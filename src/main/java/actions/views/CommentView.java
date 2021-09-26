package actions.views;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * コメント情報について画面の入力値・出力値を扱うViewモデル
 */
@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
public class CommentView {

    /**
     * id
     */
    private Integer id;

    /**
     * コメントする日報のid
     */
    private ReportView report;

    /**
     * コメントを投稿した従業員
     */
    private Integer commentator;

    /**
     * コメント内容
     */
    private String comment;

    /**
     * 登録日時
     */
    private LocalDateTime createdAt;
}
