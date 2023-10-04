package persistence;

public class DataBaseDaoFactory {

    public DataBaseInterface createDataBaseDao(){
        return new DataBaseDaoImplements();
    }
}

