interface SmartDevice{
    void turnon();
    void turnoff();
}

class Fan implements SmartDevice{
    public void turnon(){
        System.out.println("Fan is turned on");
    }
    public void turnoff(){
        System.out.println("Fan is turned off");
    }
}

class Light implements SmartDevice{
    public void turnon(){
        System.out.println("Light is turned on");
    }
    public void turnoff(){
        System.out.println("Light is turned off");
    }
}

class AC implements SmartDevice{
    public void turnon(){
        System.out.println("AC is turned on");
    }
    public void turnoff(){
        System.out.println("AC is turned off");
    }
}

class SmartHome{
    public static void main(String[]args){
        Fan fan = new Fan();
        Light light = new Light();
        AC ac = new AC();
        fan.turnon();
        light.turnon();
        ac.turnon();
        fan.turnoff();
        light.turnoff();
        ac.turnoff();
    }
}