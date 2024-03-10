package gb_Masterov.hw_03.controller;

import gb_Masterov.hw_03.exceptions.MyExceptions;
import gb_Masterov.hw_03.exceptions.WrongDataFormat;
import gb_Masterov.hw_03.exceptions.WrongSizeOfInputData;
import gb_Masterov.hw_03.model.Contact;
import gb_Masterov.hw_03.model.Human;
import gb_Masterov.hw_03.viewer.ContactValidator;
import gb_Masterov.hw_03.viewer.StringParser;
import gb_Masterov.hw_03.viewer.Viewer;
import gb_Masterov.hw_03.viewer.ViewerContact;

public class ContactController {
    public void run(){
        Human contact = new Contact();
        ViewerContact viewerContact = new ViewerContact();
        boolean exit = false;
        while (!exit){
            try {
                contact = new ContactValidator().validate(new StringParser().getDataFromString(viewerContact.getContact()));
            } catch (WrongSizeOfInputData | WrongDataFormat e) {
                System.err.println(e.getMessage());
                System.out.println("Попробуйте позже еще раз...");
                exit = true;
            }
            if (!exit) {
                System.out.println(contact);
                System.out.printf("Записываю данные в файл %s.csv%n", contact.getLastname());
                new SaveToFile().saveToFile(contact.getLastname() + ".csv", contact);
            }
        }
        viewerContact.close();
    }
}
