public class InnerClassesExample {
    public static void main(String[] args) {
        TV sony = new TV();
        TV.Remote sonyRemote = sony.new Remote(); //WEIRD SYNTAX
        sonyRemote.increaseVolume();
        sonyRemote.decreaseVolume();
        System.out.println(sonyRemote.getClass().getName());
        Outer.SomeClass obj = new Outer.SomeClass();
    }
}

class Outer {
    class Inner {
        class Innermost {

        }
    }
    static class SomeClass { //Usually used as test cases to unit test private methods

    }
}

class TV {
    private int volume;

    public void increaseVolume() {
        volume++;
    }

    public void decreaseVolume() {
        volume--;
    }

    class Remote {
        class Chip {
        }

        public void increaseVolume() {
            volume++;
        }

        public void decreaseVolume() {
            volume--;
        }
    }
}