public class Destruction {
    public static void main(String[] args) {
        Sample sampleObj = new Sample();
        sampleObj = null; //Becomes eligible to be garbage collected
        //When will the GC come in and clean the memory?
        //No idea
        System.gc(); //NOT A RECOMMENDED PIECE OF CODE
        System.out.println("End of main");
    }
}

class Sample {
    //Java doesn't have a destructor equal to the one in C#

    //Deprecated
    protected void finalize() throws Throwable {
        super.finalize();
    }
}