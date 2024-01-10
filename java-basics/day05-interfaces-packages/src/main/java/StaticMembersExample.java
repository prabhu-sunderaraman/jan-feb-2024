public class StaticMembersExample {
    public static void main(String[] args) {
        Company hl = new Company("Herbalife");
        Company ibm = new Company("IBM");
        Company.setRegistrar("Delaware corp");
        System.out.println(Company.getRegistrar());
        //NOT RECOMMENDED TO ACCESS static members using object reference
        System.out.println(ibm.getRegistrar());
        System.out.println(hl.getRegistrar());
    }
}

class Company {
    private String name;
    private static String registrar;

    static {
        //static initializer block
        //CALLED ONLY ONCE
        registrar = "San Diago";
    }
    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getRegistrar() {
        return registrar;
    }

    public static void setRegistrar(String registrarName) {
        registrar = registrarName;
    }
}