```mermaid
erDiagram
    組織マスタ {
        ID PK 
        会社ID NOT NULL 
        組織ID NOT NULL 
        上位会社組織ID FK 
    }
    社員マスタ {
        社員ID PK 
    }
    所属マスタ {
        ID PK 
        社員ID FK NOT NULL 
        会社組織ID FK NOT NULL 
        主務兼務フラグ NOT NULL 
    }
    カテゴリマスタ {
        カテゴリID PK 
        大中小区分 NOT NULL 
        上位カテゴリID FK 
        編集可能範囲フラグ NOT NULL 
        研修担当者グループID FK 
    }
    会場マスタ {
        会場ID PK 
        編集可能範囲フラグ NOT NULL 
        研修担当者グループID FK 
    }
    研修会社マスタ {
        研修会社ID PK 
        編集可能範囲フラグ NOT NULL 
        研修担当者グループID FK 
    }
    種別マスタ {
        種別ID PK 
    }
    必修区分マスタ {
        必修区分ID PK 
        編集可能範囲フラグ NOT NULL 
        研修担当者グループID FK 
    }
    研修担当者グループマスタ {
        研修担当者グループID PK 
    }
    カテゴリ設定 {
        ID PK 
        コース・研修ID FK NOT NULL 
        カテゴリID FK NOT NULL 
    }
    付箋メモ設定 {
        ID PK 
        コース・研修ID FK NOT NULL 
        社員ID FK NOT NULL 
        付箋色 NOT NULL 
    }
    受講対象設定 {
        ID PK 
        コース・研修ID FK NOT NULL 
        必修区分 FK NOT NULL 
        社員ID FK NOT NULL 
    }
    研修担当者グループ設定 {
        ID PK 
        研修担当者グループID FK NOT NULL 
        社員ID FK NOT NULL 
    }
    コース・研修マスタ {
        コース・研修ID PK 
        コース・研修種別 FK NOT NULL 
        研修会社ID FK 
        研修担当者グループID FK 
    }
    教材マスタ {
        ID PK 
        コース・研修ID FK NOT NULL 
        表示順 NOT NULL 
        教材配置URL NOT NULL 
        公開範囲フラグ NOT NULL 
    }
    アンケートシートマスタ {
        ID PK 
        コース・研修ID FK NOT NULL 
        表示順 NOT NULL 
        公開範囲フラグ NOT NULL 
    }
    募集単位 {
        ID PK 
        コース・研修ID FK NOT NULL 
        募集単位ID NOT NULL 
        会場ID FK 
        開催中止フラグ NOT NULL 
    }
    コース所属研修募集単位 {
        ID PK 
        コース募集単位ID FK NOT NULL 
        研修募集単位ID FK NOT NULL 
        選択必修フラグ NOT NULL 
    }
    開催日程 {
        ID PK 
        募集単位ID FK NOT NULL 
        表示順 NOT NULL 
        公開範囲フラグ NOT NULL 
    }
    申請管理 {
        ID PK 
        申請者所属ID FK NOT NULL 
        申請年月日時刻 NOT NULL 
        キャンセル待ち実施中フラグ NOT NULL 
    }
    申請管理明細 {
        ID PK 
        申請ID FK NOT NULL 
        選択研修表示順 NOT NULL 
        コース・研修募集単位ID FK NOT NULL 
    }
    承認管理 {
        ID PK 
        申請ID FK NOT NULL 
        承認ステップ順 NOT NULL 
        承認者所属ID FK NOT NULL 
    }
    受講管理 {
        受講ID PK FK 
        受講ステータス NOT NULL 
    }
    受講管理明細 {
        ID PK 
        受講ID FK NOT NULL 
        コース・研修募集単位指定ID FK NOT NULL 
    }
    受講履歴 {
        ID PK 
        申請者社員ID NOT NULL 
        コース・研修ID NOT NULL 
        募集単位ID NOT NULL 
        修了日 NOT NULL 
    }
    
    組織マスタ }|--|| 組織マスタ : "上位会社組織ID"
    所属マスタ }|--|| 社員マスタ : "社員ID"
    所属マスタ }|--|| 組織マスタ : "会社組織ID"

```