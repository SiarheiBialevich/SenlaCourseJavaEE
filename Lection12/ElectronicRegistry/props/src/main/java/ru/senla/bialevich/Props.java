package ru.senla.bialevich;

public class Props {

    private boolean blockStatus;
    private Integer countRegistrations;
    private String pathToMainFile;
    private String pathToInstanceFile;
    private String pathToFileEntity;
    private String pathToFolderEntity;

    private String hostToDb;
    private String PathToDriverJdbc;
    private String LoginToDb;
    private String PasswordToDb;

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

    public String getHostToDb() {
        return hostToDb;
    }

    public void setHostToDb(String hostToDb) {
        this.hostToDb = hostToDb;
    }

    public String getPathToDriverJdbc() {
        return PathToDriverJdbc;
    }

    public void setPathToDriverJdbc(String pathToDriverJdbc) {
        PathToDriverJdbc = pathToDriverJdbc;
    }

    public String getLoginToDb() {
        return LoginToDb;
    }

    public void setLoginToDb(String loginToDb) {
        LoginToDb = loginToDb;
    }

    public String getPasswordToDb() {
        return PasswordToDb;
    }

    public void setPasswordToDb(String passwordToDb) {
        PasswordToDb = passwordToDb;
    }

    public String getPathToFolderEntity() {
        return pathToFolderEntity;
    }

    public void setPathToFolderEntity(String pathToFolderEntity) {
        this.pathToFolderEntity = pathToFolderEntity;
    }
}
