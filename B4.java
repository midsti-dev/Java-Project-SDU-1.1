import java.util.Scanner;
interface Message{
    public final Scanner sc = new Scanner(System.in);
    abstract public void send();
    abstract public void recieve();
    abstract public void display(); 
}
class Email implements Message{
    String sender, reciever, message;
    @Override
    public void send(){
        System.out.print("Enter Email content: ");
        message = sc.nextLine();
        System.out.print("From: ");
        this.sender = sc.nextLine();
        System.out.print("To: ");
        this.reciever = sc.nextLine();
    }
    @Override
    public void recieve(){
        System.out.println(this.reciever + " recieved Email from " + this.sender);
        this.display();
    }
    @Override
    public void display(){
        System.out.println("Details:");
        System.out.println("Sender: " + this.sender);
        System.out.println("Reciever: " + this.reciever);
        System.out.println("SMS content: " + this.message);
    }
}

class SMS implements Message{
    String sender, reciever, message;
    @Override
    public void send(){
        System.out.print("Enter SMS: ");
        message = sc.nextLine();
        System.out.print("From: ");
        this.sender = sc.nextLine();
        System.out.print("To: ");
        this.reciever = sc.nextLine();

    }
    @Override
    public void recieve(){
        System.out.println(this.reciever + " recieved SMS from " + this.sender);
        this.display();
    }
    @Override
    public void display(){
        System.out.println("Details:");
        System.out.println("Sender: " + this.sender);
        System.out.println("Reciever: " + this.reciever);
        System.out.println("SMS content: " + this.message);
    }
}

public class B4 {

    public static void main(String args[]){
        Email mess1 = new Email();
        mess1.send();
        mess1.recieve();
        SMS mess2 = new SMS();
        mess2.send();
        mess2.recieve();

    }
}
