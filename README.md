# シンプルスケジュール帳

- 使用言語：Kotlin
- フレームワーク：MVVM
- データベース：Room
- スキル：LiveData・Coroutines・DataBinding

## 概要
Kotlinを用いたAndroidアプリです。
<br>シンプルなスケジュール管理用のアプリケーションで、カレンダーの日付を選択し、予定を追加/削除します。

## 使用方法
アプリを起動すると、カレンダーと前回書いた予定の一覧がリストとして表示されます。
<br>リストには日単位の予定件数が表示されます。
<br>カレンダーかリストをタップして、予定を追加/削除する日付を選択します。
<br><img src="demo_Image/demo1.jpg" width=35%>
<br>
<br>選択した日付がツールバーのタイトルとして表示されます。
<br>画面下の丸ボタン（FAB）をタップすると新しい予定を追加し、リストをタップすると、その予定内容を変更します。
<br><img src="demo_Image/demo2.jpg" width=35%>
<br>
<br>リストをタップすると前回設定した予定の内容が表示され、FABをタップすると新しい予定を表示されます。
<br>予定の内容はタイトル・開始/終了時刻・タイトルの説明があります。新しい予定を追加したときは現在の時間が開始/終了時刻に表示されます。
<br><img src="demo_Image/demo3.jpg" width=35%>
<img src="demo_Image/demo4.jpg" width=35%>
<br><img src="demo_Image/demo5.jpg" width=35%>
<br><img src="demo_Image/demo6.jpg" width=35%>
