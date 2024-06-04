<h1 align="center">ЗАДАЧА №2</h1>

<h3 align="center">Текст задачи</h3>

[Резервуары: цилиндры и параллелепипеды. Размеры, уровень жидкости, скорость накачки/истечения жидкости. «Длительный» метод – накачка/откачка жидкости с конечной скоростью (имитируется паузами). Специфический метод вывода в консоль общий и текущий объёмы жидкости в зависимости от геометрических параметров. Фильтрация по размерам или заполненности.]

<h3 align="center">Описание</h3>

При запуске программы выводится меню с возможными действиями.

Создаётся стандартный список, заполненный 2-я уникальными дочерними объектами (параллелепипед и цилиндр с заранее присвоенными значениями по умолчанию).

В некоторых меню и подменю присутствуют подсказки.

<b> В случае некорректности вводимых данных (уровня жидкости) происходит корректировка при выходе в меню. </b>

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

![Снимок экрана 2024-05-30 192557](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/168a8fac-6abc-4ee0-8537-c1b331832184)

<h3 align="center"><br>1. Виды резервуаров.</h3>
<br>
<li>Выводит предпросмотр типов резервуаров, их название и формулу для расчёта объёма.</li>

![Снимок экрана 2024-05-30 192706](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/7435f26c-4065-4bc3-91e3-afc13682eeac)

<h3 align="center"><br>2. Вывести список резервуаров.</h3>
<p><br>
<li>Выводит примечание к таблице.</li>
<li>Выводит таблицу с резервуарами, где перечислены их название, объём, уровень жидкости (%), скорость закачки, скорость откачки.</li>
(<i>Присутствует дебаг информация.</i>)
  
![Снимок экрана 2024-05-30 192808](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/4ffdb24e-31c2-4d73-aaa1-2fb82543c651)

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

![Снимок экрана 2024-05-30 192855](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/52090d4b-f70c-4d64-a6ab-e271774b8e50)
![Снимок экрана 2024-05-30 192938](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/0d6ea6e9-712f-4ec2-8f0b-27663ebeb2d7)
![Снимок экрана 2024-05-30 193040](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/3edea5a2-f241-414c-891b-90c67389b889)
![Снимок экрана 2024-05-30 193135](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/a8a243ef-2de7-4b1f-bc87-3ed041b828a9)
</p>

<h3 align="center"><br>4. Добавить резервуар.</h3>
<p><br>
<li>
  Предлогает выбрать тип добавляемого объекта.

  В подменю предложен выбор с добавлением объекта по умолчанию (данные приведены), если «нет» даёт возможность изменить параметры объекта.

  <b>Примечание:</b> Нужно обязательно сохранить ПОСЛЕ изменения <i>ВСЕХ (или хотябы одного)</i> необходимых данных.
  
![Снимок экрана 2024-05-30 193245](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/1ab806f2-b816-45c8-9e92-d6a6e9037ae2)
![Снимок экрана 2024-05-30 193322](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/e5879334-54ef-47e1-9d9e-c2be46a40861)
если НЕТ \\/
![Снимок экрана 2024-05-30 193347](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/80733dc8-ec48-4922-9a65-f9f01eeb9e76)

</li>
</p>

<h3 align="center"><br>5. Изменить данные резервуара.</h3>
<p><br>
<li>
  Меню с возможностью изменить данные выбранного объекта.

  <b>Примечание:</b> Кроме уровня жидкости
  
  ![Снимок экрана 2024-05-30 193555](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/d58e6704-f25d-4edf-aeed-4b232f65eb14)
![Снимок экрана 2024-05-30 193624](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/735369a1-465f-452d-9c8e-27ceeae76ee3)

</li>
</p>

<h3 align="center"><br>6. Удалить резервуар.</h3>
<p><br>
<li>
  Удаляет элемент.

  <b>Примечание:</b> Выбрать можно один за раз.
</li>
</p>

<h3 align="center"><br>7. Фильтровать резервуары.</h3>
<p><br>
<li>
  Позволяет фильтровать элементы таблицы по:

  1. Названию
  2. Объёму
  3. Заполненности
  4. Скорости закачки
  5. Скорости откачки

  <b>Примечание:</b> Тип фильтровки доступен после подменю с (1. Фильтровать (ввод значения)) (по возможности сортировки будет подсказка)
  
  ![Снимок экрана 2024-05-30 193716](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/9fc14eec-f392-4b4e-beff-a007b5d5b056)
  Фильтрация по названия \\/
![Снимок экрана 2024-05-30 193744](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/2ebd9301-b86e-4f9f-a67a-0813e5e2a989)

</li>
</p>

