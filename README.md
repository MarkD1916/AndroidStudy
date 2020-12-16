# AndroidStudy
Toy example проекты, которые не обязаны нести в себе смысловой нагрузки, а призваны лишь для тренировки различных элементов разработки под Android.

#### По технологиям:
<p><a href="#ViewModel">ViewModel</a></p>

#### По проектам:
<p><a href="#Tips">Tips</a></p>
<p><a href="#IntentCodingChallenge">IntentCodingChallenge</a></p>
<p><a href="#AndroidFundamentalsIntUI">AndroidFundamentalsIntUI</a></p>

## Tips
<p align="center">
  <img src="Pict for readme/Tips1" width="200">
  <img src="Pict for readme/Tips2" width="200">
  <img src="Pict for readme/Tips3" width="200">
</p>
<p><a name="ViewModel"></a></p>
<p align="center">
  <img src="Pict for readme/tipsLand.jpg" width="400" title="View Model - реализуется смена ориентации">
</p>

<p><a name="Tips"></a></p>



[Простое приложение для подсчета чаевых](https://github.com/MarkD1916/AndroidStudy/tree/master/Tips).

### SeekPresenter

#### SeekBar

Логику работы SeekBar вынес в класс SeekPresenter в методе setSeekBarListener устанавливается SeekBarListener, для того, чтобы движение были плавными вводится переменная smoothnessFactor и по определенной формуле исскуственно сглаживается движение.
calculateResult - расчитывает чаевые и сигнализирует о закрытии виртуальной клавиатуры

### PercentageButtons

Объект, который содержит описание кнопок для быстрого выбора процентов: имя кнопки, значение процента и SeekPresenter из MainActivity. Массив из объектов PercentageButtons передается ButtonAdapter.
### ButtonAdapter

В ButtonAdapter кнопкам присваиваются имена и background. Через SeekPresenter, который есть в описании модели каждой кнопки, SeekBar устанавливается прогресс и значение остановки через метод setProgress в SeekPresenter

## IntentCodingChallenge
<p align="center">
  <img src="Pict for readme/IntCodChal1" width="200">
  <img src="Pict for readme/IntCodChal2" width="200">
  <img src="Pict for readme/IntCodChal4" width="200">
</p>

<p><a name="IntentCodingChallenge"></a></p>

[Простая адаптация задания](https://github.com/MarkD1916/AndroidStudy/tree/master/IntentCodingChallenge) с [лаболаторных гугла](https://developer.android.com/codelabs/android-training-create-an-activity#7). Реализован переход между двумя активностями с передачей значения выбранным игроком хода, затем случайно выбирается ответный ход, и по заданным правилам выясняется победитель.

## AndroidFundamentalsIntUI 

<p align="center">
  <img src="Pict for readme/AndrFundUI1.PNG" width="200">
  <img src="Pict for readme/AndrFundUI2.PNG" width="200">
</p>
<p align="center">
   <img src="Pict for readme/AndrFundUI3.PNG" width="400" title="есть горизонтальный вариант">
</p> 

<p><a name="AndroidFundamentalsIntUI"></a></p>

[Задание](https://github.com/MarkD1916/AndroidStudy/tree/master/AndroidFundamentalsIntUI) [лаболаторных гугла](https://developer.android.com/codelabs/android-training-layout-editor-part-a?index=..%2F..%2Fandroid-training#1)
