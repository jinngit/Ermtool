# Ermtool

## 概要
[ERMaster](http://ermaster.sourceforge.net/index_ja.html)で作成したermファイルからDDL文、JavaのDtoを作成するツールです。
ERMasterからも同様のことができますが、フォーマットを調整したいためvelocityによりテンプレートを変更できるようにしています。

## ライセンス
MIT

## 使用ライブラリー
付属のcommons-cli、velocity、guavaについては各ライブラリーのライセンス通りです。LICENSEフォルダに各ライブラリーのライセンスを明示しています。

## 使い方
今はテーブルと、インデックス、シーケンスのみ対応しています。

Groovyは動く状態だと仮定します。

クラスパスはプロジェクトホームを起点として、以下のように設定します。

```sh
export CLASSPATH=\
$CURRENT/src/main/groovy\
:$CURRENT/lib/commons-cli-1.2.jar\
:$CURRENT/lib/guava-14.0.1.jar\
:$CURRENT/lib/velocity-1.7-dep.jar
```

実行の起点は、ermtool/Ermtool.groovyです。オプションとして必須なのは、iとoです。

- i ERMasterで記述した定義ファイル
- o 出力先ディレクトリ

```sh
groovy  src/main/groovy/ermtool/Ermtool.groovy \
  -i input/test.erm \
  -o file
```

上記のままで指定すると記述してあるすべての、テーブル、インデックス、シーケンスのDDL、JavaのEntityクラスが出力されます。

限定するには、-tないし-sオプションでそれぞれテーブル名、シーケンス名を指定します。

-tと-sオプションは同時に指定することはできません。

## 実行方法
TODO

## 更新履歴
### 0.2.0（2013年11月4日）
* 機能追加
 - numeric(p,s)対応
 - sequence対応
* バグ
 - NOT NULLの判断が逆になっていた。

### 0.1.4（2013年9月6日）
* 機能追加
 - numeric(p)対応

### 0.1.3（2013年9月4日）
* 改善
 - ドキュメントが大きい字が多すぎて見難いので文字サイズを調整
* バグ
 - Javaクラスの出力時、フィールド名の先頭が大文字になっている問題の修正

### 0.1.2（2013年8月7日）
* 機能追加
 - JavaクラスにserialVersionUIDを付加するかを設定できるようにする
* バグ
 - columnにdescriptionがある場合に、JavaDocに不要な「*」が入る
 - COMMENT ON COLUMNにテーブル名がないため、エラーになる

### 0.1.1（2013年8月6日）
* 機能追加
 - 個別カラムのUNIQUE制約の実装
 - TIMESTAMPは「timestamp with time zone」だけでなく「timestamp」にも対応させる
 - INTEGER型はINTではなくINTEGERで出力する
 - PRIMARY KEYにはCONSTRAINTで名前をつける（pk_テーブル名）
* バグ
 - table.vmに全角スペースが入っていた（半角に修正）

### 0.1.0（2013年8月5日）
新規作成
