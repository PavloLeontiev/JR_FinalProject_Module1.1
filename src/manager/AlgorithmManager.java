package manager;

import algorithm.Algorithm;
import util.DefineAlgorithm;
import util.DefineLanguageInFileContent;

import java.util.ArrayList;

public class AlgorithmManager {
    private final int CIPHER_MODE_ARGUMENT = 0;
    private final int FILE_PATH_ARGUMENT = 1;
    private final int KEY_ARGUMENT = 2;
    private Algorithm algorithm;

    public Algorithm initializeAlgorithm (String[] inputData){
        ArrayList<Character> alphabet = DefineLanguageInFileContent.detectLanguage(inputData[FILE_PATH_ARGUMENT]);
        algorithm = DefineAlgorithm.defineAlgorithm(inputData[CIPHER_MODE_ARGUMENT], inputData[FILE_PATH_ARGUMENT],
                                                    inputData[KEY_ARGUMENT], alphabet);
        return algorithm;
    }
}
