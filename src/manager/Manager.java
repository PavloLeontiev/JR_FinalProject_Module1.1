package manager;

import algorithm.Algorithm;

public class Manager {
    InputDataManager inputDataManager = new InputDataManager();
    AlgorithmManager algorithmManager = new AlgorithmManager();
    public void run(String[] args){
        String[] inputData = inputDataManager.getInputData(args);
        Algorithm algorithm = algorithmManager.initializeAlgorithm(inputData);

    }
}
