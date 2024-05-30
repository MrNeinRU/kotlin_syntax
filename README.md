<h1 align="center">ЗАДАЧА №2</h1>

<h3 align="center">Текст задачи</h3>

[Резервуары: цилиндры и параллелепипеды. Размеры, уровень жидкости, скорость накачки/истечения жидкости. «Длительный» метод – накачка/откачка жидкости с конечной скоростью (имитируется паузами). Специфический метод вывода в консоль общий и текущий объёмы жидкости в зависимости от геометрических параметров. Фильтрация по размерам или заполненности.]

<h3 align="center">Описание</h3>

При запуске программы выводится меню с возможными действиями.

Создаётся стандартный список, заполненный 2-я уникальными дочерними объектами (параллелепипед и цилиндр с заранее присвоенными значениями по умолчанию).

В некоторых меню и подменю присутствуют подсказки.

<h3 align="center">Пункты меню</h3>

<p>1. Виды резервуаров.</p>
<p>2. Вывести список резервуаров.</p>
<p>3. Закачка/откачка.</p>
<p>4. Добавить резервуар.</p>
<p>5. Изменить данные резервуара.</p>
<p>6. Удалить резервуар.</p>
<p>7. Фильтровать резервуары.</p>
<p>8. Сортировать резервуары.</p>
<p>9. test.</p>
<p>0. Выход.</p>

<h3 align="center"><br>1. Виды резервуаров.</h3>
<br>
<li>Выводит предпросмотр типов резервуаров, их название и формулу для расчёта объёма.</li>

<h3 align="center"><br>2. Вывести список резервуаров.</h3>
<p><br>
<li>Выводит примечание к таблице.</li>
<li>Выводит таблицу с резервуарами, где перечислены их название, объём, уровень жидкости (%), скорость закачки, скорость откачки.</li>
(<i>Присутствует дебаг информация.</i>)
</p>

<h3 align="center"><br>3. Закачка/откачка.</h3>
<p><br>
<li><i> Долгое действие (по завершению) </i></li>
<li>
  Предлагает список резервуаров, из которых пользователь может выбрать один или несколько объектов для изменения.
  
  После выбора запускается процесс обработки изменений в подменю можно выбрать тип действия и уровень изменения.

  <b>Примечание:</b> скорость действий зависит от параметров объекта.

  <ins> Рандомизация не завершина</ins> , но не является основным методом.

</li>
<li>
  После последнего подтверждения производится асинхронное действие с выводом в консоль.

  По завершению всех действий выведется специальное сообщение.
</li>
</p>

<h3 align="center"><br>4. Добавить резервуар.</h3>
<p><br>
<li>
  Предлогает выбрать тип добавляемого объекта.

  В подменю предложен выбор с добавлением объекта по умолчанию (данные приведены), если «нет» даёт возможность изменить параметры объекта.

  <b>Примечание:</b> Нужно обязательно сохранить ПОСЛЕ изменения <i>ВСЕХ (или хотябы одного)</i> необходимых данных.
</li>
</p>

<h3 align="center"><br>5. Изменить данные резервуара.</h3>
<p><br>
<li>
  Меню с возможностью изменить данные выбранного объекта.

  <b>Примечание:</b> Кроме уровня жидкости
</li>
</p>
