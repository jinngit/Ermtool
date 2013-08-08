# 概要
[ERMaster](http://ermaster.sourceforge.net/index_ja.html)で作成したermファイルからDDL文、JavaのDtoを作成するツールです。
ERMasterからも同様のことができますが、フォーマットを調整したいためvelocityによりテンプレートを変更できるようにしています。

# ライセンス
MIT

# 使用ライブラリー
付属のcommons-cli、velocity、guavaについては各ライブラリーのライセンス通りです。LICENSEフォルダに各ライブラリーのライセンスを明示しています。

# 使い方
## Ermtoolで使用するデータ
### テーブル
テーブル情報のタブごとに以下の制限があります。
TODO

## 実行方法
TODO

# 更新履歴
## 0.1.2（2013年8月7日）
# 機能追加
 - JavaクラスにserialVersionUIDを付加するかを設定できるようにする
* バグ
 - columnにdescriptionがある場合に、JavaDocに不要な「*」が入る
 - COMMENT ON COLUMNにテーブル名がないため、エラーになる

## 0.1.1（2013年8月6日）
* 機能追加
 - 個別カラムのUNIQUE制約の実装
 - TIMESTAMPは「timestamp with time zone」だけでなく「timestamp」にも対応させる
 - INTEGER型はINTではなくINTEGERで出力する
 - PRIMARY KEYにはCONSTRAINTで名前をつける（pk_テーブル名）
* バグ
 - table.vmに全角スペースが入っていた（半角に修正）

## 0.1.0（2013年8月5日）
新規作成
