package manager;

public class Manager {
    InputDataManager inputDataManager;

    public Manager(){
        inputDataManager = new InputDataManager();
    }
    public void run(String[] args){
        String[] inputData = inputDataManager.getInputData(args);

    }
}
