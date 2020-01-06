package src.main.java.com.capturis.capstone.webapp.bo;

import src.main.java.com.capturis.capstone.webapp.data.ExampleDataAccess;
import src.main.java.com.capturis.capstone.webapp.models.Example;

import javax.inject.Inject;
import java.io.IOException;
import java.sql.SQLException;

public class ExampleBO {

    private final ExampleDataAccess exampleDataAccess;

    @Inject
    public ExampleBO(ExampleDataAccess exampleDataAccess) {
        this.exampleDataAccess = exampleDataAccess;
    }

    public Example createExampleModel(Example example) throws SQLException, IOException, Exception {
        return exampleDataAccess.createExampleModel(example);
    }

    public Example getById(int id)throws SQLException, IOException, Exception {
        return exampleDataAccess.getById(id);
    }

    public boolean updateExample(Example example) throws SQLException, IOException, Exception {
        return exampleDataAccess.updateExample(example);
    }

    public boolean deleteExample(int id) throws SQLException, IOException, Exception {
        return exampleDataAccess.deleteExample(id);
    }
}
