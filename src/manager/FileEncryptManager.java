package manager;

import algorithm.Algorithm;
import mode.CipherMode;
import util.FilePathWrite;

import java.io.*;

public class FileEncryptManager {
    private final int CIPHER_MODE_ARGUMENT = 0;
    private final int FILE_PATH_ARGUMENT = 1;
    private final int KEY_ARGUMENT = 2;
    private Algorithm algorithm;
    private String filePathRead;
    private String filePathWrite;
    private int bufferCapacity = 1024;

    public FileEncryptManager(Algorithm algorithm, String[] inputData) {
        this.algorithm = algorithm;
        this.filePathRead = inputData[FILE_PATH_ARGUMENT];
        this.filePathWrite = FilePathWrite.createFilePathWrite(inputData[CIPHER_MODE_ARGUMENT], inputData[FILE_PATH_ARGUMENT]);
    }

    public void encrypt() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePathRead));
             BufferedWriter writer = new BufferedWriter(new FileWriter(filePathWrite))) {
            char[] array = new char[bufferCapacity];
            int bytesRead = -1;
            do{
                bytesRead = reader.read(array);
                array = algorithm.encrypt(array, bytesRead);
                writer.write(array, 0, bytesRead);
                writer.flush();
                bytesRead = reader.read(array);
            } while (bytesRead != -1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
