package pl.krzysiek.conferenceroombookingsystem.exceprion;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerTemp {

    @ExceptionHandler({NotFoundException.class})
    ResponseEntity<ExceptionDto> onException(NotFoundException exception) {
        return createProperResponse(exception, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ExceptionDto> createProperResponse(NotFoundException exception, HttpStatus internalServerError) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(exception.getMessage());
        return ResponseEntity.status(internalServerError).body(exceptionDto);
    }

}
