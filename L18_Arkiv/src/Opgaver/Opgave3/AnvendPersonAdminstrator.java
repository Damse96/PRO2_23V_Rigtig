package Opgaver.Opgave3;

public class AnvendPersonAdminstrator {

    public static void main(String[] args) {
        Person p1 = new Person("Mikkel");
        Person p2 = new Person("Mazza");
        Person p3 = new Person("Jens");

        PersonAdminstrator.getInstance().add(p1);
        PersonAdminstrator.getInstance().add(p2);
        PersonAdminstrator.getInstance().add(p3);


        System.out.println(PersonAdminstrator.getInstance().getSet());

        PersonAdminstrator.getInstance().remove(p2);

        System.out.println(PersonAdminstrator.getInstance().getSet());
    }
}
