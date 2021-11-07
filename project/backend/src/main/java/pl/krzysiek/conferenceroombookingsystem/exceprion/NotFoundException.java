package pl.krzysiek.conferenceroombookingsystem.exceprion;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class NotFoundException extends RuntimeException {

    private HttpStatus errorNr;

    public NotFoundException(String msg) {
        super(msg);
        this.errorNr = HttpStatus.NOT_FOUND;
    }

    public NotFoundException(String msg, HttpStatus status) {
        super(msg);
        this.errorNr = status;
    }
}
