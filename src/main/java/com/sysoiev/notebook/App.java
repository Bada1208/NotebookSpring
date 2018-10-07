package com.sysoiev.notebook;


import com.sysoiev.notebook.dao.ContactDao;
import com.sysoiev.notebook.dao.impl.H2ContactDaoImpl;
import com.sysoiev.notebook.dao.impl.PostgresContactDaoImpl;
import com.sysoiev.notebook.dao.impl.SpringJdbcConfig;
import com.sysoiev.notebook.model.Contact;
import com.sysoiev.notebook.services.ContactService;
import com.sysoiev.notebook.services.impl.FSContactServiceImpl;
import com.sysoiev.notebook.view.CmdLineService;
import com.sysoiev.notebook.view.impl.CmdLineServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App {

    /**
     * Начало программы. Тут запускается программа, создаются все сервиса и устанавливаются связи между ними.
     */
    public static void main(String[] args) throws IOException {

        /*//Создание самого нижнего слоя сервисов  - слой dao который работает со средствами долгосрочноого хранения информации.
        ContactDao contactDao = new PostgresContactDaoImpl();

        //Создание слоя севисов, которые хранят бизнесс логику. Логику управления моделями и т.д.
        //Обычно эти сервисы используют слой dao для долгосрочного хранения данных.
        ContactService contactService = new FSContactServiceImpl(contactDao);

        //Создание сервисов слоя представления. Самые высокоуровневые сервиса которые управляют сервисами бизнесс логики.
        //Слой отвечающий за графический интерфейс и удобство работы Пользователя с программой
        CmdLineService cmd = new CmdLineServiceImpl(contactService);

        //Непосредственный запуск графического интерфейса и программы
        cmd.runMenu();*/

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Contact contact = (Contact) context.getBean("splitter");
        /*StudentJDBCTemplate studentJDBCTemplate =
                (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");*/

    }
}