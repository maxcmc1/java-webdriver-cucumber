package pages;

public class FarmAnimals extends Animals{

    public FarmAnimals(String value){
        type = value;
    }

    public FarmAnimals(){
        type = "nameless one";
    }

    public void speak(){
        System.out.println(type + " moo!");
    }

}
