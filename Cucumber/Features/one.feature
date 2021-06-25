#language: ru
@1
Функционал: Поиск на авито

  Структура сценария: Найдем самые дорогой товар - <Товар> в категории Оргтехника_и_расходники
    Пусть открыт ресурс авито
    И в выпадающем списке категорий выбрана Оргтехника_и_расходники
    И в поле поиска введено значение <Товар>
    Тогда кликнуть по выпадающему списку региона
    Тогда в поле регион введено значение <Город>
    И нажата кнопка показать объявления
    Тогда открылась страница результата по запросу <Товар>
    И активирован чекбокс С Авито Доставкой
    И в выпадающей списке сортировка выбрано значение Дороже
    И в консоль выведено значение назвния и цены <Число ответов> первых товаров
    Примеры:
      | Товар   | Город           | Число ответов |
      | принтер | Владивосток     | 3             |
      | ручка   | Москва          | 1             |
      | ибп     | Санкт-Петербург | 10            |