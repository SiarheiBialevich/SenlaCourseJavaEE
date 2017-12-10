package ru.senla.bialevich;

public class Props {

    private boolean blockStatus;
    private Integer countRegistrations;
    private String pathToMainFile;
    private String pathToInstanceFile;
    private String pathToFileEntity;

    public boolean isBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(boolean blockStatus) {
        this.blockStatus = blockStatus;
    }

    public Integer getCountRegistrations() {
        return countRegistrations;
    }

    public void setCountRegistrations(Integer countRegistrations) {
        this.countRegistrations = countRegistrations;
    }

    public String getPathToMainFile() {
        return pathToMainFile;
    }

    public void setPathToMainFile(String pathToMainFile) {
        this.pathToMainFile = pathToMainFile;
    }

    public String getPathToInstanceFile() {
        return pathToInstanceFile;
    }

    public void setPathToInstanceFile(String pathToInstanceFile) {
        this.pathToInstanceFile = pathToInstanceFile;
    }

    public String getPathToFileEntity() {
        return pathToFileEntity;
    }

    public void setPathToFileEntity(String pathToFileEntity) {
        this.pathToFileEntity = pathToFileEntity;
    }
}