<h3 align="center"><br>8. Сортировать резервуары.</h3>
<p><br>
<li>
  Позволяет сортировать (и сохранять(автоматически)) таблицу по:

  1. Названию
  2. Общему объёму
  3. Объёму жидкости

  <b>Примечание:</b> Также доступен выбор сортировать (по возрастанию и по убыванию)
  
  ![Снимок экрана 2024-05-30 193856](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/a954676a-0705-4d63-a206-8c77bf092f37)
![Снимок экрана 2024-05-30 193918](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/fac3c029-afa2-4726-b9e8-912dbbeb6be1)

</li>
</p>

<h3 align="center"><br>9. test.</h3>
<p><br>
<li>
  Тестовый функционал

  <b>Примечание:</b> Полностью описан в файле (test.kt)
  
  ![Снимок экрана 2024-05-30 193938](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/3bc9ec8b-367b-4482-ba0e-b2ca71822868)

</li>
</p>

<h3 align="center"><br>0. Выход.</h3>
<p><br>
<li>
  Завершает работу программы.
  
  ![Снимок экрана 2024-05-30 194006](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/be63f4d4-f015-4a5c-955d-1e46891c4f87)

</li>
</p>

<h1 align="center"></h1>
<h1 align="center">РЕЗУЛЬТАТЫ</h1>

<h3 align="center"><br>Действие (2. Вывести список резервуаров.)</br></h3>
<p>
  
  ![Снимок экрана 2024-05-30 192808](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/4ffdb24e-31c2-4d73-aaa1-2fb82543c651)
  
</p>

<h3 align="center"><br>Действие (3. Закачка/откачка.)</br></h3>
<p>
  Одновременная откачка из резервуара 1 и закачка в резервуар 2
  
  ![Снимок экрана 2024-06-04 131035](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/882a5ad0-8ba5-47e9-88a7-2ee25765d1ba)
  
</p>

<h3 align="center"><br>Действие (4. Добавить резервуар.)</br></h3>
<p>
  Добавление параллелепипеда по умолчанию и изменённого цилиндра.
  
  ![Снимок экрана 2024-06-04 131402](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/df004193-80ef-48cc-99c6-4919199a255e)

</p>

<h3 align="center"><br>Действие (5. Изменить данные резервуара.)</br></h3>
<p>
  У номера [4] изменяю общий объём
  
  ![Снимок экрана 2024-06-04 131618](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/e73b4133-ca22-4e6b-8e22-cc09dd8ffa59)

</p>

<h3 align="center"><br>Действие (6. Удалить резервуар.)</br></h3>
<p>
  Удоляю номера [2] (название: «Цилиндр»).
  
  ![Снимок экрана 2024-06-04 131809](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/100370a4-1fd3-44e1-ab22-b8ffab845f4c)

</p>

<h3 align="center"><br>Действие (7. Фильтровать резервуары.)</br></h3>
<p>
  <li>
    Фильтрация по названию:

  ![Снимок экрана 2024-06-04 132058](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/35bb1516-a6c7-4d25-804d-fa00de196e52)
    
  </li>

  <li>
    Фильтрация по объёму:

  ![Снимок экрана 2024-06-04 132221](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/61a2e939-1752-4e2b-80f5-9fcadc1934e0)
    
  </li>

  <li>
    Фильтрация по заполненности:

  ![Снимок экрана 2024-06-04 132328](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/49458c45-9831-472b-83e0-681ec663ed74)
    
  </li>

  <li>
    Фильтрация по cкорости закачки:

  ![Снимок экрана 2024-06-04 133315](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/adf671ab-0463-4e58-a9fb-b4bbefc728a6)
    
  </li>

  <li>
    Фильтрация по cкорости откачки:

  ![Снимок экрана 2024-06-04 133526](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/d9cffa8c-fe0e-4073-83fa-7ef4895099f7)

    
  </li>
</p>

<h3 align="center"><br>Действие (8. Сортировать резервуары.)</br></h3>
<p>
  <li>
    Исходная таблица:

![Снимок экрана 2024-06-04 133859](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/5affea5a-e733-46cd-b3f9-979c49cf81c4)

    
  </li>
  
  <li>
    Сортировка по названию:
(По возрастанию)

![Снимок экрана 2024-06-04 134047](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/c018de03-2a9d-4c87-bdcd-40e51fb52de6)
    
  </li>

  <li>
    Сортировка по общему объёму:
(По возрастанию)

![Снимок экрана 2024-06-04 134206](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/efedbac8-cd1f-4398-a1ef-db7b0ab99367)
    
  </li>

  <li>
    Сортировка по объёму жидкости:
(По возрастанию)

![Снимок экрана 2024-06-04 134310](https://github.com/MrNeinRU/kotlin_syntax/assets/171032643/da445a8f-3b37-45c9-a8d8-fe9d1f5aac12)

    
  </li>
</p>

