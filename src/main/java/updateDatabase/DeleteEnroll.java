package updateDatabase;

import registration.Enroll;

import java.io.File;

public class DeleteEnroll {

    public DeleteEnroll() {
    }

    public void deleteDatabaseData(int id) {

        String directoryPath="db/wiseSaying";
        String fileNameToDelete=String.valueOf(id)+".json";
        File fileToDelete = new File(directoryPath, fileNameToDelete);

        fileToDelete.delete();


    }
}
