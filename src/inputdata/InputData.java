package inputdata;

public abstract class InputData {
    public abstract String getCipherMode();
    public abstract String getFilePath();
    public abstract String getKey(boolean isBruteForce);
}
