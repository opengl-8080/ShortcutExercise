#Shortcut Exercise

ショートカットキーを練習するためのツールです。

Groovy で書かれているので、 Java と Groovy が必要です。

![画面イメージ](https://github.com/opengl-8080/ShortcutExercise/raw/master/doc/se.JPG)

##動作環境
###OS
Windows7 と VM 上の CentOS 6.3 で動いたのを確認しています。
Mac は環境がないので分からないです。

###Java
- 1.7+

###Groovy
- 2.3.7+

##使い方

###ショートカットを定義したファイルを用意する
`preset` フォルダの下に、ショートカットを定義したファイルを配置します。

ファイル名は、 `xxxx_shortcut.txt` となるようにしてください（`xxxx` の部分は任意）。

####フォーマット
```text
コメントの切り替え,Ctrl,Shift,c
フォーマット,Ctrl,Shift,f
コンテンツアシスト,Ctrl,Space
クイックフィックス,Ctrl,1
（略）
```

カンマ区切りの CSV ファイルです。
１列目にショートカットの説明、２列目以降にショートカットの組み合わせを記述します。

文字コードは、環境デフォルトにしておけば、たぶん全角も扱える（Windows=>Shift_JIS, Linux=>UTF-8）。

ショートカットの各キーは、末尾の表に従って記載してください。

###起動
Windows は `exercise.bat` を、 Linux は `exercise` を実行。

###練習するセットを選ぶ
先ほど用意した定義ファイルごとに、プルダウンから選べるようになっているので、練習したいセットを選ぶ。

###start ボタンをクリックする
start ボタンをクリックすると出題が開始されるので、表示された説明に対応するショートカットを入力します。

###結果表示
正解なら緑、不正解なら赤く結果が表示されます。

###次の問題に進む
`Shift + Esc` で次の問題に進めます。

###問題をスキップする
正解がわからず問題をスキップしたい場合も `Shift + Esc` を入力してください。
問題がスキップされ、正解が表示されます。


##ショートカットのキーに指定する文字列

大文字小文字の区別なし。

`,` は区切り文字と区別できるようにするため、 `comma` で指定します。

|文字列|対応するキー|
|:--|:--|
|ctrl|Ctrl|
|alt|Alt|
|shift|Shift|
|a|A|
|b|B|
|c|C|
|d|D|
|e|E|
|f|F|
|g|G|
|h|H|
|i|I|
|j|J|
|k|K|
|l|L|
|m|M|
|n|N|
|o|O|
|p|P|
|q|Q|
|r|R|
|s|S|
|t|T|
|u|U|
|v|V|
|w|W|
|x|X|
|y|Y|
|z|Z|
|f1|F1|
|f2|F2|
|f3|F3|
|f4|F4|
|f5|F5|
|f6|F6|
|f7|F7|
|f8|F8|
|f9|F9|
|f10|F10|
|f11|F11|
|f12|F12|
|0|0|
|1|1|
|2|2|
|3|3|
|4|4|
|5|5|
|6|6|
|7|7|
|8|8|
|9|9|
|n0|テンキーの0|
|n1|テンキーの1|
|n2|テンキーの2|
|n3|テンキーの3|
|n4|テンキーの4|
|n5|テンキーの5|
|n6|テンキーの6|
|n7|テンキーの7|
|n8|テンキーの8|
|n9|テンキーの9|
|escape|Esc|
|esc|Esc|
|back_space|BackSpace|
|bs|BackSpace|
|enter|Enter|
|space|Space|
|delete|Delete|
|del|Delete|
|caps|CAPS LOCK|
|caps_lock|CAPS LOCK|
|tab|Tab|
|home|Home|
|end|End|
|ins|Insert|
|insert|Insert|
|up|↑|
|right|→|
|left|←|
|down|↓|
|kup|キーバッドの↑|
|kright|キーバッドの→|
|kleft|キーバッドの←|
|kdown|キーバッドの↓|
|begin|Begin|
|^|^|
|@|@|
|/|/|
|\\|\\|
|[|[|
|]|]|
|:|:|
|;|;|
|.|.|
|comma|,|
|+|テンキーの+|
|-|-|
|*|テンキーの*|
|subtract|テンキーの-|
|decimal|テンキーの.|
|num_lock|NumLock|
|page_down|PageDown|
|page_up|PageUp|
|pause|Pause|
|print_screen|PrintScreen|
|scroll_lock|ScrollLock|

