package by.barbuk.epam.aircompany.exeption;

public class AirCompanyTechnicalException extends Exception {
    public AirCompanyTechnicalException() {
    }

    public AirCompanyTechnicalException(String msg, Throwable ex) {
        super(msg, ex);
    }

    public AirCompanyTechnicalException(String msg) {
        super(msg);
    }

    public AirCompanyTechnicalException(Throwable ex) {
        super(ex);
    }
}
