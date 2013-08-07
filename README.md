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
## 0.1.1（2031年8月6日）
* 機能追加
 - 個別カラムのUNIQUE制約の実装
* バグ
 - table.vmに全角スペースが入っていた（半角に修正）

## 0.1.0（2013年8月5日）
新規作成
