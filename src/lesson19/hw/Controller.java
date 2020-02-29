package lesson19.hw;

public class Controller {


    private File put(Storage storage, File file) throws Exception {
        //- добавляет файл в хранилище. гарантируется что файл уже есть в условной БД
        if (file == null) {
            return null;
        }
        //поиск такого же файла по айди
        if (findByID(storage, file) != null)
            return null;

        //проверка подходящего формата и размера
        for (String format : storage.getFormatsSupported()) {
            if (!file.getFormat().equals(format) && file.getSize() > storage.getStorageSize()) {
                return null;
            }
        }
        int index = 0;
        for (File file1 : storage.getFiles()) {
            if (file1 == null) {
                storage.getFiles()[index] = file;
            }
            index++;
        }

        return null;
    }


    public void delete(Storage storage, File file) {

        File file1 = findByID(storage, file);
        int index = 0;
        for (File file2 : storage.getFiles()) {
            if (file1 == file2) {
                storage.getFiles()[index] = null;
                break;
            }
            index++;
        }
    }


    public void transferAll(Storage storageFrom, Storage storageTo) {

        long filesSize = 0;
        for (File fileFrom : storageFrom.getFiles()) {
            filesSize += fileFrom.getSize();
        }
        if (storageTo.getStorageSize() < filesSize) {
            return;
        }
        for (File fileFrom : storageFrom.getFiles()) {
            for (String format : storageTo.getFormatsSupported()) {
                if (!fileFrom.getFormat().equals(format)) {
                    return;
                }
            }
        }

        for (File fileFrom : storageFrom.getFiles()) {
            for (File fileTo : storageTo.getFiles()) {
                if (fileFrom.getId() == fileTo.getId()) {
                    return;
                }
            }
        }

        for (File filefrom : storageFrom.getFiles()) {
            try {
                put(storageTo, filefrom);
                delete(storageFrom, filefrom);
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }


    private void transferFile(Storage storageFrom, Storage storageTo, long id) {
        for (File fileFrom : storageFrom.getFiles()) {
            if (fileFrom.getId() == id && storageTo.getStorageSize()-fileFrom.getSize()>0) {
                try {
                    put(storageTo, fileFrom);
                    delete(storageFrom, fileFrom);
                } catch (Exception e) {
                    System.out.println("Impossible. file ID: " + fileFrom.getId() + " is already in storage");
                }

            }

        }

    }

    private File findByID(Storage storage, File file) {
        for (File fl : storage.getFiles()) {
            if (fl != null && file.getId() == fl.getId())
                return fl;
        }
        return null;
    }


}