package manager;

import inputdata.CLIInputData;
import inputdata.ConsoleInputData;
import inputdata.InputData;
import modes.CipherMode;

public class InputDataManager {
    private final int CIPHER_MODE_ARGUMENT = 0;
    private final int FILEPATH_ARGUMENT = 1;
    private final int KEY_ARGUMENT = 2;
    InputData inputData;
    public String[] getInputData(String[] args){
        String[] data = new String[3];
        if(args.length > 0){
            inputData = new ConsoleInputData(args);
        } else {
            inputData = new CLIInputData();
        }
        data[CIPHER_MODE_ARGUMENT] = inputData.getCipherMode();
        data[FILEPATH_ARGUMENT] = inputData.getFilePath();
        data[KEY_ARGUMENT] = inputData.getKey(CipherMode.BRUTE_FORCE.toString().equals(data[CIPHER_MODE_ARGUMENT].trim()));
        return data;
    }
}
