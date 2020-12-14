# AndroidStudy
Toy example проекты, которые не обязаны нести в себе смысловой нагрузки, а призваны лишь для тренировки различных элементов разработки под Android.
## Tips
<p align="center">
  <img src="Pict for readme/Tips1" width="200" title="hover text">
  <img src="Pict for readme/Tips2" width="200" alt="accessibility text">
  <img src="Pict for readme/Tips3" width="200" alt="accessibility text">
</p>
Простое приложение для подсчета чаевых.

## SeekPresenter

### SeekBar

Логику работы SeekBar вынес в класс SeekPresenter в методе setSeekBarListener устанавливается SeekBarListener, для того, чтобы движение были плавными вводится переменная smoothnessFactor и по определенной формуле исскуственно сглаживается движение.
calculateResult - расчитывает чаевые и сигнализирует о закрытии виртуальной клавиатуры

## PercentageButtons

Объект, который содержит описание кнопок для быстрого выбора процентов: имя кнопки, значение процента и SeekPresenter из MainActivity. Массив из объектов PercentageButtons передается ButtonAdapter.
## ButtonAdapter

В ButtonAdapter кнопкам присваиваются имена и background. Через SeekPresenter, который есть в описании модели каждой кнопки, SeekBar устанавливается прогресс и значение остановки через метод setProgress в SeekPresenter
