package com.sysoiev.notebook.util;

public class ValidationUtil {
    /**
     * Утилитный класс. Для жизни и работы которого не требуется экземпляр данного класса,
     * поскольку он не имеет состояния.
     * Использует только статические методы и переменные.
     */

    private ValidationUtil() {
    }


    /**
     * Метод который преобразовывает строку в число. Выбрасывает NumberFormatException при неудачи, который необходимо обработать.
     */
    static public int checkNumber(String number) {
        return new Integer(number);
    }
}
