package factory;

import database.PeopleDB;
import database.RegistrationPeople;
import person.Person;
import ticket.*;

import java.util.Scanner;

public class TicketMaker extends AFact{
    private static TicketMaker registrationTicketMaker_instance;

    public static TicketMaker getInstance()
    {
        if(registrationTicketMaker_instance == null) {
            registrationTicketMaker_instance = new TicketMaker();
        }
        return registrationTicketMaker_instance;
    }

    @Override
    public Ticket makeTicket(int type, Person p, double paidamount, boolean split) {
        PeopleDB db = RegistrationPeople.getInstance();
        int peopleAmount = db.getList().size();
        if(split)
        {
            for(Person person: db.getList())
            {
                if(!person.getName().equals(p.getName())) {
                    person.addDebt(p,paidamount/peopleAmount);
                }
            }
        }
        else{
            Scanner in = new Scanner(System.in);
            System.out.println("Entering amounts for ticket paid by "+p.getName()+", total amount: "+paidamount);
            double toPayAmount = paidamount;
            for(Person person: db.getList())
            {
                if(!person.getName().equals(p.getName()))
                {
                    System.out.println("How much does "+person.getName()+" owe?");
                    String debt = in.nextLine();
                    double personalDebt = Double.parseDouble(debt);
                    if(personalDebt < toPayAmount) {
                        person.addDebt(p, personalDebt);
                        toPayAmount -= personalDebt;
                    }
                    else System.out.println("Wrong value entered, total amount is: "+paidamount+" while entered amount is: "+personalDebt);
                }
            }

        }
        switch(type)
        {
            case 1:
                return new Ticket_Restaurant(p,paidamount,split);
            case 2:
                return new Ticket_Sports(p,paidamount,split);
            case 3:
                return new Ticket_Cinema(p,paidamount,split);
            case 4:
                return new Ticket_Transport(p,paidamount,split);
        }
        return null;
    }

}
