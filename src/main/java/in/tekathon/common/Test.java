/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author administrator
 */
public class Test {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-mm-dd");
        String startDate = "2017-01-30";
        String endDate = "2017-02-01";

        try {
            Date date1 = myFormat.parse(startDate);
            Date date2 = myFormat.parse(endDate);
            long diff = date1.getTime() - date2.getTime();
            System.out.println("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

//            Integer dateDiff = Utility.getDateDiff(date2, date1);
            long differenceDays = getDifferenceDays(date2,date1);System.out.println("differenceDays = " + differenceDays);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

}
//
