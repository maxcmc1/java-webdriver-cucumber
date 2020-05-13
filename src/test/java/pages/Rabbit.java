package pages;

public class Rabbit extends Pet{

    public void speak(){
        System.out.println(name + " is purring...");
    }

    @Override
    public void walk() {
        System.out.println(name + " is jumping");
    }
}
