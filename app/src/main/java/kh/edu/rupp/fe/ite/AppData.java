package kh.edu.rupp.fe.ite;

public class AppData {

    private static AppData INSTANCE;

    private String name;

    private AppData() {
    }

    public static AppData getInstance(){
        if(INSTANCE == null){
            INSTANCE = new AppData();
        }
        return INSTANCE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
