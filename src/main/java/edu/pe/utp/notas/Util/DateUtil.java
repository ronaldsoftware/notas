package edu.pe.utp.notas.Util;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {

    public static String formatDate(Date date) {
        String stringFormat = null;
        if (Optional.ofNullable(date).isPresent()) {
            SimpleDateFormat sdfOutput = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            stringFormat = sdfOutput.format(date);
        }
        return stringFormat;
    }
}
