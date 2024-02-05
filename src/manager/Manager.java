package manager;

import algorithm.Algorithm;

public class Manager {
    InputDataManager inputDataManager = new InputDataManager();
    AlgorithmManager algorithmManager;
    FileEncryptManager fileEncryptManager;
    public void run(String[] args){
        String[] inputData = inputDataManager.getInputData(args);
        algorithmManager = new AlgorithmManager(inputData);
        Algorithm algorithm = algorithmManager.initializeAlgorithm(inputData);
        fileEncryptManager = new FileEncryptManager(algorithm, inputData);
        fileEncryptManager.encrypt();
    }
}
