/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Samuel
 */
public class Time {
    
    private Date date;
    private java.sql.Date dateSql; 
    private LocalDate localDate;
    private LocalTime localTime;
    private LocalDateTime localDateTime;
    private Calendar calendar;
    private GregorianCalendar gregorianCalendar;
    private static final SimpleDateFormat defaultDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public Time(Date date, java.sql.Date dateSql, LocalDate localDate, LocalTime localTime, Calendar calendar, GregorianCalendar gregorianCalendar) {
        this.date = date;
        this.dateSql = dateSql;
        this.localDate = localDate;
        this.localTime = localTime;
        this.calendar = calendar;
        this.gregorianCalendar = gregorianCalendar;
    }

    public Time() {
        
        this.date = new Date();
        this.dateSql = new java.sql.Date(date.getTime());
        this.localDate = LocalDate.now();
        this.localTime = LocalTime.now();
        this.localDateTime = LocalDateTime.now();
        this.gregorianCalendar = new GregorianCalendar();
        
    }
    
    
    
}
