package lesson9.utils;

public class Checker {

    //public - доступно с любой точки проекта
    //private - противоположность паблику. Поля конструкторы или метод доступны только внутри этого класса.
   // более 90+%

    //default (package private) доступен в середине пакета
    //protected - доступен внутри класса, пакета, и во всех наследниках класса. То же что и дефолт но + наследники

    int companyNamesValidatedCount = 0;

    public boolean checkCompanyName(String companyName){
        if (companyNamesValidatedCount > 10)
            return false;

        companyNamesValidatedCount++;
        return companyName != "Google" && companyName != "Amazon";
    }

}
