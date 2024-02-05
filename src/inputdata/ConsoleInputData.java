package inputdata;

import util.ValidationInputData;

public class ConsoleInputData extends InputData{
    private final String CIPHER_MODE_ARGUMENT;
    private final String FILEPATH_ARGUMENT;
    private final String KEY_ARGUMENT;
    public ConsoleInputData(String[] inputData){
        CIPHER_MODE_ARGUMENT = inputData[0].toUpperCase();
        FILEPATH_ARGUMENT = inputData[1];
        KEY_ARGUMENT = inputData[2];
    }

    public String getCipherMode() {
        return ValidationInputData.validateCipherMode(CIPHER_MODE_ARGUMENT);
    }

    public String getFilePath() {
        return ValidationInputData.validateFilePath(FILEPATH_ARGUMENT);
    }

    public String getKey(boolean isBruteForce) {
        if(!isBruteForce) return ValidationInputData.validateKey(KEY_ARGUMENT);
        return null;
    }
}
