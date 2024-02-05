package manager;

import algorithm.Algorithm;
import algorithm.CaesarCipher;
import alphabet.Alphabet;
import util.DefineLanguageInFileContent;
import util.InitializeCaesarKey;

public class AlgorithmManager {
    private String cipherMode;
    private String filePath;
    private String key;
    private Algorithm algorithm;
    public AlgorithmManager(String[] inputData){
        cipherMode = inputData[0];
        filePath = inputData[1];
        key = inputData[2];
    }
    public Algorithm initializeAlgorithm (String[] inputData){
        Alphabet alphabet = DefineLanguageInFileContent.defineLanguage(filePath);
        int modifyKey = InitializeCaesarKey.initializeKey(cipherMode, filePath, key, alphabet);
        algorithm = new CaesarCipher(modifyKey, alphabet.getARRAY_LIST());
        return algorithm;
    }
}
